package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generate() {
		addDrop(ModBlocks.MIKU_PLUSH_BR_BLOCK, ModItems.MIKU_PLUSH_BR);
		addDrop(ModBlocks.MIKU_PLUSH_BR_BA_BLOCK, ModItems.MIKU_PLUSH_BR_BA);
		addDrop(ModBlocks.MIKU_PLUSH_BIK_BLOCK, ModItems.MIKU_PLUSH_BIK);
		addDrop(ModBlocks.MIKU_PLUSH_BIK_BLOCK, ModItems.MIKU_PLUSH_BR_BEACH);
		addDrop(ModBlocks.MIKU_PLUSH_BIK_BLOCK, ModItems.MIKU_PLUSH_BR_BRAID);
		addDrop(ModBlocks.MIKU_PLUSH_BR_BA_DRUM_BLOCK, ModItems.MIKU_PLUSH_BR_BA_DRUM);
	}
}
