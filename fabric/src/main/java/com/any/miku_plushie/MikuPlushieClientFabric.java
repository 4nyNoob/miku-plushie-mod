package com.any.miku_plushie;

import com.any.miku_plushie.impl.common.entity.AbstractPlushEntity;
import com.any.miku_plushie.impl.client.render.AbstractPlushRender;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.impl.common.registry.ModEntities;
import com.any.miku_plushie.impl.common.registry.ModParticles;
import com.any.miku_plushie.impl.common.particle.PlushSpawnParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.EntityType;
import software.bernie.geckolib.loading.math.MathParser;

@Environment(EnvType.CLIENT)
public class MikuPlushieClientFabric implements ClientModInitializer {

  @Override
  public void onInitializeClient() {

    MikuPlushieClient.init();

    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " Block Render Layer Maps");

    //PLUSH CUTOUT
    for (int block = 0; block < ModBlocks.PLUSH_BLOCKS.size(); block++) {
      if (!ModBlocks.PLUSH_BLOCKS.get(block).equals(ModBlocks.MIKU_PLUSH_GHOST)) {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUSH_BLOCKS.get(block), RenderType.cutout());
      }
    }

    //PLUSH TRANSLUCENT
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIKU_PLUSH_GHOST, RenderType.translucent());

    //NON PLUSH BLOCKS
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEEK_CROP, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_LEEK_CROP, RenderType.cutout());

    //GLIB QUERY
    MathParser.setVariable("query.miku.is_game", () -> 90 / Math.PI);

    //ENTITIES RENDERERS
    for (EntityType<? extends AbstractPlushEntity> plushEntity : ModEntities.PLUSH_ENTITIES) {
      EntityRendererRegistry.register(plushEntity, AbstractPlushRender::new);
    }

    //PARTICLE
    ParticleFactoryRegistry.getInstance().register(ModParticles.MIKU_SPAWN, PlushSpawnParticle.Factory::new);
  }
}
