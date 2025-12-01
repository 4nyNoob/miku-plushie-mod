package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BAGUETTE)
            .pattern("www")
            .pattern("www")
            .input('w', Items.WHEAT)
            .criterion(FabricRecipeProvider.hasItem(Items.WHEAT), FabricRecipeProvider.conditionsFromItem(Items.WHEAT))
            .offerTo(exporter);

        //AIKO
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.AIKO_PLUSH)
                .pattern("121")
                .pattern("131")
                .input('1', Items.BLUE_WOOL)
                .input('2', Items.WHITE_WOOL)
                .input('3', Items.GREEN_WOOL)
                .criterion(FabricRecipeProvider.hasItem(Items.BLUE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.BLUE_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.GREEN_WOOL), FabricRecipeProvider.conditionsFromItem(Items.GREEN_WOOL))
                .offerTo(exporter);
        }

        //NERU
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.AKITA_NERU_PLUSH)
                .pattern("121")
                .pattern("131")
                .input('1', Items.YELLOW_WOOL)
                .input('2', Items.WHITE_WOOL)
                .input('3', Items.BROWN_WOOL)
                .criterion(FabricRecipeProvider.hasItem(Items.YELLOW_WOOL), FabricRecipeProvider.conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.BROWN_WOOL), FabricRecipeProvider.conditionsFromItem(Items.BROWN_WOOL))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.AKITA_NERU_PLUSH_TAILS)
                .input(ModBlocks.AKITA_NERU_PLUSH)
                .input(Items.YELLOW_WOOL)
                .input(Items.REDSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);
        }

        //RIN
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RIN_PLUSH)
                .pattern("121")
                .pattern("121")
                .input('1', Items.YELLOW_WOOL)
                .input('2', Items.WHITE_WOOL)
                .criterion(FabricRecipeProvider.hasItem(Items.YELLOW_WOOL), FabricRecipeProvider.conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                .offerTo(exporter);
        }

        //LEN
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LEN_PLUSH)
                .pattern("121")
                .pattern("131")
                .input('1', Items.YELLOW_WOOL)
                .input('2', Items.WHITE_WOOL)
                .input('3', Items.GRAY_WOOL)
                .criterion(FabricRecipeProvider.hasItem(Items.YELLOW_WOOL), FabricRecipeProvider.conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.GRAY_WOOL), FabricRecipeProvider.conditionsFromItem(Items.GRAY_WOOL))
                .offerTo(exporter);
        }

        //KONOHA
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.KONOHA_PLUSH)
                .pattern("121")
                .pattern("323")
                .input('1', Items.WHITE_WOOL)
                .input('2', Items.LIGHT_GRAY_WOOL)
                .input('3', Items.LIME_WOOL)
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.LIGHT_GRAY_WOOL), FabricRecipeProvider.conditionsFromItem(Items.LIGHT_GRAY_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.LIME_WOOL), FabricRecipeProvider.conditionsFromItem(Items.LIME_WOOL))
                .offerTo(exporter);
        }

        //LUKA
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LUKA_PLUSH)
                .pattern("121")
                .pattern("131")
                .input('1', Items.PINK_WOOL)
                .input('2', Items.YELLOW_WOOL)
                .input('3', Items.BROWN_WOOL)
                .criterion(FabricRecipeProvider.hasItem(Items.PINK_WOOL), FabricRecipeProvider.conditionsFromItem(Items.PINK_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.YELLOW_WOOL), FabricRecipeProvider.conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.BROWN_WOOL), FabricRecipeProvider.conditionsFromItem(Items.BROWN_WOOL))
                .offerTo(exporter);
        }

        //MIKU
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH)
                .pattern("121")
                .pattern("131")
                .input('1', Items.CYAN_WOOL)
                .input('2', Items.WHITE_WOOL)
                .input('3', Items.GRAY_WOOL)
                .criterion(FabricRecipeProvider.hasItem(Items.CYAN_WOOL), FabricRecipeProvider.conditionsFromItem(Items.CYAN_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.GRAY_WOOL), FabricRecipeProvider.conditionsFromItem(Items.GRAY_WOOL))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.YELLOW_WOOL)
                .input(Items.GREEN_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BA)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.RED_WOOL)
                .input(Items.WHITE_WOOL)
                .input(Items.BLUE_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BIK)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BLUE_WOOL)
                .input(Items.WATER_BUCKET)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BEACH)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.YELLOW_WOOL)
                .input(Items.GREEN_WOOL)
                .input(Items.SAND)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BRAID)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.YELLOW_WOOL)
                .input(Items.GREEN_WOOL)
                .input(Items.GLOWSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BA_DRUM)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.RED_WOOL)
                .input(Items.WHITE_WOOL)
                .input(Items.BLUE_WOOL)
                .input(Items.NOTE_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_PA)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.WHITE_WOOL)
                .input(Items.CORNFLOWER)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_SP)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.WHITE_WOOL)
                .input(Items.RED_WOOL)
                .input(Items.BLACK_WOOL)
                .input(Items.GRAY_CONCRETE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_MG)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BROWN_WOOL)
                .input(Items.RED_WOOL)
                .input(Items.GOLD_NUGGET)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BROWN_BRO)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BROWN_WOOL)
                .input(Items.BLACK_WOOL)
                .input(Items.IRON_NUGGET)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BROWN_WOOL)
                .input(Items.BLUE_WOOL)
                .input(Items.REDSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.ORANGE_WOOL)
                .input(Items.WATER_BUCKET)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_AM)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.GREEN_WOOL)
                .input(Items.YELLOW_WOOL)
                .input(Items.BLUE_WOOL)
                .input(Items.JUNGLE_SAPLING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_FUT_FLA)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.RED_WOOL)
                .input(Items.BLACK_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_FUT_CAM)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.LIGHT_GRAY_WOOL)
                .input(Items.BLACK_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_FUT_CRVG)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.WHITE_WOOL)
                .input(Items.BLACK_WOOL)
                .input(Items.CARTOGRAPHY_TABLE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_GO)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.YELLOW_WOOL)
                .input(Items.GREEN_WOOL)
                .input(Items.LEAD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.WHITE_WOOL)
                .input(Items.BLUE_WOOL)
                .input(Items.TUBE_CORAL_FAN)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_BR_RS)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.GRAY_WOOL)
                .input(Items.RED_WOOL)
                .input(Items.MOSS_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_FROG)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.LIGHT_BLUE_WOOL)
                .input(Items.TADPOLE_BUCKET)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MUSHROOM)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.MOSS_BLOCK)
                .input(Items.RED_MUSHROOM_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SENBONZAKURA)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.GREEN_WOOL)
                .input(Items.CHERRY_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_URAOTOMELOVERS)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.WHITE_WOOL)
                .input(Items.BLACK_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_PERSONADANCING)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.WHITE_WOOL)
                .input(Items.BLACK_WOOL)
                .input(Items.NOTE_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_HELLOPLANET)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.WHITE_WOOL)
                .input(Items.LIME_WOOL)
                .input(Items.MAGENTA_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_HACHUNE)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.LILY_OF_THE_VALLEY)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_ZATSUNE)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BLACK_WOOL, 2)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_INFINITY)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.ENDER_EYE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_VAMPIRE)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.FERMENTED_SPIDER_EYE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_WEREWOMAN)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BONE)
                .input(Items.MUTTON)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_JASON)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BIRCH_PLANKS)
                .input(Items.BROWN_WOOL)
                .input(Items.IRON_SWORD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MICHAEL_MYERS)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BROWN_WOOL)
                .input(Items.BLUE_WOOL)
                .input(Items.IRON_SWORD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_PUMPKIN)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.CARVED_PUMPKIN)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_GHOSTFACE)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BIRCH_PLANKS)
                .input(Items.BLACK_WOOL)
                .input(Items.IRON_SWORD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_FRANKENSTEIN)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BROWN_WOOL)
                .input(Items.GREEN_WOOL)
                .input(Items.LIGHTNING_ROD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MUMMY)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BLACK_WOOL)
                .input(Items.PAPER, 2)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_GHOST)
                .pattern("121")
                .pattern("131")
                .input('1', Items.CYAN_STAINED_GLASS)
                .input('2', Items.WHITE_STAINED_GLASS)
                .input('3', Items.GRAY_STAINED_GLASS)
                .criterion(FabricRecipeProvider.hasItem(Items.CYAN_STAINED_GLASS), FabricRecipeProvider.conditionsFromItem(Items.CYAN_STAINED_GLASS))
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_STAINED_GLASS), FabricRecipeProvider.conditionsFromItem(Items.WHITE_STAINED_GLASS))
                .criterion(FabricRecipeProvider.hasItem(Items.GRAY_STAINED_GLASS), FabricRecipeProvider.conditionsFromItem(Items.GRAY_STAINED_GLASS))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_PATATI)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.YELLOW_WOOL)
                .input(Items.LIGHT_BLUE_WOOL)
                .input(Items.WHITE_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_PATATA)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.YELLOW_WOOL)
                .input(Items.LIME_WOOL)
                .input(Items.RED_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_DEVIL)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.MAGMA_BLOCK)
                .input(Items.NETHERRACK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_WITCH)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.PURPLE_WOOL)
                .input(Items.GREEN_WOOL)
                .input(Items.STICK)
                .input(Items.WHEAT)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SANTA)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.RED_WOOL)
                .input(Items.WHITE_WOOL)
                .input(Items.SNOW_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_REINDEER)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BROWN_WOOL)
                .input(Items.REDSTONE_TORCH)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SANTA_ELF)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.LIME_WOOL)
                .input(Items.RED_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_XMAS_TREE)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.SPRUCE_LEAVES)
                .input(Items.RED_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.MAGENTA_WOOL)
                .input(Items.BLACK_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_FORTNITE_NEKO)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.PINK_WOOL)
                .input(Items.LIGHT_BLUE_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_V4)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.IRON_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MESMERIZER)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.LIGHT_BLUE_WOOL, 2)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_SONIC)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BLUE_WOOL)
                .input(Items.REDSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.NOTE_BLOCK)
                .input(Items.GOLD_NUGGET, 4)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_ROTTEN_GIRL)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.ROTTEN_FLESH)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_PSYCHO_MODE)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.AMETHYST_SHARD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.WHITE_WOOL)
                .input(Items.LIGHT_BLUE_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_STATIC)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.YELLOW_DYE)
                .input(Items.MAGENTA_DYE)
                .input(Items.CYAN_DYE)
                .input(Items.BLUE_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MOCHIMOCHI)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.LIGHT_BLUE_WOOL)
                .input(Items.PINK_WOOL)
                .input(Items.PINK_PETALS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_MONITORING)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BROWN_WOOL)
                .input(Items.SPYGLASS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_WORLD_IS_MINE)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.WHITE_WOOL)
                .input(Items.GOLD_INGOT)
                .input(Items.CAKE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_ROLLING_GIRL)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.WHITE_WOOL)
                .input(Items.BROWN_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);
        }

        //TETO
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH)
                .pattern("121")
                .pattern("131")
                .input('1', Items.RED_WOOL)
                .input('2', Items.WHITE_WOOL)
                .input('3', Items.LIGHT_GRAY_WOOL)
                .criterion(FabricRecipeProvider.hasItem(Items.RED_WOOL), FabricRecipeProvider.conditionsFromItem(Items.RED_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.LIGHT_GRAY_WOOL), FabricRecipeProvider.conditionsFromItem(Items.LIGHT_GRAY_WOOL))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE)
                .pattern("121")
                .input('1', Items.DIAMOND)
                .input('2', ModBlocks.TETO_PLUSH)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH))
                .criterion(FabricRecipeProvider.hasItem(Items.DIAMOND), FabricRecipeProvider.conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_MESMERIZER)
                .input(ModBlocks.TETO_PLUSH)
                .input(Items.RED_WOOL, 2)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_MESMERIZER)
                .pattern("121")
                .input('1', Items.DIAMOND)
                .input('2', ModBlocks.TETO_PLUSH_MESMERIZER)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH_MESMERIZER), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH_MESMERIZER))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_SHADOW)
                .input(ModBlocks.TETO_PLUSH)
                .input(Items.BLACK_WOOL)
                .input(Items.REDSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_BIRDBRAIN)
                .input(ModBlocks.TETO_PLUSH)
                .input(Items.WHEAT_SEEDS)
                .input(Items.EGG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_BIRDBRAIN)
                .pattern("121")
                .input('1', Items.DIAMOND)
                .input('2', ModBlocks.TETO_PLUSH_BIRDBRAIN)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH_BIRDBRAIN), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH_BIRDBRAIN))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_REGRET_ROCK)
                .input(ModBlocks.TETO_PLUSH)
                .input(Items.PURPLE_DYE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_REGRET_ROCK)
                .pattern("121")
                .input('1', Items.DIAMOND)
                .input('2', ModBlocks.TETO_PLUSH_REGRET_ROCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH_REGRET_ROCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH_REGRET_ROCK))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T)
                .input(ModBlocks.TETO_PLUSH)
                .input(Items.WHITE_WOOL)
                .input(Items.RED_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_DONT_BELIEVE_IN_T)
                .pattern("121")
                .input('1', Items.DIAMOND)
                .input('2', ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_LIAR_DANCER)
                .input(ModBlocks.TETO_PLUSH)
                .input(Items.BLACK_STAINED_GLASS, 2)
                .input(Items.WHITE_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_LIAR_DANCER)
                .pattern("121")
                .input('1', Items.DIAMOND)
                .input('2', ModBlocks.TETO_PLUSH_LIAR_DANCER)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH_LIAR_DANCER), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH_LIAR_DANCER))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME)
                .input(ModBlocks.TETO_PLUSH)
                .input(Items.GLASS, 2)
                .input(Items.RED_WOOL)
                .input(Items.ORANGE_WOOL)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_WHATCHACALLITSNAME)
                .pattern("121")
                .input('1', Items.DIAMOND)
                .input('2', ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG)
                .input(ModBlocks.TETO_PLUSH)
                .input(Items.LIGHT_BLUE_WOOL, 1)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_SOME_MORE_OF_THAT_SONG)
                .pattern("121")
                .input('1', Items.DIAMOND)
                .input('2', ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_LOBSTER)
                .input(ModBlocks.TETO_PLUSH)
                .input(Items.SEAGRASS, 2)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_HOLLOW_KNIGHT)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.BLACK_WOOL, 1)
                .input(Items.IRON_SWORD, 1)
                .input(Items.BONE_BLOCK, 1)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_HORNET)
                .input(ModBlocks.MIKU_PLUSH)
                .input(Items.RED_WOOL, 1)
                .input(Items.IRON_SWORD, 1)
                .input(Items.BONE_BLOCK, 1)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MIKU_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.MIKU_PLUSH))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_SYNTHV)
                .input(ModBlocks.TETO_PLUSH)
                .input(Items.IRON_INGOT, 1)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_SYNTHV)
                .pattern("121")
                .input('1', Items.DIAMOND)
                .input('2', ModBlocks.TETO_PLUSH_SYNTHV)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH_SYNTHV), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH_SYNTHV))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH_SPOKEN_FOR)
                .input(ModBlocks.TETO_PLUSH)
                .input(Items.PINK_DYE, 1)
                .input(Items.GLOWSTONE_DUST, 1)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TETO_PICKAXE_SPOKEN_FOR)
                .pattern("121")
                .input('1', Items.DIAMOND)
                .input('2', ModBlocks.TETO_PLUSH_SPOKEN_FOR)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TETO_PLUSH_SPOKEN_FOR), FabricRecipeProvider.conditionsFromItem(ModBlocks.TETO_PLUSH_SPOKEN_FOR))
                .offerTo(exporter);
        }

        //MEIKO
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MEIKO_PLUSH)
                .pattern("121")
                .pattern(" 3 ")
                .input('1', Items.BROWN_WOOL)
                .input('2', Items.WHITE_WOOL)
                .input('3', Items.RED_WOOL)
                .criterion(FabricRecipeProvider.hasItem(Items.BROWN_WOOL), FabricRecipeProvider.conditionsFromItem(Items.BROWN_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.RED_WOOL), FabricRecipeProvider.conditionsFromItem(Items.RED_WOOL))
                .offerTo(exporter);
        }

    }
}
