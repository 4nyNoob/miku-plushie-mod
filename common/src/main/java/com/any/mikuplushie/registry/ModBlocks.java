package com.any.mikuplushie.registry;

import com.any.mikuplushie.CommonClass;
import com.any.mikuplushie.Constants;
import com.any.mikuplushie.block.MikuPlushieBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.intellij.lang.annotations.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModBlocks {
    public static List<Block> PLUSH_BLOCKS = new ArrayList<>();

    public static final Block MIKU_PLUSH_BR = registerPlush("miku_plush_br");

    //REGISTER PLUSHIES
    public static Block registerPlush(String name) {
        //IF THE BLOCK SOUND IS NULL SET TO WOOL
//        SoundType blockSoundGroup = null;
//        blockSoundGroup = Objects.requireNonNullElse(blockSound, SoundType.WOOL);
        //REGISTER BLOCK NORMALLY
//        return register(
//            new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
//                .sound(blockSoundGroup).noOcclusion()), name, false);
        return register(
            new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)),
            name,
            true);
    }

    //REGISTER REGULAR BLOCKS
    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        //CREATE IDENTIFIER
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name);

        //REGISTER ITEM IF REQUESTED
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Properties());
            Registry.register(BuiltInRegistries.ITEM, id, blockItem);
        }

        Block blockRegister = Registry.register(BuiltInRegistries.BLOCK, id, block);

        //IF BLOCK IS A PLUSH ADD IT TO THE LIST
        if (block instanceof MikuPlushieBlock){
            PLUSH_BLOCKS.add(block);
        }

        return blockRegister;
    }

    public static void initialize(){
        Constants.LOG.info("Registering " + Constants.MOD_ID + " Blocks");
    }
}
