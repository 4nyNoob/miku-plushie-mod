package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import com.google.gson.JsonElement;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.CANUDINHO, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEEK_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEEK, Models.HANDHELD);
//		itemModelGenerator.register(ModItems.BAGUETTE, Models.GENERATED);
	}
}
