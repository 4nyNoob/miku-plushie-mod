package com.any.miku_plushie.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushie;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.AddPackFindersEvent;

public class ModResourcePacksNeoForge {

  public static void initialize(IEventBus modEventBus) {

    Constants.LOG.info("Registering " + Constants.MOD_ID + " Resource Packs");

    modEventBus.addListener((AddPackFindersEvent event) -> {
      event.addPackFinders(MikuPlushie.id("resourcepacks/en_us_dub"), PackType.CLIENT_RESOURCES,
          Component.literal("EN_US-DUB"), PackSource.BUILT_IN, false, Pack.Position.TOP);
      event.addPackFinders(MikuPlushie.id("resourcepacks/legacy_textures"), PackType.CLIENT_RESOURCES,
          Component.literal("Legacy Textures"), PackSource.BUILT_IN, false, Pack.Position.TOP);
    });
  }
}
