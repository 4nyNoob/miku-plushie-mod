package com.any.mikuplushie.entity;

import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.entity.variant.MikuVariant;
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

public class TetoEntity extends MikuEntity{
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final TrackedData<Integer> TETO_VARIANT = DataTracker.registerData(TetoEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public TetoEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    //MC ENTITY STUFF
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(TETO_VARIANT, 0);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        TetoVariant variant = Util.getRandom(TetoVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSoundEvents.TETO_BYE;
    }

    //TETO VARIANTS

    public TetoVariant getTetoVariant() {
        return TetoVariant.byId(this.getTypeVariant()/* & 255*/);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(TETO_VARIANT);
    }

    public void setVariant(TetoVariant variant) {
        this.dataTracker.set(TETO_VARIANT, variant.getId()/* & 255*/);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(TETO_VARIANT, nbt.getInt("Variant"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }

    //GECKO LIB STUFF
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
