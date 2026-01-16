package com.any.mikuplushie;

import com.any.mikuplushie.item.*;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {

	public static final Tier PLUSH_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_STONE_TOOL,
		500,
		15F,
		0F,
		25, () -> Ingredient.of(Items.DIAMOND)
	);


	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MikuPlushie.MOD_ID);

	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MikuPlushie.MOD_ID);

	public static final DeferredItem<Item> CANUDINHO = ITEMS.registerSimpleItem("canudinho",new Item.Properties().rarity(Rarity.RARE));
    public static final DeferredItem<Item> BAGUETTE = ITEMS.registerSimpleItem("baguette", new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.6F).build()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR = ITEMS.register("miku_plush_br",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_BA = ITEMS.register("miku_plush_br_ba",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BA.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BIK = ITEMS.register("miku_plush_bik",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BIK.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_BEACH = ITEMS.register("miku_plush_br_beach",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BEACH.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_BRAID = ITEMS.register("miku_plush_br_braid",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BRAID.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_BA_DRUM = ITEMS.register("miku_plush_br_ba_drum",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BA_DRUM.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_PA = ITEMS.register("miku_plush_br_pa",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_PA.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_SP = ITEMS.register("miku_plush_br_sp",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_SP.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_MG = ITEMS.register("miku_plush_br_mg",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_MG.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_BROWN_BRO = ITEMS.register("miku_plush_br_brown_bro",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BROWN_BRO.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_ELECTRICIAN = ITEMS.register("miku_plush_br_electrician",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_BIK_ORANGE = ITEMS.register("miku_plush_br_bik_orange",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_AM = ITEMS.register("miku_plush_br_am",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_AM.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_FUT_FLA = ITEMS.register("miku_plush_br_fut_fla",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_FUT_FLA.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_FUT_CAM = ITEMS.register("miku_plush_br_fut_cam",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_FUT_CAM.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_GO = ITEMS.register("miku_plush_br_go",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_GO.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_SCHOOL_PE = ITEMS.register("miku_plush_br_school_pe",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_FUT_CRVG = ITEMS.register("miku_plush_br_fut_crvg",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_FUT_CRVG.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_BR_RS = ITEMS.register("miku_plush_br_rs",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_RS.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_FROG = ITEMS.register("miku_plush_frog",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_FROG.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_MUSHROOM = ITEMS.register("miku_plush_mushroom",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MUSHROOM.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_SENBONZAKURA = ITEMS.register("miku_plush_senbonzakura",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_SENBONZAKURA.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_URAOTOMELOVERS = ITEMS.register("miku_plush_uraotomelovers",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_URAOTOMELOVERS.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_PERSONADANCING = ITEMS.register("miku_plush_personadancing",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_PERSONADANCING.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_HELLOPLANET = ITEMS.register("miku_plush_helloplanet",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_HELLOPLANET.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_HACHUNE = ITEMS.register("miku_plush_hachune",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_HACHUNE.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_ZATSUNE = ITEMS.register("miku_plush_zatsune",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_ZATSUNE.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_INFINITY = ITEMS.register("miku_plush_infinity",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_INFINITY.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_VAMPIRE = ITEMS.register("miku_plush_vampire",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_VAMPIRE.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_WEREWOMAN = ITEMS.register("miku_plush_werewoman",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_WEREWOMAN.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_JASON = ITEMS.register("miku_plush_jason",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_JASON.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_MICHAEL_MYERS = ITEMS.register("miku_plush_michael_myers",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MICHAEL_MYERS.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_PUMPKIN = ITEMS.register("miku_plush_pumpkin",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_PUMPKIN.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_GHOSTFACE = ITEMS.register("miku_plush_ghostface",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_GHOSTFACE.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_FRANKENSTEIN = ITEMS.register("miku_plush_frankenstein",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_FRANKENSTEIN.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_MUMMY = ITEMS.register("miku_plush_mummy",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MUMMY.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_GHOST = ITEMS.register("miku_plush_ghost",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_GHOST.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_PATATI = ITEMS.register("miku_plush_patati",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_PATATI.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_PATATA = ITEMS.register("miku_plush_patata",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_PATATA.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_DEVIL = ITEMS.register("miku_plush_devil",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_DEVIL.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_WITCH = ITEMS.register("miku_plush_witch",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_WITCH.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_SANTA = ITEMS.register("miku_plush_santa",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_SANTA.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_REINDEER = ITEMS.register("miku_plush_reindeer",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_REINDEER.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_SANTA_ELF = ITEMS.register("miku_plush_santa_elf",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_SANTA_ELF.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_XMAS_TREE = ITEMS.register("miku_plush_xmas_tree",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_XMAS_TREE.get()));
	public static final DeferredItem<MikuPlushieBlockItem> AIKO_PLUSH = ITEMS.register("aiko_plush",
			()->new MikuPlushieBlockItem(ModBlocks.AIKO_PLUSH.get()));
	public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH = ITEMS.register("teto_plush",
			()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH.get()));
	public static final DeferredItem<TetoPickaxeItem> TETO_PICKAXE = ITEMS.register("teto_pickaxe", () ->
		new TetoPickaxeItem(PLUSH_TIER, new Item.Properties().attributes(TetoPickaxeItem.createAttributes(PLUSH_TIER, 0, -2.8f))));

	public static final DeferredItem<MikuPlushieBlockItem> AKITA_NERU_PLUSH = ITEMS.register("akita_neru_plush",
			()->new MikuPlushieBlockItem(ModBlocks.AKITA_NERU_PLUSH.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH = ITEMS.register("miku_plush",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH.get()));
	public static final DeferredItem<MikuPlushieBlockItem> RIN_PLUSH = ITEMS.register("rin_plush",
			()->new MikuPlushieBlockItem(ModBlocks.RIN_PLUSH.get()));
	public static final DeferredItem<MikuPlushieBlockItem> LEN_PLUSH = ITEMS.register("len_plush",
			()->new MikuPlushieBlockItem(ModBlocks.LEN_PLUSH.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_SONIC_CROSSWORLDS = ITEMS.register("miku_plush_sonic_crossworlds",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_FORTNITE_NEKO = ITEMS.register("miku_plush_fortnite_neko",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_FORTNITE_NEKO.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_V4 = ITEMS.register("miku_plush_v4",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_V4.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_MESMERIZER = ITEMS.register("miku_plush_mesmerizer",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MESMERIZER.get()));
	public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_MESMERIZER = ITEMS.register("teto_plush_mesmerizer",
			()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_MESMERIZER.get()));
	public static final DeferredItem<TetoPickaxeItem> TETO_PICKAXE_MESMERIZER = ITEMS.register("teto_pickaxe_mesmerizer", () ->
		new TetoPickaxeItem(PLUSH_TIER, new Item.Properties().attributes(TetoPickaxeItem.createAttributes(PLUSH_TIER, 0, -2.8f))));

	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_SONIC = ITEMS.register("miku_plush_sonic",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_SONIC.get()));
	public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_SHADOW = ITEMS.register("teto_plush_shadow",
			()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_SHADOW.get()));
	public static final DeferredItem<MikuPlushieBlockItem> AKITA_NERU_PLUSH_TAILS = ITEMS.register("akita_neru_plush_tails",
			()->new MikuPlushieBlockItem(ModBlocks.AKITA_NERU_PLUSH_TAILS.get()));
	public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_BIRDBRAIN = ITEMS.register("teto_plush_birdbrain",
			()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_BIRDBRAIN.get()));
	public static final DeferredItem<TetoPickaxeItem> TETO_PICKAXE_BIRDBRAIN = ITEMS.register("teto_pickaxe_birdbrain", () ->
		new TetoPickaxeItem(PLUSH_TIER, new Item.Properties().attributes(TetoPickaxeItem.createAttributes(PLUSH_TIER, 0, -2.8f))));

	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_DIGITAL_STARS_2025 = ITEMS.register("miku_plush_digital_stars_2025",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_ROTTEN_GIRL = ITEMS.register("miku_plush_rotten_girl",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_ROTTEN_GIRL.get()));
	public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_REGRET_ROCK = ITEMS.register("teto_plush_regret_rock",
			()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_REGRET_ROCK.get()));
	public static final DeferredItem<TetoPickaxeItem> TETO_PICKAXE_REGRET_ROCK = ITEMS.register("teto_pickaxe_regret_rock", () ->
		new TetoPickaxeItem(PLUSH_TIER, new Item.Properties().attributes(TetoPickaxeItem.createAttributes(PLUSH_TIER, 0, -2.8f))));

	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_PSYCHO_MODE = ITEMS.register("miku_plush_psycho_mode",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_PSYCHO_MODE.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_DONT_BELIEVE_IN_T = ITEMS.register("miku_plush_dont_believe_in_t",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T.get()));
	public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_DONT_BELIEVE_IN_T = ITEMS.register("teto_plush_dont_believe_in_t",
			()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T.get()));
	public static final DeferredItem<TetoPickaxeItem> TETO_PICKAXE_DONT_BELIEVE_IN_T = ITEMS.register("teto_pickaxe_dont_believe_in_t", () ->
		new TetoPickaxeItem(PLUSH_TIER, new Item.Properties().attributes(TetoPickaxeItem.createAttributes(PLUSH_TIER, 0, -2.8f))));

	public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_LIAR_DANCER = ITEMS.register("teto_plush_liar_dancer",
			()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_LIAR_DANCER.get()));
	public static final DeferredItem<TetoPickaxeItem> TETO_PICKAXE_LIAR_DANCER = ITEMS.register("teto_pickaxe_liar_dancer", () ->
		new TetoPickaxeItem(PLUSH_TIER, new Item.Properties().attributes(TetoPickaxeItem.createAttributes(PLUSH_TIER, 0, -2.8f))));

	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_STATIC = ITEMS.register("miku_plush_static",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_STATIC.get()));
	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_MOCHIMOCHI = ITEMS.register("miku_plush_mochimochi",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MOCHIMOCHI.get()));
	public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_WHATCHACALLITSNAME = ITEMS.register("teto_plush_whatchacallitsname",
			()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME.get()));
	public static final DeferredItem<TetoPickaxeItem> TETO_PICKAXE_WHATCHACALLITSNAME = ITEMS.register("teto_pickaxe_whatchacallitsname", () ->
		new TetoPickaxeItem(PLUSH_TIER, new Item.Properties().attributes(TetoPickaxeItem.createAttributes(PLUSH_TIER, 0, -2.8f))));

	public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_MONITORING = ITEMS.register("miku_plush_monitoring",
			()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MONITORING.get()));
    public static final DeferredItem<MikuPlushieBlockItem> KONOHA_PLUSH = ITEMS.register("konoha_plush",
            ()->new MikuPlushieBlockItem(ModBlocks.KONOHA_PLUSH.get()));
    public static final DeferredItem<MikuPlushieBlockItem> LUKA_PLUSH = ITEMS.register("luka_plush",
            ()->new MikuPlushieBlockItem(ModBlocks.LUKA_PLUSH.get()));
    public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_SOME_MORE_OF_THAT_SONG = ITEMS.register("teto_plush_some_more_of_that_song",
            ()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG.get()));
    public static final DeferredItem<TetoPickaxeItem> TETO_PICKAXE_SOME_MORE_OF_THAT_SONG = ITEMS.register("teto_pickaxe_some_more_of_that_song", () ->
            new TetoPickaxeItem(PLUSH_TIER, new Item.Properties().attributes(TetoPickaxeItem.createAttributes(PLUSH_TIER, 0, -2.8f))));

    public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_LOBSTER = ITEMS.register("teto_plush_lobster",
            ()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_LOBSTER.get()));
    public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_HOLLOW_KNIGHT = ITEMS.register("miku_plush_hollow_knight",
            ()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_HOLLOW_KNIGHT.get()));
    public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_HORNET = ITEMS.register("miku_plush_hornet",
            ()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_HORNET.get()));
    public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_SYNTHV = ITEMS.register("teto_plush_synthv",
            ()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_SYNTHV.get()));
    public static final DeferredItem<TetoPickaxeItem> TETO_PICKAXE_SYNTHV = ITEMS.register("teto_pickaxe_synthv", () ->
            new TetoPickaxeItem(PLUSH_TIER, new Item.Properties().attributes(TetoPickaxeItem.createAttributes(PLUSH_TIER, 0, -2.8f))));
    public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_WORLD_IS_MINE = ITEMS.register("miku_plush_world_is_mine",
            ()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_WORLD_IS_MINE.get()));
    public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_ROLLING_GIRL = ITEMS.register("miku_plush_rolling_girl",
            ()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_ROLLING_GIRL.get()));
    public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_SPOKEN_FOR = ITEMS.register("teto_plush_spoken_for",
            ()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_SPOKEN_FOR.get()));
    public static final DeferredItem<TetoPickaxeItem> TETO_PICKAXE_SPOKEN_FOR = ITEMS.register("teto_pickaxe_spoken_for", () ->
            new TetoPickaxeItem(PLUSH_TIER, new Item.Properties().attributes(TetoPickaxeItem.createAttributes(PLUSH_TIER, 0, -2.8f))));
    public static final DeferredItem<MikuPlushieBlockItem> MEIKO_PLUSH = ITEMS.register("meiko_plush",
            ()->new MikuPlushieBlockItem(ModBlocks.MEIKO_PLUSH.get()));
    public static final DeferredItem<MikuPlushieBlockItem> MEIKO_PLUSH_V3 = ITEMS.register("meiko_plush_v3",
            ()->new MikuPlushieBlockItem(ModBlocks.MEIKO_PLUSH_V3.get()));
    public static final DeferredItem<MikuPlushieBlockItem> MEIKO_PLUSH_V4 = ITEMS.register("meiko_plush_v4",
            ()->new MikuPlushieBlockItem(ModBlocks.MEIKO_PLUSH_V4.get()));
    public static final DeferredItem<MikuPlushieBlockItem> GUMI_PLUSH = ITEMS.register("gumi_plush",
            ()->new MikuPlushieBlockItem(ModBlocks.GUMI_PLUSH.get()));
    public static final DeferredItem<MikuPlushieBlockItem> GUMI_PLUSH_V3 = ITEMS.register("gumi_plush_v3",
            ()->new MikuPlushieBlockItem(ModBlocks.GUMI_PLUSH_V3.get()));
    public static final DeferredItem<MikuPlushieBlockItem> GUMI_PLUSH_V4 = ITEMS.register("gumi_plush_v4",
            ()->new MikuPlushieBlockItem(ModBlocks.GUMI_PLUSH_V4.get()));
    public static final DeferredItem<MikuPlushieBlockItem> GUMI_PLUSH_V6 = ITEMS.register("gumi_plush_v6",
            ()->new MikuPlushieBlockItem(ModBlocks.GUMI_PLUSH_V6.get()));
    public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_DEEP_SEA_GIRL = ITEMS.register("miku_plush_deep_sea_girl",
            ()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_DEEP_SEA_GIRL.get()));
    public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_LUCARIO_Z = ITEMS.register("miku_plush_lucario_z",
            ()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_LUCARIO_Z.get()));
    public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_PPPP = ITEMS.register("teto_plush_pppp",
            ()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_PPPP.get()));
    public static final DeferredItem<TetoPickaxeItem> TETO_PICKAXE_PPPP = ITEMS.register("teto_pickaxe_pppp", () ->
            new TetoPickaxeItem(PLUSH_TIER, new Item.Properties().attributes(TetoPickaxeItem.createAttributes(PLUSH_TIER, 0, -2.8f))));
    public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_PPPP = ITEMS.register("miku_plush_pppp",
            ()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_PPPP.get()));
    public static final DeferredItem<MikuPlushieBlockItem> TETO_PLUSH_SHRIMP = ITEMS.register("teto_plush_shrimp",
            ()->new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_SHRIMP.get()));
    public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_LINK = ITEMS.register("miku_plush_link",
            ()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_LINK.get()));
    public static final DeferredItem<MikuPlushieBlockItem> MIKU_PLUSH_RENAISSANCE = ITEMS.register("miku_plush_renaissance",
            ()->new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_RENAISSANCE.get()));
    public static final DeferredItem<MikuPlushieBlockItem> KAITO_PLUSH = ITEMS.register("kaito_plush",
            ()->new MikuPlushieBlockItem(ModBlocks.KAITO_PLUSH.get()));
    public static final DeferredItem<MikuPlushieBlockItem> KAITO_PLUSH_V3 = ITEMS.register("kaito_plush_v3",
            ()->new MikuPlushieBlockItem(ModBlocks.KAITO_PLUSH_V3.get()));
    public static final DeferredItem<MikuPlushieBlockItem> KAITO_PLUSH_V4 = ITEMS.register("kaito_plush_v4",
            ()->new MikuPlushieBlockItem(ModBlocks.KAITO_PLUSH_V4.get()));


	public static final DeferredHolder<CreativeModeTab,CreativeModeTab> MAIN_TAB = CREATIVE_TABS.register("main_tab",
			()-> CreativeModeTab.builder()
					.title(Component.translatable("item.group.miku_plushies"))
					.icon(MIKU_PLUSH_SENBONZAKURA.get()::getDefaultInstance)
					.displayItems((params,output)->{
						ITEMS.getEntries().stream().map(Holder::value).map(Item::getDefaultInstance).forEach(output::accept);
					})
					.build());
}
