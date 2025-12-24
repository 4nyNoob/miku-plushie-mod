package com.any.mikuplushie.entity;

import com.any.mikuplushie.registry.ModItems;
import com.any.mikuplushie.entity.goals.MikuDelayedAttackGoal;
import com.any.mikuplushie.entity.variant.LukaVariant;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class LukaEntity extends AbstractPlushEntity {

    private static final TrackedData<Integer> LUKA_VARIANT = DataTracker.registerData(LukaEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation SWIPE = RawAnimation.begin().thenPlay("attack.swipe");
    private static final RawAnimation SWIPE2 = RawAnimation.begin().thenPlay("attack.swipe2");
    private static final RawAnimation SWIPE3 = RawAnimation.begin().thenPlay("attack.swipe3");
    private static RawAnimation SELECTED_ATTACK = SWIPE;

    public LukaEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    //RANDOM ATTACK ANIM
    @Override
    public void swingHand(Hand hand) {
        super.swingHand(hand);
        int randomAttack = this.random.nextBetween(1, 3);
        switch (randomAttack) {
            case 1: SELECTED_ATTACK = SWIPE; break;
            case 2: SELECTED_ATTACK = SWIPE2; break;
            case 3: SELECTED_ATTACK = SWIPE3; break;
        }
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
