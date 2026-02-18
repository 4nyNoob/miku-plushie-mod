package com.any.mikuplushie.datagen;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.AbstractPlushEntity;
import com.any.mikuplushie.registry.ModEntities;
import com.any.mikuplushie.registry.ModItems;
import com.any.mikuplushie.util.ModUtil;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output,
                              CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Item> PLUSHIES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "plushies"));
    public static final TagKey<Item> TETO_PICKAXE = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "teto_pickaxe"));

    public static List<TagKey<Item>> PLUSH_TAGS = new ArrayList<>();

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {

        List<EntityType<? extends AbstractPlushEntity>> plushEntities = ModEntities.PLUSH_ENTITIES;

        for (EntityType<?> plushEntity : plushEntities){
            String plushName = plushEntity.toShortString();
            PLUSH_TAGS.add(
                TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, plushName))
            );
        }

        //ADD PLUSHIES TO RESPECTIVE TAGS
        for (int plush = 0; plush < ModItems.PLUSH_ITEMS.size(); plush++) {
            String plushName = ModUtil.getBlockIdFromItem(ModItems.PLUSH_ITEMS.get(plush));
            String plushTagName;
            for (TagKey<Item> tag : PLUSH_TAGS) {
                plushTagName = tag.location().toString().split(":")[1];
                if (plushName.contains(plushTagName)){
                    tag(tag).add();
                }
            }
        }

        //ADD PICKAXES TO THEIR OWN TAG
        for (Item pickaxe : ModItems.PICKAXE_ITEMS){
            tag(TETO_PICKAXE).add();
            tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add();
            tag(ItemTags.PICKAXES).add();
        }

        for (TagKey<Item> tag : PLUSH_TAGS){
            tag(PLUSHIES).addOptionalTag(tag.location());
        }

    }
}
