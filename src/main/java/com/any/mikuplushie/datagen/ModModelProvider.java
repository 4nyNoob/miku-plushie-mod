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
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_BLOCK);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_BA_BLOCK);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BIK_BLOCK);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_BEACH_BLOCK);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_BRAID_BLOCK);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_BA_DRUM_BLOCK);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_PR_BLOCK);
		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MIKU_PLUSH_BR_SP_BLOCK);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.CANUDINHO, Models.GENERATED);
	}
}
