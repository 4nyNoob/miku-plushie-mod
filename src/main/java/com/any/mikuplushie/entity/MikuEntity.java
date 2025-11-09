package com.any.mikuplushie.entity;

import com.any.mikuplushie.ModEntities;
import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.entity.variant.MikuVariant;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.EntityView;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.IntFunction;

public class MikuEntity extends TameableEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final TrackedData<Integer> VARIANT = DataTracker.registerData(MikuEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("misc.idle");
    private static final RawAnimation SIT = RawAnimation.begin().thenLoop("misc.sit");
    private static final RawAnimation SIT_DANCE = RawAnimation.begin().thenLoop("misc.sit-dance");
    private static final RawAnimation DANCE = RawAnimation.begin().thenLoop("misc.dance");
    private static final RawAnimation DANCE2 = RawAnimation.begin().thenLoop("misc.dance2");
    private static final RawAnimation DANCE3 = RawAnimation.begin().thenLoop("misc.dance3");
    private static final RawAnimation DANCE4 = RawAnimation.begin().thenLoop("misc.dance4");
    private static final RawAnimation DANCE5 = RawAnimation.begin().thenLoop("misc.dance5");

    private static RawAnimation SELECTED_DANCE = DANCE;

    private boolean songPlaying;
    @Nullable
    private BlockPos songSource;

    public MikuEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    //GOALS AND ATTRIBUTES
    @Override
    public void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 16F));
        this.goalSelector.add(2, new LookAtEntityGoal(this, MikuEntity.class, 8F));
        this.goalSelector.add(2, new FollowOwnerGoal(this,1.0F, 5F, 1F, true));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F);
    }

    //GECKOLIB STUFF
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Miku", state -> {
            if (MikuEntity.this.isInSittingPose()){
                return  state.setAndContinue(MikuEntity.this.isSongPlaying() ? SIT_DANCE : SIT);
            } else {
                return  state.setAndContinue(MikuEntity.this.isSongPlaying() ? SELECTED_DANCE : IDLE);
            }
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    //MC ENTITY STUFF
    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        if (pose.equals(EntityPose.STANDING)){
            return 0.6F;
        } else {
            return 0.85F;
        }
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public EntityView method_48926() {
        return this.getWorld();
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(VARIANT, 0);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        MikuVariant variant = Util.getRandom(MikuVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSoundEvents.MIKU_BYE;
    }

    @Override
    public float getSoundPitch() {
        return 1F;
    }

    //ENTITY RIGHT CLICK
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!this.isTamed() && player.getStackInHand(hand).isOf(ModItems.CANUDINHO)) {
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }

            if (!this.isSilent()) {
                this.getWorld()
                    .playSound(null, this.getX(), this.getY(), this.getZ(),
                        SoundEvents.ENTITY_GENERIC_EAT, this.getSoundCategory(),
                        1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F
                    );
            }

            if (!this.getWorld().isClient) {
                if (this.random.nextInt(10) == 0) {
                    this.setOwner(player);
                    this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
                } else {
                    this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES);
                }
            }

            return ActionResult.success(this.getWorld().isClient);
        } else if (this.isOnGround() && this.isTamed() && this.isOwner(player)) {
            if (!this.getWorld().isClient) {
                this.setSitting(!this.isSitting());
                this.setInSittingPose(!this.isInSittingPose());
                if (this.isInSittingPose()) {
                    this.setPose(EntityPose.STANDING);
                } else {
                    this.setPose(EntityPose.SITTING);
                }
            }
            return ActionResult.success(this.getWorld().isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    //GET NEARBY SONG PLAYING
    @Override
    public void tickMovement() {
        if (
            this.songSource == null
            || !this.songSource.isWithinDistance(this.getPos(), 8D)
            || !this.getWorld().getBlockState(this.songSource).isOf(Blocks.JUKEBOX)
        )
        {
            this.songPlaying = false;
            this.songSource = null;
        }

        super.tickMovement();

    }

    @Override
    public void setNearbySongPlaying(BlockPos songPosition, boolean playing) {
        this.songSource = songPosition;
        this.songPlaying = playing;
//        if (!songPlaying && songSource != null){
        Random random = this.random;
//        random.setSeed(this.getPos().hashCode());
        int randomDance = random.nextBetweenExclusive(1, 5);
//        System.out.println(this.getPos().hashCode());
        switch (randomDance) {
            case 1: SELECTED_DANCE = DANCE; break;
            case 2: SELECTED_DANCE = DANCE2; break;
            case 3: SELECTED_DANCE = DANCE3; break;
            case 4: SELECTED_DANCE = DANCE4; break;
            case 5: SELECTED_DANCE = DANCE5; break;
//            default: SELECTED_DANCE = DANCE; break;
        }
//        }
    }

    public boolean isSongPlaying() {
        return this.songPlaying;
    }

    //MIKU VARIANTS

    public MikuVariant getVariant () {
        return MikuVariant.byId(this.getTypeVariant()/* & 255*/);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(VARIANT);
    }

    public void setVariant(MikuVariant variant) {
        this.dataTracker.set(VARIANT, variant.getId()/* & 255*/);
    }
//
//    public void setVariantByName(MikuVariant variant) {
//        this.dataTracker.set(VARIANT, variant.getId() & 255);
//    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(VARIANT, nbt.getInt("Variant"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }
}
