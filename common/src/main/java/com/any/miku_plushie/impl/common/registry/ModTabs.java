package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushie;
import com.any.miku_plushie.platform.Services;
import java.util.function.BiConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {

  public static CreativeModeTab MIKU_GROUP;

  public static void register(BiConsumer<CreativeModeTab, ResourceLocation> consumer) {

    Constants.LOG.info("Registering " + Constants.MOD_ID + " Creative Mode Tabs");

    ModTabs.MIKU_GROUP = Services.registry().creativeTabBuilder() // FabricItemGroup.builder()
        .icon(() -> new ItemStack(ModBlocks.MIKU_PLUSH))
        .title(Component.translatable("item.group.miku_plushies"))
        .displayItems((itemDisplayParameters, output) -> {
          ModItems.REGULAR_ITEMS.forEach(output::accept);
          ModItems.PLUSH_ITEMS.forEach(output::accept);
          ModItems.PICKAXE_ITEMS.forEach(output::accept);
        })
        .build();

    consumer.accept(MIKU_GROUP, MikuPlushie.id("item_group"));
  }
}
