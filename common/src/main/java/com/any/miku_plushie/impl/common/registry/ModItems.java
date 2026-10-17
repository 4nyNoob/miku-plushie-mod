package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushie;
import com.any.miku_plushie.impl.common.item.MikuPlushieBlockItem;
import com.any.miku_plushie.impl.common.item.PlushToolMaterial;
import com.any.miku_plushie.impl.common.util.ModUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import oshi.util.tuples.Pair;

public class ModItems {

  public static final List<Item> REGULAR_ITEMS = new ArrayList<>();
  public static final List<Item> PLUSH_ITEMS = new ArrayList<>();
  public static final List<Item> PICKAXE_ITEMS = new ArrayList<>();

  public static Item CANUDINHO;
  public static Item BAGUETTE;
  public static Item LEEK_SEEDS;
  public static Item LEEK;
  public static Item AKITA_NERU_PHONE;
  public static Item VOCALOID_HEART;

  public static Item TETO_PICKAXE;
  public static Item TETO_PICKAXE_MESMERIZER;
  public static Item TETO_PICKAXE_BIRDBRAIN;
  public static Item TETO_PICKAXE_REGRET_ROCK;
  public static Item TETO_PICKAXE_DONT_BELIEVE_IN_T;
  public static Item TETO_PICKAXE_LIAR_DANCER;
  public static Item TETO_PICKAXE_WHATCHACALLITSNAME;
  public static Item TETO_PICKAXE_SOME_MORE_OF_THAT_SONG;
  public static Item TETO_PICKAXE_SYNTHV;
  public static Item TETO_PICKAXE_SPOKEN_FOR;
  public static Item TETO_PICKAXE_PPPP;

  public static void register(BiConsumer<Item, ResourceLocation> consumer) {

    Constants.LOG.info("Registering " + Constants.MOD_ID + " Items");

    CANUDINHO = register(new Item(new Item.Properties().rarity(Rarity.RARE)), "canudinho", consumer);
    BAGUETTE = register(new Item(new Item.Properties().food(ModFoods.BAGUETTE)), "baguette", consumer);
    LEEK_SEEDS = register(new ItemNameBlockItem(ModBlocks.LEEK_CROP, new Item.Properties()), "leek_seeds", consumer);
    LEEK = register(new Item(new Item.Properties().food(ModFoods.LEEK)), "leek", consumer);
    AKITA_NERU_PHONE = register(new Item(new Item.Properties()), "akita_neru_phone", consumer);
    VOCALOID_HEART = register(new Item(new Item.Properties()), "vocaloid_heart", consumer);

    TETO_PICKAXE = registerPickaxe("teto_pickaxe", consumer);
    TETO_PICKAXE_MESMERIZER = registerPickaxe("teto_pickaxe_mesmerizer", consumer);
    TETO_PICKAXE_BIRDBRAIN = registerPickaxe("teto_pickaxe_birdbrain", consumer);
    TETO_PICKAXE_REGRET_ROCK = registerPickaxe("teto_pickaxe_regret_rock", consumer);
    TETO_PICKAXE_DONT_BELIEVE_IN_T = registerPickaxe("teto_pickaxe_dont_believe_in_t", consumer);
    TETO_PICKAXE_LIAR_DANCER = registerPickaxe("teto_pickaxe_liar_dancer", consumer);
    TETO_PICKAXE_WHATCHACALLITSNAME = registerPickaxe("teto_pickaxe_whatchacallitsname", consumer);
    TETO_PICKAXE_SOME_MORE_OF_THAT_SONG = registerPickaxe("teto_pickaxe_some_more_of_that_song", consumer);
    TETO_PICKAXE_SYNTHV = registerPickaxe("teto_pickaxe_synthv", consumer);
    TETO_PICKAXE_SPOKEN_FOR = registerPickaxe("teto_pickaxe_spoken_for", consumer);
    TETO_PICKAXE_PPPP = registerPickaxe("teto_pickaxe_pppp", consumer);

    //CREATE A ITEM FOR EVERY PLUSH BLOCK
    for (Block plushblock : ModBlocks.PLUSH_BLOCKS) {
      Item plushItem = registerPlush(ModUtil.getBlockIdFromBlock(plushblock), consumer);
      PLUSH_ITEMS.add(plushItem);
    }

    // TODO still need to register all items here lol
    for (Pair<Block, ResourceLocation> blockIdPair : ModBlocks.NEEDS_BLOCK_ITEM) {
      consumer.accept(new BlockItem(blockIdPair.getA(), new Item.Properties()), blockIdPair.getB());
    }
  }

  //REGISTER PLUSH ITEMS
  public static Item registerPlush(String name, BiConsumer<Item, ResourceLocation> consumer) {
    Block plushBlock = null;
    for (int block = 0; block < ModBlocks.PLUSH_BLOCKS.size(); block++) {
      //MATCH ITEM TO THE RIGHT BLOCK
      Block registeredPlushBlock = ModBlocks.PLUSH_BLOCKS.get(block);
      if (ModUtil.getBlockIdFromBlock(registeredPlushBlock).matches(name)) {
        plushBlock = registeredPlushBlock;
      }
    }
    return register(new MikuPlushieBlockItem(plushBlock, new Item.Properties()), name, consumer);
  }

  //REGISTER PICKAXES HELPER
  public static Item registerPickaxe(String name, BiConsumer<Item, ResourceLocation> consumer) {
    Constants.TETO_PICKAXE_NAMES.add(name);
    return register(
        new PickaxeItem(PlushToolMaterial.PLUSH_TOOL_MATERIAL, new Item.Properties().attributes(PickaxeItem.createAttributes(
                PlushToolMaterial.PLUSH_TOOL_MATERIAL, 1f, -2.8F))), name,
        consumer);
  }

  //REGISTER NORMAL ITEM
  public static Item register(Item item, String id, BiConsumer<Item, ResourceLocation> consumer) {
    // ADD REGULAR ITEMS TO ALIAS LIST
    Constants.OTHER_ITEM_NAMES.add(id);

    ResourceLocation itemID = MikuPlushie.id(id);
//    Item register = Registry.register(BuiltInRegistries.ITEM, itemID, item);
    consumer.accept(item, itemID);
    String itemName = ModUtil.getBlockIdFromItem(item);

    //ADD TETO PICKAXES TO THE PICKAXES LIST
    if (itemName.contains("pickaxe")) {
      PICKAXE_ITEMS.add(item);
    }
    //ADD REGULAR ITEMS TOO
    else if (!itemName.contains("plush")) {
      REGULAR_ITEMS.add(item);
    }

    return item;
  }
}
