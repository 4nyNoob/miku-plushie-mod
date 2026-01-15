package com.any.mikuplushie.entity;

import com.any.mikuplushie.entity.variant.GumiVariant;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

public class GumiEntity extends AbstractPlushEntity {

    private static final TrackedData<Integer> GUMI_VARIANT = DataTracker.registerData(GumiEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public GumiEntity(EntityType<? extends TameableEntity> entityType, World world) {
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
        this.dataTracker.startTracking(GUMI_VARIANT, 0);
    }

    //GUMI VARIANTS
    public String getVariant() {
        return GumiVariant.byId(this.getTypeVariant()).getBlock();
    }

    private int getTypeVariant() {
        return this.dataTracker.get(GUMI_VARIANT);
    }

    public void setVariant(GumiVariant variant) {
        this.dataTracker.set(GUMI_VARIANT, variant.getId()/* & 255*/);
    }

    public void setVariantByBlock(String variant) {
        for (int variation = 0; variation < GumiVariant.values().length; variation++) {
            if (GumiVariant.byId(variation).getBlock().equals(variant))
                this.dataTracker.set(GUMI_VARIANT, variation);
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(GUMI_VARIANT, nbt.getInt("Variant"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }
}
