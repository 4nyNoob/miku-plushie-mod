package com.any.mikuplushie.entity;

import com.any.mikuplushie.entity.goals.MikuDelayedAttackGoal;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModEntities;
import com.any.mikuplushie.registry.ModItems;
import com.any.mikuplushie.util.ModUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.net.httpserver.Authenticator;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Map;

public class AbstractPlushEntity extends TameableEntity implements GeoEntity {

    private static final TrackedData<Integer> SPAWN_AGE = DataTracker.registerData(AbstractPlushEntity.class, TrackedDataHandlerRegistry.INTEGER);

    //DANCE GLOBALS
    boolean songPlaying;
    @Nullable BlockPos songSource;

    //GLIB VARIABLES
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("misc.idle");
    public static final RawAnimation SIT = RawAnimation.begin().thenLoop("misc.sit");
    public static final RawAnimation SIT_DANCE = RawAnimation.begin().thenLoop("misc.sit-dance");
    protected static final List<RawAnimation> ATTACK_ANIMATIONS = List.of(
        RawAnimation.begin().thenPlay("attack.swipe"),
        RawAnimation.begin().thenPlay("attack.swipe2"),
        RawAnimation.begin().thenPlay("attack.swipe3")
    );
    public static final RawAnimation SPAWN = RawAnimation.begin().thenPlay("misc.spawn");

    protected AbstractPlushEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    //GOALS
    @Override
    public void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new MikuDelayedAttackGoal(this, 1.5F, true));
        this.goalSelector.add(4, new FollowOwnerGoal(this,1.0F, 5F, 1F));
        this.goalSelector.add(6, new TemptGoal(this, 1.5, Ingredient.ofItems(ModItems.LEEK), false));
        this.goalSelector.add(7, new LookAtEntityGoal(this, AbstractPlushEntity.class, 8F));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8F));
        this.goalSelector.add(9, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, new RevengeGoal(this).setGroupRevenge());
    }

    //DO NOT ATTACK SOME ENTITIES
    @Override
    public boolean canAttackWithOwner(LivingEntity target, LivingEntity owner) {
        return !(target instanceof AbstractPlushEntity)
            && !(target instanceof CreeperEntity)
            && !(target instanceof GhastEntity)
            ;
    }

    //ATTRIBUTES
    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0F)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0F);
    }

    //ENTITY POSES
    public static final EntityDimensions STANDING_DIMENSIONS = EntityDimensions
        .changing(ModEntities.PLUSH_WIDTH, 1F)
        .withEyeHeight(0.85F);
    public static final EntityDimensions SITTING_DIMENSIONS = EntityDimensions
        .changing(ModEntities.PLUSH_WIDTH, 0.8F)
        .withEyeHeight(0.6F);

    //HASH MAP OF ENTITY POSES
    private static final Map<EntityPose, EntityDimensions> POSE_DIMENSIONS = ImmutableMap.<EntityPose, EntityDimensions>builder()
        .put(EntityPose.STANDING, STANDING_DIMENSIONS)
        .put(EntityPose.SITTING, SITTING_DIMENSIONS)
        .build();

    //SET BASE DIMENSIONS
    @Override
    protected EntityDimensions getBaseDimensions(EntityPose pose) {
        return POSE_DIMENSIONS.getOrDefault(pose, STANDING_DIMENSIONS);
    }

    //LIST OF AVAILABLE POSES
    @Override
    public ImmutableList<EntityPose> getPoses() {
        return ImmutableList.of(EntityPose.STANDING, EntityPose.SITTING);
    }

    //UPDATE POSE
    protected void updatePose() {
        if (this.isInSittingPose()) {
            this.setPose(EntityPose.SITTING);
        } else {
            this.setPose(EntityPose.STANDING);
        }
    }

    //UPDATE ENTITY POSE ON TICK METHOD
    @Override
    public void tick() {
        super.tick();
        this.updatePose();
    }

    public List<RawAnimation> getDances(){
        return  List.of(
            RawAnimation.begin().thenLoop("misc.dance.generic.caramelldansen")
        );
    }

    //ANIMATION CONTROLLER
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Plush", 2, state -> {
            List<RawAnimation> DANCES = getDances();

            //SITTING ANIMATIONS
            if (this.isInSittingPose()) {
                //SONG PLAYING NEARBY
                if (this.isSongPlaying()){
                    return state.setAndContinue(SIT_DANCE);
                } else {
                    return state.setAndContinue(SIT);
                }
            }

            //STANDING UP ANIMATIONS
            else {

                //SPAWN ANIMATION
                if (this.dataTracker.get(SPAWN_AGE) < 10){
                    return state.setAndContinue(SPAWN);
                }

                //DANCE
                else if (this.isSongPlaying()){
                    RawAnimation currentAnimation = state.getController().getCurrentRawAnimation();

                    for (RawAnimation animation : DANCES){
                        //IF ALREADY DANCING THEN CONTINUE
                        if (currentAnimation.equals(animation)){
                            return state.setAndContinue(animation);
                        }
                    }
                    //IF LIST IS TOO SMALL THEN GET 1ST ENTRY
                    if (DANCES.size() == 1){
                        return state .setAndContinue(DANCES.get(0));
                    }
                    //RANDOMLY SELECT DANCE ANIMATION FROM LIST
                    else {
                        return state.setAndContinue(DANCES.get(this.random.nextBetweenExclusive(
                            0, DANCES.size()-1)
                        ));
                    }

                }

                //ATTACKING
                else if (this.handSwinging) {
                    RawAnimation currentAnimation = state.getController().getCurrentRawAnimation();

                    for (RawAnimation animation : ATTACK_ANIMATIONS){
                        //IF ALREADY ATTACKING THE CONTINUE
                        if (currentAnimation.equals(animation)){
                            return state.setAndContinue(animation);
                        }
                    }
                    //RANDOMLY SELECT ATTACK ANIMATION FROM LIST
                    return state.setAndContinue(ATTACK_ANIMATIONS.get(this.random.nextBetweenExclusive(
                        0, ATTACK_ANIMATIONS.size()-1)
                    ));
                }

                //IDLE
                else {
                    return state.setAndContinue(IDLE);
                }
            }
        }));

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    //HAND SWING DURATION
    @Override
    public final int getHandSwingDuration() {
        return 10;
    }

    //STATIC SOUND PITCH
    @Override
    public float getSoundPitch() {
        return 1F;
    }

    //DEATH SOUND
    @Override
    protected @Nullable SoundEvent getDeathSound() {
        String plushName = this.getType().getTranslationKey().split("[.]")[2];
        return ModUtil.getPlushSoundEvent(plushName, "bye");
    }

    //ENTITY RIGHT CLICK
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack playerItemStack = player.getStackInHand(player.getActiveHand());
        FoodComponent foodComponent = playerItemStack.get(DataComponentTypes.FOOD);
        ItemStack entityHandStack = this.getMainHandStack();


        //TAMED INTERACTION
        if (this.isOnGround() && this.isTamed() && this.isOwner(player)) {
            //DO STUFF ON SERVER
            if (!this.getWorld().isClient) {
                //DROP HELD ITEM
                if (player.isSneaking() && playerItemStack.isEmpty()) {
                    this.dropStack(entityHandStack);
                    this.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                    return ActionResult.SUCCESS;
                }

                //LEEK HEAL
                else if (this.getHealth() < this.getMaxHealth() && playerItemStack.isOf(ModItems.LEEK)) {
                    if (!this.getWorld().isClient()){
                        if (!player.getAbilities().creativeMode){
                            playerItemStack.decrement(1);
                        }
                        float nutrition = foodComponent != null ? (float)foodComponent.nutrition() : 1.0F;
                        this.heal(nutrition);
                        this.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1, 1);
                    }
                    return ActionResult.SUCCESS;
                }

                //TOGGLE SITTING POSE
                else {
                    this.setSitting(!this.isSitting());
                    this.setInSittingPose(!this.isInSittingPose());
                    if (this.isInSittingPose()) {
                        this.setPose(EntityPose.SITTING);
                    } else {
                        this.setPose(EntityPose.STANDING);
                    }
                    return ActionResult.SUCCESS;
                }

            } else if (this.getHealth() < this.getMaxHealth() && playerItemStack.isOf(ModItems.LEEK)) {
                for (int particle = 0; particle < 20; particle++) {
                    this.getWorld().addParticle(
                        new BlockStateParticleEffect(ParticleTypes.BLOCK, ModBlocks.LEEK_CROP.withAge(7)),
                        this.getPos().getX(),
                        this.getPos().getY() + 0.5D,
                        this.getPos().getZ(),
                        this.random.nextGaussian() * 0.1,
                        this.random.nextGaussian() * 0.1,
                        this.random.nextGaussian() * 0.1
                    );
                }
            }

            return ActionResult.SUCCESS;
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

    //HANDLE NEARBY SONG PLAYING
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

        //INCREMENT SPAWN TIMER IF IT'S LESS THAN 10
        if (this.dataTracker.get(SPAWN_AGE) < 10){
            this.dataTracker.set(SPAWN_AGE, Math.min(this.age, 10));
        }

    }

    //IS SONG PLAYING FUNCTION
    public boolean isSongPlaying() {
        return this.songPlaying;
    }

    public int isIngame(){
        return 1;
    }

    //SELECT RANDOM DANCE
    @Override
    public void setNearbySongPlaying(BlockPos songPosition, boolean playing) {
        this.songSource = songPosition;
        this.songPlaying = playing;
    }

    //DATA TRACKER
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(SPAWN_AGE, 0);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(SPAWN_AGE, nbt.getInt("SpawnAge"));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("SpawnAge", Math.min(this.age, 11));
    }

    //NO CHILD
    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public void setVariantByBlock(String variant) {
    }

}
