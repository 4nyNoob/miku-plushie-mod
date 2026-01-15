package com.any.mikuplushie.datagen;

import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BAGUETTE)
            .pattern("www")
            .pattern("www")
            .input('w', Items.WHEAT)
            .criterion(FabricRecipeProvider.hasItem(Items.WHEAT), FabricRecipeProvider.conditionsFromItem(Items.WHEAT))
            .offerTo(exporter);

        simpleShapeless(exporter, ModItems.AKITA_NERU_PHONE, Items.GOLD_INGOT, Items.REDSTONE, Items.BLACK_STAINED_GLASS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.VOCALOID_HEART)
            .pattern("LN")
            .pattern("BP")
            .input('L', ModItems.LEEK)
            .input('N', Items.NOTE_BLOCK)
            .input('B', ModItems.BAGUETTE)
            .input('P', ModItems.AKITA_NERU_PHONE)
            .criterion(FabricRecipeProvider.hasItem(ModItems.LEEK), FabricRecipeProvider.conditionsFromItem(ModItems.LEEK))
            .criterion(FabricRecipeProvider.hasItem(Items.NOTE_BLOCK), FabricRecipeProvider.conditionsFromItem(Items.NOTE_BLOCK))
            .criterion(FabricRecipeProvider.hasItem(ModItems.BAGUETTE), FabricRecipeProvider.conditionsFromItem(ModItems.BAGUETTE))
            .criterion(FabricRecipeProvider.hasItem(ModItems.AKITA_NERU_PHONE), FabricRecipeProvider.conditionsFromItem(ModItems.AKITA_NERU_PHONE))
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

            plushShapeless(exporter, ModBlocks.AKITA_NERU_PLUSH_TAILS, ModBlocks.AKITA_NERU_PLUSH, Items.YELLOW_WOOL, Items.REDSTONE);
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

            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.GREEN_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_BA, ModBlocks.MIKU_PLUSH, Items.RED_WOOL, Items.WHITE_WOOL, Items.BLUE_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BIK, ModBlocks.MIKU_PLUSH, Items.BLUE_WOOL, Items.WATER_BUCKET);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_BEACH, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.GREEN_WOOL, Items.SAND);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_BRAID, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.GREEN_WOOL, Items.GLOWSTONE);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_BA_DRUM, ModBlocks.MIKU_PLUSH, Items.RED_WOOL, Items.WHITE_WOOL, Items.BLUE_WOOL, Items.NOTE_BLOCK);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_PA, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.CORNFLOWER);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_SP, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.RED_WOOL, Items.BLACK_WOOL, Items.GRAY_CONCRETE);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_MG, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.RED_WOOL, Items.GOLD_NUGGET);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_BROWN_BRO, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.BLACK_WOOL, Items.IRON_NUGGET);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.BLUE_WOOL, Items.REDSTONE);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE, ModBlocks.MIKU_PLUSH, Items.ORANGE_WOOL, Items.WATER_BUCKET);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_AM, ModBlocks.MIKU_PLUSH, Items.GREEN_WOOL, Items.YELLOW_WOOL, Items.BLUE_WOOL, Items.JUNGLE_SAPLING);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_FUT_FLA, ModBlocks.MIKU_PLUSH, Items.RED_WOOL, Items.BLACK_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_FUT_CAM, ModBlocks.MIKU_PLUSH, Items.LIGHT_GRAY_WOOL, Items.BLACK_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_FUT_CRVG, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.BLACK_WOOL, Items.CARTOGRAPHY_TABLE);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_GO, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.GREEN_WOOL, Items.LEAD);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.BLUE_WOOL, Items.TUBE_CORAL_FAN);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_BR_RS, ModBlocks.MIKU_PLUSH, Items.GRAY_WOOL, Items.RED_WOOL, Items.MOSS_BLOCK);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_FROG, ModBlocks.MIKU_PLUSH, Items.LIGHT_BLUE_WOOL, Items.TADPOLE_BUCKET);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_MUSHROOM, ModBlocks.MIKU_PLUSH, Items.MOSS_BLOCK, Items.RED_MUSHROOM_BLOCK);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_SENBONZAKURA, ModBlocks.MIKU_PLUSH, Items.GREEN_WOOL, Items.CHERRY_LOG);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_URAOTOMELOVERS, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.BLACK_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_PERSONADANCING, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.BLACK_WOOL, Items.NOTE_BLOCK);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_HELLOPLANET, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.LIME_WOOL, Items.MAGENTA_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_HACHUNE, ModBlocks.MIKU_PLUSH, Items.LILY_OF_THE_VALLEY);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_ZATSUNE, ModBlocks.MIKU_PLUSH, Items.BLACK_WOOL, Items.BLACK_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_INFINITY, ModBlocks.MIKU_PLUSH, Items.ENDER_EYE);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_VAMPIRE, ModBlocks.MIKU_PLUSH, Items.FERMENTED_SPIDER_EYE);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_WEREWOMAN, ModBlocks.MIKU_PLUSH, Items.BONE, Items.MUTTON);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_JASON, ModBlocks.MIKU_PLUSH, Items.BIRCH_PLANKS, Items.BROWN_WOOL, Items.IRON_SWORD);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_MICHAEL_MYERS, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.BLUE_WOOL, Items.IRON_SWORD);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_PUMPKIN, ModBlocks.MIKU_PLUSH, Items.CARVED_PUMPKIN);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_GHOSTFACE, ModBlocks.MIKU_PLUSH, Items.BIRCH_PLANKS, Items.BLACK_WOOL, Items.IRON_SWORD);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_FRANKENSTEIN, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.GREEN_WOOL, Items.LIGHTNING_ROD);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_MUMMY, ModBlocks.MIKU_PLUSH, Items.BLACK_WOOL, Items.PAPER, Items.PAPER);

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

            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_PATATI, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.LIGHT_BLUE_WOOL, Items.WHITE_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_PATATA, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.LIME_WOOL, Items.RED_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_DEVIL, ModBlocks.MIKU_PLUSH, Items.MAGMA_BLOCK, Items.NETHERRACK);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_WITCH, ModBlocks.MIKU_PLUSH, Items.PURPLE_WOOL, Items.GREEN_WOOL, Items.STICK, Items.WHEAT);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_SANTA, ModBlocks.MIKU_PLUSH, Items.RED_WOOL, Items.WHITE_WOOL, Items.SNOW_BLOCK);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_REINDEER, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.REDSTONE_TORCH);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_SANTA_ELF, ModBlocks.MIKU_PLUSH, Items.LIME_WOOL, Items.RED_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_XMAS_TREE, ModBlocks.MIKU_PLUSH, Items.SPRUCE_LEAVES, Items.RED_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS, ModBlocks.MIKU_PLUSH, Items.MAGENTA_WOOL, Items.BLACK_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_FORTNITE_NEKO, ModBlocks.MIKU_PLUSH, Items.PINK_WOOL, Items.LIGHT_BLUE_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_V4, ModBlocks.MIKU_PLUSH, Items.IRON_INGOT);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_MESMERIZER, ModBlocks.MIKU_PLUSH, Items.LIGHT_BLUE_WOOL, Items.LIGHT_BLUE_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_SONIC, ModBlocks.MIKU_PLUSH, Items.BLUE_WOOL, Items.REDSTONE);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025, ModBlocks.MIKU_PLUSH, Items.NOTE_BLOCK, Items.GOLD_NUGGET, Items.GOLD_NUGGET, Items.GOLD_NUGGET, Items.GOLD_NUGGET);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_ROTTEN_GIRL, ModBlocks.MIKU_PLUSH, Items.ROTTEN_FLESH);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_PSYCHO_MODE, ModBlocks.MIKU_PLUSH, Items.AMETHYST_SHARD);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.LIGHT_BLUE_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_STATIC, ModBlocks.MIKU_PLUSH, Items.YELLOW_DYE, Items.MAGENTA_DYE, Items.CYAN_DYE, Items.BLUE_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_MOCHIMOCHI, ModBlocks.MIKU_PLUSH, Items.LIGHT_BLUE_WOOL, Items.PINK_WOOL, Items.PINK_PETALS);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_MONITORING, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.SPYGLASS);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_HOLLOW_KNIGHT, ModBlocks.MIKU_PLUSH, Items.BLACK_WOOL, Items.IRON_SWORD, Items.BONE_BLOCK);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_HORNET, ModBlocks.MIKU_PLUSH, Items.RED_WOOL, Items.IRON_SWORD, Items.BONE_BLOCK);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_WORLD_IS_MINE, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.GOLD_INGOT, Items.CAKE);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_ROLLING_GIRL, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.BROWN_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_DEEP_SEA_GIRL, ModBlocks.MIKU_PLUSH, Items.TUBE_CORAL, Items.BUBBLE_CORAL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_LUCARIO_Z, ModBlocks.MIKU_PLUSH, Items.IRON_BARS, Items.WHITE_WOOL, Items.REDSTONE);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_PPPP, ModBlocks.MIKU_PLUSH, Items.CYAN_WOOL, Items.WHITE_WOOL);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_LINK, ModBlocks.MIKU_PLUSH, Items.GREEN_WOOL, Items.EMERALD);
            plushShapeless(exporter, ModBlocks.MIKU_PLUSH_RENAISSANCE, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.WRITABLE_BOOK);
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
            pickaxeRecipe(exporter, ModItems.TETO_PICKAXE, ModBlocks.TETO_PLUSH);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_MESMERIZER, ModBlocks.TETO_PLUSH, Items.RED_WOOL, Items.RED_WOOL);
            pickaxeRecipe(exporter, ModItems.TETO_PICKAXE_MESMERIZER, ModBlocks.TETO_PLUSH_MESMERIZER);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_SHADOW, ModBlocks.TETO_PLUSH, Items.BLACK_WOOL, Items.REDSTONE);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_BIRDBRAIN, ModBlocks.TETO_PLUSH, Items.WHEAT_SEEDS, Items.EGG);
            pickaxeRecipe(exporter, ModItems.TETO_PICKAXE_BIRDBRAIN, ModBlocks.TETO_PLUSH_BIRDBRAIN);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_REGRET_ROCK, ModBlocks.TETO_PLUSH, Items.PURPLE_DYE);
            pickaxeRecipe(exporter, ModItems.TETO_PICKAXE_REGRET_ROCK, ModBlocks.TETO_PLUSH_REGRET_ROCK);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T, ModBlocks.TETO_PLUSH, Items.WHITE_WOOL, Items.RED_WOOL);
            pickaxeRecipe(exporter, ModItems.TETO_PICKAXE_DONT_BELIEVE_IN_T, ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_LIAR_DANCER, ModBlocks.TETO_PLUSH, Items.BLACK_STAINED_GLASS, Items.BLACK_STAINED_GLASS, Items.WHITE_WOOL);
            pickaxeRecipe(exporter, ModItems.TETO_PICKAXE_LIAR_DANCER, ModBlocks.TETO_PLUSH_LIAR_DANCER);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME, ModBlocks.TETO_PLUSH, Items.GLASS, Items.GLASS, Items.RED_WOOL, Items.ORANGE_WOOL);
            pickaxeRecipe(exporter, ModItems.TETO_PICKAXE_WHATCHACALLITSNAME, ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG, ModBlocks.TETO_PLUSH, Items.LIGHT_BLUE_WOOL);
            pickaxeRecipe(exporter, ModItems.TETO_PICKAXE_SOME_MORE_OF_THAT_SONG, ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_LOBSTER, ModBlocks.TETO_PLUSH, Items.SEAGRASS, Items.SEAGRASS);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_SYNTHV, ModBlocks.TETO_PLUSH, Items.IRON_INGOT);
            pickaxeRecipe(exporter, ModItems.TETO_PICKAXE_SYNTHV, ModBlocks.TETO_PLUSH_SYNTHV);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_SPOKEN_FOR, ModBlocks.TETO_PLUSH, Items.PINK_DYE, Items.GLOWSTONE_DUST);
            pickaxeRecipe(exporter, ModItems.TETO_PICKAXE_SPOKEN_FOR, ModBlocks.TETO_PLUSH_SPOKEN_FOR);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_PPPP, ModBlocks.TETO_PLUSH, Items.RED_WOOL, Items.WHITE_WOOL);
            pickaxeRecipe(exporter, ModItems.TETO_PICKAXE_PPPP, ModBlocks.TETO_PLUSH_PPPP);

            plushShapeless(exporter, ModBlocks.TETO_PLUSH_SHRIMP, ModBlocks.TETO_PLUSH, Items.KELP, Items.KELP);

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

            plushShapeless(exporter, ModBlocks.MEIKO_PLUSH_V3, ModBlocks.MEIKO_PLUSH, Items.IRON_INGOT);
            plushShapeless(exporter, ModBlocks.MEIKO_PLUSH_V4, ModBlocks.MEIKO_PLUSH, Items.IRON_INGOT, Items.IRON_INGOT);
        }

        //GUMI
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.GUMI_PLUSH)
                .pattern("121")
                .pattern(" 3 ")
                .input('1', Items.LIME_WOOL)
                .input('2', Items.WHITE_WOOL)
                .input('3', Items.ORANGE_WOOL)
                .criterion(FabricRecipeProvider.hasItem(Items.LIME_WOOL), FabricRecipeProvider.conditionsFromItem(Items.LIME_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.ORANGE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.ORANGE_WOOL))
                .offerTo(exporter);

            plushShapeless(exporter, ModBlocks.GUMI_PLUSH_V3, ModBlocks.GUMI_PLUSH, Items.IRON_INGOT);
            plushShapeless(exporter, ModBlocks.GUMI_PLUSH_V4, ModBlocks.GUMI_PLUSH, Items.IRON_INGOT, Items.IRON_INGOT);
            plushShapeless(exporter, ModBlocks.GUMI_PLUSH_V6, ModBlocks.GUMI_PLUSH, Items.IRON_INGOT, Items.IRON_INGOT, Items.REDSTONE);
        }

        //KAITO
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.KAITO_PLUSH)
                .pattern("121")
                .pattern(" 3 ")
                .input('1', Items.BLUE_WOOL)
                .input('2', Items.WHITE_WOOL)
                .input('3', Items.ORANGE_WOOL)
                .criterion(FabricRecipeProvider.hasItem(Items.BLUE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.BLUE_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                .criterion(FabricRecipeProvider.hasItem(Items.ORANGE_WOOL), FabricRecipeProvider.conditionsFromItem(Items.ORANGE_WOOL))
                .offerTo(exporter);
            plushShapeless(exporter, ModBlocks.KAITO_PLUSH_V3, ModBlocks.KAITO_PLUSH, Items.IRON_INGOT);
            plushShapeless(exporter, ModBlocks.KAITO_PLUSH_V4, ModBlocks.KAITO_PLUSH, Items.IRON_INGOT, Items.IRON_INGOT);
        }

    }

    public static void pickaxeRecipe (RecipeExporter exporter, ItemConvertible result, ItemConvertible ingredient) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
            .pattern("121")
            .input('1', Items.DIAMOND)
            .input('2', ingredient)
            .criterion(FabricRecipeProvider.hasItem(ingredient), FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);
    }

    public static void plushShapeless(RecipeExporter exporter, ItemConvertible result, ItemConvertible plush, ItemConvertible... ingredients) {
        //CREATE SHAPELESS RECIPE WITH A PLUSH
        ShapelessRecipeJsonBuilder shapeless =
            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, result)
            .input(plush);

        //ADD EXTRA INGREDIENTS AS NEEDED
        for (ItemConvertible ingredient : ingredients) {
            shapeless.input(ingredient);
        }

        //ADD RECIPE UNLOCK REQUIREMENT AND EXPORT RECIPE
        shapeless.criterion(FabricRecipeProvider.hasItem(plush), FabricRecipeProvider.conditionsFromItem(plush))
        .offerTo(exporter);
    }

    public static void simpleShapeless(RecipeExporter exporter, ItemConvertible result, ItemConvertible... ingredients) {
        //CREATE SHAPELESS RECIPE WITH A PLUSH
        ShapelessRecipeJsonBuilder shapeless =
            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, result);

        //ADD EXTRA INGREDIENTS AS NEEDED
        for (ItemConvertible ingredient : ingredients) {
            shapeless.input(ingredient);
            shapeless.criterion(FabricRecipeProvider.hasItem(ingredient), FabricRecipeProvider.conditionsFromItem(ingredient));
        }

        //ADD RECIPE UNLOCK REQUIREMENT AND EXPORT RECIPE
        shapeless.offerTo(exporter);
    }
}
