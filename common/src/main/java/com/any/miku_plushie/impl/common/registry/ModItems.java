package com.any.miku_plushie.impl.common.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
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

    // TODO still need to register all items here lol
    for (Pair<Block, ResourceLocation> blockIdPair : ModBlocks.NEEDS_BLOCK_ITEM) {
      consumer.accept(new BlockItem(blockIdPair.getA(), new Item.Properties()), blockIdPair.getB());
    }
  }
}
