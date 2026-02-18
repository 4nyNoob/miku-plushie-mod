package com.any.mikuplushie.worldgen.generators;

import com.any.mikuplushie.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModLeekGenerator {
    public static void generateLeek(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                Biomes.TAIGA,
                Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.OLD_GROWTH_PINE_TAIGA
            ),
            GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LEEK_PLACED_KEY
        );
    }
}
