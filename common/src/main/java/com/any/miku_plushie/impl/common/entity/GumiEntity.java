package com.any.miku_plushie.impl.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class GumiEntity extends AbstractPlushEntity {

  public GumiEntity(EntityType<? extends TamableAnimal> entityType, Level world) {
    super(entityType, world);
  }

}
