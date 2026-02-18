package com.any.mikuplushie.worldgen;

import com.any.mikuplushie.MikuPlushie;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> LEEK_PLACED_KEY = registerKey("leek_placed");

    public static void bootstrap (BootstrapContext<PlacedFeature> context) {
        var configuredFeatureRegistryLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, LEEK_PLACED_KEY,
            configuredFeatureRegistryLookup.getOrThrow(ModConfiguredFeatures.LEEK_KEY),
            RarityFilter.onAverageOnceEvery(8),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        );
    }

    public static ResourceKey<PlacedFeature> registerKey (String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, name));
    }

    private static void register(
        BootstrapContext<PlacedFeature> context,
        ResourceKey<PlacedFeature> key,
        Holder<ConfiguredFeature<?, ?>> configuration,
        List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
        BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
        Holder<ConfiguredFeature<?, ?>> configuration,
        PlacementModifier... modifiers
    ) {
        register(context, key, configuration, List.of(modifiers));
    }
}
