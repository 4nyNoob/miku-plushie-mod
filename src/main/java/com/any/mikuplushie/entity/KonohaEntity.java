package com.any.mikuplushie.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class KonohaEntity extends AbstractPlushEntity {

    public KonohaEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return null;
    }
}
