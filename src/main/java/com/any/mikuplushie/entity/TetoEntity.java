package com.any.mikuplushie.entity;

import com.any.mikuplushie.registry.ModItems;
import com.any.mikuplushie.entity.goals.MikuDelayedAttackGoal;
import com.any.mikuplushie.entity.variant.TetoVariant;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

public class TetoEntity extends AbstractPlushEntity {

    private static final TrackedData<Integer> TETO_VARIANT = DataTracker.registerData(TetoEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final List<RawAnimation> DANCES = List.of(
        RawAnimation.begin().thenLoop("misc.dance.generic.caramelldansen"),
        RawAnimation.begin().thenLoop("misc.dance.teto.teto-territory"),
        RawAnimation.begin().thenLoop("misc.dance.teto.birdbrain"),
        RawAnimation.begin().thenLoop("misc.dance.teto.liar-dancer")
    );
    private static final RawAnimation SWIPE = RawAnimation.begin().thenPlay("attack.swipe");
    private static final RawAnimation SWIPE2 = RawAnimation.begin().thenPlay("attack.swipe2");
    private static final RawAnimation SWIPE3 = RawAnimation.begin().thenPlay("attack.swipe3");

    private static RawAnimation SELECTED_DANCE = DANCES.get(0);
    private static RawAnimation SELECTED_ATTACK = SWIPE;

    public TetoEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    //ANIMATION CONTROLLER
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Plush", 2, state -> {

            //SITTING ANIMATIONS
            if (this.isInSittingPose()) {
                //SONG PLAYING NEARBY
                if (this.isSongPlaying()){
                    return state.setAndContinue(AbstractPlushEntity.SIT_DANCE);
                } else {
                    return state.setAndContinue(AbstractPlushEntity.SIT);
                }
            }

            //STANDING UP ANIMATIONS
            else {
                //SPAWN ANIMATION
                if (this.age < 10){
                    return state.setAndContinue(AbstractPlushEntity.SPAWN);
                }
                //DANCE
                else if (this.isSongPlaying()){
                    return state.setAndContinue(SELECTED_DANCE);
                }
                //ATTACKING
                else if (this.handSwinging) {
                    return state.setAndContinue(SELECTED_ATTACK);
                }
                //IDLE
                else {
                    return state.setAndContinue(AbstractPlushEntity.IDLE);
                }
            }
        }));

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
        this.dataTracker.startTracking(TETO_VARIANT, 0);
    }

    //SELECT RANDOM DANCE
    @Override
    public void setNearbySongPlaying(BlockPos songPosition, boolean playing) {
        this.songSource = songPosition;
        this.songPlaying = playing;
        int randomDance = this.random.nextInt(DANCES.size());
        SELECTED_DANCE = DANCES.get(randomDance);
    }

    //TETO VARIANTS
    public String getVariant() {
        return TetoVariant.byId(this.getTypeVariant()).getBlock();
    }

    private int getTypeVariant() {
        return this.dataTracker.get(TETO_VARIANT);
    }

    public void setVariant(TetoVariant variant) {
        this.dataTracker.set(TETO_VARIANT, variant.getId()/* & 255*/);
    }

    public void setVariantByBlock(String variant) {
        for (int variation = 0; variation < TetoVariant.values().length; variation++) {
            if (TetoVariant.byId(variation).getBlock().equals(variant))
                this.dataTracker.set(TETO_VARIANT, variation);
        }
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
}
