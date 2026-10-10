package com.any.miku_plushie.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushie;
import com.any.miku_plushie.MikuPlushieFabric;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;

public class ModResourcePacksFabric {

  public static void initialize() {
    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " Resource Packs");

    FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(modContainer ->
        ResourceManagerHelper.registerBuiltinResourcePack(MikuPlushie.id("en_us_dub"), modContainer,
            Component.literal("EN_US-DUB"), ResourcePackActivationType.NORMAL)
    );
    FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(modContainer ->
        ResourceManagerHelper.registerBuiltinResourcePack(MikuPlushie.id("legacy_textures"), modContainer,
            Component.literal("Legacy Textures"), ResourcePackActivationType.NORMAL)
    );
  }
}
