package com.any.mikuplushie.entity;

import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.entity.variant.NeruVariant;
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

public class NeruEntity extends MikuEntity{
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final TrackedData<Integer> NERU_VARIANT = DataTracker.registerData(NeruEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public NeruEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    //MC ENTITY STUFF
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(NERU_VARIANT, 0);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        NeruVariant variant = Util.getRandom(NeruVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSoundEvents.NERU_BYE;
    }

    //NERU VARIANTS

    public NeruVariant getNeruVariant() {
        return NeruVariant.byId(this.getTypeVariant());
    }

    private int getTypeVariant() {
        return this.dataTracker.get(NERU_VARIANT);
    }

    public void setVariant(NeruVariant variant) {
        this.dataTracker.set(NERU_VARIANT, variant.getId());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(NERU_VARIANT, nbt.getInt("Variant"));
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
