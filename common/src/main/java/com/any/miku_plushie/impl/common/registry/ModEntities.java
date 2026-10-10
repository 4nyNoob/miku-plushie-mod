package com.any.miku_plushie.impl.common.registry;

import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;

public class ModEntities {

  public static final float PLUSH_WIDTH = 0.6F;
  public static final float PLUSH_HEIGHT = 1F;
  public static EntityType<TamableAnimal> TAMABLE_RAW_HOLDER; // TODO REPLACE / REMOVE

  public static void register(BiConsumer<EntityType<?>, ResourceLocation> consumer) {}
}
