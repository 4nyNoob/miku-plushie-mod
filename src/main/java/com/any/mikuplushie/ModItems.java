package com.any.mikuplushie;

import com.any.mikuplushie.item.MikuPlushieBlockItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

	public static final Item CANUDINHO = register(new Item(new Item.Settings().rarity(Rarity.RARE)), "canudinho");
	public static final Item MIKU_PLUSH_BR = register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BLOCK,
			new Item.Settings().equipmentSlot((entity, stack) -> EquipmentSlot.HEAD)), "miku_plush_br");
	public static final Item MIKU_PLUSH_BR_BA = register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BA_BLOCK,
			new Item.Settings().equipmentSlot((entity, stack) -> EquipmentSlot.HEAD)), "miku_plush_br_ba");
	public static final Item MIKU_PLUSH_BIK = register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BIK_BLOCK,
			new Item.Settings().equipmentSlot((entity, stack) -> EquipmentSlot.HEAD)), "miku_plush_bik");
	public static final Item MIKU_PLUSH_BR_BEACH = register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BEACH_BLOCK,
			new Item.Settings().equipmentSlot((entity, stack) -> EquipmentSlot.HEAD)), "miku_plush_br_beach");
	public static final Item MIKU_PLUSH_BR_BRAID = register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BRAID_BLOCK,
			new Item.Settings().equipmentSlot((entity, stack) -> EquipmentSlot.HEAD)), "miku_plush_br_braid");
	public static final Item MIKU_PLUSH_BR_BA_DRUM = register(new MikuPlushieBlockItem(ModBlocks.MIKU_PLUSH_BR_BA_DRUM_BLOCK,
			new Item.Settings().equipmentSlot((entity, stack) -> EquipmentSlot.HEAD)), "miku_plush_br_ba_drum");




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



		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(ModItems.CANUDINHO));

	}
}
