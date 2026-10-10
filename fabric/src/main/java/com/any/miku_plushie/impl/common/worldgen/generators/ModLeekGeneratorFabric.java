package com.any.miku_plushie.impl.common.worldgen.generators;

import com.any.miku_plushie.impl.common.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModLeekGeneratorFabric {

  /// NeoForge does this in JSON, so this is specific to Fabric. (no "exact" parity)
  public static void generateLeek() {

    BiomeModifications.addFeature(BiomeSelectors.includeByKey(
            Biomes.TAIGA,
            Biomes.OLD_GROWTH_SPRUCE_TAIGA,
            Biomes.OLD_GROWTH_PINE_TAIGA
        ),
        GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LEEK_PLACED_KEY
    );
  }
}
