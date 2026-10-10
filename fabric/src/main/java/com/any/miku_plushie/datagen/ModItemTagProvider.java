package com.any.miku_plushie.datagen;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.entity.AbstractPlushEntity;
import com.any.miku_plushie.impl.common.registry.ModItems;
import com.any.miku_plushie.registry.ModEntities;
import com.any.miku_plushie.util.ModUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

  public static final TagKey<Item> PLUSHIES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "plushies"));
  public static final TagKey<Item> TETO_PICKAXE = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "teto_pickaxe"));
  public static List<TagKey<Item>> PLUSH_TAGS = new ArrayList<>();

  public ModItemTagProvider(FabricDataOutput output,
      CompletableFuture<HolderLookup.Provider> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider wrapperLookup) {

    List<EntityType<? extends AbstractPlushEntity>> plushEntities = ModEntities.PLUSH_ENTITIES;

    for (EntityType<?> plushEntity : plushEntities) {
      String plushName = plushEntity.toShortString();
      PLUSH_TAGS.add(
          TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, plushName))
      );
    }

    //ADD PLUSHIES TO RESPECTIVE TAGS
    for (int plush = 0; plush < ModItems.PLUSH_ITEMS.size(); plush++) {
      String plushName = ModUtil.getBlockIdFromItem(ModItems.PLUSH_ITEMS.get(plush));
      String plushTagName;
      for (TagKey<Item> tag : PLUSH_TAGS) {
        plushTagName = tag.location().toString().split(":")[1];
        if (plushName.contains(plushTagName)) {
          tag(tag).add(reverseLookup(ModItems.PLUSH_ITEMS.get(plush)));
        }
      }
    }

    //ADD PICKAXES TO THEIR OWN TAG
    for (Item pickaxe : ModItems.PICKAXE_ITEMS) {
      tag(TETO_PICKAXE).add(reverseLookup(pickaxe));
      tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(reverseLookup(pickaxe));
      tag(ItemTags.PICKAXES).add(reverseLookup(pickaxe));
    }

    for (TagKey<Item> tag : PLUSH_TAGS) {
      tag(PLUSHIES).addOptionalTag(tag.location());
    }

  }
}
