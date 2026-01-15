package com.any.mikuplushie.worldgen;

import com.any.mikuplushie.MikuPlushie;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> LEEK_PLACED_KEY = registerKey("leek_placed");

    public static void bootstrap (Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, LEEK_PLACED_KEY,
            configuredFeatureRegistryLookup.getOrThrow(ModConfiguredFeatures.LEEK_KEY),
            RarityFilterPlacementModifier.of(8),
            SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
            BiomePlacementModifier.of()
        );
    }

    public static RegistryKey<PlacedFeature> registerKey (String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MikuPlushie.MOD_ID, name));
    }

    private static void register(
        Registerable<PlacedFeature> context,
        RegistryKey<PlacedFeature> key,
        RegistryEntry<ConfiguredFeature<?, ?>> configuration,
        List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
        Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
        RegistryEntry<ConfiguredFeature<?, ?>> configuration,
        PlacementModifier... modifiers
    ) {
        register(context, key, configuration, List.of(modifiers));
    }
}
