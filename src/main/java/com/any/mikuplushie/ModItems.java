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

    //CREATE ITEM GROUP
	public static final RegistryKey<ItemGroup> MIKU_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
		new Identifier(MikuPlushie.MOD_ID, "item_group")
	);
	public static final ItemGroup MIKU_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(ModBlocks.MIKU_PLUSH))
		.displayName(Text.translatable("item.group.miku_plushies"))
		.build();

    //REGULAR ITEMS
	public static final Item CANUDINHO =
        register(new Item(new Item.Settings().rarity(Rarity.RARE)), "canudinho");
	public static final Item BAGUETTE =
        register(new Item(new Item.Settings().food(ModFoodComponents.BAGUETTE)), "baguette");

    //TETO PICKAXE ITEMS
    public static final Item TETO_PICKAXE = registerPickaxe("teto_pickaxe");
    public static final Item TETO_PICKAXE_MESMERIZER = registerPickaxe("teto_pickaxe_mesmerizer");
    public static final Item TETO_PICKAXE_BIRDBRAIN = registerPickaxe("teto_pickaxe_birdbrain");
    public static final Item TETO_PICKAXE_REGRET_ROCK = registerPickaxe("teto_pickaxe_regret_rock");
    public static final Item TETO_PICKAXE_DONT_BELIEVE_IN_T = registerPickaxe("teto_pickaxe_dont_believe_in_t");
    public static final Item TETO_PICKAXE_LIAR_DANCER = registerPickaxe("teto_pickaxe_liar_dancer");
    public static final Item TETO_PICKAXE_WHATCHACALLITSNAME = registerPickaxe("teto_pickaxe_whatchacallitsname");
    public static final Item TETO_PICKAXE_SOME_MORE_OF_THAT_SONG = registerPickaxe("teto_pickaxe_some_more_of_that_song");
    public static final Item TETO_PICKAXE_SYNTHV = registerPickaxe("teto_pickaxe_synthv");
    public static final Item TETO_PICKAXE_SPOKEN_FOR = registerPickaxe("teto_pickaxe_spoken_for");

    //LEEK CROP ITEMS
    public static final Item LEEK_SEEDS =
        register(new AliasedBlockItem(ModBlocks.LEEK_CROP, new Item.Settings()), "leek_seeds");
    public static final Item LEEK =
        register(new Item(new Item.Settings().food(ModFoodComponents.LEEK)), "leek");

    //REGISTER PLUSH ITEMS
    public static Item registerPlush(String name) {
        Block plushBlock = null;
        for (int block = 0; block < ModBlocks.PLUSH_BLOCKS.size(); block++) {
            //MATCH ITEM TO THE RIGHT BLOCK
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

        //ADD TETO PICKAXES TO THE PICKAXES LIST
        if (item instanceof PickaxeItem){
            PICKAXE_ITEMS.add(item);
        }

        return register;
	}


	public static void initialize() {
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Items");

        //REGISTER ITEM GROUP
		Registry.register(Registries.ITEM_GROUP, MIKU_GROUP_KEY, MIKU_GROUP);

        //CREATE A ITEM FOR EVERY PLUSH BLOCK
        for (Block plushblock : ModBlocks.PLUSH_BLOCKS) {
            Item plushItem = registerPlush(plushblock.getTranslationKey().split("[.]")[2]);
            PLUSH_ITEMS.add(plushItem);
        }

        //POPULATE ITEM GROUP
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
