package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		addDrop(ModBlocks.MIKU_PLUSH_BR, ModItems.MIKU_PLUSH_BR);
		addDrop(ModBlocks.MIKU_PLUSH_BR_BA, ModItems.MIKU_PLUSH_BR_BA);
		addDrop(ModBlocks.MIKU_PLUSH_BIK, ModItems.MIKU_PLUSH_BIK);
		addDrop(ModBlocks.MIKU_PLUSH_BR_BEACH, ModItems.MIKU_PLUSH_BR_BEACH);
		addDrop(ModBlocks.MIKU_PLUSH_BR_BRAID, ModItems.MIKU_PLUSH_BR_BRAID);
		addDrop(ModBlocks.MIKU_PLUSH_BR_BA_DRUM, ModItems.MIKU_PLUSH_BR_BA_DRUM);
		addDrop(ModBlocks.MIKU_PLUSH_BR_PA, ModItems.MIKU_PLUSH_BR_PA);
		addDrop(ModBlocks.MIKU_PLUSH_BR_SP, ModItems.MIKU_PLUSH_BR_SP);
		addDrop(ModBlocks.MIKU_PLUSH_BR_MG, ModItems.MIKU_PLUSH_BR_MG);
		addDrop(ModBlocks.MIKU_PLUSH_BR_BROWN_BRO, ModItems.MIKU_PLUSH_BR_BROWN_BRO);
		addDrop(ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN, ModItems.MIKU_PLUSH_BR_ELECTRICIAN);
		addDrop(ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE, ModItems.MIKU_PLUSH_BR_BIK_ORANGE);
		addDrop(ModBlocks.MIKU_PLUSH_BR_AM, ModItems.MIKU_PLUSH_BR_AM);
		addDrop(ModBlocks.MIKU_PLUSH_BR_FUT_FLA, ModItems.MIKU_PLUSH_BR_FUT_FLA);
		addDrop(ModBlocks.MIKU_PLUSH_BR_FUT_CAM, ModItems.MIKU_PLUSH_BR_FUT_CAM);
		addDrop(ModBlocks.MIKU_PLUSH_BR_GO, ModItems.MIKU_PLUSH_BR_GO);
		addDrop(ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE, ModItems.MIKU_PLUSH_BR_SCHOOL_PE);
		addDrop(ModBlocks.MIKU_PLUSH_BR_FUT_CRVG, ModItems.MIKU_PLUSH_BR_FUT_CRVG);
		addDrop(ModBlocks.MIKU_PLUSH_BR_RS, ModItems.MIKU_PLUSH_BR_RS);
		addDrop(ModBlocks.MIKU_PLUSH_FROG, ModItems.MIKU_PLUSH_FROG);
		addDrop(ModBlocks.MIKU_PLUSH_MUSHROOM, ModItems.MIKU_PLUSH_MUSHROOM);
	}
}
