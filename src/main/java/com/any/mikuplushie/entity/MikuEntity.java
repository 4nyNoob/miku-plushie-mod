package com.any.mikuplushie.entity;

import com.any.mikuplushie.entity.goals.EatLeekGoal;
import com.any.mikuplushie.entity.variant.MikuVariant;
import com.any.mikuplushie.registry.ModBlocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

public class MikuEntity extends AbstractPlushEntity {

    private static final TrackedData<Integer> MIKU_VARIANT = DataTracker.registerData(MikuEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private static final int MAX_LEEK_TIMER = 40;
    private int eatLeekTimer;
    public boolean eatingLeek;

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation EAT = RawAnimation.begin().thenPlay("misc.eat");

    public MikuEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    //GOALS AND ATTRIBUTES
    @Override
    public void initGoals() {
        super.initGoals();
        EatLeekGoal eatLeekGoal = new EatLeekGoal(this);
        this.goalSelector.add(5, eatLeekGoal);
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
        controllers.add(new AnimationController<>(this, "miku_eat", 2, state -> {
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

    //TRACK VARIANT
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(MIKU_VARIANT, 0);
    }

    //UPDATE EAT LEEK GOAL
    @Override
    public void tickMovement() {
        super.tickMovement();

        //CLIENT LEEK EATING TIMER
        if (this.getWorld().isClient){
            //DECREASE LEEK TIMER UNTIL 0
            this.eatLeekTimer = Math.max(0, this.eatLeekTimer -1);
            //SET EATING LEEK TRUE IF THE COUNTER IS RUNNING
            this.setEatingLeek(eatLeekTimer > 0);

            //SPAWN EATING PARTICLES
            if (eatLeekTimer > 0 && !this.isInSittingPose()) {
                Vec3d mikuPos = this.getPos();
                this.getWorld().addParticle(
                    new BlockStateParticleEffect(ParticleTypes.BLOCK, ModBlocks.LEEK_CROP.withAge(7)),
                    mikuPos.getX(),
                    mikuPos.getY() + 0.5D,
                    mikuPos.getZ(),
                    this.random.nextGaussian() * 0.5,
                    this.random.nextGaussian() * 0.5,
                    this.random.nextGaussian() * 0.5
                );
            }

        }
    }

    //SET LEEK TIMER 40 TICKS WHEN LEEK EATING STATUS IS TRUE
    @Override
    public void handleStatus(byte status) {
        if (status == 10){
            this.eatLeekTimer = MAX_LEEK_TIMER;
        } else {
            super.handleStatus(status);
        }
    }

    //EATING LEEK GETTER AND SETTER
    public boolean isEatingLeek(){
        return this.eatingLeek;
    }

    public void setEatingLeek(boolean eatingLeek){
        this.eatingLeek = eatingLeek;
    }

    //MIKU VARIANTS
    public String getVariant() {
        return MikuVariant.byId(this.getTypeVariant()).getBlock();
    }

    private int getTypeVariant() {
        return this.dataTracker.get(MIKU_VARIANT);
    }

    public void setVariant(MikuVariant variant) {
        this.dataTracker.set(MIKU_VARIANT, variant.getId()/* & 255*/);
    }

    public void setVariantByBlock(String variant) {
        for (int variation = 0; variation < MikuVariant.values().length; variation++) {
            if (MikuVariant.byId(variation).getBlock().equals(variant))
                this.dataTracker.set(MIKU_VARIANT, variation);
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(MIKU_VARIANT, nbt.getInt("Variant"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }
}
