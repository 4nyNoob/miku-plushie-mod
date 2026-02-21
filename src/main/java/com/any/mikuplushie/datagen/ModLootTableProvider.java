package com.any.mikuplushie.datagen;

import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    protected ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
	public void generate() {
        //GENERATE PLUSH LOOT TABLES ENTRIES AUTOMATICALLY
        List<Block> plushBlocks = ModBlocks.PLUSH_BLOCKS;
        List<Item> plushItems = ModItems.PLUSH_ITEMS;
        for (int block = 0; block < plushBlocks.size(); block++) {
            dropOther(plushBlocks.get(block), plushItems.get(block));
        }

        LootItemCondition.Builder leekLootCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.LEEK_CROP)
            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(ModBlocks.LEEK_CROP, createCropDrops(ModBlocks.LEEK_CROP, ModItems.LEEK, ModItems.LEEK_SEEDS, leekLootCondition));
        LootItemCondition.Builder wildLeekLootCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.WILD_LEEK_CROP);
        add(ModBlocks.WILD_LEEK_CROP, createCropDrops(ModBlocks.WILD_LEEK_CROP, ModItems.LEEK, ModItems.LEEK_SEEDS, wildLeekLootCondition));
	}
}
