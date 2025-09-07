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
		addDrop(ModBlocks.MIKU_PLUSH_SANTA, ModItems.MIKU_PLUSH_SANTA);
		addDrop(ModBlocks.MIKU_PLUSH_REINDEER, ModItems.MIKU_PLUSH_REINDEER);
		addDrop(ModBlocks.MIKU_PLUSH_SANTA_ELF, ModItems.MIKU_PLUSH_SANTA_ELF);
		addDrop(ModBlocks.MIKU_PLUSH_XMAS_TREE, ModItems.MIKU_PLUSH_XMAS_TREE);
		addDrop(ModBlocks.AIKO_PLUSH, ModItems.AIKO_PLUSH);
		addDrop(ModBlocks.TETO_PLUSH, ModItems.TETO_PLUSH);
		addDrop(ModBlocks.AIKO_PLUSH, ModItems.AKITA_NERU_PLUSH);
		addDrop(ModBlocks.MIKU_PLUSH, ModItems.MIKU_PLUSH);
		addDrop(ModBlocks.RIN_PLUSH, ModItems.RIN_PLUSH);
		addDrop(ModBlocks.LEN_PLUSH, ModItems.LEN_PLUSH);
		addDrop(ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS, ModItems.MIKU_PLUSH_SONIC_CROSSWORLDS);
		addDrop(ModBlocks.MIKU_PLUSH_FORTNITE_NEKO, ModItems.MIKU_PLUSH_FORTNITE_NEKO);
		addDrop(ModBlocks.MIKU_PLUSH_V4, ModItems.MIKU_PLUSH_V4);
		addDrop(ModBlocks.MIKU_PLUSH_MESMERIZER, ModItems.MIKU_PLUSH_MESMERIZER);
		addDrop(ModBlocks.TETO_PLUSH_MESMERIZER, ModItems.TETO_PLUSH_MESMERIZER);
		addDrop(ModBlocks.MIKU_PLUSH_SONIC, ModItems.MIKU_PLUSH_SONIC);
		addDrop(ModBlocks.TETO_PLUSH_SHADOW, ModItems.TETO_PLUSH_SHADOW);
		addDrop(ModBlocks.AKITA_NERU_PLUSH_TAILS, ModItems.AKITA_NERU_PLUSH_TAILS);
		addDrop(ModBlocks.TETO_PLUSH_BIRDBRAIN, ModItems.TETO_PLUSH_BIRDBRAIN);
		addDrop(ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025, ModItems.MIKU_PLUSH_DIGITAL_STARS_2025);
		addDrop(ModBlocks.MIKU_PLUSH_ROTTEN_GIRL, ModItems.MIKU_PLUSH_ROTTEN_GIRL);
		addDrop(ModBlocks.TETO_PLUSH_REGRET_ROCK, ModItems.TETO_PLUSH_REGRET_ROCK);
		addDrop(ModBlocks.MIKU_PLUSH_PSYCHO_MODE, ModItems.MIKU_PLUSH_PSYCHO_MODE);
		addDrop(ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T, ModItems.MIKU_PLUSH_DONT_BELIEVE_IN_T);
		addDrop(ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T, ModItems.TETO_PLUSH_DONT_BELIEVE_IN_T);
		addDrop(ModBlocks.TETO_PLUSH_LIAR_DANCER, ModItems.TETO_PLUSH_LIAR_DANCER);
		addDrop(ModBlocks.MIKU_PLUSH_STATIC, ModItems.MIKU_PLUSH_STATIC);
		addDrop(ModBlocks.MIKU_PLUSH_MOCHIMOCHI, ModItems.MIKU_PLUSH_MOCHIMOCHI);
		addDrop(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME, ModItems.TETO_PLUSH_WHATCHACALLITSNAME);
		addDrop(ModBlocks.MIKU_PLUSH_MONITORING, ModItems.MIKU_PLUSH_MONITORING);
		addDrop(ModBlocks.KONOHA_PLUSH, ModItems.KONOHA_PLUSH);
		addDrop(ModBlocks.LUKA_PLUSH, ModItems.LUKA_PLUSH);
        addDrop(ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG, ModItems.TETO_PLUSH_SOME_MORE_OF_THAT_SONG);
//        addDrop(ModBlocks.TETO_PLUSH_LOBSTER, ModItems.TETO_PLUSH_LOBSTER);
	}
}
