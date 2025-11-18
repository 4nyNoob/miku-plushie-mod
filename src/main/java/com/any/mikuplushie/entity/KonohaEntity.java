package com.any.mikuplushie.entity;

import com.any.mikuplushie.ModSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

public class KonohaEntity extends MikuEntity{
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public KonohaEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    //MC ENTITY STUFF
    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return null;
    }

    //GECKO LIB STUFF
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
