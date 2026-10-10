package com.any.miku_plushie.datagen;

import com.any.miku_plushie.MikuPlushieFabric;
import com.any.miku_plushie.registry.ModEntities;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {

  public static final TagKey<EntityType<?>> PLUSH_ENTITY = TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MikuPlushieFabric.MOD_ID, "plush_entity"));

  public ModEntityTagProvider(FabricDataOutput output,
      CompletableFuture<HolderLookup.Provider> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider wrapperLookup) {
    //REGISTER PLUSH ENTITY TYPE TAG AUTOMATICALLY
    for (EntityType<?> plush : ModEntities.PLUSH_ENTITIES) {
      tag(PLUSH_ENTITY).add(reverseLookup(plush));
    }
  }
}
