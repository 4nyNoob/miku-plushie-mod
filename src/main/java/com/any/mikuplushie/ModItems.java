package com.any.mikuplushie;

import com.any.mikuplushie.datagen.ModItemTagProvider;
import com.any.mikuplushie.item.MikuPlushieBlockItem;
import com.any.mikuplushie.item.ModFoodComponents;
import com.any.mikuplushie.item.PlushToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModItems {

    public static List<Item> PLUSH_ITEMS = new ArrayList<>();
    public static List<Item> PICKAXE_ITEMS = new ArrayList<>();

	public static final RegistryKey<ItemGroup> MIKU_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
		new Identifier(MikuPlushie.MOD_ID, "item_group")
	);
	public static final ItemGroup MIKU_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(ModItems.MIKU_PLUSH))
		.displayName(Text.translatable("item.group.miku_plushies"))
		.build();


	public static final Item CANUDINHO =
        register(new Item(new Item.Settings().rarity(Rarity.RARE)), "canudinho");
	public static final Item BAGUETTE =
        register(new Item(new Item.Settings().food(ModFoodComponents.BAGUETTE)), "baguette");



	public static final Item MIKU_PLUSH_BR = registerPlush("miku_plush_br");
	public static final Item MIKU_PLUSH_BR_BA = registerPlush("miku_plush_br_ba");
	public static final Item MIKU_PLUSH_BIK = registerPlush("miku_plush_bik");
	public static final Item MIKU_PLUSH_BR_BEACH = registerPlush("miku_plush_br_beach");
	public static final Item MIKU_PLUSH_BR_BRAID = registerPlush("miku_plush_br_braid");
	public static final Item MIKU_PLUSH_BR_BA_DRUM = registerPlush("miku_plush_br_ba_drum");
	public static final Item MIKU_PLUSH_BR_PA = registerPlush("miku_plush_br_pa");
	public static final Item MIKU_PLUSH_BR_SP = registerPlush("miku_plush_br_sp");
	public static final Item MIKU_PLUSH_BR_MG = registerPlush("miku_plush_br_mg");
	public static final Item MIKU_PLUSH_BR_BROWN_BRO = registerPlush("miku_plush_br_brown_bro");
	public static final Item MIKU_PLUSH_BR_ELECTRICIAN = registerPlush("miku_plush_br_electrician");
	public static final Item MIKU_PLUSH_BR_BIK_ORANGE = registerPlush("miku_plush_br_bik_orange");
	public static final Item MIKU_PLUSH_BR_AM = registerPlush("miku_plush_br_am");
	public static final Item MIKU_PLUSH_BR_FUT_FLA = registerPlush("miku_plush_br_fut_fla");
	public static final Item MIKU_PLUSH_BR_FUT_CAM = registerPlush("miku_plush_br_fut_cam");
	public static final Item MIKU_PLUSH_BR_GO = registerPlush("miku_plush_br_go");
	public static final Item MIKU_PLUSH_BR_SCHOOL_PE = registerPlush("miku_plush_br_school_pe");
	public static final Item MIKU_PLUSH_BR_FUT_CRVG = registerPlush("miku_plush_br_fut_crvg");
	public static final Item MIKU_PLUSH_BR_RS = registerPlush("miku_plush_br_rs");
	public static final Item MIKU_PLUSH_FROG = registerPlush("miku_plush_frog");
	public static final Item MIKU_PLUSH_MUSHROOM = registerPlush("miku_plush_mushroom");
	public static final Item MIKU_PLUSH_SENBONZAKURA = registerPlush("miku_plush_senbonzakura");
	public static final Item MIKU_PLUSH_URAOTOMELOVERS = registerPlush("miku_plush_uraotomelovers");
	public static final Item MIKU_PLUSH_PERSONADANCING = registerPlush("miku_plush_personadancing");
	public static final Item MIKU_PLUSH_HELLOPLANET = registerPlush("miku_plush_helloplanet");
	public static final Item MIKU_PLUSH_HACHUNE = registerPlush("miku_plush_hachune");
	public static final Item MIKU_PLUSH_ZATSUNE = registerPlush("miku_plush_zatsune");
	public static final Item MIKU_PLUSH_INFINITY = registerPlush("miku_plush_infinity");
	public static final Item MIKU_PLUSH_VAMPIRE = registerPlush("miku_plush_vampire");
	public static final Item MIKU_PLUSH_WEREWOMAN = registerPlush("miku_plush_werewoman");
	public static final Item MIKU_PLUSH_JASON = registerPlush("miku_plush_jason");
	public static final Item MIKU_PLUSH_MICHAEL_MYERS = registerPlush("miku_plush_michael_myers");
	public static final Item MIKU_PLUSH_PUMPKIN = registerPlush("miku_plush_pumpkin");
	public static final Item MIKU_PLUSH_GHOSTFACE = registerPlush("miku_plush_ghostface");
	public static final Item MIKU_PLUSH_FRANKENSTEIN = registerPlush("miku_plush_frankenstein");
	public static final Item MIKU_PLUSH_MUMMY = registerPlush("miku_plush_mummy");
	public static final Item MIKU_PLUSH_GHOST = registerPlush("miku_plush_ghost");
	public static final Item MIKU_PLUSH_PATATI = registerPlush("miku_plush_patati");
	public static final Item MIKU_PLUSH_PATATA = registerPlush("miku_plush_patata");
	public static final Item MIKU_PLUSH_DEVIL = registerPlush("miku_plush_devil");
	public static final Item MIKU_PLUSH_WITCH = registerPlush("miku_plush_witch");
	public static final Item MIKU_PLUSH_SANTA = registerPlush("miku_plush_santa");
	public static final Item MIKU_PLUSH_REINDEER = registerPlush("miku_plush_reindeer");
	public static final Item MIKU_PLUSH_SANTA_ELF = registerPlush("miku_plush_santa_elf");
	public static final Item MIKU_PLUSH_XMAS_TREE = registerPlush("miku_plush_xmas_tree");
	public static final Item AIKO_PLUSH = registerPlush("aiko_plush");
	public static final Item TETO_PLUSH = registerPlush("teto_plush");
	public static final Item TETO_PICKAXE = registerPickaxe("teto_pickaxe");

	public static final Item AKITA_NERU_PLUSH = registerPlush("akita_neru_plush");
	public static final Item MIKU_PLUSH = registerPlush("miku_plush");
	public static final Item RIN_PLUSH = registerPlush("rin_plush");
	public static final Item LEN_PLUSH = registerPlush("len_plush");
	public static final Item MIKU_PLUSH_SONIC_CROSSWORLDS = registerPlush("miku_plush_sonic_crossworlds");
	public static final Item MIKU_PLUSH_FORTNITE_NEKO = registerPlush("miku_plush_fortnite_neko");
	public static final Item MIKU_PLUSH_V4 = registerPlush("miku_plush_v4");
	public static final Item MIKU_PLUSH_MESMERIZER = registerPlush("miku_plush_mesmerizer");
	public static final Item TETO_PLUSH_MESMERIZER = registerPlush("teto_plush_mesmerizer");
	public static final Item TETO_PICKAXE_MESMERIZER = registerPickaxe("teto_pickaxe_mesmerizer");

	public static final Item MIKU_PLUSH_SONIC = registerPlush("miku_plush_sonic");
	public static final Item TETO_PLUSH_SHADOW = registerPlush("teto_plush_shadow");
	public static final Item AKITA_NERU_PLUSH_TAILS = registerPlush("akita_neru_plush_tails");
	public static final Item TETO_PLUSH_BIRDBRAIN = registerPlush("teto_plush_birdbrain");
	public static final Item TETO_PICKAXE_BIRDBRAIN = registerPickaxe("teto_pickaxe_birdbrain");

	public static final Item MIKU_PLUSH_DIGITAL_STARS_2025 = registerPlush("miku_plush_digital_stars_2025");
	public static final Item MIKU_PLUSH_ROTTEN_GIRL = registerPlush("miku_plush_rotten_girl");
	public static final Item TETO_PLUSH_REGRET_ROCK = registerPlush("teto_plush_regret_rock");
	public static final Item TETO_PICKAXE_REGRET_ROCK = registerPickaxe("teto_pickaxe_regret_rock");

	public static final Item MIKU_PLUSH_PSYCHO_MODE = registerPlush("miku_plush_psycho_mode");
	public static final Item MIKU_PLUSH_DONT_BELIEVE_IN_T = registerPlush("miku_plush_dont_believe_in_t");
	public static final Item TETO_PLUSH_DONT_BELIEVE_IN_T = registerPlush("teto_plush_dont_believe_in_t");
	public static final Item TETO_PICKAXE_DONT_BELIEVE_IN_T = registerPickaxe("teto_pickaxe_dont_believe_in_t");

	public static final Item TETO_PLUSH_LIAR_DANCER = registerPlush("teto_plush_liar_dancer");
	public static final Item TETO_PICKAXE_LIAR_DANCER = registerPickaxe("teto_pickaxe_liar_dancer");

	public static final Item MIKU_PLUSH_STATIC = registerPlush("miku_plush_static");
	public static final Item MIKU_PLUSH_MOCHIMOCHI = registerPlush("miku_plush_mochimochi");
	public static final Item TETO_PLUSH_WHATCHACALLITSNAME = registerPlush("teto_plush_whatchacallitsname");
	public static final Item TETO_PICKAXE_WHATCHACALLITSNAME = registerPickaxe("teto_pickaxe_whatchacallitsname");

	public static final Item MIKU_PLUSH_MONITORING = registerPlush("miku_plush_monitoring");
    public static final Item KONOHA_PLUSH = registerPlush("konoha_plush");
    public static final Item LUKA_PLUSH = registerPlush("luka_plush");
    public static final Item TETO_PLUSH_SOME_MORE_OF_THAT_SONG = registerPlush("teto_plush_some_more_of_that_song");
    public static final Item TETO_PICKAXE_SOME_MORE_OF_THAT_SONG = registerPickaxe("teto_pickaxe_some_more_of_that_song");

    public static final Item TETO_PLUSH_LOBSTER = registerPlush("teto_plush_lobster");
    public static final Item MIKU_PLUSH_HOLLOW_KNIGHT = registerPlush("miku_plush_hollow_knight");
    public static final Item MIKU_PLUSH_HORNET = registerPlush("miku_plush_hornet");
    public static final Item TETO_PLUSH_SYNTHV = registerPlush("teto_plush_synthv");
    public static final Item TETO_PICKAXE_SYNTHV = registerPickaxe("teto_pickaxe_synthv");

    public static final Item MIKU_PLUSH_WORLD_IS_MINE = registerPlush("miku_plush_world_is_mine");
    public static final Item MIKU_PLUSH_ROLLING_GIRL = registerPlush("miku_plush_rolling_girl");
    public static final Item TETO_PLUSH_SPOKEN_FOR = registerPlush("teto_plush_spoken_for");
    public static final Item TETO_PICKAXE_SPOKEN_FOR = registerPickaxe("teto_pickaxe_spoken_for");

    public static final Item MEIKO_PLUSH = registerPlush("meiko_plush");
    public static final Item MEIKO_PLUSH_V3 = registerPlush("meiko_plush_v3");
    public static final Item MEIKO_PLUSH_V4 = registerPlush("meiko_plush_v4");
    public static final Item GUMI_PLUSH = registerPlush("gumi_plush");
    public static final Item GUMI_PLUSH_V3 = registerPlush("gumi_plush_v3");
    public static final Item GUMI_PLUSH_V4 = registerPlush("gumi_plush_v4");
    public static final Item GUMI_PLUSH_V6 = registerPlush("gumi_plush_v6");
    public static final Item MIKU_PLUSH_DEEP_SEA_GIRL = registerPlush("miku_plush_deep_sea_girl");
    public static final Item MIKU_PLUSH_LUCARIO_Z = registerPlush("miku_plush_lucario_z");



    public static final Item LEEK_SEEDS =
        register(new AliasedBlockItem(ModBlocks.LEEK_CROP, new Item.Settings()), "leek_seeds");
    public static final Item LEEK =
        register(new Item(new Item.Settings().food(ModFoodComponents.LEEK)), "leek");

    //REGISTER PLUSH ITEMS
    public static Item registerPlush(String name) {
        Block plushBlock = null;
        for (int block = 0; block < ModBlocks.PLUSH_BLOCKS.size(); block++) {
            if (ModBlocks.PLUSH_BLOCKS.get(block).getTranslationKey().split("[.]")[2].matches(name)){
                plushBlock = ModBlocks.PLUSH_BLOCKS.get(block);
            }
        }
        return register(new MikuPlushieBlockItem(plushBlock, new Item.Settings()), name);
    }

    //REGISTER PICKAXES
    public static Item registerPickaxe(String name) {
        return register(new PickaxeItem(PlushToolMaterial.PLUSH_TOOL_MATERIAL, 1, -2.8F, new Item.Settings()), name);
    }

    //REGISTER NORMAL ITEM
	public static Item register(Item item, String id) {
		Identifier itemID = Identifier.of(MikuPlushie.MOD_ID, id);
        Item register = Registry.register(Registries.ITEM, itemID, item);

        if (item instanceof MikuPlushieBlockItem){
            PLUSH_ITEMS.add(item.getDefaultStack().getItem());
        }
        if (item instanceof PickaxeItem){
            PICKAXE_ITEMS.add(item);
        }

        return register;
	}



	public static void initialize() {
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Items");

		Registry.register(Registries.ITEM_GROUP, MIKU_GROUP_KEY, MIKU_GROUP);

		ItemGroupEvents.modifyEntriesEvent(MIKU_GROUP_KEY).register(itemGroup -> {

			itemGroup.add(ModItems.CANUDINHO);
			itemGroup.add(ModItems.BAGUETTE);
			itemGroup.add(ModItems.LEEK_SEEDS);
			itemGroup.add(ModItems.LEEK);

            for (Item plushItem : PLUSH_ITEMS) {
                itemGroup.add(plushItem);
            }
            for (Item pickaxeItem : PICKAXE_ITEMS) {
                itemGroup.add(pickaxeItem);
            }

		});
	}
}
