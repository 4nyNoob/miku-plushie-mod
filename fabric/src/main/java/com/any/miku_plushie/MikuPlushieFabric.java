package com.any.miku_plushie;

import com.any.miku_plushie.entity.AbstractPlushEntity;
import com.any.miku_plushie.entity.variant.PlushVariants;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.impl.common.registry.ModItems;
import com.any.miku_plushie.registry.ModCommands;
import com.any.miku_plushie.registry.ModEntitiesFabric;
import com.any.miku_plushie.registry.ModParticlesFabric;
import com.any.miku_plushie.registry.ModResourcePacks;
import com.any.miku_plushie.registry.ModSoundEventsFabric;
import com.any.miku_plushie.registry.ModTabsFabric;
import com.any.miku_plushie.registry.ModVillagerTrades;
import com.any.miku_plushie.worldgen.generators.ModWorldGeneration;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MikuPlushieFabric implements ModInitializer {

  public static final Logger LOGGER = LoggerFactory.getLogger(Constants.MOD_ID);

  @Override
  public void onInitialize() {

    MikuPlushie.init();

    LOGGER.info("Miku is now Joining Fabric!!!");

    // will remove lol
    ModSoundEventsFabric.initialize();
//    bind(BuiltInRegistries.SOUND_EVENT, ModSounds::register);
    bind(BuiltInRegistries.BLOCK, ModBlocks::register);
    ModEntitiesFabric.initialize();
//    bind(BuiltInRegistries.ENTITY_TYPE, ModEntities::register);
    bind(BuiltInRegistries.ITEM, ModItems::register);
    ModParticlesFabric.initialize();
//    bind(BuiltInRegistries.PARTICLE_TYPE, ModParticles::register);
    ModTabsFabric.initialize();
//    bind(BuiltInRegistries.CREATIVE_MODE_TAB, ModTabs::register);

    ModCommands.initialize();
    ModResourcePacks.initialize();
    ModVillagerTrades.initialize();
    ModWorldGeneration.generateModWorldGeneration();

    // technically occurred at the end of ModEntitiesFabric#initialize, putting it before PlushVariants#initialize
    for (EntityType<? extends AbstractPlushEntity> entity : ModEntitiesFabric.PLUSH_ENTITIES) {
      FabricDefaultAttributeRegistry.register(entity, AbstractPlushEntity.createAttributes());
    }

    PlushVariants.initialize();

    LOGGER.info("Miku: (^v^)/ Hi!!!");
  }

  public <T> void bind(Registry<T> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {

    source.accept((t, id) -> Registry.register(registry, id, t));
  }
}
