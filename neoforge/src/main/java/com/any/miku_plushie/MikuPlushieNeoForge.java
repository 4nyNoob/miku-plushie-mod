package com.any.miku_plushie;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class MikuPlushieNeoForge {

  public MikuPlushieNeoForge(IEventBus modEventBus) {

    MikuPlushie.init();

  }
}