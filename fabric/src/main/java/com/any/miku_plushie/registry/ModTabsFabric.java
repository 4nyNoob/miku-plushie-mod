package com.any.miku_plushie.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushieFabric;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.impl.common.registry.ModTabs;
import com.any.miku_plushie.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class ModTabsFabric {

  public static void initialize() {

    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " Creative Mode Tabs");

    ModTabs.MIKU_GROUP = Services.registry().creativeTabBuilder() // FabricItemGroup.builder()
        .icon(() -> new ItemStack(ModBlocks.MIKU_PLUSH))
        .title(Component.translatable("item.group.miku_plushies"))
        .displayItems((itemDisplayParameters, output) -> {
          ModItemsFabric.REGULAR_ITEMS.forEach(output::accept);
          ModItemsFabric.PLUSH_ITEMS.forEach(output::accept);
          ModItemsFabric.PICKAXE_ITEMS.forEach(output::accept);
        })
        .build();

    //REGISTER ITEM GROUP
    Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ModTabs.MIKU_GROUP_KEY, ModTabs.MIKU_GROUP);
  }
}
