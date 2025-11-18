package com.any.mikuplushie.commands;

import com.any.mikuplushie.ModEntities;
import com.any.mikuplushie.datagen.ModTagProvider;
import com.any.mikuplushie.entity.*;
import com.any.mikuplushie.entity.variant.MikuVariant;
import com.any.mikuplushie.entity.variant.NeruVariant;
import com.any.mikuplushie.entity.variant.TetoVariant;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.block.Block;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.command.argument.Vec3ArgumentType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
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

        //CREATE LISTS FROM ITEM TAG
        Registry<Item> itemRegistry = world.getRegistryManager().get(RegistryKeys.ITEM);
        Registry<Block> blockRegistry = world.getRegistryManager().get(RegistryKeys.BLOCK);
        List<ItemStack> PLUSHIES = new ArrayList<>();
        List<ItemStack> PICKAXES = new ArrayList<>();

        for (int item = 0; item < itemRegistry.size(); item++) {
            if (Objects.requireNonNull(itemRegistry.get(item)).getDefaultStack().isIn(ModTagProvider.PLUSHIES)){
                PLUSHIES.add(Objects.requireNonNull(itemRegistry.get(item)).getDefaultStack());
            }
            if (Objects.requireNonNull(itemRegistry.get(item)).getDefaultStack().isIn(ModTagProvider.TETO_PICKAXE)){
                PICKAXES.add(Objects.requireNonNull(itemRegistry.get(item)).getDefaultStack());
            }
        }

        List<Block> BLOCKS = new ArrayList<>();
        for (int block = 0; block < blockRegistry.size(); block++) {
            if (Objects.requireNonNull(blockRegistry.get(block)).asItem().getDefaultStack().isIn(ModTagProvider.PLUSHIES)){
                BLOCKS.add(blockRegistry.get(block));
            }
        }

        List<String> VARIANTS = new ArrayList<>();
        for (int variant = 0; variant < MikuVariant.values().length; variant++) {
            VARIANTS.add(MikuVariant.byId(variant).getBlock());
        }
        for (int variant = 0; variant < TetoVariant.values().length; variant++) {
            VARIANTS.add(TetoVariant.byId(variant).getBlock());
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
            int mikuVariation = 0;
            int tetoVariation = 0;
            int neruVariation = 0;

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
                            world.setBlockState(blockPos, ((Block) currentList.get(plushies)).getDefaultState());
                        }

                        //SPAWN MIKU ENTITIES
                        else if (currentList.contains(VARIANTS.get(0))) {
                            Vec3d entitySpawnLocation = getEntitySpawnLocation(spawnPos, column, row, list, spacing);

                            //CHECK IF BLOCK BELLOW IS A MIKU PLUSH
                            if (isVariationAboveBlock(world, entitySpawnLocation, ModTagProvider.MIKU_PLUSH)) {
                                MikuEntity entity = new MikuEntity(ModEntities.MIKU, world);
                                entity.setVariant(MikuVariant.byId(mikuVariation));
                                setupEntity(entity, entitySpawnLocation);
                                world.spawnEntity(entity);
                                mikuVariation++;
                            }

                            //CHECK IF BLOCK BELLOW IS A TETO PLUSH
                            if (isVariationAboveBlock(world, entitySpawnLocation, ModTagProvider.TETO_PLUSH)) {
                                TetoEntity entity = new TetoEntity(ModEntities.TETO, world);
                                entity.setVariant(TetoVariant.byId(tetoVariation));
                                setupEntity(entity, entitySpawnLocation);
                                world.spawnEntity(entity);
                                tetoVariation++;
                            }

                            //CHECK IF BLOCK BELLOW IS A AIKO PLUSH
                            if (isVariationAboveBlock(world, entitySpawnLocation, ModTagProvider.AIKO_PLUSH)) {
                                AikoEntity entity = new AikoEntity(ModEntities.AIKO, world);
                                setupEntity(entity, entitySpawnLocation);
                                world.spawnEntity(entity);
                            }

                            //CHECK IF BLOCK BELLOW IS A NERU PLUSH
                            if (isVariationAboveBlock(world, entitySpawnLocation, ModTagProvider.NERU_PLUSH)) {
                                NeruEntity entity = new NeruEntity(ModEntities.NERU, world);
                                entity.setVariant(NeruVariant.byId(neruVariation));
                                setupEntity(entity, entitySpawnLocation);
                                world.spawnEntity(entity);
                                neruVariation++;
                            }

                            //CHECK IF BLOCK BELLOW IS A RIN PLUSH
                            if (isVariationAboveBlock(world, entitySpawnLocation, ModTagProvider.RIN_PLUSH)) {
                                RinEntity entity = new RinEntity(ModEntities.RIN, world);
                                setupEntity(entity, entitySpawnLocation);
                                world.spawnEntity(entity);
                            }

                            //CHECK IF BLOCK BELLOW IS A LEN PLUSH
                            if (isVariationAboveBlock(world, entitySpawnLocation, ModTagProvider.LEN_PLUSH)) {
                                LenEntity entity = new LenEntity(ModEntities.LEN, world);
                                setupEntity(entity, entitySpawnLocation);
                                world.spawnEntity(entity);
                            }

                            //CHECK IF BLOCK BELLOW IS A KONOHA PLUSH
                            if (isVariationAboveBlock(world, entitySpawnLocation, ModTagProvider.KONOHA_PLUSH)) {
                                KonohaEntity entity = new KonohaEntity(ModEntities.KONOHA, world);
                                setupEntity(entity, entitySpawnLocation);
                                world.spawnEntity(entity);
                            }

                            //CHECK IF BLOCK BELLOW IS A LUKA PLUSH
                            if (isVariationAboveBlock(world, entitySpawnLocation, ModTagProvider.LUKA_PLUSH)) {
                                LukaEntity entity = new LukaEntity(ModEntities.LUKA, world);
                                setupEntity(entity, entitySpawnLocation);
                                world.spawnEntity(entity);
                            }

                            //ELSE DO NOTHING
                            else {
                                continue;
                            }
                        }

                    }
                    plushies++;
                }
            }
        }
        return 1;
    }

    private static boolean isVariationAboveBlock(World world, Vec3d entitySpawnPos, TagKey<Item> itemTag){
        BlockPos blockPos = BlockPos.ofFloored(entitySpawnPos.subtract(0, 2, 0));
        return world.getBlockState(blockPos).getBlock().asItem().getDefaultStack().isIn(itemTag);
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
