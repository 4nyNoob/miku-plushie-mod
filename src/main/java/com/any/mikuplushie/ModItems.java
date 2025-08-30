package com.any.mikuplushie;

import com.any.mikuplushie.item.MikuPlushieBlockItem;
import com.any.mikuplushie.item.ModFoodComponents;
import com.any.mikuplushie.item.PlushToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

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
	public static final Item MIKU_PLUSH_BR =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR, new Item.Settings()), "miku_plush_br");
	public static final Item MIKU_PLUSH_BR_BA =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BA, new Item.Settings()), "miku_plush_br_ba");
	public static final Item MIKU_PLUSH_BIK =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BIK, new Item.Settings()), "miku_plush_bik");
	public static final Item MIKU_PLUSH_BR_BEACH =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BEACH, new Item.Settings()), "miku_plush_br_beach");
	public static final Item MIKU_PLUSH_BR_BRAID =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BRAID, new Item.Settings()), "miku_plush_br_braid");
	public static final Item MIKU_PLUSH_BR_BA_DRUM =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BA_DRUM, new Item.Settings()), "miku_plush_br_ba_drum");
	public static final Item MIKU_PLUSH_BR_PA =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_PA, new Item.Settings()), "miku_plush_br_pa");
	public static final Item MIKU_PLUSH_BR_SP =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_SP, new Item.Settings()), "miku_plush_br_sp");
	public static final Item MIKU_PLUSH_BR_MG =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_MG, new Item.Settings()), "miku_plush_br_mg");
	public static final Item MIKU_PLUSH_BR_BROWN_BRO =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BROWN_BRO, new Item.Settings()), "miku_plush_br_brown_bro");
	public static final Item MIKU_PLUSH_BR_ELECTRICIAN =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN, new Item.Settings()), "miku_plush_br_electrician");
	public static final Item MIKU_PLUSH_BR_BIK_ORANGE =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE, new Item.Settings()), "miku_plush_br_bik_orange");
	public static final Item MIKU_PLUSH_BR_AM =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_AM, new Item.Settings()), "miku_plush_br_am");
	public static final Item MIKU_PLUSH_BR_FUT_FLA =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_FUT_FLA, new Item.Settings()), "miku_plush_br_fut_fla");
	public static final Item MIKU_PLUSH_BR_FUT_CAM =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_FUT_CAM, new Item.Settings()), "miku_plush_br_fut_cam");
	public static final Item MIKU_PLUSH_BR_GO =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_GO, new Item.Settings()), "miku_plush_br_go");
	public static final Item MIKU_PLUSH_BR_SCHOOL_PE =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE, new Item.Settings()), "miku_plush_br_school_pe");
	public static final Item MIKU_PLUSH_BR_FUT_CRVG =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_FUT_CRVG, new Item.Settings()), "miku_plush_br_fut_crvg");
	public static final Item MIKU_PLUSH_BR_RS =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_RS, new Item.Settings()), "miku_plush_br_rs");
	public static final Item MIKU_PLUSH_FROG =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_FROG, new Item.Settings()), "miku_plush_frog");
	public static final Item MIKU_PLUSH_MUSHROOM =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MUSHROOM, new Item.Settings()), "miku_plush_mushroom");
	public static final Item MIKU_PLUSH_SENBONZAKURA =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_SENBONZAKURA, new Item.Settings()), "miku_plush_senbonzakura");
	public static final Item MIKU_PLUSH_URAOTOMELOVERS =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_URAOTOMELOVERS, new Item.Settings()), "miku_plush_uraotomelovers");
	public static final Item MIKU_PLUSH_PERSONADANCING =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_PERSONADANCING, new Item.Settings()), "miku_plush_personadancing");
	public static final Item MIKU_PLUSH_HELLOPLANET =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_HELLOPLANET, new Item.Settings()), "miku_plush_helloplanet");
	public static final Item MIKU_PLUSH_HACHUNE =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_HACHUNE, new Item.Settings()), "miku_plush_hachune");
	public static final Item MIKU_PLUSH_ZATSUNE =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_ZATSUNE, new Item.Settings()), "miku_plush_zatsune");
	public static final Item MIKU_PLUSH_INFINITY =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_INFINITY, new Item.Settings()), "miku_plush_infinity");
	public static final Item MIKU_PLUSH_VAMPIRE =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_VAMPIRE, new Item.Settings()), "miku_plush_vampire");
	public static final Item MIKU_PLUSH_WEREWOMAN =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_WEREWOMAN, new Item.Settings()), "miku_plush_werewoman");
	public static final Item MIKU_PLUSH_JASON =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_JASON, new Item.Settings()), "miku_plush_jason");
	public static final Item MIKU_PLUSH_MICHAEL_MYERS =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MICHAEL_MYERS, new Item.Settings()), "miku_plush_michael_myers");
	public static final Item MIKU_PLUSH_PUMPKIN =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_PUMPKIN, new Item.Settings()), "miku_plush_pumpkin");
	public static final Item MIKU_PLUSH_GHOSTFACE =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_GHOSTFACE, new Item.Settings()), "miku_plush_ghostface");
	public static final Item MIKU_PLUSH_FRANKENSTEIN =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_FRANKENSTEIN, new Item.Settings()), "miku_plush_frankenstein");
	public static final Item MIKU_PLUSH_MUMMY =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MUMMY, new Item.Settings()), "miku_plush_mummy");
	public static final Item MIKU_PLUSH_GHOST =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_GHOST, new Item.Settings()), "miku_plush_ghost");
	public static final Item MIKU_PLUSH_PATATI =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_PATATI, new Item.Settings()), "miku_plush_patati");
	public static final Item MIKU_PLUSH_PATATA =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_PATATA, new Item.Settings()), "miku_plush_patata");
	public static final Item MIKU_PLUSH_DEVIL =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_DEVIL, new Item.Settings()), "miku_plush_devil");
	public static final Item MIKU_PLUSH_WITCH =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_WITCH, new Item.Settings()), "miku_plush_witch");
	public static final Item MIKU_PLUSH_SANTA =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_SANTA, new Item.Settings()), "miku_plush_santa");
	public static final Item MIKU_PLUSH_REINDEER =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_REINDEER, new Item.Settings()), "miku_plush_reindeer");
	public static final Item MIKU_PLUSH_SANTA_ELF =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_SANTA_ELF, new Item.Settings()), "miku_plush_santa_elf");
	public static final Item MIKU_PLUSH_XMAS_TREE =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_XMAS_TREE, new Item.Settings()), "miku_plush_xmas_tree");
	public static final Item AIKO_PLUSH =
			register(new MikuPlushieBlockItem(ModBlocks.AIKO_PLUSH, new Item.Settings()), "aiko_plush");
	public static final Item TETO_PLUSH =
			register(new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH, new Item.Settings()), "teto_plush");
	public static final Item TETO_PICKAXE =
			register(new PickaxeItem(PlushToolMaterial.INSTANCE, 1, -2.8f, new FabricItemSettings()), "teto_pickaxe");
	public static final Item AKITA_NERU_PLUSH =
			register(new MikuPlushieBlockItem(ModBlocks.AKITA_NERU_PLUSH, new Item.Settings()), "akita_neru_plush");
	public static final Item MIKU_PLUSH =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH, new Item.Settings()), "miku_plush");
	public static final Item RIN_PLUSH =
			register(new MikuPlushieBlockItem(ModBlocks.RIN_PLUSH, new Item.Settings()), "rin_plush");
	public static final Item LEN_PLUSH =
			register(new MikuPlushieBlockItem(ModBlocks.LEN_PLUSH, new Item.Settings()), "len_plush");
	public static final Item MIKU_PLUSH_SONIC_CROSSWORLDS =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS, new Item.Settings()), "miku_plush_sonic_crossworlds");
	public static final Item MIKU_PLUSH_FORTNITE_NEKO =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_FORTNITE_NEKO, new Item.Settings()), "miku_plush_fortnite_neko");
	public static final Item MIKU_PLUSH_V4 =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_V4, new Item.Settings()), "miku_plush_v4");
	public static final Item MIKU_PLUSH_MESMERIZER =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MESMERIZER, new Item.Settings()), "miku_plush_mesmerizer");
	public static final Item TETO_PLUSH_MESMERIZER =
			register(new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_MESMERIZER, new Item.Settings()), "teto_plush_mesmerizer");
	public static final Item TETO_PICKAXE_MESMERIZER =
		register(new PickaxeItem(PlushToolMaterial.INSTANCE, 1, -2.8f, new FabricItemSettings()), "teto_pickaxe_mesmerizer");
	public static final Item MIKU_PLUSH_SONIC =
			register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_SONIC, new Item.Settings()), "miku_plush_sonic");
	public static final Item TETO_PLUSH_SHADOW =
			register(new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_SHADOW, new Item.Settings()), "teto_plush_shadow");
	public static final Item AKITA_NERU_PLUSH_TAILS =
			register(new MikuPlushieBlockItem(ModBlocks.AKITA_NERU_PLUSH_TAILS, new Item.Settings()), "akita_neru_plush_tails");
	public static final Item TETO_PLUSH_BIRDBRAIN =
			register(new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_BIRDBRAIN, new Item.Settings()), "teto_plush_birdbrain");
	public static final Item TETO_PICKAXE_BIRDBRAIN =
		register(new PickaxeItem(PlushToolMaterial.INSTANCE, 1, -2.8f, new FabricItemSettings()), "teto_pickaxe_birdbrain");
	public static final Item MIKU_PLUSH_DIGITAL_STARS_2025 =
		register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025, new Item.Settings()), "miku_plush_digital_stars_2025");
	public static final Item MIKU_PLUSH_ROTTEN_GIRL =
		register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_ROTTEN_GIRL, new Item.Settings()), "miku_plush_rotten_girl");
	public static final Item TETO_PLUSH_REGRET_ROCK =
		register(new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_REGRET_ROCK, new Item.Settings()), "teto_plush_regret_rock");
	public static final Item TETO_PICKAXE_REGRET_ROCK =
		register(new PickaxeItem(PlushToolMaterial.INSTANCE, 1, -2.8f, new FabricItemSettings()), "teto_pickaxe_regret_rock");
	public static final Item MIKU_PLUSH_PSYCHO_MODE =
		register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_PSYCHO_MODE, new Item.Settings()), "miku_plush_psycho_mode");
	public static final Item MIKU_PLUSH_DONT_BELIEVE_IN_T =
		register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T, new Item.Settings()), "miku_plush_dont_believe_in_t");
	public static final Item TETO_PLUSH_DONT_BELIEVE_IN_T =
		register(new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T, new Item.Settings()), "teto_plush_dont_believe_in_t");
	public static final Item TETO_PICKAXE_DONT_BELIEVE_IN_T =
		register(new PickaxeItem(PlushToolMaterial.INSTANCE, 1, -2.8f, new FabricItemSettings()), "teto_pickaxe_dont_believe_in_t");
	public static final Item TETO_PLUSH_LIAR_DANCER =
		register(new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_LIAR_DANCER, new Item.Settings()), "teto_plush_liar_dancer");
	public static final Item TETO_PICKAXE_LIAR_DANCER =
		register(new PickaxeItem(PlushToolMaterial.INSTANCE, 1, -2.8f, new FabricItemSettings()), "teto_pickaxe_liar_dancer");
	public static final Item MIKU_PLUSH_STATIC =
		register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_STATIC, new Item.Settings()), "miku_plush_static");
	public static final Item MIKU_PLUSH_MOCHIMOCHI =
		register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MOCHIMOCHI, new Item.Settings()), "miku_plush_mochimochi");
	public static final Item TETO_PLUSH_WHATCHACALLITSNAME =
		register(new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME, new Item.Settings()), "teto_plush_whatchacallitsname");
	public static final Item TETO_PICKAXE_WHATCHACALLITSNAME =
		register(new PickaxeItem(PlushToolMaterial.INSTANCE, 1, -2.8f, new FabricItemSettings()), "teto_pickaxe_whatchacallitsname");
	public static final Item MIKU_PLUSH_MONITORING =
		register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_MONITORING, new Item.Settings()), "miku_plush_monitoring");
    public static final Item KONOHA_PLUSH =
        register(new MikuPlushieBlockItem(ModBlocks.KONOHA_PLUSH, new Item.Settings()), "konoha_plush");
    public static final Item LUKA_PLUSH =
        register(new MikuPlushieBlockItem(ModBlocks.LUKA_PLUSH, new Item.Settings()), "luka_plush");
    public static final Item TETO_PLUSH_SOME_MORE_OF_THAT_SONG =
        register(new MikuPlushieBlockItem(ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG, new Item.Settings()), "teto_plush_some_more_of_that_song");
    public static final Item TETO_PICKAXE_SOME_MORE_OF_THAT_SONG =
        register(new PickaxeItem(PlushToolMaterial.INSTANCE, 1, -2.8f, new FabricItemSettings()), "teto_pickaxe_some_more_of_that_song");




	public static Item register(Item item, String id) {
		// Create the identifier for the item.
		Identifier itemID = Identifier.of(MikuPlushie.MOD_ID, id);

		// Register the item.
		Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

		// Return the registered item!
		return registeredItem;
	}



	public static void initialize() {

		Registry.register(Registries.ITEM_GROUP, MIKU_GROUP_KEY, MIKU_GROUP);

		ItemGroupEvents.modifyEntriesEvent(MIKU_GROUP_KEY).register(itemGroup -> {
			itemGroup.add(ModItems.CANUDINHO);
			itemGroup.add(ModItems.BAGUETTE);

			itemGroup.add(ModItems.MIKU_PLUSH_BR);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_BA);
			itemGroup.add(ModItems.MIKU_PLUSH_BIK);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_BEACH);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_BRAID);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_BA_DRUM);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_PA);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_SP);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_MG);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_BROWN_BRO);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_ELECTRICIAN);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_BIK_ORANGE);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_AM);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_FUT_FLA);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_FUT_CAM);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_FUT_CRVG);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_GO);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_SCHOOL_PE);
			itemGroup.add(ModItems.MIKU_PLUSH_BR_RS);
			itemGroup.add(ModItems.MIKU_PLUSH_FROG);
			itemGroup.add(ModItems.MIKU_PLUSH_MUSHROOM);
			itemGroup.add(ModItems.MIKU_PLUSH_SENBONZAKURA);
			itemGroup.add(ModItems.MIKU_PLUSH_URAOTOMELOVERS);
			itemGroup.add(ModItems.MIKU_PLUSH_PERSONADANCING);
			itemGroup.add(ModItems.MIKU_PLUSH_HELLOPLANET);
			itemGroup.add(ModItems.MIKU_PLUSH_HACHUNE);
			itemGroup.add(ModItems.MIKU_PLUSH_ZATSUNE);
			itemGroup.add(ModItems.MIKU_PLUSH_INFINITY);
			itemGroup.add(ModItems.MIKU_PLUSH_VAMPIRE);
			itemGroup.add(ModItems.MIKU_PLUSH_WEREWOMAN);
			itemGroup.add(ModItems.MIKU_PLUSH_JASON);
			itemGroup.add(ModItems.MIKU_PLUSH_MICHAEL_MYERS);
			itemGroup.add(ModItems.MIKU_PLUSH_PUMPKIN);
			itemGroup.add(ModItems.MIKU_PLUSH_GHOSTFACE);
			itemGroup.add(ModItems.MIKU_PLUSH_FRANKENSTEIN);
			itemGroup.add(ModItems.MIKU_PLUSH_MUMMY);
			itemGroup.add(ModItems.MIKU_PLUSH_GHOST);
			itemGroup.add(ModItems.MIKU_PLUSH_PATATI);
			itemGroup.add(ModItems.MIKU_PLUSH_PATATA);
			itemGroup.add(ModItems.MIKU_PLUSH_DEVIL);
			itemGroup.add(ModItems.MIKU_PLUSH_WITCH);
			itemGroup.add(ModItems.MIKU_PLUSH_SANTA);
			itemGroup.add(ModItems.MIKU_PLUSH_REINDEER);
			itemGroup.add(ModItems.MIKU_PLUSH_SANTA_ELF);
			itemGroup.add(ModItems.MIKU_PLUSH_XMAS_TREE);
			itemGroup.add(ModItems.AIKO_PLUSH);
			itemGroup.add(ModItems.TETO_PLUSH);
			itemGroup.add(ModItems.TETO_PICKAXE);
			itemGroup.add(ModItems.AKITA_NERU_PLUSH);
			itemGroup.add(ModItems.MIKU_PLUSH);
			itemGroup.add(ModItems.RIN_PLUSH);
			itemGroup.add(ModItems.LEN_PLUSH);
			itemGroup.add(ModItems.MIKU_PLUSH_SONIC_CROSSWORLDS);
			itemGroup.add(ModItems.MIKU_PLUSH_FORTNITE_NEKO);
			itemGroup.add(ModItems.MIKU_PLUSH_V4);
			itemGroup.add(ModItems.MIKU_PLUSH_MESMERIZER);
			itemGroup.add(ModItems.TETO_PLUSH_MESMERIZER);
			itemGroup.add(ModItems.TETO_PICKAXE_MESMERIZER);
			itemGroup.add(ModItems.MIKU_PLUSH_SONIC);
			itemGroup.add(ModItems.TETO_PLUSH_SHADOW);
			itemGroup.add(ModItems.AKITA_NERU_PLUSH_TAILS);
			itemGroup.add(ModItems.TETO_PLUSH_BIRDBRAIN);
			itemGroup.add(ModItems.TETO_PICKAXE_BIRDBRAIN);
			itemGroup.add(ModItems.MIKU_PLUSH_DIGITAL_STARS_2025);
			itemGroup.add(ModItems.MIKU_PLUSH_ROTTEN_GIRL);
			itemGroup.add(ModItems.TETO_PLUSH_REGRET_ROCK);
			itemGroup.add(ModItems.TETO_PICKAXE_REGRET_ROCK);
			itemGroup.add(ModItems.MIKU_PLUSH_PSYCHO_MODE);
			itemGroup.add(ModItems.MIKU_PLUSH_DONT_BELIEVE_IN_T);
			itemGroup.add(ModItems.TETO_PLUSH_DONT_BELIEVE_IN_T);
			itemGroup.add(ModItems.TETO_PICKAXE_DONT_BELIEVE_IN_T);
			itemGroup.add(ModItems.TETO_PLUSH_LIAR_DANCER);
			itemGroup.add(ModItems.TETO_PICKAXE_LIAR_DANCER);
			itemGroup.add(ModItems.MIKU_PLUSH_STATIC);
			itemGroup.add(ModItems.MIKU_PLUSH_MOCHIMOCHI);
			itemGroup.add(ModItems.TETO_PLUSH_WHATCHACALLITSNAME);
			itemGroup.add(ModItems.TETO_PICKAXE_WHATCHACALLITSNAME);
			itemGroup.add(ModItems.MIKU_PLUSH_MONITORING);
			itemGroup.add(ModItems.KONOHA_PLUSH);
			itemGroup.add(ModItems.LUKA_PLUSH);
            itemGroup.add(ModItems.TETO_PLUSH_SOME_MORE_OF_THAT_SONG);
            itemGroup.add(ModItems.TETO_PICKAXE_SOME_MORE_OF_THAT_SONG);
		});
	}
}
