package com.any.mikuplushie.entity;

import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.entity.variant.MikuVariant;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.EntityView;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class MikuEntity extends TameableEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final TrackedData<Integer> MIKU_VARIANT = DataTracker.registerData(MikuEntity.class, TrackedDataHandlerRegistry.INTEGER);

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
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new MikuDelayedAttackGoal(this, 1.5F, true));
        this.goalSelector.add(4, new FollowOwnerGoal(this,1.0F, 5F, 1F, true));
        this.goalSelector.add(5, new TemptGoal(this, 1.5, Ingredient.ofItems(ModItems.CANUDINHO), false));
        this.goalSelector.add(6, new LookAtEntityGoal(this, MikuEntity.class, 8F));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0F)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0F);
    }

    //GECKO LIB STUFF
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Miku", 2, state -> {
            if (MikuEntity.this.isInSittingPose()){
                return state.setAndContinue(MikuEntity.this.isSongPlaying() ? SIT_DANCE : SIT);
            } else {

                if (MikuEntity.this.isSongPlaying()){
                    return state.setAndContinue(SELECTED_DANCE);
                } else {
                    if (MikuEntity.this.handSwinging){
                        return state.setAndContinue(SELECTED_ATTACK);
                    } else {
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
    public final int getHandSwingDuration() {
        return 10;
    }

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

    //MIKU DELAYED ATTACK GOAL
    static class MikuDelayedAttackGoal extends MeleeAttackGoal {
        private int attackDelay = 5;
        private LivingEntity target;
        private boolean mikuAttacking;

        public MikuDelayedAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
            super(mob, speed, pauseWhenMobIdle);
        }
        /**
        *   Swing the entity hand but handle the actual attack on the {@link  com.any.mikuplushie.entity.MikuEntity.MikuDelayedAttackGoal#tick()} method
        */
        protected void attack(LivingEntity target, double squaredDistance) {
            double d = this.getSquaredMaxAttackDistance(target);
            if (squaredDistance <= d && this.isCooledDown()) {
                this.resetCooldown();
                this.mob.swingHand(Hand.MAIN_HAND);
                this.target = target;
                this.mikuAttacking = true;
            }
        }
        /**
        *   Receive the attack command but wait 5 ticks to execute it, then reset
        */
        @Override
        public void tick() {
            if (this.mikuAttacking){
                --this.attackDelay;
                if (this.attackDelay < 0){
                    this.mob.tryAttack(this.target);
                    this.mikuAttacking = false;
                }
            } else {
                this.attackDelay = 5;
            }
            super.tick();
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
        //TRACK MIKU VARIANT BETWEEN SERVER AND CLIENT
        this.dataTracker.startTracking(MIKU_VARIANT, 0);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        //INITIALIZE MIKU WITH A RANDOM VARIANT
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
        //FIXED SOUND PITCH
        return 1F;
    }

    //ENTITY RIGHT CLICK
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack playerItemStack = player.getStackInHand(player.getActiveHand());
        ItemStack entityHandStack = this.getMainHandStack();

        //UNTAMED INTERACTION
        if (!this.isTamed() && player.getStackInHand(hand).isOf(ModItems.CANUDINHO)) {
            if (!player.getAbilities().creativeMode) {
                playerItemStack.decrement(1);
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
        }
        //TAMED INTERACTION
        else if (this.isOnGround() && this.isTamed() && this.isOwner(player)) {
            //DO STUFF ON SERVER
            if (!this.getWorld().isClient) {
                //DROP HELD ITEM
                if (player.isSneaking() && playerItemStack.isEmpty()) {
                    this.dropStack(entityHandStack);
                    this.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                }
                //TOGGLE SITTING POSE
                else {
                    this.setSitting(!this.isSitting());
                    this.setInSittingPose(!this.isInSittingPose());
                    if (this.isInSittingPose()) {
                        this.setPose(EntityPose.STANDING);
                    } else {
                        this.setPose(EntityPose.SITTING);
                    }
                }
            }
            return ActionResult.success(this.getWorld().isClient);
        }
        //OTHER PLAYER INTERACTION
        else {
            return super.interactMob(player, hand);
        }
    }

    @Override
    public boolean canPickupItem(ItemStack stack) {
        return stack.isIn(ItemTags.SWORDS);
    }

    @Override
    public boolean canPickUpLoot() {
        return true;
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
        this.tickHandSwing();
    }

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

    public boolean isSongPlaying() {
        return this.songPlaying;
    }

    //MIKU VARIANTS

    public MikuVariant getMikuVariant() {
        return MikuVariant.byId(this.getTypeVariant()/* & 255*/);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(MIKU_VARIANT);
    }

    public void setVariant(MikuVariant variant) {
        this.dataTracker.set(MIKU_VARIANT, variant.getId()/* & 255*/);
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
