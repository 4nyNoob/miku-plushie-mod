package com.any.miku_plushie.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class RinEntity extends AbstractPlushEntity {

  public RinEntity(EntityType<? extends TamableAnimal> entityType, Level world) {
    super(entityType, world);
  }

}
