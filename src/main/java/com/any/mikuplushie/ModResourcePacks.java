package com.any.mikuplushie;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModResourcePacks {

    public static void initialize () {
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Resource Packs");

        FabricLoader.getInstance().getModContainer(MikuPlushie.MOD_ID).ifPresent(modContainer ->
        ResourceManagerHelper.registerBuiltinResourcePack(asId("en_us_dub"), modContainer, Text.literal("EN_US-DUB"), ResourcePackActivationType.NORMAL)
        );
    }

    public static Identifier asId(String path) {
        return new Identifier(MikuPlushie.MOD_ID, path);
    }
}
