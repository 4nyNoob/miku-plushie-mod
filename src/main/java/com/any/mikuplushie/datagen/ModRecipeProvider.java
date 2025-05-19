package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
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

		super.buildRecipes(recipeOutput);
	}
}
