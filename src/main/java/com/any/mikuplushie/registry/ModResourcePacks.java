package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class ModResourcePacks {

    public static void initialize () {
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Resource Packs");

        FabricLoader.getInstance().getModContainer(MikuPlushie.MOD_ID).ifPresent(modContainer ->
            ResourceManagerHelper.registerBuiltinResourcePack(asId("en_us_dub"), modContainer,
                Component.literal("EN_US-DUB"), ResourcePackActivationType.NORMAL)
        );
        FabricLoader.getInstance().getModContainer(MikuPlushie.MOD_ID).ifPresent(modContainer ->
            ResourceManagerHelper.registerBuiltinResourcePack(asId("legacy_textures"), modContainer,
                Component.literal("Legacy Textures"), ResourcePackActivationType.NORMAL)
        );
    }

    public static Identifier asId(String path) {
        return Identifier.fromNamespaceAndPath(MikuPlushie.MOD_ID, path);
    }
}
