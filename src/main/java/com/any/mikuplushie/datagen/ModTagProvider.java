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

    public ModTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Item> BR_MIKU_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "br_miku_plush"));
    public static final TagKey<Item> AIKO_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "aiko_plush"));
    public static final TagKey<Item> TETO_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "teto_plush"));
    public static final TagKey<Item> TETO_PICKAXE = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "teto_pickaxe"));
    public static final TagKey<Item> AKITA_NERU_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "akita_neru_plush"));
    public static final TagKey<Item> RIN_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "rin_plush"));
    public static final TagKey<Item> LEN_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "len_plush"));

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
            .add(ModItems.MIKU_PLUSH_SANTA)
            .add(ModItems.MIKU_PLUSH_REINDEER)
            .add(ModItems.MIKU_PLUSH_SANTA_ELF)
            .add(ModItems.MIKU_PLUSH_XMAS_TREE)
            .add(ModItems.MIKU_PLUSH)
            .add(ModItems.MIKU_PLUSH_SONIC_CROSSWORLDS)
            .add(ModItems.MIKU_PLUSH_FORTNITE_NEKO)
            .add(ModItems.MIKU_PLUSH_V4)
            .add(ModItems.MIKU_PLUSH_MESMERIZER)
            .add(ModItems.MIKU_PLUSH_SONIC)
            .add(ModItems.MIKU_PLUSH_DIGITAL_STARS_2025)
            .add(ModItems.MIKU_PLUSH_ROTTEN_GIRL)
            .add(ModItems.MIKU_PLUSH_PSYCHO_MODE)
            .add(ModItems.MIKU_PLUSH_DONT_BELIEVE_IN_T)
        ;
        getOrCreateTagBuilder(AIKO_PLUSH)
            .add(ModItems.AIKO_PLUSH)
        ;
        getOrCreateTagBuilder(TETO_PLUSH)
            .add(ModItems.TETO_PLUSH)
            .add(ModItems.TETO_PLUSH_MESMERIZER)
            .add(ModItems.TETO_PLUSH_SHADOW)
            .add(ModItems.TETO_PLUSH_BIRDBRAIN)
            .add(ModItems.TETO_PLUSH_REGRET_ROCK)
            .add(ModItems.TETO_PLUSH_DONT_BELIEVE_IN_T)
        ;
        getOrCreateTagBuilder(TETO_PICKAXE)
            .add(ModItems.TETO_PICKAXE)
            .add(ModItems.TETO_PICKAXE_MESMERIZER)
            .add(ModItems.TETO_PICKAXE_BIRDBRAIN)
            .add(ModItems.TETO_PICKAXE_REGRET_ROCK)
            .add(ModItems.TETO_PICKAXE_DONT_BELIEVE_IN_T)
        ;
        getOrCreateTagBuilder(AKITA_NERU_PLUSH)
            .add(ModItems.AKITA_NERU_PLUSH)
            .add(ModItems.AKITA_NERU_PLUSH_TAILS)
        ;
        getOrCreateTagBuilder(RIN_PLUSH)
            .add(ModItems.RIN_PLUSH)
        ;
        getOrCreateTagBuilder(LEN_PLUSH)
            .add(ModItems.LEN_PLUSH)
        ;
    }
}
