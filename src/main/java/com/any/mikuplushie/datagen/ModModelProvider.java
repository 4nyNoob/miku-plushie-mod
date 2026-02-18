package com.any.mikuplushie.datagen;

import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import java.util.List;

public class ModModelProvider extends FabricModelProvider {

	public ModModelProvider(FabricDataOutput output) {
		super(output);
    }

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        //REGISTER PLUSH BLOCK STATES AUTOMATICALLY
        List<Block> plushBlocks = ModBlocks.PLUSH_BLOCKS;
        for (Block plushBlock : plushBlocks) {
            blockStateModelGenerator.createNonTemplateHorizontalBlock(plushBlock);
        }

        BlockModels.registerCrop(blockStateModelGenerator, ModBlocks.LEEK_CROP, CropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        BlockModels.registerWildCrop(blockStateModelGenerator, ModBlocks.WILD_LEEK_CROP, ModBlocks.LEEK_CROP);
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
		itemModelGenerator.generateFlatItem(ModItems.CANUDINHO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.LEEK_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VOCALOID_HEART, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.LEEK, ModelTemplates.FLAT_HANDHELD_ITEM);
	}
}
