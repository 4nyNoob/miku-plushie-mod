package com.any.miku_plushie;

import com.any.miku_plushie.impl.common.entity.AbstractPlushEntity;
import com.any.miku_plushie.impl.client.render.AbstractPlushRender;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.impl.common.registry.ModEntities;
import com.any.miku_plushie.impl.common.registry.ModParticles;
import com.any.miku_plushie.impl.common.particle.PlushSpawnParticle;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.world.entity.EntityType;
import com.geckolib.loading.math.MathParser;
import net.fabricmc.api.ClientModInitializer;

//@Environment(EnvType.CLIENT)
public class MikuPlushieClientFabric implements ClientModInitializer {

  @Override
  public void onInitializeClient() {

    MikuPlushieClient.init();
    MikuPlushieClientFabric.registerBlockRenderLayers(); // fabric specific

    //GLIB QUERY
    //TODO REGISTER
//    MathParser.setVariable("query.miku.is_game", () -> 90 / Math.PI);

    //ENTITIES RENDERERS
    for (EntityType<? extends AbstractPlushEntity> plushEntity : ModEntities.PLUSH_ENTITIES) {
      EntityRenderers.register(plushEntity, AbstractPlushRender::new);
    }

    //TODO REGISTER PARTICLE RENDER
//    ParticleFactoryRegistry.getInstance().register(ModParticles.MIKU_SPAWN, PlushSpawnParticle.Factory::new);
  }

  /// NeoForge does this in JSON, so this is specific to Fabric. (no "exact" parity)
  private static void registerBlockRenderLayers() {

    Constants.LOG.info("Registering " + Constants.MOD_ID + " Block Render Layer Maps");

    // TODO BLOCK RENDER LAYERS

//    //PLUSH CUTOUT
//    for (int block = 0; block < ModBlocks.PLUSH_BLOCKS.size(); block++) {
//      if (!ModBlocks.PLUSH_BLOCKS.get(block).equals(ModBlocks.MIKU_PLUSH_GHOST)) {
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUSH_BLOCKS.get(block), RenderType.cutout());
//      }
//    }
//
//    //PLUSH TRANSLUCENT
//    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIKU_PLUSH_GHOST, RenderType.translucent());
//
//    //NON-PLUSH BLOCKS
//    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEEK_CROP, RenderType.cutout());
//    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_LEEK_CROP, RenderType.cutout());
  }
}
