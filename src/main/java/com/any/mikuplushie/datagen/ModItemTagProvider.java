package com.any.mikuplushie.datagen;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.AbstractPlushEntity;
import com.any.mikuplushie.registry.ModEntities;
import com.any.mikuplushie.registry.ModItems;
import com.any.mikuplushie.util.ModUtil;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output,
                              CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Item> PLUSHIES = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "plushies"));
    public static final TagKey<Item> TETO_PICKAXE = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "teto_pickaxe"));

    public static List<TagKey<Item>> PLUSH_TAGS = new ArrayList<>();

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        List<EntityType<? extends AbstractPlushEntity>> plushEntities = ModEntities.PLUSH_ENTITIES;

        for (EntityType<?> plushEntity : plushEntities){
            String plushName = plushEntity.getUntranslatedName();
            PLUSH_TAGS.add(
                TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, plushName))
            );
        }

        //ADD PLUSHIES TO RESPECTIVE TAGS
        for (int plush = 0; plush < ModItems.PLUSH_ITEMS.size(); plush++) {
            String plushName = ModUtil.getBlockIdFromItem(ModItems.PLUSH_ITEMS.get(plush));
            String plushTagName;
            for (TagKey<Item> tag : PLUSH_TAGS) {
                plushTagName = tag.id().toString().split(":")[1];
                if (plushName.contains(plushTagName)){
                    getOrCreateTagBuilder(tag).add(ModItems.PLUSH_ITEMS.get(plush));
                }
            }
        }

        //ADD PICKAXES TO THEIR OWN TAG
        for (Item pickaxe : ModItems.PICKAXE_ITEMS){
            getOrCreateTagBuilder(TETO_PICKAXE).add(pickaxe);
            getOrCreateTagBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES).add(pickaxe);
            getOrCreateTagBuilder(ItemTags.PICKAXES).add(pickaxe);
        }

        for (TagKey<Item> tag : PLUSH_TAGS){
            getOrCreateTagBuilder(PLUSHIES).addOptionalTag(tag);
        }

    }
}
