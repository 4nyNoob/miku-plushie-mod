package com.any.miku_plushie;

import net.neoforged.bus.api.IEventBus;

public class MikuPlushieClientNeoForge {

  public MikuPlushieClientNeoForge(final IEventBus modEventBus) {

    MikuPlushieClient.init();
  }
}
