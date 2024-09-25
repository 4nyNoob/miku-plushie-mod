package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output);
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CANUDINHO)
				.pattern("p")
				.pattern("p")
				.input('p', Items.PAPER)
				.criterion(FabricRecipeProvider.hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
				.offerTo(exporter);


		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR)
				.pattern("cyc")
				.pattern("cgc")
				.input('c', Blocks.CYAN_WOOL)
				.input('y', Blocks.YELLOW_WOOL)
				.input('g', Blocks.GREEN_WOOL)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.YELLOW_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.YELLOW_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.GREEN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.GREEN_WOOL))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BA)
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

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BIK)
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

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BRAID)
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

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BA_DRUM)
				.pattern("crc")
				.pattern("cwc")
				.pattern("bn ")
				.input('c', Blocks.CYAN_WOOL)
				.input('r', Blocks.RED_WOOL)
				.input('w', Blocks.WHITE_WOOL)
				.input('b', Blocks.BLUE_WOOL)
				.input('n', Blocks.NOTE_BLOCK)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.RED_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.RED_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLUE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLUE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.NOTE_BLOCK), FabricRecipeProvider.conditionsFromItem(Blocks.NOTE_BLOCK))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_PA)
				.pattern("cwc")
				.pattern("cwc")
				.pattern("i  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('w', Blocks.WHITE_WOOL)
				.input('i', Blocks.CORNFLOWER)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.CORNFLOWER), FabricRecipeProvider.conditionsFromItem(Blocks.CORNFLOWER))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_SP)
				.pattern("cwc")
				.pattern("crc")
				.pattern("bi ")
				.input('c', Blocks.CYAN_WOOL)
				.input('w', Blocks.WHITE_WOOL)
				.input('r', Blocks.RED_WOOL)
				.input('b', Blocks.BLACK_WOOL)
				.input('i', Blocks.GRAY_CONCRETE)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.RED_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLACK_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLACK_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLACK_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.GRAY_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.GRAY_CONCRETE))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_MG)
				.pattern("cwc")
				.pattern("cbc")
				.pattern("rg ")
				.input('c', Blocks.CYAN_WOOL)
				.input('w', Blocks.WHITE_WOOL)
				.input('b', Blocks.BLACK_WOOL)
				.input('r', Blocks.RED_WOOL)
				.input('g', Items.GOLD_NUGGET)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLACK_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLACK_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.RED_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLACK_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Items.GOLD_NUGGET), FabricRecipeProvider.conditionsFromItem(Items.GOLD_NUGGET))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BROWN_BRO)
				.pattern("cbc")
				.pattern("cBc")
				.pattern("i  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('b', Blocks.BROWN_WOOL)
				.input('B', Blocks.BLACK_WOOL)
				.input('i', Items.IRON_NUGGET)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BROWN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BROWN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLACK_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLACK_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Items.IRON_NUGGET), FabricRecipeProvider.conditionsFromItem(Items.IRON_NUGGET))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN)
				.pattern("cbc")
				.pattern("cBc")
				.pattern("r  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('b', Blocks.BROWN_WOOL)
				.input('B', Blocks.BLUE_WOOL)
				.input('r', Items.REDSTONE)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BROWN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BROWN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLUE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLUE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Items.REDSTONE), FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE)
				.pattern("cwc")
				.pattern("coc")
				.input('c', Blocks.CYAN_WOOL)
				.input('w', Blocks.WHITE_WOOL)
				.input('o', Blocks.ORANGE_WOOL)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.ORANGE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.ORANGE_WOOL))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_AM)
				.pattern("cwc")
				.pattern("coc")
				.pattern("bj ")
				.input('c', Blocks.CYAN_WOOL)
				.input('w', Blocks.WHITE_WOOL)
				.input('o', Blocks.RED_WOOL)
				.input('b', Blocks.BLUE_WOOL)
				.input('j', Blocks.JUNGLE_SAPLING)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.RED_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.RED_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLUE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLUE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.JUNGLE_SAPLING), FabricRecipeProvider.conditionsFromItem(Blocks.JUNGLE_SAPLING))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_FUT_FLA)
				.pattern("crc")
				.pattern("cbc")
				.input('c', Blocks.CYAN_WOOL)
				.input('r', Blocks.RED_WOOL)
				.input('b', Blocks.BLACK_WOOL)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.RED_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.RED_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLACK_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLACK_WOOL))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_FUT_CAM)
				.pattern("clc")
				.pattern("cbc")
				.input('c', Blocks.CYAN_WOOL)
				.input('l', Blocks.LIGHT_GRAY_WOOL)
				.input('b', Blocks.BLACK_WOOL)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.LIGHT_GRAY_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.LIGHT_GRAY_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLACK_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLACK_WOOL))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_GO)
				.pattern("clc")
				.pattern("cbc")
				.pattern("a  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('l', Blocks.YELLOW_WOOL)
				.input('b', Blocks.GREEN_WOOL)
				.input('a', Items.LEAD)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.YELLOW_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.YELLOW_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.GREEN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.GREEN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Items.LEAD), FabricRecipeProvider.conditionsFromItem(Items.LEAD))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE)
				.pattern("clc")
				.pattern("cbc")
				.pattern("a  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('l', Blocks.WHITE_WOOL)
				.input('b', Blocks.BLUE_WOOL)
				.input('a', Items.TUBE_CORAL_FAN)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLUE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLUE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Items.TUBE_CORAL_FAN), FabricRecipeProvider.conditionsFromItem(Items.TUBE_CORAL_FAN))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_FUT_CRVG)
				.pattern("clc")
				.pattern("cbc")
				.pattern("a  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('l', Blocks.WHITE_WOOL)
				.input('b', Blocks.BLACK_WOOL)
				.input('a', Items.CARTOGRAPHY_TABLE)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.BLACK_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.BLACK_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Items.CARTOGRAPHY_TABLE), FabricRecipeProvider.conditionsFromItem(Items.CARTOGRAPHY_TABLE))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_RS)
				.pattern("clc")
				.pattern("cbc")
				.pattern("a  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('l', Blocks.GRAY_WOOL)
				.input('b', Blocks.RED_WOOL)
				.input('a', Items.MOSS_BLOCK)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.GRAY_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.GRAY_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.RED_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.RED_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Items.MOSS_BLOCK), FabricRecipeProvider.conditionsFromItem(Items.MOSS_BLOCK))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_FROG)
				.pattern("clc")
				.pattern("cbc")
				.pattern("a  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('l', Blocks.GRAY_WOOL)
				.input('b', Blocks.LIGHT_BLUE_WOOL)
				.input('a', Items.TADPOLE_BUCKET)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.GRAY_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.GRAY_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.LIGHT_BLUE_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.LIGHT_BLUE_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Items.TADPOLE_BUCKET), FabricRecipeProvider.conditionsFromItem(Items.TADPOLE_BUCKET))
				.offerTo(exporter);

		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MUSHROOM)
				.pattern("clc")
				.pattern("cbc")
				.pattern("a  ")
				.input('c', Blocks.CYAN_WOOL)
				.input('l', Blocks.RED_WOOL)
				.input('b', Blocks.MOSS_BLOCK)
				.input('a', Items.RED_MUSHROOM_BLOCK)
				.criterion(FabricRecipeProvider.hasItem(Blocks.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.CYAN_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.RED_WOOL), FabricRecipeProvider.conditionsFromItem(Blocks.RED_WOOL))
				.criterion(FabricRecipeProvider.hasItem(Blocks.MOSS_BLOCK), FabricRecipeProvider.conditionsFromItem(Blocks.MOSS_BLOCK))
				.criterion(FabricRecipeProvider.hasItem(Items.RED_MUSHROOM_BLOCK), FabricRecipeProvider.conditionsFromItem(Items.RED_MUSHROOM_BLOCK))
				.offerTo(exporter);


	}
}
