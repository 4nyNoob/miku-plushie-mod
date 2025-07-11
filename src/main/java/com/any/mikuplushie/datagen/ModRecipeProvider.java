package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void buildRecipes(RecipeOutput recipeOutput) {

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.AIKO_PLUSH)
			.pattern("121")
			.pattern("131")
			.define('1', Blocks.BLUE_WOOL)
			.define('2', Blocks.WHITE_WOOL)
			.define('3', Blocks.GREEN_WOOL)
			.group("")
			.unlockedBy("has_blue_wool", has(Blocks.BLUE_WOOL))
			.unlockedBy("has_white_wool", has(Blocks.WHITE_WOOL))
			.unlockedBy("has_green_wool", has(Blocks.GREEN_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH)
			.pattern("121")
			.pattern("131")
			.define('1', Items.RED_WOOL)
			.define('2', Items.WHITE_WOOL)
			.define('3', Items.LIGHT_GRAY_WOOL)
			.unlockedBy(getHasName(Items.RED_WOOL), has(Items.RED_WOOL))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.unlockedBy(getHasName(Items.LIGHT_GRAY_WOOL), has(Items.LIGHT_GRAY_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE)
			.pattern("121")
			.define('1', Items.DIAMOND)
			.define('2', ModBlocks.TETO_PLUSH)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
			.unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.AKITA_NERU_PLUSH)
			.pattern("121")
			.pattern("131")
			.define('1', Items.YELLOW_WOOL)
			.define('2', Items.WHITE_WOOL)
			.define('3', Items.BROWN_WOOL)
			.unlockedBy(getHasName(Items.YELLOW_WOOL), has(Items.YELLOW_WOOL))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.unlockedBy(getHasName(Items.BROWN_WOOL), has(Items.BROWN_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH)
			.pattern("121")
			.pattern("131")
			.define('1', Items.CYAN_WOOL)
			.define('2', Items.WHITE_WOOL)
			.define('3', Items.GRAY_WOOL)
			.unlockedBy(getHasName(Items.CYAN_WOOL), has(Items.CYAN_WOOL))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.unlockedBy(getHasName(Items.GRAY_WOOL), has(Items.GRAY_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.RIN_PLUSH)
			.pattern("121")
			.pattern("121")
			.define('1', Items.YELLOW_WOOL)
			.define('2', Items.WHITE_WOOL)
			.unlockedBy(getHasName(Items.YELLOW_WOOL), has(Items.YELLOW_WOOL))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.LEN_PLUSH)
			.pattern("121")
			.pattern("131")
			.define('1', Items.YELLOW_WOOL)
			.define('2', Items.WHITE_WOOL)
			.define('3', Items.GRAY_WOOL)
			.unlockedBy(getHasName(Items.YELLOW_WOOL), has(Items.YELLOW_WOOL))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.unlockedBy(getHasName(Items.GRAY_WOOL), has(Items.GRAY_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS)
			.pattern("121")
			.pattern("131")
			.define('1', Items.CYAN_WOOL)
			.define('2', Items.WHITE_WOOL)
			.define('3', Items.BLACK_WOOL)
			.unlockedBy(getHasName(Items.CYAN_WOOL), has(Items.CYAN_WOOL))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.unlockedBy(getHasName(Items.BLACK_WOOL), has(Items.BLACK_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_FORTNITE_NEKO)
			.pattern("121")
			.pattern("313")
			.define('1', Items.PINK_WOOL)
			.define('2', Items.WHITE_WOOL)
			.define('3', Items.LIGHT_BLUE_WOOL)
			.unlockedBy(getHasName(Items.PINK_WOOL), has(Items.PINK_WOOL))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.unlockedBy(getHasName(Items.LIGHT_BLUE_WOOL), has(Items.LIGHT_BLUE_WOOL))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_V4)
			.requires(ModBlocks.MIKU_PLUSH)
			.requires(Items.IRON_INGOT)
			.unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
			.unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MESMERIZER)
			.pattern("121")
			.pattern("111")
			.define('1', Items.LIGHT_BLUE_WOOL)
			.define('2', Items.WHITE_WOOL)
			.unlockedBy(getHasName(Items.LIGHT_BLUE_WOOL), has(Items.LIGHT_BLUE_WOOL))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_MESMERIZER)
			.pattern("121")
			.pattern("111")
			.define('1', Items.RED_WOOL)
			.define('2', Items.WHITE_WOOL)
			.unlockedBy(getHasName(Items.RED_WOOL), has(Items.RED_WOOL))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_MESMERIZER)
			.pattern("121")
			.define('1', Items.DIAMOND)
			.define('2', ModBlocks.TETO_PLUSH_MESMERIZER)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH_MESMERIZER), has(ModBlocks.TETO_PLUSH_MESMERIZER))
			.unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SONIC)
			.requires(ModBlocks.MIKU_PLUSH)
			.requires(Items.BLUE_WOOL)
			.requires(Items.REDSTONE)
			.unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
			.unlockedBy(getHasName(Items.BLUE_WOOL), has(Items.BLUE_WOOL))
			.unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_SHADOW)
			.requires(ModBlocks.TETO_PLUSH)
			.requires(Items.BLACK_WOOL)
			.requires(Items.REDSTONE)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
			.unlockedBy(getHasName(Items.BLACK_WOOL), has(Items.BLACK_WOOL))
			.unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.AKITA_NERU_PLUSH_TAILS)
			.requires(ModBlocks.AKITA_NERU_PLUSH)
			.requires(Items.YELLOW_WOOL)
			.requires(Items.REDSTONE)
			.unlockedBy(getHasName(ModBlocks.AKITA_NERU_PLUSH), has(ModBlocks.AKITA_NERU_PLUSH))
			.unlockedBy(getHasName(Items.YELLOW_WOOL), has(Items.YELLOW_WOOL))
			.unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_BIRDBRAIN)
			.requires(ModBlocks.TETO_PLUSH)
			.requires(Items.WHEAT_SEEDS)
			.requires(Items.EGG)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
			.unlockedBy(getHasName(Items.WHEAT_SEEDS), has(Items.WHEAT_SEEDS))
			.unlockedBy(getHasName(Items.EGG), has(Items.EGG))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_BIRDBRAIN)
			.pattern("121")
			.define('1', Items.DIAMOND)
			.define('2', ModBlocks.TETO_PLUSH_BIRDBRAIN)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH_BIRDBRAIN), has(ModBlocks.TETO_PLUSH_BIRDBRAIN))
			.unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025)
			.requires(ModBlocks.MIKU_PLUSH)
			.requires(Items.NOTE_BLOCK)
			.requires(Items.GOLD_NUGGET, 4)
			.unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
			.unlockedBy(getHasName(Items.NOTE_BLOCK), has(Items.NOTE_BLOCK))
			.unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_ROTTEN_GIRL)
			.requires(ModBlocks.MIKU_PLUSH)
			.requires(Items.ROTTEN_FLESH)
			.unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
			.unlockedBy(getHasName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_REGRET_ROCK)
			.requires(ModBlocks.TETO_PLUSH)
			.requires(Items.PURPLE_DYE)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
			.unlockedBy(getHasName(Items.PURPLE_DYE), has(Items.PURPLE_DYE))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_REGRET_ROCK)
			.pattern("121")
			.define('1', Items.DIAMOND)
			.define('2', ModBlocks.TETO_PLUSH_REGRET_ROCK)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH_REGRET_ROCK), has(ModBlocks.TETO_PLUSH_REGRET_ROCK))
			.unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_PSYCHO_MODE)
			.requires(ModBlocks.MIKU_PLUSH)
			.requires(Items.AMETHYST_SHARD)
			.unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
			.unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T)
			.requires(ModBlocks.MIKU_PLUSH)
			.requires(Items.WHITE_WOOL)
			.requires(Items.LIGHT_BLUE_WOOL)
			.unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.unlockedBy(getHasName(Items.LIGHT_BLUE_WOOL), has(Items.LIGHT_BLUE_WOOL))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T)
			.requires(ModBlocks.TETO_PLUSH)
			.requires(Items.WHITE_WOOL)
			.requires(Items.RED_WOOL)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.unlockedBy(getHasName(Items.RED_WOOL), has(Items.RED_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_DONT_BELIEVE_IN_T)
			.pattern("121")
			.define('1', Items.DIAMOND)
			.define('2', ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T), has(ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T))
			.unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_LIAR_DANCER)
			.requires(ModBlocks.TETO_PLUSH)
			.requires(Items.BLACK_STAINED_GLASS, 2)
			.requires(Items.WHITE_WOOL)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
			.unlockedBy(getHasName(Items.BLACK_STAINED_GLASS), has(Items.BLACK_STAINED_GLASS))
			.unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_LIAR_DANCER)
			.pattern("121")
			.define('1', Items.DIAMOND)
			.define('2', ModBlocks.TETO_PLUSH_LIAR_DANCER)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH_LIAR_DANCER), has(ModBlocks.TETO_PLUSH_LIAR_DANCER))
			.unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_STATIC)
			.requires(ModBlocks.MIKU_PLUSH)
			.requires(Items.YELLOW_DYE)
			.requires(Items.MAGENTA_DYE)
			.requires(Items.CYAN_DYE)
			.requires(Items.BLUE_WOOL)
			.unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
			.unlockedBy(getHasName(Items.YELLOW_DYE), has(Items.YELLOW_DYE))
			.unlockedBy(getHasName(Items.MAGENTA_DYE), has(Items.MAGENTA_DYE))
			.unlockedBy(getHasName(Items.CYAN_DYE), has(Items.CYAN_DYE))
			.unlockedBy(getHasName(Items.BLUE_WOOL), has(Items.BLUE_WOOL))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MOCHIMOCHI)
			.requires(ModBlocks.MIKU_PLUSH)
			.requires(Items.LIGHT_BLUE_WOOL)
			.requires(Items.PINK_WOOL)
			.requires(Items.PINK_PETALS)
			.unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
			.unlockedBy(getHasName(Items.LIGHT_BLUE_WOOL), has(Items.LIGHT_BLUE_WOOL))
			.unlockedBy(getHasName(Items.PINK_WOOL), has(Items.PINK_WOOL))
			.unlockedBy(getHasName(Items.PINK_PETALS), has(Items.PINK_PETALS))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME)
			.requires(ModBlocks.TETO_PLUSH)
			.requires(Items.GLASS, 2)
			.requires(Items.RED_WOOL)
			.requires(Items.ORANGE_WOOL)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
			.unlockedBy(getHasName(Items.GLASS), has(Items.GLASS))
			.unlockedBy(getHasName(Items.RED_WOOL), has(Items.RED_WOOL))
			.unlockedBy(getHasName(Items.ORANGE_WOOL), has(Items.ORANGE_WOOL))
			.save(recipeOutput);

		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_WHATCHACALLITSNAME)
			.pattern("121")
			.define('1', Items.DIAMOND)
			.define('2', ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME)
			.unlockedBy(getHasName(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME), has(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME))
			.unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
			.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MONITORING)
			.requires(ModBlocks.MIKU_PLUSH)
			.requires(Items.BROWN_WOOL)
			.requires(Items.SPYGLASS)
			.unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
			.unlockedBy(getHasName(Items.BROWN_WOOL), has(Items.BROWN_WOOL))
			.unlockedBy(getHasName(Items.SPYGLASS), has(Items.SPYGLASS))
			.save(recipeOutput);


		super.buildRecipes(recipeOutput);
	}
}
