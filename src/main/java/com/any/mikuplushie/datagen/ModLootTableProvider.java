package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModLootTableProvider extends BlockLootSubProvider {
	public ModLootTableProvider(HolderLookup.Provider registries) {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
	}

	@Override
	public void generate() {
		dropOther(ModBlocks.MIKU_PLUSH_BR.get(), ModItems.MIKU_PLUSH_BR.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_BA.get(), ModItems.MIKU_PLUSH_BR_BA.get());
		dropOther(ModBlocks.MIKU_PLUSH_BIK.get(), ModItems.MIKU_PLUSH_BIK.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_BEACH.get(), ModItems.MIKU_PLUSH_BR_BEACH.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_BRAID.get(), ModItems.MIKU_PLUSH_BR_BRAID.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_BA_DRUM.get(), ModItems.MIKU_PLUSH_BR_BA_DRUM.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_PA.get(), ModItems.MIKU_PLUSH_BR_PA.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_SP.get(), ModItems.MIKU_PLUSH_BR_SP.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_MG.get(), ModItems.MIKU_PLUSH_BR_MG.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_BROWN_BRO.get(), ModItems.MIKU_PLUSH_BR_BROWN_BRO.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN.get(), ModItems.MIKU_PLUSH_BR_ELECTRICIAN.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE.get(), ModItems.MIKU_PLUSH_BR_BIK_ORANGE.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_AM.get(), ModItems.MIKU_PLUSH_BR_AM.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_FUT_FLA.get(), ModItems.MIKU_PLUSH_BR_FUT_FLA.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_FUT_CAM.get(), ModItems.MIKU_PLUSH_BR_FUT_CAM.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_GO.get(), ModItems.MIKU_PLUSH_BR_GO.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE.get(), ModItems.MIKU_PLUSH_BR_SCHOOL_PE.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_FUT_CRVG.get(), ModItems.MIKU_PLUSH_BR_FUT_CRVG.get());
		dropOther(ModBlocks.MIKU_PLUSH_BR_RS.get(), ModItems.MIKU_PLUSH_BR_RS.get());
		dropOther(ModBlocks.MIKU_PLUSH_FROG.get(), ModItems.MIKU_PLUSH_FROG.get());
		dropOther(ModBlocks.MIKU_PLUSH_MUSHROOM.get(), ModItems.MIKU_PLUSH_MUSHROOM.get());
		dropOther(ModBlocks.MIKU_PLUSH_SENBONZAKURA.get(), ModItems.MIKU_PLUSH_SENBONZAKURA.get());
		dropOther(ModBlocks.MIKU_PLUSH_URAOTOMELOVERS.get(), ModItems.MIKU_PLUSH_URAOTOMELOVERS.get());
		dropOther(ModBlocks.MIKU_PLUSH_PERSONADANCING.get(), ModItems.MIKU_PLUSH_PERSONADANCING.get());
		dropOther(ModBlocks.MIKU_PLUSH_HELLOPLANET.get(), ModItems.MIKU_PLUSH_HELLOPLANET.get());
		dropOther(ModBlocks.MIKU_PLUSH_HACHUNE.get(), ModItems.MIKU_PLUSH_HACHUNE.get());
		dropOther(ModBlocks.MIKU_PLUSH_ZATSUNE.get(), ModItems.MIKU_PLUSH_ZATSUNE.get());
		dropOther(ModBlocks.MIKU_PLUSH_INFINITY.get(), ModItems.MIKU_PLUSH_INFINITY.get());
		dropOther(ModBlocks.MIKU_PLUSH_VAMPIRE.get(), ModItems.MIKU_PLUSH_VAMPIRE.get());
		dropOther(ModBlocks.MIKU_PLUSH_WEREWOMAN.get(), ModItems.MIKU_PLUSH_WEREWOMAN.get());
		dropOther(ModBlocks.MIKU_PLUSH_JASON.get(), ModItems.MIKU_PLUSH_JASON.get());
		dropOther(ModBlocks.MIKU_PLUSH_MICHAEL_MYERS.get(), ModItems.MIKU_PLUSH_MICHAEL_MYERS.get());
		dropOther(ModBlocks.MIKU_PLUSH_PUMPKIN.get(), ModItems.MIKU_PLUSH_PUMPKIN.get());
		dropOther(ModBlocks.MIKU_PLUSH_GHOSTFACE.get(), ModItems.MIKU_PLUSH_GHOSTFACE.get());
		dropOther(ModBlocks.MIKU_PLUSH_FRANKENSTEIN.get(), ModItems.MIKU_PLUSH_FRANKENSTEIN.get());
		dropOther(ModBlocks.MIKU_PLUSH_MUMMY.get(), ModItems.MIKU_PLUSH_MUMMY.get());
		dropOther(ModBlocks.MIKU_PLUSH_GHOST.get(), ModItems.MIKU_PLUSH_GHOST.get());
		dropOther(ModBlocks.MIKU_PLUSH_PATATI.get(), ModItems.MIKU_PLUSH_PATATI.get());
		dropOther(ModBlocks.MIKU_PLUSH_PATATA.get(), ModItems.MIKU_PLUSH_PATATA.get());
		dropOther(ModBlocks.MIKU_PLUSH_DEVIL.get(), ModItems.MIKU_PLUSH_DEVIL.get());
		dropOther(ModBlocks.MIKU_PLUSH_WITCH.get(), ModItems.MIKU_PLUSH_WITCH.get());
		dropOther(ModBlocks.MIKU_PLUSH_SANTA.get(), ModItems.MIKU_PLUSH_SANTA.get());
		dropOther(ModBlocks.MIKU_PLUSH_REINDEER.get(), ModItems.MIKU_PLUSH_REINDEER.get());
		dropOther(ModBlocks.MIKU_PLUSH_SANTA_ELF.get(), ModItems.MIKU_PLUSH_SANTA_ELF.get());
		dropOther(ModBlocks.MIKU_PLUSH_XMAS_TREE.get(), ModItems.MIKU_PLUSH_XMAS_TREE.get());
		//use dropSelf() for further entries
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value).toList();
	}
}
