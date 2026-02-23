package com.any.mikuplushie.entity;

import com.any.mikuplushie.entity.goals.EatLeekGoal;
import com.any.mikuplushie.registry.ModBlocks;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class MikuEntity extends AbstractPlushEntity {

    private static final int MAX_LEEK_TIMER = 40;
    private int eatLeekTimer;
    public boolean eatingLeek;

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation EAT = RawAnimation.begin().thenPlay("misc.eat");

    public MikuEntity(EntityType<? extends TamableAnimal> entityType, Level world) {
        super(entityType, world);
    }

    //GOALS AND ATTRIBUTES
    @Override
    public void registerGoals() {
        super.registerGoals();
        EatLeekGoal eatLeekGoal = new EatLeekGoal(this);
        this.goalSelector.addGoal(5, eatLeekGoal);
    }

    //DANCE ANIMATIONS
    @Override
    public List<RawAnimation> getDances() {
        return List.of(
            RawAnimation.begin().thenLoop("misc.dance.generic.caramelldansen"),
            RawAnimation.begin().thenLoop("misc.dance.miku.miku"),
            RawAnimation.begin().thenLoop("misc.dance.miku.ievan-polkka"),
            RawAnimation.begin().thenLoop("misc.dance.miku.vegetable-juice"),
            RawAnimation.begin().thenLoop("misc.dance.miku.static")
        );
    }

    //ANIMATION CONTROLLER
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        super.registerControllers(controllers);
        controllers.add(new AnimationController<>("miku_eat", 2, state -> {
            if (!this.isInSittingPose() && this.isEatingLeek()){
                return state.setAndContinue(EAT);
            }
            return PlayState.STOP;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

//    //UPDATE EAT LEEK GOAL
//    @Override
//    public void aiStep() {
//        super.aiStep();
//
////        //CLIENT LEEK EATING TIMER
////        if (this.level().isClientSide()){
////            //DECREASE LEEK TIMER UNTIL 0
////            this.eatLeekTimer = Math.max(0, this.eatLeekTimer -1);
////            //SET EATING LEEK TRUE IF THE COUNTER IS RUNNING
////            this.setEatingLeek(eatLeekTimer > 0);
////
////            //SPAWN EATING PARTICLES
////            if (eatLeekTimer > 0 && !this.isInSittingPose()) {
////                Vec3 mikuPos = this.position();
////                this.level().addParticle(
////                    new BlockParticleOption(ParticleTypes.BLOCK, ModBlocks.LEEK_CROP.getStateForAge(7)),
////                    mikuPos.x(),
////                    mikuPos.y() + 0.5D,
////                    mikuPos.z(),
////                    this.random.nextGaussian() * 0.5,
////                    this.random.nextGaussian() * 0.5,
////                    this.random.nextGaussian() * 0.5
////                );
////            }
////
////        }
//    }

    //SET LEEK TIMER 40 TICKS WHEN LEEK EATING STATUS IS TRUE
    @Override
    public void handleEntityEvent(byte status) {
        if (status == 10){
            this.eatLeekTimer = MAX_LEEK_TIMER;
        } else {
            super.handleEntityEvent(status);
        }
    }

    //EATING LEEK GETTER AND SETTER
    public boolean isEatingLeek(){
        return this.eatingLeek;
    }

    public void setEatingLeek(boolean eatingLeek){
        this.eatingLeek = eatingLeek;
    }

}
