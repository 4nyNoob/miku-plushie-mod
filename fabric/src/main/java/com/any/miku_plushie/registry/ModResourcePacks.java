package com.any.miku_plushie.registry;

import com.any.miku_plushie.MikuPlushieFabric;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ModResourcePacks {

    public static void initialize () {
        MikuPlushieFabric.LOGGER.info("Registering " + MikuPlushieFabric.MOD_ID + " Resource Packs");

        FabricLoader.getInstance().getModContainer(MikuPlushieFabric.MOD_ID).ifPresent(modContainer ->
            ResourceManagerHelper.registerBuiltinResourcePack(asId("en_us_dub"), modContainer,
                Component.literal("EN_US-DUB"), ResourcePackActivationType.NORMAL)
        );
        FabricLoader.getInstance().getModContainer(MikuPlushieFabric.MOD_ID).ifPresent(modContainer ->
            ResourceManagerHelper.registerBuiltinResourcePack(asId("legacy_textures"), modContainer,
                Component.literal("Legacy Textures"), ResourcePackActivationType.NORMAL)
        );
    }

    public static ResourceLocation asId(String path) {
        return ResourceLocation.fromNamespaceAndPath(MikuPlushieFabric.MOD_ID, path);
    }
}
