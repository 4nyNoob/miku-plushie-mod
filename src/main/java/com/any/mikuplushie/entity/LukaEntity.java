package com.any.mikuplushie.entity;

import com.any.mikuplushie.entity.variant.LukaVariant;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

public class LukaEntity extends AbstractPlushEntity {

    private static final TrackedData<Integer> LUKA_VARIANT = DataTracker.registerData(LukaEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public LukaEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    //TRACK VARIANT
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(LUKA_VARIANT, 0);
    }

    //LUKA VARIANTS
    public String getVariant() {
        return LukaVariant.byId(this.getTypeVariant()).getBlock();
    }

    private int getTypeVariant() {
        return this.dataTracker.get(LUKA_VARIANT);
    }

    public void setVariant(LukaVariant variant) {
        this.dataTracker.set(LUKA_VARIANT, variant.getId()/* & 255*/);
    }

    public void setVariantByBlock(String variant) {
        for (int variation = 0; variation < LukaVariant.values().length; variation++) {
            if (LukaVariant.byId(variation).getBlock().equals(variant))
                this.dataTracker.set(LUKA_VARIANT, variation);
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(LUKA_VARIANT, nbt.getInt("Variant"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }
}
