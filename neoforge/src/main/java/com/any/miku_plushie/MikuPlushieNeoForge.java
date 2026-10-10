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
import com.any.miku_plushie.impl.common.registry.ModResourcePacksNeoForge;
import com.any.miku_plushie.impl.common.registry.ModVillagerTradesNeoForge;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class MikuPlushieNeoForge {

  public static IEventBus EVENT_BUS;

  public MikuPlushieNeoForge(IEventBus modEventBus) {

    EVENT_BUS = modEventBus;

    MikuPlushie.preModInitialization();

    // game object registration
    bind(Registries.SOUND_EVENT, ModSounds::register);
    bind(Registries.BLOCK, ModBlocks::register);
    bind(Registries.ENTITY_TYPE, ModEntities::register);
    bind(Registries.ITEM, ModItems::register);
    bind(Registries.PARTICLE_TYPE, ModParticles::register);
    bind(Registries.CREATIVE_MODE_TAB, ModTabs::register);

    // misc registration
    modEventBus.addListener((EntityAttributeCreationEvent event) -> {
      for (EntityType<? extends AbstractPlushEntity> entity : ModEntities.PLUSH_ENTITIES) {
        event.put(entity, AbstractPlushEntity.createAttributes().build());
      }
    });

    NeoForge.EVENT_BUS.addListener((RegisterCommandsEvent event) ->
        ModCommands.register(event.getDispatcher(), event.getBuildContext(), event.getCommandSelection()));

    ModResourcePacksNeoForge.initialize(modEventBus);
    ModVillagerTradesNeoForge.initialize();

    // must occur after entities are registered, so we do it during common setup, after RegisterEvent is fired
    modEventBus.addListener((FMLCommonSetupEvent event) -> event.enqueueWork(PlushVariants::initialize));

    MikuPlushie.postModInitialization();

    // on to client init
    if (FMLLoader.getDist() == Dist.CLIENT) {
      new MikuPlushieClientNeoForge(modEventBus);
    }
  }

  public <T> void bind(ResourceKey<Registry<T>> registryKey, Consumer<BiConsumer<T, ResourceLocation>> source) {

    EVENT_BUS.addListener((Consumer<RegisterEvent>) event -> {
      if (registryKey.equals(event.getRegistryKey())) {
        source.accept((t, rl) -> event.register(registryKey, rl, () -> t));
      }
    });
  }
}