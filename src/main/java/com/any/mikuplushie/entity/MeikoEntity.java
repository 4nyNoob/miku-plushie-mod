package com.any.mikuplushie.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class MeikoEntity extends AbstractPlushEntity {

    public MeikoEntity(EntityType<? extends TamableAnimal> entityType, Level world) {
        super(entityType, world);
    }

}
