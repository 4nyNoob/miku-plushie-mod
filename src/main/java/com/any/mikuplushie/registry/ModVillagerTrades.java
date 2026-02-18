package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

public class ModVillagerTrades {
    public static void initialize(){

        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Villager Trades");

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
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
        });

        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            //RANDOM PLUSH TRADE
            factories.add((entity, random) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.PLUSH_ITEMS.get(random.nextInt(ModItems.PLUSH_ITEMS.size())), 1),
                6, 2, 0.02f
            ));
        });

    }
}
