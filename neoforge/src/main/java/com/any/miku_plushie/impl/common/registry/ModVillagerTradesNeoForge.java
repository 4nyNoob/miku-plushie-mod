package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.impl.common.registry.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

public class ModVillagerTradesNeoForge {

  public static void initialize() {

    Constants.LOG.info("Registering " + Constants.MOD_ID + " Villager Trades");

    NeoForge.EVENT_BUS.addListener((VillagerTradesEvent event) -> {
      if (event.getType() == VillagerProfession.FARMER) {
        var factories = event.getTrades().get(1);
        //BUY LEEK SEEDS
        factories.add((entity, random) -> new MerchantOffer(
            new ItemCost(Items.EMERALD, 1),
            new ItemStack(ModItems.LEEK_SEEDS, 3), 6, 2, 0.02f
        ));
        //SELL LEEK
        factories.add((entity, random) -> new MerchantOffer(
            new ItemCost(ModItems.LEEK, 16),
            new ItemStack(Items.EMERALD, 1), 6, 2, 0.02f
        ));
      }
    });

    NeoForge.EVENT_BUS.addListener((WandererTradesEvent event) -> {
      //RANDOM PLUSH TRADE
      event.getGenericTrades().add((entity, random) -> new MerchantOffer(
          new ItemCost(Items.EMERALD, 1),
          new ItemStack(ModItems.PLUSH_ITEMS.get(random.nextInt(ModItems.PLUSH_ITEMS.size())), 1),
          6, 2, 0.02f
      ));
    });

  }
}
