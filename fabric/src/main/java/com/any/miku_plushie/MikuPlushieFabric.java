package com.any.miku_plushie;

import com.any.miku_plushie.impl.common.entity.AbstractPlushEntity;
import com.any.miku_plushie.impl.common.entity.variant.PlushVariants;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.impl.common.registry.ModCommands;
import com.any.miku_plushie.impl.common.registry.ModEntities;
import com.any.miku_plushie.impl.common.registry.ModItems;
import com.any.miku_plushie.impl.common.registry.ModParticles;
import com.any.miku_plushie.impl.common.registry.ModSounds;
import com.any.miku_plushie.impl.common.registry.ModTabs;
import com.any.miku_plushie.registry.ModResourcePacks;
import com.any.miku_plushie.registry.ModVillagerTrades;
import com.any.miku_plushie.worldgen.generators.ModWorldGeneration;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
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

    MikuPlushie.preModInitialization();

    // game object registration
    bind(BuiltInRegistries.SOUND_EVENT, ModSounds::register);
    bind(BuiltInRegistries.BLOCK, ModBlocks::register);
    bind(BuiltInRegistries.ENTITY_TYPE, ModEntities::register);
    bind(BuiltInRegistries.ITEM, ModItems::register);
    bind(BuiltInRegistries.PARTICLE_TYPE, ModParticles::register);
    bind(BuiltInRegistries.CREATIVE_MODE_TAB, ModTabs::register);

    // misc registration
    CommandRegistrationCallback.EVENT.register(ModCommands::register);

    ModResourcePacks.initialize();
    ModVillagerTrades.initialize();
    ModWorldGeneration.generateModWorldGeneration();

    // technically occurred at the end of ModEntitiesFabric#initialize, putting it before PlushVariants#initialize
    for (EntityType<? extends AbstractPlushEntity> entity : ModEntities.PLUSH_ENTITIES) {
      FabricDefaultAttributeRegistry.register(entity, AbstractPlushEntity.createAttributes());
    }

    PlushVariants.initialize();

    MikuPlushie.postModInitialization();

    // on to client init
  }

  public <T> void bind(Registry<T> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {

    source.accept((t, id) -> Registry.register(registry, id, t));
  }
}
