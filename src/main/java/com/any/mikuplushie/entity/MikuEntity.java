package com.any.mikuplushie.entity;

import com.any.mikuplushie.ModBlocks;
import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.block.LeekCropBlock;
import com.any.mikuplushie.entity.goals.EatLeekGoal;
import com.any.mikuplushie.entity.goals.MikuDelayedAttackGoal;
import com.any.mikuplushie.entity.variant.MikuVariant;
import com.mojang.datafixers.kinds.IdF;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.*;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.include.com.google.common.base.Predicates;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class MikuEntity extends TameableEntity implements GeoEntity {

    private static final TrackedData<Integer> MIKU_VARIANT = DataTracker.registerData(MikuEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private boolean songPlaying;
    @Nullable
    private BlockPos songSource;



    private static final int MAX_LEEK_TIMER = 40;
    private int eatLeekTimer;
    private EatLeekGoal eatLeekGoal;
    public boolean eatingLeek;



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
    private static final RawAnimation EAT = RawAnimation.begin().thenPlay("misc.eat");

    private static RawAnimation SELECTED_DANCE = DANCE;
    private static RawAnimation SELECTED_ATTACK = SWIPE;



    public MikuEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    //GOALS AND ATTRIBUTES
    @Override
    public void initGoals() {
        this.eatLeekGoal = new EatLeekGoal(this);
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new MikuDelayedAttackGoal(this, 1.5F, true));
        this.goalSelector.add(4, new FollowOwnerGoal(this,1.0F, 5F, 1F, true));
        this.goalSelector.add(5, this.eatLeekGoal);
        this.goalSelector.add(6, new TemptGoal(this, 1.5, Ingredient.ofItems(ModItems.CANUDINHO), false));
        this.goalSelector.add(7, new LookAtEntityGoal(this, MikuEntity.class, 8F));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8F));
        this.goalSelector.add(9, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0F)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0F);
    }

    //ANIMATION CONTROLLER
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Miku", 2, state -> {

            //MIKU SIT OR DANCE WHEN SONG IS PLAYING NEARBY
            if (MikuEntity.this.isInSittingPose()){
                return state.setAndContinue(MikuEntity.this.isSongPlaying() ? SIT_DANCE : SIT);
            }

            //EATING ANIMATION
            else if (MikuEntity.this.isEatingLeek()) {
                return state.setAndContinue(EAT);
            }

            else {
                //DANCE WHEN SONG IS PLAYING NEARBY
                if (MikuEntity.this.isSongPlaying()){
                    return state.setAndContinue(SELECTED_DANCE);
                } else {
                    //ATTACK
                    if (MikuEntity.this.handSwinging){
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

    //PICK UP SWORDS FORM THE GROUND
    @Override
    public boolean canPickupItem(ItemStack stack) {
        return stack.isIn(ItemTags.SWORDS);
    }

    @Override
    public boolean canPickUpLoot() {
        return true;
    }

    @Override
    protected void mobTick() {
        //UPDATE LEEK TIMER
        this.eatLeekTimer = this.eatLeekGoal.getTimer();
        super.mobTick();
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        this.tickHandSwing();

        //GET NEARBY SONG PLAYING
        if (
            this.songSource == null
            || !this.songSource.isWithinDistance(this.getPos(), 8D)
            || !this.getWorld().getBlockState(this.songSource).isOf(Blocks.JUKEBOX)
        )
        {
            this.songPlaying = false;
            this.songSource = null;
        }

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
