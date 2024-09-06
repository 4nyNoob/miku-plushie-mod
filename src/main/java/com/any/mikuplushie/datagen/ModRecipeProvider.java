package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void generate(RecipeExporter exporter) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CANUDINHO)
				.pattern("p")
				.pattern("p")
				.input('p', Items.PAPER)
				.criterion(FabricRecipeProvider.hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
				.offerTo(exporter);


		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BLOCK)
				.pattern("cyc")
				.pattern("cgc")
				.input('c', Blocks.CYAN_WOOL)
				.input('y', Blocks.YELLOW_WOOL)
				.input('g', Blocks.GREEN_WOOL)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.YELLOW_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.YELLOW_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.GREEN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.GREEN_WOOL))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BA_BLOCK)
				.pattern("crc")
				.pattern("cwc")
				.pattern("b  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('r', Blocks.RED_WOOL)
				.input('w', Blocks.WHITE_WOOL)
				.input('b', Blocks.BLUE_WOOL)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.RED_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.RED_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLUE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLUE_WOOL))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BIK_BLOCK)
				.pattern("cwc")
				.pattern("cwc")
				.pattern("   ")
				.input('c', Blocks.CYAN_WOOL)
				.input('w', Blocks.WHITE_WOOL)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_WOOL))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BEACH)
				.pattern("cyc")
				.pattern("cgc")
				.pattern("s  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('y', Blocks.YELLOW_WOOL)
				.input('g', Blocks.GREEN_WOOL)
				.input('s', Blocks.SAND)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.YELLOW_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.YELLOW_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.GREEN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.GREEN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.SAND), FabricRecipeProvider.conditionsFromItem(Blocks.SAND))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BRAID_BLOCK)
				.pattern("cyc")
				.pattern("cgc")
				.pattern("b  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('y', Blocks.YELLOW_WOOL)
				.input('g', Blocks.GREEN_WOOL)
				.input('b', Blocks.BLACK_WOOL)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.YELLOW_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.YELLOW_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.GREEN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.GREEN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLACK_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLACK_WOOL))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BA_DRUM_BLOCK)
				.pattern("crc")
				.pattern("cwc")
				.pattern("bj ")
				.input('c', Blocks.CYAN_WOOL)
				.input('r', Blocks.RED_WOOL)
				.input('w', Blocks.WHITE_WOOL)
				.input('b', Blocks.BLUE_WOOL)
				.input('j', Blocks.BLUE_WOOL)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.RED_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.RED_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLUE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLUE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.JUKEBOX), FabricRecipeProvider.conditionsFromItem(Blocks.JUKEBOX))
				.offerTo(exporter);

	}
}
