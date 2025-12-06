package com.any.mikuplushie;

import com.any.mikuplushie.entity.client.render.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import software.bernie.geckolib.core.molang.LazyVariable;
import software.bernie.geckolib.core.molang.MolangParser;

@Environment(EnvType.CLIENT)
public class MikuPlushieClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Block Render Layer Maps");

        //PLUSH CUTOUT
        for (int block = 0; block < ModBlocks.PLUSH_BLOCKS.size(); block++) {
            if (!ModBlocks.PLUSH_BLOCKS.get(block).equals(ModBlocks.MIKU_PLUSH_GHOST))
                BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUSH_BLOCKS.get(block), RenderLayer.getCutout());
        }

        //PLUSH TRANSLUCENT
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIKU_PLUSH_GHOST, RenderLayer.getTranslucent());

        //NON PLUSH BLOCKS
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEEK_CROP, RenderLayer.getCutout());

        //GLIB QUERY
        MolangParser.INSTANCE.register(new LazyVariable("q.miku.is_game", 1));

        //ENTITIES RENDERERS
        EntityRendererRegistry.register(ModEntities.MIKU, MikuRender::new);
        EntityRendererRegistry.register(ModEntities.TETO, TetoRender::new);
        EntityRendererRegistry.register(ModEntities.AIKO, AikoRender::new);
        EntityRendererRegistry.register(ModEntities.NERU, NeruRender::new);
        EntityRendererRegistry.register(ModEntities.RIN, RinRender::new);
        EntityRendererRegistry.register(ModEntities.LEN, LenRender::new);
        EntityRendererRegistry.register(ModEntities.KONOHA, KonohaRender::new);
        EntityRendererRegistry.register(ModEntities.LUKA, LukaRender::new);
        EntityRendererRegistry.register(ModEntities.MEIKO, MeikoRender::new);
        EntityRendererRegistry.register(ModEntities.GUMI, GumiRender::new);
	}
}
