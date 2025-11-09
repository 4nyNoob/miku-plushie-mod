package com.any.mikuplushie.commands;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModEntities;
import com.any.mikuplushie.datagen.ModTagProvider;
import com.any.mikuplushie.entity.MikuEntity;
import com.any.mikuplushie.entity.variant.MikuVariant;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.block.Block;
import net.minecraft.command.argument.Vec3ArgumentType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtTypes;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

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

        List<MikuVariant> VARIANTS = new ArrayList<>();
        for (int variant = 0; variant < MikuVariant.values().length; variant++) {
            VARIANTS.add(MikuVariant.byId(variant));
        }

        //LIST OF LISTS
        List<List<?>> LISTS = List.of(
            PLUSHIES,
            PICKAXES,
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
            for (int r = 0; r < plushiesRows; r++) {
                //COLUMNS SPAWN
                for (int c = 0; c < plushiesColumns; c++) {
                    //AVOID SPAWNING MORE ARMOR STANDS THAN NECESSARY
                    if (plushies < currentList.size()) {
                        //PLACE PLUSHIE BLOCKS
                        if (currentList.contains(ModBlocks.MIKU_PLUSH_BR)){
                            BlockPos blockPos = spawnPos.add(c * spacing, list * spacing + 1, r * spacing);
                            world.setBlockState(blockPos, ((Block) currentList.get(plushies)).getDefaultState());
                        } else if (currentList.contains(MikuVariant.MIKU_PLUSH_BR)) {
                            MikuEntity mikuEntity = new MikuEntity(ModEntities.MIKU, world);
                            mikuEntity.setPosition(
                                spawnPos.getX() + c * spacing + 0.5,
                                spawnPos.getY() + list * spacing,
                                spawnPos.getZ() + r * spacing + 0.5
                            );
                            mikuEntity.setHeadYaw(180F);
                            mikuEntity.setVariant(MikuVariant.byId(plushies));
                            mikuEntity.setAiDisabled(true);
                            mikuEntity.setCustomName(Text.of("Plush"));
                            mikuEntity.setCustomNameVisible(false);
                            mikuEntity.setSilent(true);
                            world.spawnEntity(mikuEntity);
                        }
                        //CREATE AND SPAWN ARMOR STAND
                        else {
                            ArmorStandEntity armorStandEntity = new ArmorStandEntity(world,
                                spawnPos.getX() + c * spacing + 0.5,
                                spawnPos.getY() + list * spacing,
                                spawnPos.getZ() + r * spacing + 0.5
                            );
                            ItemStack itemStack = (ItemStack) currentList.get(plushies);
                            armorStandEntity.equipStack(EquipmentSlot.HEAD, itemStack);
                            armorStandEntity.equipStack(EquipmentSlot.MAINHAND, itemStack);
                            armorStandEntity.equipStack(EquipmentSlot.OFFHAND, itemStack);
                            armorStandEntity.setShowArms(true);
                            armorStandEntity.setYaw(180F);
                            armorStandEntity.setNoGravity(true);
                            armorStandEntity.setCustomName(Text.of("Plush"));
                            world.spawnEntity(armorStandEntity);
                        }
                    }
                    plushies++;
                }
            }
        }
        return 1;
    }

}
