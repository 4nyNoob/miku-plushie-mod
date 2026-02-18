package com.any.mikuplushie.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class KonohaEntity extends AbstractPlushEntity {

    public KonohaEntity(EntityType<? extends TamableAnimal> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return null;
    }
}
