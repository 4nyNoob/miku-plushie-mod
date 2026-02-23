package com.any.mikuplushie.entity;

import com.any.mikuplushie.entity.goals.MikuDelayedAttackGoal;
import com.any.mikuplushie.entity.variant.PlushVariants;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModEntities;
import com.any.mikuplushie.registry.ModItems;
import com.any.mikuplushie.util.ModUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.net.httpserver.Authenticator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.awt.font.TextHitInfo;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class AbstractPlushEntity extends TamableAnimal implements GeoEntity {

    private static final EntityDataAccessor<Integer> SPAWN_AGE = SynchedEntityData.defineId(AbstractPlushEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(AbstractPlushEntity.class, EntityDataSerializers.INT);

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

    protected AbstractPlushEntity(EntityType<? extends TamableAnimal> entityType, Level world) {
        super(entityType, world);
    }

    //GOALS
    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new MikuDelayedAttackGoal(this, 1.5F, true));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this,1.0F, 5F, 1F));
        this.goalSelector.addGoal(6, new TemptGoal(this, 1.5, Ingredient.of(ModItems.LEEK), false));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, AbstractPlushEntity.class, 8F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers());
    }

    //DO NOT ATTACK SOME ENTITIES
    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) {
        return !(target instanceof AbstractPlushEntity)
            && !(target instanceof Creeper)
            && !(target instanceof Ghast)
            ;
    }

    //ATTRIBUTES


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 20.0F)
            .add(Attributes.MOVEMENT_SPEED, 0.3F)
            .add(Attributes.ATTACK_DAMAGE, 2.0F)
            .add(Attributes.TEMPT_RANGE, 8.0F)
            ;
    }

    //ENTITY POSES
    public static final EntityDimensions STANDING_DIMENSIONS = EntityDimensions
        .scalable(ModEntities.PLUSH_WIDTH, 1F)
        .withEyeHeight(0.85F);
    public static final EntityDimensions SITTING_DIMENSIONS = EntityDimensions
        .scalable(ModEntities.PLUSH_WIDTH, 0.8F)
        .withEyeHeight(0.6F);

    //HASH MAP OF ENTITY POSES
    private static final Map<Pose, EntityDimensions> POSE_DIMENSIONS = ImmutableMap.<Pose, EntityDimensions>builder()
        .put(Pose.STANDING, STANDING_DIMENSIONS)
        .put(Pose.SITTING, SITTING_DIMENSIONS)
        .build();

    //SET BASE DIMENSIONS
    @Override
    protected EntityDimensions getDefaultDimensions(Pose pose) {
        return POSE_DIMENSIONS.getOrDefault(pose, STANDING_DIMENSIONS);
    }

    //LIST OF AVAILABLE POSES
    @Override
    public ImmutableList<Pose> getDismountPoses() {
        return ImmutableList.of(Pose.STANDING, Pose.SITTING);
    }

    //UPDATE POSE
    protected void updatePose() {
        if (this.isInSittingPose()) {
            this.setPose(Pose.SITTING);
        } else {
            this.setPose(Pose.STANDING);
        }
    }

//    //UPDATE ENTITY POSE ON TICK METHOD
//    @Override
//    public void tick() {
//        super.tick();
////        this.updatePose();
//    }

    public List<RawAnimation> getDances(){
        return  List.of(
            RawAnimation.begin().thenLoop("misc.dance.generic.caramelldansen")
        );
    }

    //ANIMATION CONTROLLER
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>("Plush", 2, state -> {
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
                if (this.entityData.get(SPAWN_AGE) < 10){
                    return state.setAndContinue(SPAWN);
                }

                //DANCE
                else if (this.isSongPlaying()){
                    RawAnimation currentAnimation = state.controller().getCurrentRawAnimation();

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
                        return state.setAndContinue(DANCES.get(this.random.nextInt(
                            0, DANCES.size()-1)
                        ));
                    }

                }

                //ATTACKING
                else if (this.swinging) {
                    RawAnimation currentAnimation = state.controller().getCurrentRawAnimation();

                    for (RawAnimation animation : ATTACK_ANIMATIONS){
                        //IF ALREADY ATTACKING THE CONTINUE
                        if (currentAnimation.equals(animation)){
                            return state.setAndContinue(animation);
                        }
                    }
                    //RANDOMLY SELECT ATTACK ANIMATION FROM LIST
                    return state.setAndContinue(ATTACK_ANIMATIONS.get(this.random.nextInt(
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
    public final int getCurrentSwingDuration() {
        return 10;
    }

    //STATIC SOUND PITCH
    @Override
    public float getVoicePitch() {
        return 1F;
    }

    //DEATH SOUND
    @Override
    protected @Nullable SoundEvent getDeathSound() {
        String plushName = this.getType().getDescriptionId().split("[.]")[2];
        return ModUtil.getPlushSoundEvent(plushName, "bye");
    }

    //ENTITY RIGHT CLICK
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack playerItemStack = player.getItemInHand(player.getUsedItemHand());
        FoodProperties foodComponent = playerItemStack.get(DataComponents.FOOD);
        ItemStack entityHandStack = this.getMainHandItem();


        //TAMED INTERACTION
        if (this.onGround() && this.isTame() && this.isOwnedBy(player)) {
            //DO STUFF ON SERVER
            if (!this.level().isClientSide()) {
                //DROP HELD ITEM
                if (player.isShiftKeyDown() && playerItemStack.isEmpty()) {
                    this.dropEquipment((ServerLevel) this.level());
                    this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                    return InteractionResult.SUCCESS;
                }

                //LEEK HEAL
                else if (this.getHealth() < this.getMaxHealth() && playerItemStack.is(ModItems.LEEK)) {
                    if (!this.level().isClientSide()){
                        if (!player.getAbilities().instabuild){
                            playerItemStack.shrink(1);
                        }
                        float nutrition = foodComponent != null ? (float)foodComponent.nutrition() : 1.0F;
                        this.heal(nutrition);
                        this.playSound(SoundEvents.GENERIC_EAT.value(), 1, 1);
                    }
                    return InteractionResult.SUCCESS;
                }

                //TOGGLE SITTING POSE
                else {
                    this.setOrderedToSit(!this.isOrderedToSit());
                    this.setInSittingPose(!this.isInSittingPose());
                    if (this.isInSittingPose()) {
                        this.setPose(Pose.SITTING);
                    } else {
                        this.setPose(Pose.STANDING);
                    }
                    return InteractionResult.SUCCESS;
                }

            } else if (this.getHealth() < this.getMaxHealth() && playerItemStack.is(ModItems.LEEK)) {
                for (int particle = 0; particle < 20; particle++) {
                    this.level().addParticle(
                        new BlockParticleOption(ParticleTypes.BLOCK, ModBlocks.LEEK_CROP.getStateForAge(7)),
                        this.position().x(),
                        this.position().y() + 0.5D,
                        this.position().z(),
                        this.random.nextGaussian() * 0.1,
                        this.random.nextGaussian() * 0.1,
                        this.random.nextGaussian() * 0.1
                    );
                }
            }

            return InteractionResult.SUCCESS;
        }

        //OTHER PLAYER INTERACTION
        else {
            return super.mobInteract(player, hand);
        }
    }

    //PICK UP SWORDS FORM THE GROUND
    @Override
    public boolean canHoldItem(ItemStack stack) {
        return stack.is(ItemTags.SWORDS);
    }

    @Override
    public boolean canPickUpLoot() {
        return true;
    }

//    //HANDLE NEARBY SONG PLAYING
//    @Override
//    public void aiStep() {
//        super.aiStep();
//        this.updateSwingTime();
//
////        //GET NEARBY SONG PLAYING
////        if (
////            this.songSource == null
////                || !this.songSource.closerToCenterThan(this.position(), 8D)
////                || !this.level().getBlockState(this.songSource).is(Blocks.JUKEBOX)
////        )
////        {
////            this.songPlaying = false;
////            this.songSource = null;
////        }
////
////        //INCREMENT SPAWN TIMER IF IT'S LESS THAN 10
////        if (this.entityData.get(SPAWN_AGE) < 10){
////            this.entityData.set(SPAWN_AGE, Math.min(this.tickCount, 10));
////        }
//
//    }

    //IS SONG PLAYING FUNCTION
    public boolean isSongPlaying() {
        return this.songPlaying;
    }

    //NEARBY SONG PLAYING
    @Override
    public void setRecordPlayingNearby(BlockPos songPosition, boolean playing) {
        this.songSource = songPosition;
        this.songPlaying = playing;
    }

    public String getPlushName(){
        return this.getTypeName().toString().split("[.]")[2].split("'")[0];
    }

    //LIST OF VARIANTS
    protected List<String> getVariantList(){
        List<String> variantList = null;
        for (List<String> variants : PlushVariants.ALL_PLUSH_VARIANTS) {
            if (variants.contains(this.getPlushName())) {
                variantList = variants;
            }
        }
        return variantList;
    }

    //GET THE VARIANT DATA TRACKER
    protected EntityDataAccessor<Integer> getVariantDataTracker(){
        return VARIANT;
    }

    //GET DATA TRACKER VALUE
    private int getTrackedVariant() {
        return this.entityData.get(this.getVariantDataTracker());
    }

    //GET VARIANT NAME
    public String getVariant() {
        return this.getVariantList().get(this.entityData.get(this.getVariantDataTracker()));
    }

    //SET VARIANT BY ID
    public void setVariant(Integer variant) {
        this.entityData.set(this.getVariantDataTracker(), variant/* & 255*/);
    }

    //SET UP DATA TRACKER
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SPAWN_AGE, 0);
        builder.define(this.getVariantDataTracker(), 0);
    }

    //LOAD AND SAVE NBT DATA
    @Override
    public void readAdditionalSaveData(ValueInput nbt) {
        super.readAdditionalSaveData(nbt);
//        this.entityData.set(SPAWN_AGE, nbt.getInt("SpawnAge"));
//        this.entityData.set(this.getVariantDataTracker(), nbt.getInt("Variant"));
        nbt.getInt("SpawnAge");
        nbt.getInt("Variant");
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return false;
    }

    @Override
    public void addAdditionalSaveData(ValueOutput nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("SpawnAge", Math.min(this.tickCount, 11));
        nbt.putInt("Variant", this.getTrackedVariant());
    }

    //NO CHILD
    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
        return null;
    }

    public void setVariantByBlock(String variant) {
        for (int variation = 0; variation < this.getVariantList().size(); variation++) {
            if (this.getVariantList().get(variation).equals(variant))
                this.entityData.set(this.getVariantDataTracker(), variation);
        }
    }

}
