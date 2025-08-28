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

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.CANUDINHO)
                .pattern("1")
                .pattern("1")
                .define('1', Items.PAPER)
                .group("")
                .unlockedBy("has_wool", has(Items.PAPER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.BAGUETTE)
                .pattern("111")
                .pattern("111")
                .define('1', Items.WHEAT)
                .group("")
                .unlockedBy("has_wool", has(Items.WHEAT))
                .save(recipeOutput);
        //MIKU
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH)
                .pattern("121")
                .pattern("131")
                .define('1', Blocks.CYAN_WOOL)
                .define('2', Blocks.WHITE_WOOL)
                .define('3', Blocks.GRAY_WOOL)
                .group("")
                .unlockedBy("has_wool", has(Blocks.CYAN_WOOL))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BLACK_WOOL)
                .requires(Items.MAGENTA_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_FORTNITE_NEKO)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.PINK_WOOL)
                .requires(Items.LIGHT_BLUE_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_V4)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.IRON_INGOT)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MESMERIZER)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.LIGHT_BLUE_WOOL)
                .requires(Items.LIGHT_BLUE_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SONIC)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BLUE_WOOL)
                .requires(Items.REDSTONE)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.NOTE_BLOCK)
                .requires(Items.GOLD_NUGGET)
                .requires(Items.GOLD_NUGGET)
                .requires(Items.GOLD_NUGGET)
                .requires(Items.GOLD_NUGGET)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_ROTTEN_GIRL)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.ROTTEN_FLESH)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_PSYCHO_MODE)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.WHITE_WOOL)
                .requires(Items.LIGHT_BLUE_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_STATIC)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.YELLOW_DYE)
                .requires(Items.MAGENTA_DYE)
                .requires(Items.CYAN_DYE)
                .requires(Items.BLUE_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MOCHIMOCHI)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.LIGHT_BLUE_WOOL)
                .requires(Items.PINK_WOOL)
                .requires(Items.PINK_PETALS)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MONITORING)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BROWN_WOOL)
                .requires(Items.SPYGLASS)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.YELLOW_WOOL)
                .requires(Items.GREEN_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BA)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.RED_WOOL)
                .requires(Items.WHITE_WOOL)
                .requires(Items.BLUE_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BIK)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BLUE_WOOL)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BEACH)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.YELLOW_WOOL)
                .requires(Items.GREEN_WOOL)
                .requires(Items.SAND)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BRAID)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.YELLOW_WOOL)
                .requires(Items.GREEN_WOOL)
                .requires(Items.GLOWSTONE)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BA_DRUM)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.RED_WOOL)
                .requires(Items.WHITE_WOOL)
                .requires(Items.BLUE_WOOL)
                .requires(Items.NOTE_BLOCK)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_PA)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.WHITE_WOOL)
                .requires(Items.CORNFLOWER)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_SP)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.WHITE_WOOL)
                .requires(Items.RED_WOOL)
                .requires(Items.BLACK_WOOL)
                .requires(Items.GRAY_CONCRETE)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_MG)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BROWN_WOOL)
                .requires(Items.RED_WOOL)
                .requires(Items.GOLD_NUGGET)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BROWN_BRO)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BROWN_WOOL)
                .requires(Items.BLACK_WOOL)
                .requires(Items.IRON_NUGGET)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BROWN_WOOL)
                .requires(Items.BLUE_WOOL)
                .requires(Items.REDSTONE)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.ORANGE_WOOL)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_AM)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.GREEN_WOOL)
                .requires(Items.YELLOW_WOOL)
                .requires(Items.BLUE_WOOL)
                .requires(Items.JUNGLE_SAPLING)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_FUT_FLA)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.RED_WOOL)
                .requires(Items.BLACK_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_FUT_CAM)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.LIGHT_GRAY_WOOL)
                .requires(Items.BLACK_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_GO)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.YELLOW_WOOL)
                .requires(Items.GREEN_WOOL)
                .requires(Items.LEAD)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.WHITE_WOOL)
                .requires(Items.BLUE_WOOL)
                .requires(Items.TUBE_CORAL_FAN)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_FUT_CRVG)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.WHITE_WOOL)
                .requires(Items.BLACK_WOOL)
                .requires(Items.CARTOGRAPHY_TABLE)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_RS)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.GRAY_WOOL)
                .requires(Items.RED_WOOL)
                .requires(Items.MOSS_BLOCK)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_FROG)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.LIGHT_BLUE_WOOL)
                .requires(Items.TADPOLE_BUCKET)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MUSHROOM)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.MOSS_BLOCK)
                .requires(Items.RED_MUSHROOM_BLOCK)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SENBONZAKURA)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.GREEN_WOOL)
                .requires(Items.CHERRY_LOG)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_URAOTOMELOVERS)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.WHITE_WOOL)
                .requires(Items.BLACK_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_PERSONADANCING)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.WHITE_WOOL)
                .requires(Items.BLACK_WOOL)
                .requires(Items.NOTE_BLOCK)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_HELLOPLANET)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.WHITE_WOOL)
                .requires(Items.LIME_WOOL)
                .requires(Items.MAGENTA_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_HACHUNE)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.LILY_OF_THE_VALLEY)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_ZATSUNE)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BLACK_WOOL)
                .requires(Items.BLACK_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_INFINITY)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.ENDER_EYE)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_VAMPIRE)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.RED_WOOL)
                .requires(Items.FERMENTED_SPIDER_EYE)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_WEREWOMAN)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BONE)
                .requires(Items.MUTTON)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_JASON)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BIRCH_PLANKS)
                .requires(Items.BROWN_WOOL)
                .requires(Items.IRON_SWORD)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MICHAEL_MYERS)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BROWN_WOOL)
                .requires(Items.BLUE_WOOL)
                .requires(Items.IRON_SWORD)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_PUMPKIN)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.CARVED_PUMPKIN)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_GHOSTFACE)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BIRCH_PLANKS)
                .requires(Items.BLACK_WOOL)
                .requires(Items.IRON_SWORD)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_FRANKENSTEIN)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BROWN_WOOL)
                .requires(Items.GREEN_WOOL)
                .requires(Items.LIGHTNING_ROD)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MUMMY)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BLACK_WOOL)
                .requires(Items.PAPER)
                .requires(Items.PAPER)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_GHOST)
                .pattern("121")
                .pattern("131")
                .define('1', Blocks.CYAN_STAINED_GLASS)
                .define('2', Blocks.WHITE_STAINED_GLASS)
                .define('3', Blocks.GRAY_STAINED_GLASS)
                .group("")
                .unlockedBy("has_wool", has(Blocks.CYAN_WOOL))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_PATATI)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.YELLOW_WOOL)
                .requires(Items.LIGHT_BLUE_WOOL)
                .requires(Items.WHITE_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_PATATA)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.YELLOW_WOOL)
                .requires(Items.LIME_WOOL)
                .requires(Items.RED_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_DEVIL)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.MAGMA_BLOCK)
                .requires(Items.NETHERRACK)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_WITCH)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.PURPLE_WOOL)
                .requires(Items.GREEN_WOOL)
                .requires(Items.STICK)
                .requires(Items.WHEAT)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SANTA)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.RED_WOOL)
                .requires(Items.WHITE_WOOL)
                .requires(Items.SNOW_BLOCK)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_REINDEER)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.BROWN_WOOL)
                .requires(Items.REDSTONE_TORCH)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SANTA_ELF)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.LIME_WOOL)
                .requires(Items.RED_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_XMAS_TREE)
                .requires(ModBlocks.MIKU_PLUSH)
                .requires(Items.SPRUCE_LEAVES)
                .requires(Items.RED_WOOL)
                .unlockedBy(getHasName(ModBlocks.MIKU_PLUSH), has(ModBlocks.MIKU_PLUSH))
                .save(recipeOutput);


        //AIKO
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.AIKO_PLUSH)
                .pattern("121")
                .pattern("131")
                .define('1', Blocks.BLUE_WOOL)
                .define('2', Blocks.LIME_WOOL)
                .define('3', Blocks.BLACK_WOOL)
                .group("")
                .unlockedBy("has_wool", has(Blocks.BLUE_WOOL))
                .save(recipeOutput);
        //TETO
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH)
                .pattern("121")
                .pattern("131")
                .define('1', Blocks.RED_WOOL)
                .define('2', Blocks.GRAY_WOOL)
                .define('3', Blocks.BLACK_WOOL)
                .group("")
                .unlockedBy("has_wool", has(Blocks.MAGENTA_WOOL))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_MESMERIZER)
                .requires(ModBlocks.TETO_PLUSH)
                .requires(Items.RED_WOOL)
                .unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_SHADOW)
                .requires(ModBlocks.TETO_PLUSH)
                .requires(Items.BLACK_WOOL)
                .requires(Items.REDSTONE)
                .unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_BIRDBRAIN)
                .requires(ModBlocks.TETO_PLUSH)
                .requires(Items.EGG)
                .unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_REGRET_ROCK)
                .requires(ModBlocks.TETO_PLUSH)
                .requires(Items.PURPLE_DYE)
                .unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T)
                .requires(ModBlocks.TETO_PLUSH)
                .requires(Items.WHITE_WOOL)
                .requires(Items.RED_WOOL)
                .unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_LIAR_DANCER)
                .requires(ModBlocks.TETO_PLUSH)
                .requires(Items.BLACK_STAINED_GLASS)
                .requires(Items.WHITE_WOOL)
                .unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME)
                .requires(ModBlocks.TETO_PLUSH)
                .requires(Items.GLASS)
                .requires(Items.RED_WOOL)
                .requires(Items.ORANGE_WOOL)
                .unlockedBy(getHasName(ModBlocks.TETO_PLUSH), has(ModBlocks.TETO_PLUSH))
                .save(recipeOutput);
        //TETO PICKAXE
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.TETO_PICKAXE)
                .pattern("121")
                .define('1', Items.DIAMOND)
                .define('2', ModBlocks.TETO_PLUSH)
                .group("")
                .unlockedBy("has_wool", has(ModBlocks.TETO_PLUSH))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.TETO_PICKAXE_MESMERIZER)
                .pattern("121")
                .define('1', Items.DIAMOND)
                .define('2', ModBlocks.TETO_PLUSH_MESMERIZER)
                .group("")
                .unlockedBy("has_wool", has(ModBlocks.TETO_PLUSH_MESMERIZER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.TETO_PICKAXE_BIRDBRAIN)
                .pattern("121")
                .define('1', Items.DIAMOND)
                .define('2', ModBlocks.TETO_PLUSH_BIRDBRAIN)
                .group("")
                .unlockedBy("has_wool", has(ModBlocks.TETO_PLUSH_BIRDBRAIN))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.TETO_PICKAXE_REGRET_ROCK)
                .pattern("121")
                .define('1', Items.DIAMOND)
                .define('2', ModBlocks.TETO_PLUSH_REGRET_ROCK)
                .group("")
                .unlockedBy("has_wool", has(ModBlocks.TETO_PLUSH_REGRET_ROCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.TETO_PICKAXE_DONT_BELIEVE_IN_T)
                .pattern("121")
                .define('1', Items.DIAMOND)
                .define('2', ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T)
                .group("")
                .unlockedBy("has_wool", has(ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.TETO_PICKAXE_LIAR_DANCER)
                .pattern("121")
                .define('1', Items.DIAMOND)
                .define('2', ModBlocks.TETO_PLUSH_LIAR_DANCER)
                .group("")
                .unlockedBy("has_wool", has(ModBlocks.TETO_PLUSH_LIAR_DANCER))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.TETO_PICKAXE_WHATCHACALLITSNAME)
                .pattern("121")
                .define('1', Items.DIAMOND)
                .define('2', ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME)
                .group("")
                .unlockedBy("has_wool", has(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME))
                .save(recipeOutput);
        //NERU
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.AKITA_NERU_PLUSH)
                .pattern("121")
                .pattern("131")
                .define('1', Blocks.YELLOW_WOOL)
                .define('2', Blocks.LIGHT_GRAY_WOOL)
                .define('3', Blocks.BROWN_WOOL)
                .group("")
                .unlockedBy("has_wool", has(Blocks.YELLOW_WOOL))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.AKITA_NERU_PLUSH_TAILS)
                .requires(ModBlocks.AKITA_NERU_PLUSH)
                .requires(Items.YELLOW_WOOL)
                .requires(Items.REDSTONE)
                .unlockedBy(getHasName(ModBlocks.AKITA_NERU_PLUSH), has(ModBlocks.AKITA_NERU_PLUSH))
                .save(recipeOutput);
        //RIN LEN
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.LEN_PLUSH)
                .pattern("121")
                .pattern("121")
                .define('1', Blocks.YELLOW_WOOL)
                .define('2', Blocks.WHITE_WOOL)
                .group("")
                .unlockedBy("has_wool", has(Blocks.YELLOW_WOOL))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.RIN_PLUSH)
                .pattern("121")
                .pattern("131")
                .define('1', Blocks.YELLOW_WOOL)
                .define('2', Blocks.WHITE_WOOL)
                .define('3', Blocks.LIGHT_GRAY_WOOL)
                .group("")
                .unlockedBy("has_wool", has(Blocks.YELLOW_WOOL))
                .save(recipeOutput);
        //LUKA
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.LUKA_PLUSH)
                .pattern("121")
                .pattern("131")
                .define('1', Blocks.PINK_WOOL)
                .define('2', Blocks.WHITE_WOOL)
                .define('3', Blocks.BROWN_WOOL)
                .group("")
                .unlockedBy("has_blue_wool", has(Blocks.PINK_WOOL))
                .unlockedBy("has_white_wool", has(Blocks.WHITE_WOOL))
                .unlockedBy("has_green_wool", has(Blocks.BROWN_WOOL))
                .save(recipeOutput);
        //KONOHA
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.KONOHA_PLUSH)
                .pattern("121")
                .pattern("131")
                .define('1', Blocks.LIME_WOOL)
                .define('2', Blocks.WHITE_WOOL)
                .define('3', Blocks.BLACK_WOOL)
                .group("")
                .unlockedBy("has_blue_wool", has(Blocks.LIME_WOOL))
                .unlockedBy("has_white_wool", has(Blocks.WHITE_WOOL))
                .unlockedBy("has_green_wool", has(Blocks.BLACK_WOOL))
                .save(recipeOutput);
/*
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
			.unlockedBy(getHasName(Items.BLACK_WOOL), has(Items.MAGENTA_WOOL))
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

 */
	}
}
