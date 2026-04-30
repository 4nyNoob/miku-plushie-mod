package com.any.mikuplushie.datagen;

import com.any.mikuplushie.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class FabricModModelProvider extends FabricModelProvider {

    public FabricModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        for (Block plushBlock : ModBlocks.PLUSH_BLOCKS) {
            blockStateModelGenerator.createNonTemplateHorizontalBlock(plushBlock);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }
}
