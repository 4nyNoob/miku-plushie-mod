package com.any.miku_plushie;

import com.any.miku_plushie.platform.Services;
import net.minecraft.resources.Identifier;

public class MikuPlushie {

  /// fires **before** game objects like items, blocks, entities, etc. get registered
  public static void preModInitialization() {

    Constants.LOG.info("Miku is now joining {}!!!", Services.PLATFORM.getPlatformName());
  }

  /// fires **after** our common initialization finishes
  public static void postModInitialization() {

    Constants.LOG.info("Miku: (^v^)/ Hi!!!");
  }

  public static Identifier id(String path) {

    return Identifier.fromNamespaceAndPath(Constants.MOD_ID, path);
  }
}