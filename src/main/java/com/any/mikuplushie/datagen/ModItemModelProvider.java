package com.any.mikuplushie.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
	public final ExistingFileHelper files;
	public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, MikuPlushie.MOD_ID, exFileHelper);
		files=exFileHelper;
	}

	@Override
	protected void registerModels() {
		basicItem(ModItems.CANUDINHO.get());
	}
}
