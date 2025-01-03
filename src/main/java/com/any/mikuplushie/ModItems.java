package com.any.mikuplushie;

import com.any.mikuplushie.item.MikuPlushieBlockItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

	public static final Item CANUDINHO =
			register(new Item(new Item.Settings().rarity(Rarity.RARE)), "canudinho");
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



	public static Item register(Item item, String id) {
		// Create the identifier for the item.
		Identifier itemID = Identifier.of(MikuPlushie.MOD_ID, id);

		// Register the item.
		Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

		// Return the registered item!
		return registeredItem;
	}



	public static void initialize() {

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_BA));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BIK));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_BEACH));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_BRAID));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_BA_DRUM));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_PA));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_SP));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_MG));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_BROWN_BRO));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_ELECTRICIAN));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_BIK_ORANGE));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_AM));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_FUT_FLA));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_FUT_CAM));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_FUT_CRVG));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_GO));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_SCHOOL_PE));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_BR_RS));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_FROG));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_MUSHROOM));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_SENBONZAKURA));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_URAOTOMELOVERS));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_PERSONADANCING));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_HELLOPLANET));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_HACHUNE));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_ZATSUNE));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_INFINITY));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_VAMPIRE));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_WEREWOMAN));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_JASON));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_MICHAEL_MYERS));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_PUMPKIN));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_GHOSTFACE));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_FRANKENSTEIN));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_MUMMY));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_GHOST));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_PATATI));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_PATATA));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_DEVIL));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_WITCH));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_SANTA));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_REINDEER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_SANTA_ELF));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> itemGroup.add(ModItems.MIKU_PLUSH_XMAS_TREE));



		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(ModItems.CANUDINHO));

	}
}
