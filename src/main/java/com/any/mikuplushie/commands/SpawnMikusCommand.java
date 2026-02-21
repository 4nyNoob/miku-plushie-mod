package com.any.mikuplushie.commands;

import com.any.mikuplushie.entity.AbstractPlushEntity;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModItems;
import com.any.mikuplushie.util.ModUtil;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.world.entity.EntitySpawnReason;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.coordinates.Vec3Argument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SpawnMikusCommand {

    public static void register (CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("spawn_mikus")
            .then(Commands.argument("pos", Vec3Argument.vec3())
                .executes(commandContext ->
                    spawnMikus(commandContext.getSource(),
                        Vec3Argument.getVec3(commandContext, "pos"))))
        );
    }

    public static int spawnMikus(CommandSourceStack source, Vec3 posArgument) {
        //GLOBAL VARIABLES
        ServerLevel world = source.getLevel();
        BlockPos spawnPos = BlockPos.containing(posArgument);
        int spacing = 3;

        //CREATE ITEM STACK LISTS
        List<ItemStack> PICKAXES = new ArrayList<>();
        for (int pickaxe = 0; pickaxe < ModItems.PICKAXE_ITEMS.size(); pickaxe++) {
            ItemStack pickaxeStack = ModItems.PICKAXE_ITEMS.get(pickaxe).getDefaultInstance();
            PICKAXES.add(pickaxeStack);
        }
        List<ItemStack> PLUSHIES = new ArrayList<>();
        for (int plush = 0; plush < ModItems.PLUSH_ITEMS.size(); plush++) {
            ItemStack plushStack = ModItems.PLUSH_ITEMS.get(plush).getDefaultInstance();
            PLUSHIES.add(plushStack);
        }

        //GET BLOCKS LIST FROM THE ALREADY MADE BLOCK LIST
        List<Block> BLOCKS = new ArrayList<>(ModBlocks.PLUSH_BLOCKS);

        //CREATE VARIANTS LIST FROM BLOCK LIST NAMES
        List<String> VARIANTS = new ArrayList<>();
        for (Block value : BLOCKS) {
            String blockName = ModUtil.getBlockIdFromBlock(value);
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
            int plushiesColumns = 9;
            int plushiesRows = (int) Math.ceil((double) currentList.size() / plushiesColumns);
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
                            Vec3 entitySpawnLocation = getEntitySpawnLocation(spawnPos, column, row, list, spacing);
                            ArmorStand armorStandEntity = getArmorStandEntity(world, entitySpawnLocation, itemStack);
                            world.addFreshEntity(armorStandEntity);
                        }

                        //PLACE PLUSHIE BLOCKS
                        if (currentList.contains(BLOCKS.get(0))){
                            BlockPos blockPos = spawnPos.offset(column * spacing, list * spacing + 1, row * spacing);
                            BlockState blockState = ((Block) currentList.get(plushies)).defaultBlockState();
                            world.setBlockAndUpdate(blockPos, blockState);
                        }

                        //SPAWN ENTITIES
                        if (currentList.contains(VARIANTS.get(0))){
                            Vec3 entitySpawnLocation = getEntitySpawnLocation(spawnPos, column, row, list, spacing);
                            String blockName = (String) currentList.get(plushies);
                            //GET FIRST TWO WORDS
                            String entityName = ModUtil.getEntityNameFromBlockId(blockName);
                            //ENTITY TYPE REGISTRY
                            Registry<EntityType<?>> entityTypeRegistry = (Registry<EntityType<?>>) world.registryAccess().getOrThrow(Registries.ENTITY_TYPE);

                            //ITERATE THROUGH ALL REGISTERED ENTITIES AND FILTER BY NAME
                            for (int entity = 0; entity < entityTypeRegistry.size(); entity++) {
                                if (Objects.requireNonNull(entityTypeRegistry.byId(entity)).getDescriptionId().contains(entityName)){
                                    //SPAWN ENTITY ACCORDING TO BLOCK NAME
                                    AbstractPlushEntity spawned = (AbstractPlushEntity) Objects.requireNonNull(entityTypeRegistry.byId(entity)).create(world, EntitySpawnReason.COMMAND);
                                    //SETUP AND SPAWN ENTITY
                                    setupEntity(Objects.requireNonNull(spawned), entitySpawnLocation);
                                    spawned.setVariantByBlock(blockName);
                                    world.addFreshEntity(spawned);
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

    private static Vec3 getEntitySpawnLocation (BlockPos spawnPos, int column, int row, int list, int spacing){
        return new Vec3(
            spawnPos.getX() + column * spacing + 0.5,
            spawnPos.getY() + list * spacing,
            spawnPos.getZ() + row * spacing + 0.5
        );
    }

    private static void setupEntity(TamableAnimal entity, Vec3 entitySpawn) {
        entity.setPos(entitySpawn);
        entity.lookAt(EntityAnchorArgument.Anchor.FEET, entitySpawn.add(0, 0 ,-1));
        entity.setNoAi(true);
        entity.setCustomName(Component.nullToEmpty("Plush"));
        entity.setSilent(true);
    }

    private static @NotNull ArmorStand getArmorStandEntity(ServerLevel world, Vec3 entitySpawn, ItemStack plushItem) {
        ArmorStand armorStandEntity = new ArmorStand(EntityType.ARMOR_STAND, world);
        armorStandEntity.setPos(entitySpawn);
        armorStandEntity.setItemSlot(EquipmentSlot.HEAD, plushItem);
        armorStandEntity.setItemSlot(EquipmentSlot.MAINHAND, plushItem);
        armorStandEntity.setItemSlot(EquipmentSlot.OFFHAND, plushItem);
        armorStandEntity.setShowArms(true);
        armorStandEntity.setYRot(180F);
        armorStandEntity.setCustomName(Component.nullToEmpty("Plush"));
        armorStandEntity.setNoGravity(true);
        return armorStandEntity;
    }

}
