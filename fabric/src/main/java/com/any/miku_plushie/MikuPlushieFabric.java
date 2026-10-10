package com.any.miku_plushie;

import com.any.miku_plushie.entity.variant.PlushVariants;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.registry.ModBlocksFabric;
import com.any.miku_plushie.registry.ModCommands;
import com.any.miku_plushie.registry.ModEntities;
import com.any.miku_plushie.registry.ModItemsFabric;
import com.any.miku_plushie.registry.ModParticles;
import com.any.miku_plushie.registry.ModResourcePacks;
import com.any.miku_plushie.registry.ModSoundEventsFabric;
import com.any.miku_plushie.registry.ModTabsFabric;
import com.any.miku_plushie.registry.ModVillagerTrades;
import com.any.miku_plushie.worldgen.generators.ModWorldGeneration;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MikuPlushieFabric implements ModInitializer {

  public static final Logger LOGGER = LoggerFactory.getLogger(Constants.MOD_ID);

  @Override
  public void onInitialize() {

    MikuPlushie.init();

    LOGGER.info("Miku is now Joining Fabric!!!");

    // will remove lol
//    bind(BuiltInRegistries.SOUND_EVENT, ModSounds::register);
//    bind(BuiltInRegistries.FLUID, ModFluids::register);
//    bind(BuiltInRegistries.MOB_EFFECT, ModEffects::register);
    ModBlocksFabric.initialize();
    bind(BuiltInRegistries.BLOCK, ModBlocks::register);
//    bind(BuiltInRegistries.ENTITY_TYPE, ModEntities::register);
//    bind(BuiltInRegistries.ITEM, ModItems::register);
//    bind(BuiltInRegistries.POTION, ModPotions::register);
//    bind(BuiltInRegistries.PARTICLE_TYPE, ModParticles::register);
//    bind(BuiltInRegistries.BLOCK_ENTITY_TYPE, ModTiles::register);
//    bind(BuiltInRegistries.MENU, ModMenus::register);
//    bind(BuiltInRegistries.RECIPE_TYPE, ModRecipeTypes::register);
//    bind(BuiltInRegistries.RECIPE_SERIALIZER, ModRecipeSerializers::register);
//    bind(BuiltInRegistries.FEATURE, ModFeatures::register);
    ModTabsFabric.initialize();
//    bind(BuiltInRegistries.CREATIVE_MODE_TAB, ModTabs::register);
//    bind(BuiltInRegistries.DATA_COMPONENT_TYPE, ModComponents::register);

    ModItemsFabric.initialize();
    ModSoundEventsFabric.initialize();
    ModCommands.initialize();
    ModEntities.initialize();
    ModResourcePacks.initialize();
    ModVillagerTrades.initialize();
    ModParticles.initialize();
    ModWorldGeneration.generateModWorldGeneration();
    PlushVariants.initialize();
    LOGGER.info("Miku: (^v^)/ Hi!!!");
  }

  public <T> void bind(Registry<T> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {

    source.accept((t, id) -> Registry.register(registry, id, t));
  }
}
