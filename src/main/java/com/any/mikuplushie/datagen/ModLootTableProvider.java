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
		addDrop(ModBlocks.MIKU_PLUSH_SENBONZAKURA, ModItems.MIKU_PLUSH_SENBONZAKURA);
		addDrop(ModBlocks.MIKU_PLUSH_URAOTOMELOVERS, ModItems.MIKU_PLUSH_URAOTOMELOVERS);
		addDrop(ModBlocks.MIKU_PLUSH_PERSONADANCING, ModItems.MIKU_PLUSH_PERSONADANCING);
		addDrop(ModBlocks.MIKU_PLUSH_HELLOPLANET, ModItems.MIKU_PLUSH_HELLOPLANET);
		addDrop(ModBlocks.MIKU_PLUSH_HACHUNE, ModItems.MIKU_PLUSH_HACHUNE);
		addDrop(ModBlocks.MIKU_PLUSH_ZATSUNE, ModItems.MIKU_PLUSH_ZATSUNE);
		addDrop(ModBlocks.MIKU_PLUSH_INFINITY, ModItems.MIKU_PLUSH_INFINITY);
		addDrop(ModBlocks.MIKU_PLUSH_VAMPIRE, ModItems.MIKU_PLUSH_VAMPIRE);
		addDrop(ModBlocks.MIKU_PLUSH_WEREWOMAN, ModItems.MIKU_PLUSH_WEREWOMAN);
		addDrop(ModBlocks.MIKU_PLUSH_JASON, ModItems.MIKU_PLUSH_JASON);
		addDrop(ModBlocks.MIKU_PLUSH_MICHAEL_MYERS, ModItems.MIKU_PLUSH_MICHAEL_MYERS);
		addDrop(ModBlocks.MIKU_PLUSH_PUMPKIN, ModItems.MIKU_PLUSH_PUMPKIN);
		addDrop(ModBlocks.MIKU_PLUSH_GHOSTFACE, ModItems.MIKU_PLUSH_GHOSTFACE);
		addDrop(ModBlocks.MIKU_PLUSH_FRANKENSTEIN, ModItems.MIKU_PLUSH_FRANKENSTEIN);
		addDrop(ModBlocks.MIKU_PLUSH_MUMMY, ModItems.MIKU_PLUSH_MUMMY);
		addDrop(ModBlocks.MIKU_PLUSH_GHOST, ModItems.MIKU_PLUSH_GHOST);
		addDrop(ModBlocks.MIKU_PLUSH_PATATI, ModItems.MIKU_PLUSH_PATATI);
		addDrop(ModBlocks.MIKU_PLUSH_PATATA, ModItems.MIKU_PLUSH_PATATA);
		addDrop(ModBlocks.MIKU_PLUSH_DEVIL, ModItems.MIKU_PLUSH_DEVIL);
		addDrop(ModBlocks.MIKU_PLUSH_WITCH, ModItems.MIKU_PLUSH_WITCH);
	}
}
