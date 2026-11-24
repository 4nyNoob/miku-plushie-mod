package com.any.miku_plushie.impl.common.datagen;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.impl.common.entity.AbstractPlushEntity;
import com.any.miku_plushie.impl.common.registry.ModEntities;
import com.any.miku_plushie.impl.common.registry.ModItems;
import com.any.miku_plushie.impl.common.util.ModItemTags;
import com.any.miku_plushie.impl.common.util.ModUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

  public static List<TagKey<Item>> PLUSH_TAGS = new ArrayList<>();

  public ModItemTagProvider(FabricPackOutput output,
                            CompletableFuture<HolderLookup.Provider> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider wrapperLookup) {

    List<EntityType<? extends AbstractPlushEntity>> plushEntities = ModEntities.PLUSH_ENTITIES;

    for (EntityType<?> plushEntity : plushEntities) {
      String plushName = plushEntity.toShortString();
      PLUSH_TAGS.add(
          TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Constants.MOD_ID, plushName))
      );
    }

    //ADD PLUSHIES TO RESPECTIVE TAGS
    for (int plush = 0; plush < ModItems.PLUSH_ITEMS.size(); plush++) {
      String plushName = ModUtil.getBlockIdFromItem(ModItems.PLUSH_ITEMS.get(plush));
      String plushTagName;
      for (TagKey<Item> tag : PLUSH_TAGS) {
        plushTagName = tag.location().toString().split(":")[1];
        if (plushName.contains(plushTagName)) {
          valueLookupBuilder(tag).add(ModItems.PLUSH_ITEMS.get(plush));
        }
      }
    }

    //ADD PICKAXES TO THEIR OWN TAG
    for (Item pickaxe : ModItems.PICKAXE_ITEMS) {
      valueLookupBuilder(ModItemTags.TETO_PICKAXE).add(pickaxe);
      valueLookupBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES).add(pickaxe);
      valueLookupBuilder(ItemTags.PICKAXES).add(pickaxe);
    }

    for (TagKey<Item> tag : PLUSH_TAGS) {
      valueLookupBuilder(ModItemTags.PLUSHIES).addOptionalTag(TagKey.create(Registries.ITEM, tag.location()));
    }

  }
}
