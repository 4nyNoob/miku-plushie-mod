package com.any.mikuplushie;

import com.any.mikuplushie.block.MikuPlushieBlock;
import com.any.mikuplushie.registration.RegistryObject;
import com.any.mikuplushie.registry.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

@Environment(EnvType.CLIENT)
public class FabricMikuPlushieClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        for (RegistryObject<Block, MikuPlushieBlock> block : ModBlocks.PLUSH_BLOCKS){
            BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderType.cutout());
        }

    }
}
