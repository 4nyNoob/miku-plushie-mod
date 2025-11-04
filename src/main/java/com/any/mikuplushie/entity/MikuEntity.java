package com.any.mikuplushie.entity;

import com.any.mikuplushie.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EntityView;
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

public class MikuEntity extends TameableEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

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

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
//        super.getActiveEyeHeight(pose, dimensions);
        if (pose.equals(EntityPose.STANDING)){
            return 0.65F;
        } else {
            return 0.85F;
        }
//        return pose.equals(EntityPose.SITTING) ? 0.65F : 0.85F;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

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
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!this.isTamed() && player.getStackInHand(hand).isOf(ModItems.CANUDINHO)) {
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }

            if (!this.isSilent()) {
                this.getWorld()
                    .playSound(
                        null,
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        SoundEvents.ENTITY_GENERIC_EAT,
                        this.getSoundCategory(),
                        1.0F,
                        1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F
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

    @Override
    public void tickMovement() {
        if (
            this.songSource == null
            || !this.songSource.isWithinDistance(this.getPos(), 4)
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
        int randomDance = this.random.nextBetween(1, 5);
        switch (randomDance) {
            case 1: SELECTED_DANCE = DANCE; break;
            case 2: SELECTED_DANCE = DANCE2; break;
            case 3: SELECTED_DANCE = DANCE3; break;
            case 4: SELECTED_DANCE = DANCE4; break;
            case 5: SELECTED_DANCE = DANCE5; break;
        }
    }

    public boolean isSongPlaying() {
        return this.songPlaying;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public EntityView method_48926() {
        return this.getWorld();
    }
}
