package com.any.mikuplushie.datagen;

import com.any.mikuplushie.MikuPlushie;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModTagProvider extends ItemTagsProvider {
    public static final TagKey<Item> MIKU_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "miku_plushie"));
    public static final TagKey<Item> AIKO_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "aiko_plushie"));
    public static final TagKey<Item> TETO_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "teto_plushie"));
    public static final TagKey<Item> AKITA_NERU_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "akita_neru_plushie"));
    public static final TagKey<Item> RIN_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "rin_plushie"));
    public static final TagKey<Item> LEN_PLUSH = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "len_plushie"));
    public static final TagKey<Item> TETO_PICKAXE = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "teto_pickaxe"));

    public ModTagProvider(
        PackOutput output,
        CompletableFuture<HolderLookup.Provider> lookupProvider,
        CompletableFuture<TagLookup<Block>> blockTags,
        @Nullable ExistingFileHelper existingFileHelper) {

        super(output, lookupProvider, blockTags, MikuPlushie.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
