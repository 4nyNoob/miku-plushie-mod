package com.any.miku_plushie;

import com.any.miku_plushie.impl.client.render.AbstractPlushRender;
import com.any.miku_plushie.impl.common.entity.AbstractPlushEntity;
import com.any.miku_plushie.impl.common.particle.PlushSpawnParticle;
import com.any.miku_plushie.impl.common.registry.ModEntities;
import com.any.miku_plushie.impl.common.registry.ModParticles;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import software.bernie.geckolib.loading.math.MathParser;

public class MikuPlushieClientNeoForge {

  public MikuPlushieClientNeoForge(final IEventBus modEventBus) {

    MikuPlushieClient.init();

    //GLIB QUERY
    MathParser.setVariable("query.miku.is_game", () -> 90 / Math.PI);

    //ENTITIES RENDERERS
    modEventBus.addListener((EntityRenderersEvent.RegisterRenderers event) -> {

      for (EntityType<? extends AbstractPlushEntity> plushEntity : ModEntities.PLUSH_ENTITIES) {
        event.registerEntityRenderer(plushEntity, AbstractPlushRender::new);
      }
    });

    //PARTICLE
    modEventBus.addListener((RegisterParticleProvidersEvent event) -> {

      event.registerSpriteSet(ModParticles.MIKU_SPAWN, PlushSpawnParticle.Factory::new);
    });
  }
}
