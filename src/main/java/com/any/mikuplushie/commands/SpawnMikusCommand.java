package com.any.mikuplushie.commands;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.block.MikuPlushieBlock;
import com.any.mikuplushie.datagen.ModItemTagProvider;
import com.any.mikuplushie.entity.MikuEntity;
import com.any.mikuplushie.entity.PlushEntity;
import com.any.mikuplushie.item.MikuPlushieBlockItem;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.command.argument.Vec3ArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpawnMikusCommand {

    public static void register (CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("spawn_mikus")
            .then(CommandManager.argument("pos", Vec3ArgumentType.vec3())
                .executes(commandContext ->
                    spawnMikus(commandContext.getSource(),
                        Vec3ArgumentType.getVec3(commandContext, "pos"))))
        );
    }

    public static int spawnMikus(ServerCommandSource source, Vec3d posArgument) {
        //GLOBAL VARIABLES
        ServerWorld world = source.getWorld();
        BlockPos spawnPos = BlockPos.ofFloored(posArgument);
        int spacing = 3;

        //CREATE ITEM STACK LISTS
        List<ItemStack> PICKAXES = new ArrayList<>();
        for (int pickaxe = 0; pickaxe < ModItems.PICKAXE_ITEMS.size(); pickaxe++) {
            ItemStack pickaxeStack = ModItems.PICKAXE_ITEMS.get(pickaxe).getDefaultStack();
            PICKAXES.add(pickaxeStack);
        }
        List<ItemStack> PLUSHIES = new ArrayList<>();
        for (int plush = 0; plush < ModItems.PLUSH_ITEMS.size(); plush++) {
            ItemStack plushStack = ModItems.PLUSH_ITEMS.get(plush).getDefaultStack();
            PLUSHIES.add(plushStack);
        }

        //GET BLOCKS LIST FROM THE ALREADY MADE BLOCK LIST
        List<Block> BLOCKS = new ArrayList<>(ModBlocks.PLUSH_BLOCKS);

        //CREATE VARIANTS LIST FROM BLOCK LIST NAMES
        List<String> VARIANTS = new ArrayList<>();
        for (Block value : BLOCKS) {
            String blockName = value.getTranslationKey().split("[.]")[2];
            VARIANTS.add(blockName);
        }

        //LIST OF LISTS
        List<List<?>> LISTS = List.of(
            PICKAXES,
            PLUSHIES,
            BLOCKS,
            VARIANTS
        );

        for (int list = 0; list < LISTS.size(); list++) {
            //HANDLE PLUSHIES SPAWNING
            List<?> currentList = LISTS.get(list);
            int plushiesRows = (int) Math.ceil(Math.sqrt(currentList.size()));
            int plushiesColumns = 9;
            int plushies = 0;

            //ROWS SPAWN
            for (int row = 0; row < plushiesRows; row++) {
                //COLUMNS SPAWN
                for (int column = 0; column < plushiesColumns; column++) {
                    //AVOID SPAWNING MORE ARMOR STANDS THAN NECESSARY
                    if (plushies < currentList.size()) {

                        //SPAWN ITEM ARMOR STANDS
                        if (
                            currentList.contains(PICKAXES.get(0)) ||
                            currentList.contains(PLUSHIES.get(0))
                        ){
                            ItemStack itemStack = (ItemStack) currentList.get(plushies);
                            Vec3d entitySpawnLocation = getEntitySpawnLocation(spawnPos, column, row, list, spacing);
                            ArmorStandEntity armorStandEntity = getArmorStandEntity(world, entitySpawnLocation, itemStack);
                            world.spawnEntity(armorStandEntity);
                        }

                        //PLACE PLUSHIE BLOCKS
                        if (currentList.contains(BLOCKS.get(0))){
                            BlockPos blockPos = spawnPos.add(column * spacing, list * spacing + 1, row * spacing);
                            BlockState blockState = ((Block) currentList.get(plushies)).getDefaultState();
                            world.setBlockState(blockPos, blockState);
                        }

                        //SPAWN ENTITIES
                        if (currentList.contains(VARIANTS.get(0))){
                            Vec3d entitySpawnLocation = getEntitySpawnLocation(spawnPos, column, row, list, spacing);
                            String blockName = (String) currentList.get(plushies);
                            //GET FIRST TWO WORDS
                            String entityName = blockName.split("_")[0] + "_" + blockName.split("_")[1];
                            //ENTITY TYPE REGISTRY
                            Registry<EntityType<?>> entityTypeRegistry = world.getRegistryManager().get(RegistryKeys.ENTITY_TYPE);

                            //ITERATE THROUGH ALL REGISTERED ENTITIES AND FILTER BY NAME
                            for (int entity = 0; entity < entityTypeRegistry.size(); entity++) {
                                if (Objects.requireNonNull(entityTypeRegistry.get(entity)).getTranslationKey().contains(entityName)){
                                    //SPAWN ENTITY ACCORDING TO BLOCK NAME
                                    PlushEntity spawned = (PlushEntity) Objects.requireNonNull(entityTypeRegistry.get(entity)).create(world);
                                    //SETUP AND SPAWN ENTITY
                                    setupEntity(Objects.requireNonNull(spawned), entitySpawnLocation);
                                    spawned.setVariantByBlock(blockName);
                                    world.spawnEntity(spawned);
                                }
                            }
                            
                        }

                    }
                    plushies++;
                }
            }
        }
        return 1;
    }

    private static Vec3d getEntitySpawnLocation (BlockPos spawnPos, int column, int row, int list, int spacing){
        return new Vec3d(
            spawnPos.getX() + column * spacing + 0.5,
            spawnPos.getY() + list * spacing,
            spawnPos.getZ() + row * spacing + 0.5
        );
    }

    private static void setupEntity(TameableEntity entity, Vec3d entitySpawn) {
        entity.setPosition(entitySpawn);
        entity.lookAt(EntityAnchorArgumentType.EntityAnchor.FEET, entitySpawn.add(0, 0 ,-1));
        entity.setAiDisabled(true);
        entity.setCustomName(Text.of("Plush"));
        entity.setSilent(true);
    }

    private static @NotNull ArmorStandEntity getArmorStandEntity(ServerWorld world, Vec3d entitySpawn, ItemStack plushItem) {
        ArmorStandEntity armorStandEntity = new ArmorStandEntity(EntityType.ARMOR_STAND, world);
        armorStandEntity.setPosition(entitySpawn);
        armorStandEntity.equipStack(EquipmentSlot.HEAD, plushItem);
        armorStandEntity.equipStack(EquipmentSlot.MAINHAND, plushItem);
        armorStandEntity.equipStack(EquipmentSlot.OFFHAND, plushItem);
        armorStandEntity.setShowArms(true);
        armorStandEntity.setYaw(180F);
        armorStandEntity.setCustomName(Text.of("Plush"));
        armorStandEntity.setNoGravity(true);
        return armorStandEntity;
    }

}
