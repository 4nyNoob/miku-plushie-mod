package com.any.mikuplushie.worldgen.generators;

import com.any.mikuplushie.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModLeekGenerator {
    public static void generateLeek(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                BiomeKeys.TAIGA,
                BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA,
                BiomeKeys.OLD_GROWTH_PINE_TAIGA
            ),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LEEK_PLACED_KEY
        );
    }
}
