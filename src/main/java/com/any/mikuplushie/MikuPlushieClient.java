package com.any.mikuplushie;

import com.any.mikuplushie.entity.AbstractPlushEntity;
import com.any.mikuplushie.entity.client.render.*;
import com.any.mikuplushie.particle.PlushSpawnParticle;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModEntities;
import com.any.mikuplushie.registry.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import software.bernie.geckolib.loading.math.MathParser;

import java.util.function.BiConsumer;

@Environment(EnvType.CLIENT)
public class MikuPlushieClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Block Render Layer Maps");

        //PLUSH CUTOUT
        for (int block = 0; block < ModBlocks.PLUSH_BLOCKS.size(); block++) {
            if (!ModBlocks.PLUSH_BLOCKS.get(block).equals(ModBlocks.MIKU_PLUSH_GHOST))
                BlockRenderLayerMap.putBlock(ModBlocks.PLUSH_BLOCKS.get(block), ChunkSectionLayer.CUTOUT);
        }

        //PLUSH TRANSLUCENT
        BlockRenderLayerMap.putBlock(ModBlocks.MIKU_PLUSH_GHOST, ChunkSectionLayer.TRANSLUCENT);

        //NON PLUSH BLOCKS
		BlockRenderLayerMap.putBlock(ModBlocks.LEEK_CROP, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(ModBlocks.WILD_LEEK_CROP, ChunkSectionLayer.CUTOUT);

        //GLIB QUERY
//        MathParser.setVariable("query.miku.is_game", 90 / Math.PI);

//        //ENTITIES RENDERERS
//        for (EntityType<? extends AbstractPlushEntity> plushEntity : ModEntities.PLUSH_ENTITIES) {
//            EntityRendererRegistry.register(plushEntity, AbstractPlushRender::new);
//        }

        registerRenderers(EntityRendererRegistry::register);

        //PARTICLE
        ParticleFactoryRegistry.getInstance().register(ModParticles.MIKU_SPAWN, PlushSpawnParticle.Factory::new);
	}

    public static void registerRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> entityRenderers) {

        //ENTITIES RENDERERS
        for (EntityType<? extends AbstractPlushEntity> plushEntity : ModEntities.PLUSH_ENTITIES) {
//            EntityRendererRegistry.register(plushEntity, AbstractPlushRender::new);
            entityRenderers.accept(plushEntity, AbstractPlushRender::new);
        }
    }
}
