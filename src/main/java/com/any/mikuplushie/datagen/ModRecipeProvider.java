package com.any.mikuplushie.datagen;

import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemlookup = registries.lookupOrThrow(Registries.ITEM);
                shaped(RecipeCategory.FOOD, ModItems.CANUDINHO)
                    .pattern("p")
                    .pattern("p")
                    .define('p', Items.PAPER)
                    .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                    .save(output);

                shaped(RecipeCategory.FOOD, ModItems.BAGUETTE)
                    .pattern("www")
                    .pattern("www")
                    .define('w', Items.WHEAT)
                    .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                    .save(output);

                simpleShapeless(output, ModItems.AKITA_NERU_PHONE, Items.GOLD_INGOT, Items.REDSTONE, Items.BLACK_STAINED_GLASS);

                shaped(RecipeCategory.FOOD, ModItems.VOCALOID_HEART)
                    .pattern("LN")
                    .pattern("BP")
                    .define('L', ModItems.LEEK)
                    .define('N', Items.NOTE_BLOCK)
                    .define('B', ModItems.BAGUETTE)
                    .define('P', ModItems.AKITA_NERU_PHONE)
                    .unlockedBy(getHasName(ModItems.LEEK), has(ModItems.LEEK))
                    .unlockedBy(getHasName(Items.NOTE_BLOCK), has(Items.NOTE_BLOCK))
                    .unlockedBy(getHasName(ModItems.BAGUETTE), has(ModItems.BAGUETTE))
                    .unlockedBy(getHasName(ModItems.AKITA_NERU_PHONE), has(ModItems.AKITA_NERU_PHONE))
                    .save(output);

                //AIKO
                {
                    shaped(RecipeCategory.DECORATIONS, ModBlocks.AIKO_PLUSH)
                        .pattern("121")
                        .pattern("131")
                        .define('1', Items.BLUE_WOOL)
                        .define('2', Items.WHITE_WOOL)
                        .define('3', Items.GREEN_WOOL)
                        .unlockedBy(getHasName(Items.BLUE_WOOL), has(Items.BLUE_WOOL))
                        .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                        .unlockedBy(getHasName(Items.GREEN_WOOL), has(Items.GREEN_WOOL))
                        .save(output);
                }

                //NERU
                {
                    shaped(RecipeCategory.DECORATIONS, ModBlocks.AKITA_NERU_PLUSH)
                        .pattern("121")
                        .pattern("131")
                        .define('1', Items.YELLOW_WOOL)
                        .define('2', Items.WHITE_WOOL)
                        .define('3', Items.BROWN_WOOL)
                        .unlockedBy(getHasName(Items.YELLOW_WOOL), has(Items.YELLOW_WOOL))
                        .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                        .unlockedBy(getHasName(Items.BROWN_WOOL), has(Items.BROWN_WOOL))
                        .save(output);

                    plushShapeless(output, ModBlocks.AKITA_NERU_PLUSH_TAILS, ModBlocks.AKITA_NERU_PLUSH, Items.YELLOW_WOOL, Items.REDSTONE);
                }

                //RIN
                {
                    shaped(RecipeCategory.DECORATIONS, ModBlocks.RIN_PLUSH)
                        .pattern("121")
                        .pattern("121")
                        .define('1', Items.YELLOW_WOOL)
                        .define('2', Items.WHITE_WOOL)
                        .unlockedBy(getHasName(Items.YELLOW_WOOL), has(Items.YELLOW_WOOL))
                        .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                        .save(output);
                }

                //LEN
                {
                    shaped(RecipeCategory.DECORATIONS, ModBlocks.LEN_PLUSH)
                        .pattern("121")
                        .pattern("131")
                        .define('1', Items.YELLOW_WOOL)
                        .define('2', Items.WHITE_WOOL)
                        .define('3', Items.GRAY_WOOL)
                        .unlockedBy(getHasName(Items.YELLOW_WOOL), has(Items.YELLOW_WOOL))
                        .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                        .unlockedBy(getHasName(Items.GRAY_WOOL), has(Items.GRAY_WOOL))
                        .save(output);
                }

                //KONOHA
                {
                    shaped(RecipeCategory.DECORATIONS, ModBlocks.KONOHA_PLUSH)
                        .pattern("121")
                        .pattern("323")
                        .define('1', Items.WHITE_WOOL)
                        .define('2', Items.LIGHT_GRAY_WOOL)
                        .define('3', Items.LIME_WOOL)
                        .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                        .unlockedBy(getHasName(Items.LIGHT_GRAY_WOOL), has(Items.LIGHT_GRAY_WOOL))
                        .unlockedBy(getHasName(Items.LIME_WOOL), has(Items.LIME_WOOL))
                        .save(output);
                }

                //LUKA
                {
                    shaped(RecipeCategory.DECORATIONS, ModBlocks.LUKA_PLUSH)
                        .pattern("121")
                        .pattern("131")
                        .define('1', Items.PINK_WOOL)
                        .define('2', Items.YELLOW_WOOL)
                        .define('3', Items.BROWN_WOOL)
                        .unlockedBy(getHasName(Items.PINK_WOOL), has(Items.PINK_WOOL))
                        .unlockedBy(getHasName(Items.YELLOW_WOOL), has(Items.YELLOW_WOOL))
                        .unlockedBy(getHasName(Items.BROWN_WOOL), has(Items.BROWN_WOOL))
                        .save(output);
                }

                //MIKU
                {
                    shaped(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH)
                        .pattern("121")
                        .pattern("131")
                        .define('1', Items.CYAN_WOOL)
                        .define('2', Items.WHITE_WOOL)
                        .define('3', Items.GRAY_WOOL)
                        .unlockedBy(getHasName(Items.CYAN_WOOL), has(Items.CYAN_WOOL))
                        .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                        .unlockedBy(getHasName(Items.GRAY_WOOL), has(Items.GRAY_WOOL))
                        .save(output);

                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.GREEN_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_BA, ModBlocks.MIKU_PLUSH, Items.RED_WOOL, Items.WHITE_WOOL, Items.BLUE_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BIK, ModBlocks.MIKU_PLUSH, Items.BLUE_WOOL, Items.WATER_BUCKET);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_BEACH, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.GREEN_WOOL, Items.SAND);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_BRAID, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.GREEN_WOOL, Items.GLOWSTONE);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_BA_DRUM, ModBlocks.MIKU_PLUSH, Items.RED_WOOL, Items.WHITE_WOOL, Items.BLUE_WOOL, Items.NOTE_BLOCK);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_PA, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.CORNFLOWER);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_SP, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.RED_WOOL, Items.BLACK_WOOL, Items.GRAY_CONCRETE);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_MG, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.RED_WOOL, Items.GOLD_NUGGET);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_BROWN_BRO, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.BLACK_WOOL, Items.IRON_NUGGET);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.BLUE_WOOL, Items.REDSTONE);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE, ModBlocks.MIKU_PLUSH, Items.ORANGE_WOOL, Items.WATER_BUCKET);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_AM, ModBlocks.MIKU_PLUSH, Items.GREEN_WOOL, Items.YELLOW_WOOL, Items.BLUE_WOOL, Items.JUNGLE_SAPLING);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_FUT_FLA, ModBlocks.MIKU_PLUSH, Items.RED_WOOL, Items.BLACK_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_FUT_CAM, ModBlocks.MIKU_PLUSH, Items.LIGHT_GRAY_WOOL, Items.BLACK_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_FUT_CRVG, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.BLACK_WOOL, Items.CARTOGRAPHY_TABLE);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_GO, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.GREEN_WOOL, Items.LEAD);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.BLUE_WOOL, Items.TUBE_CORAL_FAN);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_BR_RS, ModBlocks.MIKU_PLUSH, Items.GRAY_WOOL, Items.RED_WOOL, Items.MOSS_BLOCK);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_FROG, ModBlocks.MIKU_PLUSH, Items.LIGHT_BLUE_WOOL, Items.TADPOLE_BUCKET);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_MUSHROOM, ModBlocks.MIKU_PLUSH, Items.MOSS_BLOCK, Items.RED_MUSHROOM_BLOCK);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_SENBONZAKURA, ModBlocks.MIKU_PLUSH, Items.GREEN_WOOL, Items.CHERRY_LOG);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_URAOTOMELOVERS, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.BLACK_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_PERSONADANCING, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.BLACK_WOOL, Items.NOTE_BLOCK);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_HELLOPLANET, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.LIME_WOOL, Items.MAGENTA_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_HACHUNE, ModBlocks.MIKU_PLUSH, Items.LILY_OF_THE_VALLEY);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_ZATSUNE, ModBlocks.MIKU_PLUSH, Items.BLACK_WOOL, Items.BLACK_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_INFINITY, ModBlocks.MIKU_PLUSH, Items.ENDER_EYE);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_VAMPIRE, ModBlocks.MIKU_PLUSH, Items.FERMENTED_SPIDER_EYE);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_WEREWOMAN, ModBlocks.MIKU_PLUSH, Items.BONE, Items.MUTTON);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_JASON, ModBlocks.MIKU_PLUSH, Items.BIRCH_PLANKS, Items.BROWN_WOOL, Items.IRON_SWORD);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_MICHAEL_MYERS, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.BLUE_WOOL, Items.IRON_SWORD);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_PUMPKIN, ModBlocks.MIKU_PLUSH, Items.CARVED_PUMPKIN);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_GHOSTFACE, ModBlocks.MIKU_PLUSH, Items.BIRCH_PLANKS, Items.BLACK_WOOL, Items.IRON_SWORD);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_FRANKENSTEIN, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.GREEN_WOOL, Items.LIGHTNING_ROD);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_MUMMY, ModBlocks.MIKU_PLUSH, Items.BLACK_WOOL, Items.PAPER, Items.PAPER);

                    shaped(RecipeCategory.DECORATIONS, ModBlocks.MIKU_PLUSH_GHOST)
                        .pattern("121")
                        .pattern("131")
                        .define('1', Items.CYAN_STAINED_GLASS)
                        .define('2', Items.WHITE_STAINED_GLASS)
                        .define('3', Items.GRAY_STAINED_GLASS)
                        .unlockedBy(getHasName(Items.CYAN_STAINED_GLASS), has(Items.CYAN_STAINED_GLASS))
                        .unlockedBy(getHasName(Items.WHITE_STAINED_GLASS), has(Items.WHITE_STAINED_GLASS))
                        .unlockedBy(getHasName(Items.GRAY_STAINED_GLASS), has(Items.GRAY_STAINED_GLASS))
                        .save(output);

                    plushShapeless(output, ModBlocks.MIKU_PLUSH_PATATI, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.LIGHT_BLUE_WOOL, Items.WHITE_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_PATATA, ModBlocks.MIKU_PLUSH, Items.YELLOW_WOOL, Items.LIME_WOOL, Items.RED_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_DEVIL, ModBlocks.MIKU_PLUSH, Items.MAGMA_BLOCK, Items.NETHERRACK);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_WITCH, ModBlocks.MIKU_PLUSH, Items.PURPLE_WOOL, Items.GREEN_WOOL, Items.STICK, Items.WHEAT);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_SANTA, ModBlocks.MIKU_PLUSH, Items.RED_WOOL, Items.WHITE_WOOL, Items.SNOW_BLOCK);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_REINDEER, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.REDSTONE_TORCH);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_SANTA_ELF, ModBlocks.MIKU_PLUSH, Items.LIME_WOOL, Items.RED_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_XMAS_TREE, ModBlocks.MIKU_PLUSH, Items.SPRUCE_LEAVES, Items.RED_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS, ModBlocks.MIKU_PLUSH, Items.MAGENTA_WOOL, Items.BLACK_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_FORTNITE_NEKO, ModBlocks.MIKU_PLUSH, Items.PINK_WOOL, Items.LIGHT_BLUE_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_V4, ModBlocks.MIKU_PLUSH, Items.IRON_INGOT);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_MESMERIZER, ModBlocks.MIKU_PLUSH, Items.LIGHT_BLUE_WOOL, Items.LIGHT_BLUE_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_SONIC, ModBlocks.MIKU_PLUSH, Items.BLUE_WOOL, Items.REDSTONE);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025, ModBlocks.MIKU_PLUSH, Items.NOTE_BLOCK, Items.GOLD_NUGGET, Items.GOLD_NUGGET, Items.GOLD_NUGGET, Items.GOLD_NUGGET);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_ROTTEN_GIRL, ModBlocks.MIKU_PLUSH, Items.ROTTEN_FLESH);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_PSYCHO_MODE, ModBlocks.MIKU_PLUSH, Items.AMETHYST_SHARD);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.LIGHT_BLUE_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_STATIC, ModBlocks.MIKU_PLUSH, Items.YELLOW_DYE, Items.MAGENTA_DYE, Items.CYAN_DYE, Items.BLUE_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_MOCHIMOCHI, ModBlocks.MIKU_PLUSH, Items.LIGHT_BLUE_WOOL, Items.PINK_WOOL, Items.PINK_PETALS);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_MONITORING, ModBlocks.MIKU_PLUSH, Items.BROWN_WOOL, Items.SPYGLASS);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_HOLLOW_KNIGHT, ModBlocks.MIKU_PLUSH, Items.BLACK_WOOL, Items.IRON_SWORD, Items.BONE_BLOCK);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_HORNET, ModBlocks.MIKU_PLUSH, Items.RED_WOOL, Items.IRON_SWORD, Items.BONE_BLOCK);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_WORLD_IS_MINE, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.GOLD_INGOT, Items.CAKE);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_ROLLING_GIRL, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.BROWN_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_DEEP_SEA_GIRL, ModBlocks.MIKU_PLUSH, Items.TUBE_CORAL, Items.BUBBLE_CORAL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_LUCARIO_Z, ModBlocks.MIKU_PLUSH, Items.IRON_BARS, Items.WHITE_WOOL, Items.REDSTONE);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_PPPP, ModBlocks.MIKU_PLUSH, Items.CYAN_WOOL, Items.WHITE_WOOL);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_LINK, ModBlocks.MIKU_PLUSH, Items.GREEN_WOOL, Items.EMERALD);
                    plushShapeless(output, ModBlocks.MIKU_PLUSH_RENAISSANCE, ModBlocks.MIKU_PLUSH, Items.WHITE_WOOL, Items.WRITABLE_BOOK);
                }

                //TETO
                {
                    shaped(RecipeCategory.DECORATIONS, ModBlocks.TETO_PLUSH)
                        .pattern("121")
                        .pattern("131")
                        .define('1', Items.RED_WOOL)
                        .define('2', Items.WHITE_WOOL)
                        .define('3', Items.LIGHT_GRAY_WOOL)
                        .unlockedBy(getHasName(Items.RED_WOOL), has(Items.RED_WOOL))
                        .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                        .unlockedBy(getHasName(Items.LIGHT_GRAY_WOOL), has(Items.LIGHT_GRAY_WOOL))
                        .save(output);
                    pickaxeRecipe(output, ModItems.TETO_PICKAXE, ModBlocks.TETO_PLUSH);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_MESMERIZER, ModBlocks.TETO_PLUSH, Items.RED_WOOL, Items.RED_WOOL);
                    pickaxeRecipe(output, ModItems.TETO_PICKAXE_MESMERIZER, ModBlocks.TETO_PLUSH_MESMERIZER);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_SHADOW, ModBlocks.TETO_PLUSH, Items.BLACK_WOOL, Items.REDSTONE);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_BIRDBRAIN, ModBlocks.TETO_PLUSH, Items.WHEAT_SEEDS, Items.EGG);
                    pickaxeRecipe(output, ModItems.TETO_PICKAXE_BIRDBRAIN, ModBlocks.TETO_PLUSH_BIRDBRAIN);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_REGRET_ROCK, ModBlocks.TETO_PLUSH, Items.PURPLE_DYE);
                    pickaxeRecipe(output, ModItems.TETO_PICKAXE_REGRET_ROCK, ModBlocks.TETO_PLUSH_REGRET_ROCK);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T, ModBlocks.TETO_PLUSH, Items.WHITE_WOOL, Items.RED_WOOL);
                    pickaxeRecipe(output, ModItems.TETO_PICKAXE_DONT_BELIEVE_IN_T, ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_LIAR_DANCER, ModBlocks.TETO_PLUSH, Items.BLACK_STAINED_GLASS, Items.BLACK_STAINED_GLASS, Items.WHITE_WOOL);
                    pickaxeRecipe(output, ModItems.TETO_PICKAXE_LIAR_DANCER, ModBlocks.TETO_PLUSH_LIAR_DANCER);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME, ModBlocks.TETO_PLUSH, Items.GLASS, Items.GLASS, Items.RED_WOOL, Items.ORANGE_WOOL);
                    pickaxeRecipe(output, ModItems.TETO_PICKAXE_WHATCHACALLITSNAME, ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG, ModBlocks.TETO_PLUSH, Items.LIGHT_BLUE_WOOL);
                    pickaxeRecipe(output, ModItems.TETO_PICKAXE_SOME_MORE_OF_THAT_SONG, ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_LOBSTER, ModBlocks.TETO_PLUSH, Items.SEAGRASS, Items.SEAGRASS);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_SYNTHV, ModBlocks.TETO_PLUSH, Items.IRON_INGOT);
                    pickaxeRecipe(output, ModItems.TETO_PICKAXE_SYNTHV, ModBlocks.TETO_PLUSH_SYNTHV);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_SPOKEN_FOR, ModBlocks.TETO_PLUSH, Items.PINK_DYE, Items.GLOWSTONE_DUST);
                    pickaxeRecipe(output, ModItems.TETO_PICKAXE_SPOKEN_FOR, ModBlocks.TETO_PLUSH_SPOKEN_FOR);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_PPPP, ModBlocks.TETO_PLUSH, Items.RED_WOOL, Items.WHITE_WOOL);
                    pickaxeRecipe(output, ModItems.TETO_PICKAXE_PPPP, ModBlocks.TETO_PLUSH_PPPP);

                    plushShapeless(output, ModBlocks.TETO_PLUSH_SHRIMP, ModBlocks.TETO_PLUSH, Items.KELP, Items.KELP);

                }

                //MEIKO
                {
                    shaped(RecipeCategory.DECORATIONS, ModBlocks.MEIKO_PLUSH)
                        .pattern("121")
                        .pattern(" 3 ")
                        .define('1', Items.BROWN_WOOL)
                        .define('2', Items.WHITE_WOOL)
                        .define('3', Items.RED_WOOL)
                        .unlockedBy(getHasName(Items.BROWN_WOOL), has(Items.BROWN_WOOL))
                        .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                        .unlockedBy(getHasName(Items.RED_WOOL), has(Items.RED_WOOL))
                        .save(output);

                    plushShapeless(output, ModBlocks.MEIKO_PLUSH_V3, ModBlocks.MEIKO_PLUSH, Items.IRON_INGOT);
                    plushShapeless(output, ModBlocks.MEIKO_PLUSH_V4, ModBlocks.MEIKO_PLUSH, Items.IRON_INGOT, Items.IRON_INGOT);
                }

                //GUMI
                {
                    shaped(RecipeCategory.DECORATIONS, ModBlocks.GUMI_PLUSH)
                        .pattern("121")
                        .pattern(" 3 ")
                        .define('1', Items.LIME_WOOL)
                        .define('2', Items.WHITE_WOOL)
                        .define('3', Items.ORANGE_WOOL)
                        .unlockedBy(getHasName(Items.LIME_WOOL), has(Items.LIME_WOOL))
                        .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                        .unlockedBy(getHasName(Items.ORANGE_WOOL), has(Items.ORANGE_WOOL))
                        .save(output);

                    plushShapeless(output, ModBlocks.GUMI_PLUSH_V3, ModBlocks.GUMI_PLUSH, Items.IRON_INGOT);
                    plushShapeless(output, ModBlocks.GUMI_PLUSH_V4, ModBlocks.GUMI_PLUSH, Items.IRON_INGOT, Items.IRON_INGOT);
                    plushShapeless(output, ModBlocks.GUMI_PLUSH_V6, ModBlocks.GUMI_PLUSH, Items.IRON_INGOT, Items.IRON_INGOT, Items.REDSTONE);
                }

                //KAITO
                {
                    shaped(RecipeCategory.DECORATIONS, ModBlocks.KAITO_PLUSH)
                        .pattern("121")
                        .pattern(" 3 ")
                        .define('1', Items.BLUE_WOOL)
                        .define('2', Items.WHITE_WOOL)
                        .define('3', Items.ORANGE_WOOL)
                        .unlockedBy(getHasName(Items.BLUE_WOOL), has(Items.BLUE_WOOL))
                        .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                        .unlockedBy(getHasName(Items.ORANGE_WOOL), has(Items.ORANGE_WOOL))
                        .save(output);
                    plushShapeless(output, ModBlocks.KAITO_PLUSH_V3, ModBlocks.KAITO_PLUSH, Items.IRON_INGOT);
                    plushShapeless(output, ModBlocks.KAITO_PLUSH_V4, ModBlocks.KAITO_PLUSH, Items.IRON_INGOT, Items.IRON_INGOT);
                }


            }

            public void pickaxeRecipe(RecipeOutput exporter, ItemLike result, ItemLike ingredient) {
                shaped(RecipeCategory.TOOLS, result)
                    .pattern("121")
                    .define('1', Items.DIAMOND)
                    .define('2', ingredient)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(exporter);
            }

            public void plushShapeless(RecipeOutput exporter, ItemLike result, ItemLike plush, ItemLike... ingredients) {
                //CREATE SHAPELESS RECIPE WITH A PLUSH
                ShapelessRecipeBuilder shapeless =
                    shapeless(RecipeCategory.DECORATIONS, result)
                        .requires(plush);

                //ADD EXTRA INGREDIENTS AS NEEDED
                for (ItemLike ingredient : ingredients) {
                    shapeless.requires(ingredient);
                }

                //ADD RECIPE UNLOCK REQUIREMENT AND EXPORT RECIPE
                shapeless.unlockedBy(getHasName(plush), has(plush))
                    .save(exporter);
            }

            public void simpleShapeless(RecipeOutput exporter, ItemLike result, ItemLike... ingredients) {
                //CREATE SHAPELESS RECIPE WITH A PLUSH
                ShapelessRecipeBuilder shapeless =
                    shapeless(RecipeCategory.DECORATIONS, result);

                //ADD EXTRA INGREDIENTS AS NEEDED
                for (ItemLike ingredient : ingredients) {
                    shapeless.requires(ingredient);
                    shapeless.unlockedBy(getHasName(ingredient), has(ingredient));
                }

                //ADD RECIPE UNLOCK REQUIREMENT AND EXPORT RECIPE
                shapeless.save(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "MikuPlushiesRecipeProvider";
    }
}
