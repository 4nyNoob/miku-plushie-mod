package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.MikuPlushie;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class ModTabs {

  public static ResourceKey<CreativeModeTab> MIKU_GROUP_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MikuPlushie.id("item_group"));

  public static CreativeModeTab MIKU_GROUP;
}
