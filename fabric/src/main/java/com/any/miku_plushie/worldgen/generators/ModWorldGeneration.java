package com.any.miku_plushie.worldgen.generators;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushieFabric;

public class ModWorldGeneration {

  public static void generateModWorldGeneration() {
    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " World Gen");
    ModLeekGenerator.generateLeek();
  }
}
