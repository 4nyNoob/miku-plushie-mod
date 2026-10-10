package com.any.miku_plushie.platform;

import com.any.miku_plushie.platform.services.IRegistryHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.world.item.CreativeModeTab.Builder;

public class FabricRegistryHelper implements IRegistryHelper {

  @Override
  public Builder creativeTabBuilder() {
    return FabricItemGroup.builder();
  }
}
