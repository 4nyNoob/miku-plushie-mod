package com.any.miku_plushie;

import com.any.miku_plushie.impl.client.render.AbstractPlushRender;
import com.any.miku_plushie.impl.common.entity.AbstractPlushEntity;
import com.any.miku_plushie.impl.common.particle.PlushSpawnParticle;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.impl.common.registry.ModEntities;
import com.any.miku_plushie.impl.common.registry.ModParticles;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import software.bernie.geckolib.loading.math.MathParser;

public class MikuPlushieClientNeoForge {

  public MikuPlushieClientNeoForge(final IEventBus modEventBus) {

    MikuPlushieClient.init();

    MathParser.setVariable("query.miku.is_game", () -> 90 / Math.PI);

    modEventBus.addListener((FMLClientSetupEvent event) -> event.enqueueWork(() -> {
      Constants.LOG.info("Registering " + Constants.MOD_ID + " Block Render Layer Maps");

      // TODO replicate behavior via datagen / manually?
//      for (Block block : ModBlocks.PLUSH_BLOCKS) {
//        if (!block.equals(ModBlocks.MIKU_PLUSH_GHOST)) {
//          ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutout());
//        }
//      }

      // "render_type": "minecraft:cutout" in model json files
      // ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_GHOST, RenderType.translucent());
      // ItemBlockRenderTypes.setRenderLayer(ModBlocks.LEEK_CROP, RenderType.cutout());
      // ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_LEEK_CROP, RenderType.cutout());
    }));

    modEventBus.addListener((EntityRenderersEvent.RegisterRenderers event) -> {
      for (EntityType<? extends AbstractPlushEntity> plushEntity : ModEntities.PLUSH_ENTITIES) {
        event.registerEntityRenderer(plushEntity, AbstractPlushRender::new);
      }
    });

    modEventBus.addListener((RegisterParticleProvidersEvent event) ->
        event.registerSpriteSet(ModParticles.MIKU_SPAWN, PlushSpawnParticle.Factory::new));
  }
}
