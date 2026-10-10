package com.any.miku_plushie.platform;

import com.any.miku_plushie.platform.services.IRegistryHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.Builder;

public class NeoForgeRegistryHelper implements IRegistryHelper {

  @Override
  public Builder creativeTabBuilder() {

    return CreativeModeTab.builder();
  }
}
