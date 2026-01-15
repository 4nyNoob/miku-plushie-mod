package com.any.mikuplushie.worldgen;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.registry.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModConfiguredFeatures {

    //FEATURE KEYS
    public static final RegistryKey<ConfiguredFeature<?, ?>> LEEK_KEY =  registerKey("leek");

    public static void bootstrap (Registerable<ConfiguredFeature<?, ?>> context){
        register(context,
            LEEK_KEY,
            Feature.RANDOM_PATCH,
            new RandomPatchFeatureConfig(
                8,2,1,
                PlacedFeatures.createEntry(
                    Feature.SIMPLE_BLOCK,
                    new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WILD_LEEK_CROP))
                )
            )
        );
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey (String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MikuPlushie.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register (
        Registerable<ConfiguredFeature<?, ?>> context,
        RegistryKey<ConfiguredFeature<?, ?>> key,
        F feature,
        FC configuration
    ){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
