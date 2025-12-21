package com.any.mikuplushie.datagen;

import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput);
	}

	@Override
	public void generate() {
        //GENERATE PLUSH LOOT TABLES ENTRIES AUTOMATICALLY
        List<Block> plushBlocks = ModBlocks.PLUSH_BLOCKS;
        List<Item> plushItems = ModItems.PLUSH_ITEMS;
        for (int block = 0; block < plushBlocks.size(); block++) {
            addDrop(plushBlocks.get(block), plushItems.get(block));
        }

        LootCondition.Builder leekLootCondition =
            BlockStatePropertyLootCondition.builder(ModBlocks.LEEK_CROP).properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 7));
        addDrop(ModBlocks.LEEK_CROP, cropDrops(ModBlocks.LEEK_CROP, ModItems.LEEK, ModItems.LEEK_SEEDS, leekLootCondition));
	}
}
