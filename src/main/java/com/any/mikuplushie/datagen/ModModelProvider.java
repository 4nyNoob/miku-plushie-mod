package com.any.mikuplushie.datagen;

import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import java.util.List;

public class ModModelProvider extends FabricModelProvider {

	public ModModelProvider(FabricDataOutput output) {
		super(output);
    }

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //REGISTER PLUSH BLOCK STATES AUTOMATICALLY
        List<Block> plushBlocks = ModBlocks.PLUSH_BLOCKS;
        for (Block plushBlock : plushBlocks) {
            blockStateModelGenerator.registerNorthDefaultHorizontalRotation(plushBlock);
        }

        BlockModels.registerCrop(blockStateModelGenerator, ModBlocks.LEEK_CROP, CropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        BlockModels.registerWildCrop(blockStateModelGenerator, ModBlocks.WILD_LEEK_CROP, ModBlocks.LEEK_CROP);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.CANUDINHO, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEEK_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOCALOID_HEART, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEEK, Models.HANDHELD);
	}
}
