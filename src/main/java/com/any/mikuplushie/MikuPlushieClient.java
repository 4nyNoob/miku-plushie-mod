package com.any.mikuplushie;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(value = Dist.CLIENT,modid = MikuPlushie.MOD_ID,bus = EventBusSubscriber.Bus.MOD)
public class MikuPlushieClient{
	@SubscribeEvent
	public static void onInitializeClient(FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_BA.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BIK.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_BEACH.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_BRAID.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_BA_DRUM.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_PA.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_SP.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_MG.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_BROWN_BRO.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_AM.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_FUT_FLA.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_FUT_CAM.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_GO.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_FUT_CRVG.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_BR_RS.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_FROG.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_MUSHROOM.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_SENBONZAKURA.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_URAOTOMELOVERS.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_PERSONADANCING.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_HELLOPLANET.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_HACHUNE.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_ZATSUNE.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_INFINITY.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_VAMPIRE.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_WEREWOMAN.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_JASON.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_MICHAEL_MYERS.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_PUMPKIN.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_GHOSTFACE.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_FRANKENSTEIN.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_MUMMY.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_PATATI.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_PATATA.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_DEVIL.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_WITCH.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_SANTA.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_REINDEER.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_SANTA_ELF.get(), RenderType.CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_XMAS_TREE.get(), RenderType.CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(ModBlocks.AIKO_PLUSH.get(), RenderType.CUTOUT);


		ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIKU_PLUSH_GHOST.get(), RenderType.TRANSLUCENT);
	}
}
