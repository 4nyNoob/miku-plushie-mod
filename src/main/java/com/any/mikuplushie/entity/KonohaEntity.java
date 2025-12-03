package com.any.mikuplushie.entity;

import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.entity.goals.MikuDelayedAttackGoal;
import com.any.mikuplushie.entity.variant.KonohaVariant;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class KonohaEntity extends PlushEntity {

    private static final TrackedData<Integer> KONOHA_VARIANT = DataTracker.registerData(KonohaEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("misc.idle");
    private static final RawAnimation SIT = RawAnimation.begin().thenLoop("misc.sit");
    private static final RawAnimation SIT_DANCE = RawAnimation.begin().thenLoop("misc.sit-dance");
    private static final RawAnimation DANCE = RawAnimation.begin().thenLoop("misc.dance");
    private static final RawAnimation DANCE2 = RawAnimation.begin().thenLoop("misc.dance2");
    private static final RawAnimation DANCE3 = RawAnimation.begin().thenLoop("misc.dance3");
    private static final RawAnimation DANCE4 = RawAnimation.begin().thenLoop("misc.dance4");
    private static final RawAnimation DANCE5 = RawAnimation.begin().thenLoop("misc.dance5");
    private static final RawAnimation SWIPE = RawAnimation.begin().thenPlay("attack.swipe");
    private static final RawAnimation SWIPE2 = RawAnimation.begin().thenPlay("attack.swipe2");
    private static final RawAnimation SWIPE3 = RawAnimation.begin().thenPlay("attack.swipe3");

    private static RawAnimation SELECTED_DANCE = DANCE;
    private static RawAnimation SELECTED_ATTACK = SWIPE;
    
    public KonohaEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new MikuDelayedAttackGoal(this, 1.5F, true));
        this.goalSelector.add(4, new FollowOwnerGoal(this,1.0F, 5F, 1F, true));
        this.goalSelector.add(6, new TemptGoal(this, 1.5, Ingredient.ofItems(ModItems.CANUDINHO), false));
        this.goalSelector.add(7, new LookAtEntityGoal(this, MikuEntity.class, 8F));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8F));
        this.goalSelector.add(9, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
    }

    //ANIMATION CONTROLLER
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Miku", 2, state -> {

            //SIT OR DANCE WHEN SONG IS PLAYING NEARBY
            if (this.isInSittingPose()){
                return state.setAndContinue(this.isSongPlaying() ? SIT_DANCE : SIT);
            }

            else {
                //DANCE WHEN SONG IS PLAYING NEARBY
                if (this.isSongPlaying()){
                    return state.setAndContinue(SELECTED_DANCE);
                } else {
                    //ATTACK
                    if (this.handSwinging){
                        return state.setAndContinue(SELECTED_ATTACK);
                    }
                    //IDLE
                    else {
                        return state.setAndContinue(IDLE);
                    }
                }
            }
        }));

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
        this.dataTracker.startTracking(KONOHA_VARIANT, 0);
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return null;
    }

    //SELECT RANDOM DANCE
    @Override
    public void setNearbySongPlaying(BlockPos songPosition, boolean playing) {
        this.songSource = songPosition;
        this.songPlaying = playing;
        int randomDance = this.random.nextBetweenExclusive(1, 5);
        switch (randomDance) {
            case 1: SELECTED_DANCE = DANCE; break;
            case 2: SELECTED_DANCE = DANCE2; break;
            case 3: SELECTED_DANCE = DANCE3; break;
            case 4: SELECTED_DANCE = DANCE4; break;
            case 5: SELECTED_DANCE = DANCE5; break;
        }
    }

    //KONOHA VARIANTS
    public String getVariant() {
        return KonohaVariant.byId(this.getTypeVariant()).getBlock();
    }

    private int getTypeVariant() {
        return this.dataTracker.get(KONOHA_VARIANT);
    }

    public void setVariant(KonohaVariant variant) {
        this.dataTracker.set(KONOHA_VARIANT, variant.getId()/* & 255*/);
    }

    public void setVariantByBlock(String variant) {
        for (int variation = 0; variation < KonohaVariant.values().length; variation++) {
            if (KonohaVariant.byId(variation).getBlock().equals(variant))
                this.dataTracker.set(KONOHA_VARIANT, variation);
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(KONOHA_VARIANT, nbt.getInt("Variant"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }
}
