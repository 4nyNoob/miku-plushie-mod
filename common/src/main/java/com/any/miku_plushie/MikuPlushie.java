package com.any.miku_plushie;

import net.minecraft.resources.ResourceLocation;

public class MikuPlushie {

  public static void init() {
  }

  public static ResourceLocation id(String path) {

    return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
  }
}