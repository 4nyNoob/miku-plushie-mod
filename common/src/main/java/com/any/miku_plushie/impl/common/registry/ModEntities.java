package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.impl.common.entity.AbstractPlushEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;

public class ModEntities {

  public static final float PLUSH_WIDTH = 0.6F;
  public static final float PLUSH_HEIGHT = 1F;
  /// hm TODO extends AbstractPlushEntity
  public static final List<EntityType<? extends AbstractPlushEntity>> PLUSH_ENTITIES = new ArrayList<>();
  public static EntityType<TamableAnimal> TAMABLE_RAW_HOLDER; // TODO REPLACE / REMOVE
  public static EntityType<TamableAnimal> MIKU;
  public static EntityType<TamableAnimal> TETO;
  public static EntityType<TamableAnimal> AIKO;
  public static EntityType<TamableAnimal> NERU;
  public static EntityType<TamableAnimal> RIN;
  public static EntityType<TamableAnimal> LEN;
  public static EntityType<TamableAnimal> KONOHA;
  public static EntityType<TamableAnimal> LUKA;
  public static EntityType<TamableAnimal> MEIKO;
  public static EntityType<TamableAnimal> GUMI;
  public static EntityType<TamableAnimal> KAITO;

  public static void register(BiConsumer<EntityType<?>, ResourceLocation> consumer) {}
}
