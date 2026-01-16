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
		dropOther(ModBlocks.AIKO_PLUSH.get(), ModItems.AIKO_PLUSH.get());
		dropOther(ModBlocks.TETO_PLUSH.get(), ModItems.TETO_PLUSH.get());
		dropOther(ModBlocks.AKITA_NERU_PLUSH.get(), ModItems.AKITA_NERU_PLUSH.get());
		dropOther(ModBlocks.MIKU_PLUSH.get(), ModItems.MIKU_PLUSH.get());
		dropOther(ModBlocks.RIN_PLUSH.get(), ModItems.RIN_PLUSH.get());
		dropOther(ModBlocks.LEN_PLUSH.get(), ModItems.LEN_PLUSH.get());
		dropOther(ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS.get(), ModItems.MIKU_PLUSH_SONIC_CROSSWORLDS.get());
		dropOther(ModBlocks.MIKU_PLUSH_FORTNITE_NEKO.get(), ModItems.MIKU_PLUSH_FORTNITE_NEKO.get());
		dropOther(ModBlocks.MIKU_PLUSH_V4.get(), ModItems.MIKU_PLUSH_V4.get());
		dropOther(ModBlocks.MIKU_PLUSH_MESMERIZER.get(), ModItems.MIKU_PLUSH_MESMERIZER.get());
		dropOther(ModBlocks.TETO_PLUSH_MESMERIZER.get(), ModItems.TETO_PLUSH_MESMERIZER.get());
		dropOther(ModBlocks.MIKU_PLUSH_SONIC.get(), ModItems.MIKU_PLUSH_SONIC.get());
		dropOther(ModBlocks.TETO_PLUSH_SHADOW.get(), ModItems.TETO_PLUSH_SHADOW.get());
		dropOther(ModBlocks.AKITA_NERU_PLUSH_TAILS.get(), ModItems.AKITA_NERU_PLUSH_TAILS.get());
		dropOther(ModBlocks.TETO_PLUSH_BIRDBRAIN.get(), ModItems.TETO_PLUSH_BIRDBRAIN.get());
		dropOther(ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025.get(), ModItems.MIKU_PLUSH_DIGITAL_STARS_2025.get());
		dropOther(ModBlocks.MIKU_PLUSH_ROTTEN_GIRL.get(), ModItems.MIKU_PLUSH_ROTTEN_GIRL.get());
		dropOther(ModBlocks.TETO_PLUSH_REGRET_ROCK.get(), ModItems.TETO_PLUSH_REGRET_ROCK.get());
		dropOther(ModBlocks.MIKU_PLUSH_PSYCHO_MODE.get(), ModItems.MIKU_PLUSH_PSYCHO_MODE.get());
		dropOther(ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T.get(), ModItems.MIKU_PLUSH_DONT_BELIEVE_IN_T.get());
		dropOther(ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T.get(), ModItems.TETO_PLUSH_DONT_BELIEVE_IN_T.get());
		dropOther(ModBlocks.TETO_PLUSH_LIAR_DANCER.get(), ModItems.TETO_PLUSH_LIAR_DANCER.get());
		dropOther(ModBlocks.MIKU_PLUSH_STATIC.get(), ModItems.MIKU_PLUSH_STATIC.get());
		dropOther(ModBlocks.MIKU_PLUSH_MOCHIMOCHI.get(), ModItems.MIKU_PLUSH_MOCHIMOCHI.get());
		dropOther(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME.get(), ModItems.TETO_PLUSH_WHATCHACALLITSNAME.get());
		dropOther(ModBlocks.MIKU_PLUSH_MONITORING.get(), ModItems.MIKU_PLUSH_MONITORING.get());
        dropOther(ModBlocks.KONOHA_PLUSH.get(), ModItems.KONOHA_PLUSH.get());
        dropOther(ModBlocks.LUKA_PLUSH.get(), ModItems.LUKA_PLUSH.get());
        dropOther(ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG.get(), ModItems.TETO_PICKAXE_SOME_MORE_OF_THAT_SONG.get());
        dropOther(ModBlocks.TETO_PLUSH_LOBSTER.get(), ModItems.TETO_PLUSH_LOBSTER.get());
        dropOther(ModBlocks.MIKU_PLUSH_HOLLOW_KNIGHT.get(), ModItems.MIKU_PLUSH_HOLLOW_KNIGHT.get());
        dropOther(ModBlocks.MIKU_PLUSH_HORNET.get(), ModItems.MIKU_PLUSH_HORNET.get());
        dropOther(ModBlocks.TETO_PLUSH_SYNTHV.get(), ModItems.TETO_PLUSH_SYNTHV.get());
        dropOther(ModBlocks.MIKU_PLUSH_WORLD_IS_MINE.get(), ModItems.MIKU_PLUSH_WORLD_IS_MINE.get());
        dropOther(ModBlocks.MIKU_PLUSH_ROLLING_GIRL.get(), ModItems.MIKU_PLUSH_ROLLING_GIRL.get());
        dropOther(ModBlocks.TETO_PLUSH_SPOKEN_FOR.get(), ModItems.TETO_PLUSH_SPOKEN_FOR.get());
        dropOther(ModBlocks.MEIKO_PLUSH.get(), ModItems.MEIKO_PLUSH.get());
        dropOther(ModBlocks.MEIKO_PLUSH_V3.get(), ModItems.MEIKO_PLUSH_V3.get());
        dropOther(ModBlocks.MEIKO_PLUSH_V4.get(), ModItems.MEIKO_PLUSH_V4.get());
        dropOther(ModBlocks.GUMI_PLUSH.get(), ModItems.GUMI_PLUSH.get());
        dropOther(ModBlocks.GUMI_PLUSH_V3.get(), ModItems.GUMI_PLUSH_V3.get());
        dropOther(ModBlocks.GUMI_PLUSH_V4.get(), ModItems.GUMI_PLUSH_V4.get());
        dropOther(ModBlocks.GUMI_PLUSH_V6.get(), ModItems.GUMI_PLUSH_V6.get());
        dropOther(ModBlocks.MIKU_PLUSH_DEEP_SEA_GIRL.get(), ModItems.MIKU_PLUSH_DEEP_SEA_GIRL.get());
        dropOther(ModBlocks.MIKU_PLUSH_LUCARIO_Z.get(), ModItems.MIKU_PLUSH_LUCARIO_Z.get());
        dropOther(ModBlocks.TETO_PLUSH_PPPP.get(), ModItems.TETO_PLUSH_PPPP.get());
        dropOther(ModBlocks.MIKU_PLUSH_PPPP.get(), ModItems.MIKU_PLUSH_PPPP.get());
        dropOther(ModBlocks.TETO_PLUSH_SHRIMP.get(), ModItems.TETO_PLUSH_SHRIMP.get());
        dropOther(ModBlocks.MIKU_PLUSH_LINK.get(), ModItems.MIKU_PLUSH_LINK.get());
        dropOther(ModBlocks.MIKU_PLUSH_RENAISSANCE.get(), ModItems.MIKU_PLUSH_RENAISSANCE.get());
        dropOther(ModBlocks.KAITO_PLUSH.get(), ModItems.KAITO_PLUSH.get());
        dropOther(ModBlocks.KAITO_PLUSH_V3.get(), ModItems.KAITO_PLUSH_V3.get());
        dropOther(ModBlocks.KAITO_PLUSH_V4.get(), ModItems.KAITO_PLUSH_V4.get());
		//use dropSelf() for further entries
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value).toList();
	}
}
