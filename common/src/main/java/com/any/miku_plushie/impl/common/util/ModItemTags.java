package com.any.miku_plushie.impl.common.util;

import com.any.miku_plushie.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

  public static final TagKey<Item> PLUSHIES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "plushies"));
  public static final TagKey<Item> TETO_PICKAXE = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "teto_pickaxe"));
}
