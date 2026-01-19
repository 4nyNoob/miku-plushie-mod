package com.any.mikuplushie.entity;

import com.any.mikuplushie.entity.variant.TetoVariant;
import com.any.mikuplushie.entity.variant.TetoVariants;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.Predicate;

public class TetoEntity extends AbstractPlushEntity {

//    private static final TrackedData<Integer> TETO_VARIANT = DataTracker.registerData(TetoEntity.class, TrackedDataHandlerRegistry.INTEGER);

//    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public TetoEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

//    @Override
//    public AnimatableInstanceCache getAnimatableInstanceCache() {
//        return this.cache;
//    }

    //DANCE ANIMATIONS
    @Override
    public List<RawAnimation> getDances(){
        return  List.of(
            RawAnimation.begin().thenLoop("misc.dance.generic.caramelldansen"),
            RawAnimation.begin().thenLoop("misc.dance.teto.teto-territory"),
            RawAnimation.begin().thenLoop("misc.dance.teto.birdbrain"),
            RawAnimation.begin().thenLoop("misc.dance.teto.liar-dancer")
        );
    }

//    //TRACK VARIANT
//    @Override
//    protected void initDataTracker() {
//        super.initDataTracker();
//        this.dataTracker.startTracking(TETO_VARIANT, 0);
//    }

    @Override
    protected List<String> getVariantList() {
        return TetoVariants.VARIANTS;
    }

//    @Override
//    protected TrackedData<Integer> getVariantDataTracker() {
//        return TETO_VARIANT;
//    }

    //TETO VARIANTS

//    private int getTypeVariant() {
//        return this.dataTracker.get(TETO_VARIANT);
//    }

//    public void setVariant(Integer variant) {
//        this.dataTracker.set(TETO_VARIANT, variant/* & 255*/);
//    }

//    public void setVariantByBlock(String variant) {
//        for (int variation = 0; variation < TetoVariants.VARIANTS.size(); variation++) {
//            if (TetoVariants.VARIANTS.get(variation).equals(variant))
//                this.dataTracker.set(this.getVariantDataTracker(), variation);
//        }
//    }

//    @Override
//    public void readCustomDataFromNbt(NbtCompound nbt) {
//        super.readCustomDataFromNbt(nbt);
//        this.dataTracker.set(TETO_VARIANT, nbt.getInt("Variant"));
//    }
//
//    @Override
//    public void writeCustomDataToNbt(NbtCompound nbt) {
//        super.writeCustomDataToNbt(nbt);
//        nbt.putInt("Variant", this.getTypeVariant());
//    }
}
