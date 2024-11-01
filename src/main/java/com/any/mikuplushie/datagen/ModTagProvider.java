package com.any.mikuplushie.datagen;

import com.any.mikuplushie.MikuPlushie;
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

    public static final TagKey<Item> BR_MIKU_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "br_miku_plush"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BR_MIKU_ITEMS)
                .add(ModItems.MIKU_PLUSH_BR)
                .add(ModItems.MIKU_PLUSH_BR_BA)
                .add(ModItems.MIKU_PLUSH_BIK)
                .add(ModItems.MIKU_PLUSH_BR_BEACH)
                .add(ModItems.MIKU_PLUSH_BR_BRAID)
                .add(ModItems.MIKU_PLUSH_BR_BA_DRUM)
                .add(ModItems.MIKU_PLUSH_BR_PA)
                .add(ModItems.MIKU_PLUSH_BR_SP)
                .add(ModItems.MIKU_PLUSH_BR_MG)
                .add(ModItems.MIKU_PLUSH_BR_BROWN_BRO)
                .add(ModItems.MIKU_PLUSH_BR_ELECTRICIAN)
                .add(ModItems.MIKU_PLUSH_BR_BIK_ORANGE)
                .add(ModItems.MIKU_PLUSH_BR_AM)
                .add(ModItems.MIKU_PLUSH_BR_FUT_FLA)
                .add(ModItems.MIKU_PLUSH_BR_FUT_CAM)
                .add(ModItems.MIKU_PLUSH_BR_GO)
                .add(ModItems.MIKU_PLUSH_BR_SCHOOL_PE)
                .add(ModItems.MIKU_PLUSH_BR_FUT_CRVG)
                .add(ModItems.MIKU_PLUSH_BR_RS)
                .add(ModItems.MIKU_PLUSH_FROG)
                .add(ModItems.MIKU_PLUSH_MUSHROOM)
                .add(ModItems.MIKU_PLUSH_SENBONZAKURA)
                .add(ModItems.MIKU_PLUSH_URAOTOMELOVERS)
                .add(ModItems.MIKU_PLUSH_PERSONADANCING)
                .add(ModItems.MIKU_PLUSH_HELLOPLANET)
                .add(ModItems.MIKU_PLUSH_HACHUNE)
                .add(ModItems.MIKU_PLUSH_ZATSUNE)
                .add(ModItems.MIKU_PLUSH_INFINITY)
                .add(ModItems.MIKU_PLUSH_VAMPIRE)
                .add(ModItems.MIKU_PLUSH_WEREWOMAN)
                .add(ModItems.MIKU_PLUSH_JASON)
                .add(ModItems.MIKU_PLUSH_MICHAEL_MYERS)
                .add(ModItems.MIKU_PLUSH_PUMPKIN)
                .add(ModItems.MIKU_PLUSH_GHOSTFACE)
                .add(ModItems.MIKU_PLUSH_FRANKENSTEIN)
                .add(ModItems.MIKU_PLUSH_MUMMY)
                .add(ModItems.MIKU_PLUSH_GHOST)
                .add(ModItems.MIKU_PLUSH_PATATI)
                .add(ModItems.MIKU_PLUSH_PATATA)
                .add(ModItems.MIKU_PLUSH_DEVIL)
                .add(ModItems.MIKU_PLUSH_WITCH)
        ;
    }
}
