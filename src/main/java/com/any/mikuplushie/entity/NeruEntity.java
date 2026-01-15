package com.any.mikuplushie.entity;

import com.any.mikuplushie.entity.variant.NeruVariant;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

public class NeruEntity extends AbstractPlushEntity {

    private static final TrackedData<Integer> NERU_VARIANT = DataTracker.registerData(NeruEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public NeruEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    //DANCE ANIMATIONS
    @Override
    public List<RawAnimation> getDances() {
        return List.of(
            RawAnimation.begin().thenLoop("misc.dance.generic.caramelldansen"),
            RawAnimation.begin().thenLoop("misc.dance.miku.ievan-polkka"),
            RawAnimation.begin().thenLoop("misc.dance.miku.vegetable-juice")
        );
    }

    //TRACK VARIANT
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(NERU_VARIANT, 0);
    }

    //NERU VARIANTS
    public String getVariant() {
        return NeruVariant.byId(this.getTypeVariant()).getBlock();
    }

    private int getTypeVariant() {
        return this.dataTracker.get(NERU_VARIANT);
    }

    public void setVariant(NeruVariant variant) {
        this.dataTracker.set(NERU_VARIANT, variant.getId()/* & 255*/);
    }

    public void setVariantByBlock(String variant) {
        for (int variation = 0; variation < NeruVariant.values().length; variation++) {
            if (NeruVariant.byId(variation).getBlock().equals(variant))
                this.dataTracker.set(NERU_VARIANT, variation);
        }
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
}
