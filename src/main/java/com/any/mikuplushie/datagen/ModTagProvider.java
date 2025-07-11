package com.any.mikuplushie.datagen;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModTagProvider extends ItemTagsProvider {
    public static final TagKey<Item> MIKU_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "miku_plushie"));
    public static final TagKey<Item> AIKO_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "aiko_plushie"));
    public static final TagKey<Item> TETO_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "teto_plushie"));
    public static final TagKey<Item> AKITA_NERU_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "akita_neru_plushie"));
    public static final TagKey<Item> RIN_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "rin_plushie"));
    public static final TagKey<Item> LEN_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "len_plushie"));
    public static final TagKey<Item> TETO_PICKAXE = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "teto_pickaxe"));

    public ModTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(MIKU_PLUSH)
            .add(ModItems.MIKU_PLUSH_BR.getKey())
            .add(ModItems.MIKU_PLUSH_BR_BA.getKey())
            .add(ModItems.MIKU_PLUSH_BIK.getKey())
            .add(ModItems.MIKU_PLUSH_BR_BEACH.getKey())
            .add(ModItems.MIKU_PLUSH_BR_BRAID.getKey())
            .add(ModItems.MIKU_PLUSH_BR_BA_DRUM.getKey())
            .add(ModItems.MIKU_PLUSH_BR_PA.getKey())
            .add(ModItems.MIKU_PLUSH_BR_SP.getKey())
            .add(ModItems.MIKU_PLUSH_BR_MG.getKey())
            .add(ModItems.MIKU_PLUSH_BR_BROWN_BRO.getKey())
            .add(ModItems.MIKU_PLUSH_BR_ELECTRICIAN.getKey())
            .add(ModItems.MIKU_PLUSH_BR_BIK_ORANGE.getKey())
            .add(ModItems.MIKU_PLUSH_BR_AM.getKey())
            .add(ModItems.MIKU_PLUSH_BR_FUT_FLA.getKey())
            .add(ModItems.MIKU_PLUSH_BR_FUT_CAM.getKey())
            .add(ModItems.MIKU_PLUSH_BR_GO.getKey())
            .add(ModItems.MIKU_PLUSH_BR_SCHOOL_PE.getKey())
            .add(ModItems.MIKU_PLUSH_BR_FUT_CRVG.getKey())
            .add(ModItems.MIKU_PLUSH_BR_RS.getKey())
            .add(ModItems.MIKU_PLUSH_FROG.getKey())
            .add(ModItems.MIKU_PLUSH_MUSHROOM.getKey())
            .add(ModItems.MIKU_PLUSH_SENBONZAKURA.getKey())
            .add(ModItems.MIKU_PLUSH_URAOTOMELOVERS.getKey())
            .add(ModItems.MIKU_PLUSH_PERSONADANCING.getKey())
            .add(ModItems.MIKU_PLUSH_HELLOPLANET.getKey())
            .add(ModItems.MIKU_PLUSH_HACHUNE.getKey())
            .add(ModItems.MIKU_PLUSH_ZATSUNE.getKey())
            .add(ModItems.MIKU_PLUSH_INFINITY.getKey())
            .add(ModItems.MIKU_PLUSH_VAMPIRE.getKey())
            .add(ModItems.MIKU_PLUSH_WEREWOMAN.getKey())
            .add(ModItems.MIKU_PLUSH_JASON.getKey())
            .add(ModItems.MIKU_PLUSH_MICHAEL_MYERS.getKey())
            .add(ModItems.MIKU_PLUSH_PUMPKIN.getKey())
            .add(ModItems.MIKU_PLUSH_GHOSTFACE.getKey())
            .add(ModItems.MIKU_PLUSH_FRANKENSTEIN.getKey())
            .add(ModItems.MIKU_PLUSH_MUMMY.getKey())
            .add(ModItems.MIKU_PLUSH_PATATI.getKey())
            .add(ModItems.MIKU_PLUSH_PATATA.getKey())
            .add(ModItems.MIKU_PLUSH_DEVIL.getKey())
            .add(ModItems.MIKU_PLUSH_WITCH.getKey())
            .add(ModItems.MIKU_PLUSH_SANTA.getKey())
            .add(ModItems.MIKU_PLUSH_REINDEER.getKey())
            .add(ModItems.MIKU_PLUSH_SANTA_ELF.getKey())
            .add(ModItems.MIKU_PLUSH_XMAS_TREE.getKey())
            .add(ModItems.MIKU_PLUSH.getKey())
            .add(ModItems.MIKU_PLUSH_SONIC_CROSSWORLDS.getKey())
            .add(ModItems.MIKU_PLUSH_FORTNITE_NEKO.getKey())
            .add(ModItems.MIKU_PLUSH_V4.getKey())
            .add(ModItems.MIKU_PLUSH_MESMERIZER.getKey())
            .add(ModItems.MIKU_PLUSH_SONIC.getKey())
            .add(ModItems.MIKU_PLUSH_DIGITAL_STARS_2025.getKey())
            .add(ModItems.MIKU_PLUSH_ROTTEN_GIRL.getKey())
            .add(ModItems.MIKU_PLUSH_PSYCHO_MODE.getKey())
            .add(ModItems.MIKU_PLUSH_DONT_BELIEVE_IN_T.getKey())
            .add(ModItems.MIKU_PLUSH_STATIC.getKey())
            .add(ModItems.MIKU_PLUSH_MOCHIMOCHI.getKey())
            .add(ModItems.MIKU_PLUSH_MONITORING.getKey())
        ;

        this.tag(AIKO_PLUSH)
            .add(ModItems.AIKO_PLUSH.getKey());

        this.tag(TETO_PLUSH)
            .add(ModItems.TETO_PLUSH.getKey())
            .add(ModItems.TETO_PLUSH_MESMERIZER.getKey())
            .add(ModItems.TETO_PLUSH_SHADOW.getKey())
            .add(ModItems.TETO_PLUSH_BIRDBRAIN.getKey())
            .add(ModItems.TETO_PLUSH_REGRET_ROCK.getKey())
            .add(ModItems.TETO_PLUSH_DONT_BELIEVE_IN_T.getKey())
            .add(ModItems.TETO_PLUSH_LIAR_DANCER.getKey())
            .add(ModItems.TETO_PLUSH_WHATCHACALLITSNAME.getKey())
        ;
        this.tag(TETO_PICKAXE)
            .add(ModItems.TETO_PICKAXE.getKey())
            .add(ModItems.TETO_PICKAXE_MESMERIZER.getKey())
            .add(ModItems.TETO_PICKAXE_BIRDBRAIN.getKey())
            .add(ModItems.TETO_PICKAXE_REGRET_ROCK.getKey())
            .add(ModItems.TETO_PICKAXE_DONT_BELIEVE_IN_T.getKey())
            .add(ModItems.TETO_PICKAXE_LIAR_DANCER.getKey())
            .add(ModItems.TETO_PICKAXE_WHATCHACALLITSNAME.getKey())
        ;
        this.tag(AKITA_NERU_PLUSH)
            .add(ModItems.AKITA_NERU_PLUSH.getKey())
            .add(ModItems.AKITA_NERU_PLUSH_TAILS.getKey())
        ;
        this.tag(RIN_PLUSH)
            .add(ModItems.RIN_PLUSH.getKey())
        ;
        this.tag(LEN_PLUSH)
            .add(ModItems.LEN_PLUSH.getKey())
        ;
    }
}
