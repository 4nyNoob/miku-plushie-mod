package com.any.mikuplushie.datagen;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModTagProvider extends BlockTagsProvider {
    public static final TagKey<Block> MIKU_PLUSH = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "miku_plushie"));
    public static final TagKey<Block> AIKO_PLUSH = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "aiko_plushie"));

    public ModTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(MIKU_PLUSH)
            .add(ModBlocks.MIKU_PLUSH_BR.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_BA.getKey())
            .add(ModBlocks.MIKU_PLUSH_BIK.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_BEACH.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_BRAID.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_BA_DRUM.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_PA.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_SP.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_MG.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_BROWN_BRO.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_AM.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_FUT_FLA.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_FUT_CAM.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_GO.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_FUT_CRVG.getKey())
            .add(ModBlocks.MIKU_PLUSH_BR_RS.getKey())
            .add(ModBlocks.MIKU_PLUSH_FROG.getKey())
            .add(ModBlocks.MIKU_PLUSH_MUSHROOM.getKey())
            .add(ModBlocks.MIKU_PLUSH_SENBONZAKURA.getKey())
            .add(ModBlocks.MIKU_PLUSH_URAOTOMELOVERS.getKey())
            .add(ModBlocks.MIKU_PLUSH_PERSONADANCING.getKey())
            .add(ModBlocks.MIKU_PLUSH_HELLOPLANET.getKey())
            .add(ModBlocks.MIKU_PLUSH_HACHUNE.getKey())
            .add(ModBlocks.MIKU_PLUSH_ZATSUNE.getKey())
            .add(ModBlocks.MIKU_PLUSH_INFINITY.getKey())
            .add(ModBlocks.MIKU_PLUSH_VAMPIRE.getKey())
            .add(ModBlocks.MIKU_PLUSH_WEREWOMAN.getKey())
            .add(ModBlocks.MIKU_PLUSH_JASON.getKey())
            .add(ModBlocks.MIKU_PLUSH_MICHAEL_MYERS.getKey())
            .add(ModBlocks.MIKU_PLUSH_PUMPKIN.getKey())
            .add(ModBlocks.MIKU_PLUSH_GHOSTFACE.getKey())
            .add(ModBlocks.MIKU_PLUSH_FRANKENSTEIN.getKey())
            .add(ModBlocks.MIKU_PLUSH_MUMMY.getKey())
            .add(ModBlocks.MIKU_PLUSH_PATATI.getKey())
            .add(ModBlocks.MIKU_PLUSH_PATATA.getKey())
            .add(ModBlocks.MIKU_PLUSH_DEVIL.getKey())
            .add(ModBlocks.MIKU_PLUSH_WITCH.getKey())
            .add(ModBlocks.MIKU_PLUSH_SANTA.getKey())
            .add(ModBlocks.MIKU_PLUSH_REINDEER.getKey())
            .add(ModBlocks.MIKU_PLUSH_SANTA_ELF.getKey())
            .add(ModBlocks.MIKU_PLUSH_XMAS_TREE.getKey());

        this.tag(AIKO_PLUSH)
            .add(ModBlocks.AIKO_PLUSH.getKey());
    }
}
