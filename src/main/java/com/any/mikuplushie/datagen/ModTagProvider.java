package com.any.mikuplushie.datagen;

import com.any.mikuplushie.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModTagProvider(FabricDataOutput output,
                          CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Item> BR_MIKU_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of("miku-plushie", "br_miku_plush"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BR_MIKU_ITEMS)
                .add(ModItems.MIKU_PLUSH_BR)
                .add(ModItems.MIKU_PLUSH_BR_BA)
                .add(ModItems.MIKU_PLUSH_BIK)
                .add(ModItems.MIKU_PLUSH_BR_BEACH)
                .add(ModItems.MIKU_PLUSH_BR_BRAID)
                .add(ModItems.MIKU_PLUSH_BR_BA_DRUM)
                .add(ModItems.MIKU_PLUSH_BR_PR)
                .add(ModItems.MIKU_PLUSH_BR_SP)
                .add(ModItems.MIKU_PLUSH_BR_MG);
    }
}
