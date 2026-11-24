package com.any.miku_plushie.impl.common.datagen;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.impl.common.registry.ModEntities;
import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModEntityTagProvider extends FabricTagsProvider.EntityTypeTagsProvider {

  public static final TagKey<EntityType<?>> PLUSH_ENTITY = TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Constants.MOD_ID, "plush_entity"));

  public ModEntityTagProvider(FabricPackOutput output,
                              CompletableFuture<HolderLookup.Provider> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider wrapperLookup) {
    //REGISTER PLUSH ENTITY TYPE TAG AUTOMATICALLY
    for (EntityType<?> plush : ModEntities.PLUSH_ENTITIES) {
      valueLookupBuilder(PLUSH_ENTITY).add(plush);
    }
  }
}
