package com.any.mikuplushie.worldgen;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ModConfiguredFeatures {

    //FEATURE KEYS
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEEK_KEY =  registerKey("leek");

    public static void bootstrap (BootstrapContext<ConfiguredFeature<?, ?>> context){
        register(context,
            LEEK_KEY,
            Feature.RANDOM_PATCH,
            new RandomPatchConfiguration(
                8,2,1,
                PlacementUtils.onlyWhenEmpty(
                    Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_LEEK_CROP))
                )
            )
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey (String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register (
        BootstrapContext<ConfiguredFeature<?, ?>> context,
        ResourceKey<ConfiguredFeature<?, ?>> key,
        F feature,
        FC configuration
    ){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
