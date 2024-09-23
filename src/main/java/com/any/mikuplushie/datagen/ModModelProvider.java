package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

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
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.CANUDINHO, Models.GENERATED);
	}
}
