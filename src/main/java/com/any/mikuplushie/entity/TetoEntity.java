package com.any.mikuplushie.entity;

import com.any.mikuplushie.entity.variant.TetoVariant;
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

public class TetoEntity extends AbstractPlushEntity {

    private static final TrackedData<Integer> TETO_VARIANT = DataTracker.registerData(TetoEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final List<RawAnimation> DANCES = List.of(
        RawAnimation.begin().thenLoop("misc.dance.generic.caramelldansen"),
        RawAnimation.begin().thenLoop("misc.dance.teto.teto-territory"),
        RawAnimation.begin().thenLoop("misc.dance.teto.birdbrain"),
        RawAnimation.begin().thenLoop("misc.dance.teto.liar-dancer")
    );

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
                    RawAnimation currentAnimation = state.getController().getCurrentRawAnimation();
                    for (RawAnimation animation : DANCES){
                        if (currentAnimation.equals(animation)){
                            return state.setAndContinue(animation);
                        }
                    }
                    return state.setAndContinue(DANCES.get(this.random.nextBetweenExclusive(
                        0, DANCES.size()-1)
                    ));
                }
                //ATTACKING
                else if (this.handSwinging) {
                    RawAnimation currentAnimation = state.getController().getCurrentRawAnimation();
                    for (RawAnimation animation : ATTACK_ANIMATIONS){
                        if (currentAnimation.equals(animation)){
                            return state.setAndContinue(animation);
                        }
                    }
                    return state.setAndContinue(ATTACK_ANIMATIONS.get(this.random.nextBetweenExclusive(
                        0, ATTACK_ANIMATIONS.size()-1)
                    ));
                }
                //IDLE
                else {
                    return state.setAndContinue(AbstractPlushEntity.IDLE);
                }
            }
        }));

    }

    //TRACK VARIANT
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(TETO_VARIANT, 0);
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
