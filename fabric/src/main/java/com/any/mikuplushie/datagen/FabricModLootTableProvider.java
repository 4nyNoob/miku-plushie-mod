package com.any.mikuplushie.datagen;

import com.any.mikuplushie.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class FabricModLootTableProvider extends FabricBlockLootTableProvider {
    public FabricModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
//        dropSelf((Block) ModBlocks.MIKU_PLUSH_BR);
    }
}
