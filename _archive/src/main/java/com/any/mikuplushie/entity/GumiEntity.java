package com.any.mikuplushie.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;

public class GumiEntity extends AbstractPlushEntity {

    public GumiEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

}
