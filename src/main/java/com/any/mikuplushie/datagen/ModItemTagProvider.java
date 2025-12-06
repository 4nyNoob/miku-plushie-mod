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

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output,
                              CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Item> PLUSHIES = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "plushies"));
    public static final TagKey<Item> MIKU_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "miku_plush"));
    public static final TagKey<Item> AIKO_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "aiko_plush"));
    public static final TagKey<Item> TETO_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "teto_plush"));
    public static final TagKey<Item> TETO_PICKAXE = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "teto_pickaxe"));
    public static final TagKey<Item> NERU_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "neru_plush"));
    public static final TagKey<Item> RIN_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "rin_plush"));
    public static final TagKey<Item> LEN_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "len_plush"));
    public static final TagKey<Item> LUKA_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "luka_plush"));
    public static final TagKey<Item> KONOHA_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "konoha_plush"));
    public static final TagKey<Item> MEIKO_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "meiko_plush"));
    public static final TagKey<Item> GUMI_PLUSH = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "gumi_plush"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //ADD PLUSHIES TO RESPECTIVE TAGS
        for (Item plush : ModItems.PLUSH_ITEMS){
            String plushName = plush.getTranslationKey().split("[.]")[2];
            if (plushName.contains("miku_plush")){
                getOrCreateTagBuilder(MIKU_PLUSH).add(plush);
            }
            if (plushName.contains("aiko_plush")){
                getOrCreateTagBuilder(AIKO_PLUSH).add(plush);
            }
            if (plushName.contains("teto_plush")){
                getOrCreateTagBuilder(TETO_PLUSH).add(plush);
            }
            if (plushName.contains("akita_neru_plush")){
                getOrCreateTagBuilder(NERU_PLUSH).add(plush);
            }
            if (plushName.contains("rin_plush")){
                getOrCreateTagBuilder(RIN_PLUSH).add(plush);
            }
            if (plushName.contains("len_plush")){
                getOrCreateTagBuilder(LEN_PLUSH).add(plush);
            }
            if (plushName.contains("luka_plush")){
                getOrCreateTagBuilder(LUKA_PLUSH).add(plush);
            }
            if (plushName.contains("konoha_plush")){
                getOrCreateTagBuilder(KONOHA_PLUSH).add(plush);
            }
            if (plushName.contains("meiko_plush")){
                getOrCreateTagBuilder(MEIKO_PLUSH).add(plush);
            }
            if (plushName.contains("gumi_plush")){
                getOrCreateTagBuilder(GUMI_PLUSH).add(plush);
            }
        }

        //ADD PICKAXES TO THEIR OWN TAG
        for (Item pickaxe : ModItems.PICKAXE_ITEMS){
            getOrCreateTagBuilder(TETO_PICKAXE).add(pickaxe);
        }

        getOrCreateTagBuilder(PLUSHIES)
            .addOptionalTag(MIKU_PLUSH)
            .addOptionalTag(AIKO_PLUSH)
            .addOptionalTag(TETO_PLUSH)
            .addOptionalTag(NERU_PLUSH)
            .addOptionalTag(RIN_PLUSH)
            .addOptionalTag(LEN_PLUSH)
            .addOptionalTag(LUKA_PLUSH)
            .addOptionalTag(KONOHA_PLUSH)
            .addOptionalTag(MEIKO_PLUSH)
            .addOptionalTag(GUMI_PLUSH)
        ;

    }
}
