package com.any.mikuplushie.entity;

import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.entity.variant.TetoVariant;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

public class AikoEntity extends MikuEntity{
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public AikoEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    //MC ENTITY STUFF
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSoundEvents.AIKO_BYE;
    }

    //GECKO LIB STUFF
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
