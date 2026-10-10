package com.any.miku_plushie;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;

@Mod(Constants.MOD_ID)
public class MikuPlushieNeoForge {

  public MikuPlushieNeoForge(IEventBus modEventBus) {

    MikuPlushie.init();

    if (FMLLoader.getDist() == Dist.CLIENT) {
      new MikuPlushieClientNeoForge(modEventBus);
    }
  }
}