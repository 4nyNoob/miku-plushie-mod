package com.any.miku_plushie.impl.common.util;

import com.any.miku_plushie.MikuPlushie;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

  public static final TagKey<Item> PLUSHIES = TagKey.create(Registries.ITEM, MikuPlushie.id("plushies"));
  public static final TagKey<Item> TETO_PICKAXE = TagKey.create(Registries.ITEM, MikuPlushie.id("teto_pickaxe"));
}
