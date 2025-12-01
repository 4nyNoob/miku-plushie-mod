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
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
            ModBlocks.MIKU_PLUSH_BR,
            ModBlocks.MIKU_PLUSH_BR_BA,
            ModBlocks.MIKU_PLUSH_BIK,
            ModBlocks.MIKU_PLUSH_BR_BEACH,
            ModBlocks.MIKU_PLUSH_BR_BRAID,
            ModBlocks.MIKU_PLUSH_BR_BA_DRUM,
            ModBlocks.MIKU_PLUSH_BR_PA,
            ModBlocks.MIKU_PLUSH_BR_SP,
            ModBlocks.MIKU_PLUSH_BR_MG,
            ModBlocks.MIKU_PLUSH_BR_BROWN_BRO,
            ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN,
            ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE,
            ModBlocks.MIKU_PLUSH_BR_AM,
            ModBlocks.MIKU_PLUSH_BR_FUT_FLA,
            ModBlocks.MIKU_PLUSH_BR_FUT_CAM,
            ModBlocks.MIKU_PLUSH_BR_GO,
            ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE,
            ModBlocks.MIKU_PLUSH_BR_FUT_CRVG,
            ModBlocks.MIKU_PLUSH_BR_RS,
            ModBlocks.MIKU_PLUSH_FROG,
            ModBlocks.MIKU_PLUSH_MUSHROOM,
            ModBlocks.MIKU_PLUSH_SENBONZAKURA,
            ModBlocks.MIKU_PLUSH_URAOTOMELOVERS,
            ModBlocks.MIKU_PLUSH_PERSONADANCING,
            ModBlocks.MIKU_PLUSH_HELLOPLANET,
            ModBlocks.MIKU_PLUSH_HACHUNE,
            ModBlocks.MIKU_PLUSH_ZATSUNE,
            ModBlocks.MIKU_PLUSH_INFINITY,
            ModBlocks.MIKU_PLUSH_VAMPIRE,
            ModBlocks.MIKU_PLUSH_WEREWOMAN,
            ModBlocks.MIKU_PLUSH_JASON,
            ModBlocks.MIKU_PLUSH_MICHAEL_MYERS,
            ModBlocks.MIKU_PLUSH_PUMPKIN,
            ModBlocks.MIKU_PLUSH_GHOSTFACE,
            ModBlocks.MIKU_PLUSH_FRANKENSTEIN,
            ModBlocks.MIKU_PLUSH_MUMMY,
            ModBlocks.MIKU_PLUSH_PATATI,
            ModBlocks.MIKU_PLUSH_PATATA,
            ModBlocks.MIKU_PLUSH_DEVIL,
            ModBlocks.MIKU_PLUSH_WITCH,
            ModBlocks.MIKU_PLUSH_SANTA,
            ModBlocks.MIKU_PLUSH_REINDEER,
            ModBlocks.MIKU_PLUSH_SANTA_ELF,
            ModBlocks.MIKU_PLUSH_XMAS_TREE,
            ModBlocks.MIKU_PLUSH,
            ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS,
            ModBlocks.MIKU_PLUSH_FORTNITE_NEKO,
            ModBlocks.MIKU_PLUSH_V4,
            ModBlocks.MIKU_PLUSH_MESMERIZER,
            ModBlocks.MIKU_PLUSH_SONIC,
            ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025,
            ModBlocks.MIKU_PLUSH_ROTTEN_GIRL,
            ModBlocks.MIKU_PLUSH_PSYCHO_MODE,
            ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T,
            ModBlocks.MIKU_PLUSH_STATIC,
            ModBlocks.MIKU_PLUSH_MOCHIMOCHI,
            ModBlocks.MIKU_PLUSH_MONITORING,
            ModBlocks.MIKU_PLUSH_HOLLOW_KNIGHT,
            ModBlocks.MIKU_PLUSH_HORNET,
            ModBlocks.MIKU_PLUSH_WORLD_IS_MINE,
            ModBlocks.MIKU_PLUSH_ROLLING_GIRL,

            ModBlocks.AIKO_PLUSH,

            ModBlocks.TETO_PLUSH,
            ModBlocks.TETO_PLUSH_MESMERIZER,
            ModBlocks.TETO_PLUSH_SHADOW,
            ModBlocks.TETO_PLUSH_BIRDBRAIN,
            ModBlocks.TETO_PLUSH_REGRET_ROCK,
            ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T,
            ModBlocks.TETO_PLUSH_LIAR_DANCER,
            ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME,
            ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG,
            ModBlocks.TETO_PLUSH_LOBSTER,
            ModBlocks.TETO_PLUSH_SYNTHV,
            ModBlocks.TETO_PLUSH_SPOKEN_FOR,

            ModBlocks.AKITA_NERU_PLUSH,
            ModBlocks.AKITA_NERU_PLUSH_TAILS,

            ModBlocks.RIN_PLUSH,

            ModBlocks.LEN_PLUSH,

            ModBlocks.LUKA_PLUSH,

            ModBlocks.KONOHA_PLUSH
        );

        //CROP CUTOUT
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEEK_CROP, RenderLayer.getCutout());

		//PLUSH TRANSLUCENT
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIKU_PLUSH_GHOST, RenderLayer.getTranslucent());

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
	}
}
