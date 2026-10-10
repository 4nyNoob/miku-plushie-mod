package com.any.miku_plushie.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushieFabric;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.impl.common.registry.ModItems;
import com.any.miku_plushie.impl.common.item.MikuPlushieBlockItem;
import com.any.miku_plushie.impl.common.item.PlushToolMaterial;
import com.any.miku_plushie.impl.common.util.ModUtil;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;

public class ModItemsFabric {

  //REGISTER PLUSH ITEMS
  public static Item registerPlush(String name) {
    Block plushBlock = null;
    for (int block = 0; block < ModBlocks.PLUSH_BLOCKS.size(); block++) {
      //MATCH ITEM TO THE RIGHT BLOCK
      Block registeredPlushBlock = ModBlocks.PLUSH_BLOCKS.get(block);
      if (ModUtil.getBlockIdFromBlock(registeredPlushBlock).matches(name)) {
        plushBlock = registeredPlushBlock;
      }
    }
    return register(new MikuPlushieBlockItem(plushBlock, new Item.Properties()), name);
  }

  //REGISTER PICKAXES HELPER
  public static Item registerPickaxe(String name) {
    return register(new PickaxeItem(PlushToolMaterial.PLUSH_TOOL_MATERIAL, new Item.Properties().attributes(PickaxeItem.createAttributes(PlushToolMaterial.PLUSH_TOOL_MATERIAL, 1f, -2.8F))), name);
  }

  //REGISTER NORMAL ITEM
  public static Item register(Item item, String id) {
    ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id);
    Item register = Registry.register(BuiltInRegistries.ITEM, itemID, item);
    String itemName = ModUtil.getBlockIdFromItem(item);

    //ADD TETO PICKAXES TO THE PICKAXES LIST
    if (itemName.contains("pickaxe")) {
      ModItems.PICKAXE_ITEMS.add(item);
    }
    //ADD REGULAR ITEMS TOO
    else if (!itemName.contains("plush")) {
      ModItems.REGULAR_ITEMS.add(item);
    }

    return register;
  }

  public static void initialize() {
    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " Items");

    ModItems.CANUDINHO = register(new Item(new Item.Properties().rarity(Rarity.RARE)), "canudinho");
    ModItems.BAGUETTE = register(new Item(new Item.Properties().food(com.any.miku_plushie.impl.common.registry.ModFoods.BAGUETTE)), "baguette");
    ModItems.LEEK_SEEDS = register(new ItemNameBlockItem(ModBlocks.LEEK_CROP, new Item.Properties()), "leek_seeds");
    ModItems.LEEK = register(new Item(new Item.Properties().food(com.any.miku_plushie.impl.common.registry.ModFoods.LEEK)), "leek");
    ModItems.AKITA_NERU_PHONE = register(new Item(new Item.Properties()), "akita_neru_phone");
    ModItems.VOCALOID_HEART = register(new Item(new Item.Properties()), "vocaloid_heart");

    ModItems.TETO_PICKAXE = registerPickaxe("teto_pickaxe");
    ModItems.TETO_PICKAXE_MESMERIZER = registerPickaxe("teto_pickaxe_mesmerizer");
    ModItems.TETO_PICKAXE_BIRDBRAIN = registerPickaxe("teto_pickaxe_birdbrain");
    ModItems.TETO_PICKAXE_REGRET_ROCK = registerPickaxe("teto_pickaxe_regret_rock");
    ModItems.TETO_PICKAXE_DONT_BELIEVE_IN_T = registerPickaxe("teto_pickaxe_dont_believe_in_t");
    ModItems.TETO_PICKAXE_LIAR_DANCER = registerPickaxe("teto_pickaxe_liar_dancer");
    ModItems.TETO_PICKAXE_WHATCHACALLITSNAME = registerPickaxe("teto_pickaxe_whatchacallitsname");
    ModItems.TETO_PICKAXE_SOME_MORE_OF_THAT_SONG = registerPickaxe("teto_pickaxe_some_more_of_that_song");
    ModItems.TETO_PICKAXE_SYNTHV = registerPickaxe("teto_pickaxe_synthv");
    ModItems.TETO_PICKAXE_SPOKEN_FOR = registerPickaxe("teto_pickaxe_spoken_for");
    ModItems.TETO_PICKAXE_PPPP = registerPickaxe("teto_pickaxe_pppp");

    //CREATE A ITEM FOR EVERY PLUSH BLOCK
    for (Block plushblock : ModBlocks.PLUSH_BLOCKS) {
      Item plushItem = registerPlush(ModUtil.getBlockIdFromBlock(plushblock));
      ModItems.PLUSH_ITEMS.add(plushItem);
    }
  }
}
