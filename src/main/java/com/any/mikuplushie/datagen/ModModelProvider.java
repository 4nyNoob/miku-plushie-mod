package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import com.google.gson.JsonElement;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModModelProvider extends FabricModelProvider {

	public ModModelProvider(FabricDataOutput output) {
		super(output);
    }

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_BA);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BIK);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_BEACH);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_BRAID);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_BA_DRUM);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_PA);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_SP);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_MG);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_BROWN_BRO);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_AM);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_FUT_FLA);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_FUT_CAM);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_GO);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_FUT_CRVG);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_RS);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_FROG);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_MUSHROOM);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_SENBONZAKURA);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_URAOTOMELOVERS);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_PERSONADANCING);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_HELLOPLANET);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_HACHUNE);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_ZATSUNE);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_INFINITY);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_VAMPIRE);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_WEREWOMAN);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_JASON);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_MICHAEL_MYERS);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_PUMPKIN);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_GHOSTFACE);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_FRANKENSTEIN);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_MUMMY);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_GHOST);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_PATATI);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_PATATA);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_DEVIL);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_WITCH);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_SANTA);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_REINDEER);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_SANTA_ELF);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_XMAS_TREE);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.AIKO_PLUSH);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.AKITA_NERU_PLUSH);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.RIN_PLUSH);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.LEN_PLUSH);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_FORTNITE_NEKO);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_V4);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_MESMERIZER);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH_MESMERIZER);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_SONIC);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH_SHADOW);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.AKITA_NERU_PLUSH_TAILS);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH_BIRDBRAIN);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_ROTTEN_GIRL);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH_REGRET_ROCK);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_PSYCHO_MODE);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH_LIAR_DANCER);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_STATIC);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_MOCHIMOCHI);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_MONITORING);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KONOHA_PLUSH);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.LUKA_PLUSH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH_LOBSTER);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_HOLLOW_KNIGHT);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_HORNET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH_SYNTHV);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_WORLD_IS_MINE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_ROLLING_GIRL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TETO_PLUSH_SPOKEN_FOR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MEIKO_PLUSH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MEIKO_PLUSH_V3);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MEIKO_PLUSH_V4);

        BlockModels.registerCrop(blockStateModelGenerator, ModBlocks.LEEK_CROP, CropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.CANUDINHO, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEEK_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEEK, Models.HANDHELD);
//		itemModelGenerator.register(ModItems.BAGUETTE, Models.GENERATED);
	}
}
