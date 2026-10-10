package com.any.miku_plushie.impl.common.worldgen.generators;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushieFabric;

public class ModWorldGenerationFabric {

  /// NeoForge does this in JSON, so this is specific to Fabric. (no "exact" parity)
  public static void generateModWorldGeneration() {

    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " World Gen");

    ModLeekGeneratorFabric.generateLeek();
  }
}
