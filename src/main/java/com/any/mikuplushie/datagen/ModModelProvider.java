package com.any.mikuplushie.datagen;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.block.MikuPlushieBlock;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ModModelProvider extends BlockStateProvider {
	public final ExistingFileHelper files;
	public ModModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, MikuPlushie.MOD_ID, exFileHelper);
		files=exFileHelper;
	}

	@Override
	protected void registerStatesAndModels() {
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_BA);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BIK);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_BEACH);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_BRAID);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_BA_DRUM);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_PA);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_SP);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_MG);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_BROWN_BRO);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_AM);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_FUT_FLA);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_FUT_CAM);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_GO);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_FUT_CRVG);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_BR_RS);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_FROG);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_MUSHROOM);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_SENBONZAKURA);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_URAOTOMELOVERS);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_PERSONADANCING);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_HELLOPLANET);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_HACHUNE);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_ZATSUNE);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_INFINITY);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_VAMPIRE);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_WEREWOMAN);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_JASON);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_MICHAEL_MYERS);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_PUMPKIN);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_GHOSTFACE);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_FRANKENSTEIN);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_MUMMY);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_GHOST);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_PATATI);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_PATATA);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_DEVIL);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_WITCH);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_SANTA);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_REINDEER);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_SANTA_ELF);
		horizontalBlockState(ModBlocks.MIKU_PLUSH_XMAS_TREE);
	}

	public void horizontalBlockState(DeferredBlock<? extends Block> block){
		horizontalBlock(block.get(),new ModelFile.ExistingModelFile(ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID,"block/"+block.getRegisteredName().split(":")[1]),files));
		blockItem(block);
	}

	private void blockItem(DeferredBlock<?> block){
		simpleBlockItem(block.get(),new ModelFile.UncheckedModelFile("miku_plushie:block/"+block.getId().getPath()));
	}
}
