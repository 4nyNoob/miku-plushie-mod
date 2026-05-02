package com.any.mikuplushie.registry;

import com.any.mikuplushie.CommonClass;
import com.any.mikuplushie.Constants;
import com.any.mikuplushie.block.MikuPlushieBlock;
import com.any.mikuplushie.registration.RegistrationProvider;
import com.any.mikuplushie.registration.RegistryObject;
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

    public static final RegistrationProvider<Block> BLOCKS =
        RegistrationProvider.get(Registries.BLOCK, Constants.MOD_ID);
    public static final RegistrationProvider<Item> ITEMS =
        RegistrationProvider.get(Registries.ITEM, Constants.MOD_ID);


    public static List<RegistryObject<Block, MikuPlushieBlock>> PLUSH_BLOCKS = new ArrayList<>();

    public static final RegistryObject<Block, MikuPlushieBlock> MIKU_PLUSH_BR = registerPlush("miku_plush_br");

    //REGISTER PLUSHIES
    public static RegistryObject<Block, MikuPlushieBlock> registerPlush(String name) {

        RegistryObject<Block, MikuPlushieBlock> plushBlock = BLOCKS.register(name, () -> new MikuPlushieBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)
        ));

        PLUSH_BLOCKS.add(plushBlock);
        return plushBlock;
    }
    //REGISTER PLUSHIES WITH CUSTOM SOUND
    public static RegistryObject<Block, MikuPlushieBlock> registerPlush(String name, SoundType soundType) {

        RegistryObject<Block, MikuPlushieBlock> plushBlock = BLOCKS.register(name, () -> new MikuPlushieBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(soundType)
        ));

        PLUSH_BLOCKS.add(plushBlock);
        return plushBlock;
    }


    public static void initialize(){
        Constants.LOG.info("Registering " + Constants.MOD_ID + " Blocks");
    }
}
