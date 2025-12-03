package com.any.mikuplushie.entity;

import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.entity.goals.MikuDelayedAttackGoal;
import com.any.mikuplushie.entity.variant.MikuVariant;
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
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
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

public class PlushEntity extends TameableEntity implements GeoEntity {

    //DANCE GLOBALS
    boolean songPlaying;
    @Nullable BlockPos songSource;

    //GLIB VARIABLES
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
//    private static final RawAnimation EAT = RawAnimation.begin().thenPlay("misc.eat");

    private static RawAnimation SELECTED_DANCE = DANCE;
    private static RawAnimation SELECTED_ATTACK = SWIPE;

    protected PlushEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    //GOALS
    @Override
    public void initGoals() {
//        this.eatLeekGoal = new EatLeekGoal(this);
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new MikuDelayedAttackGoal(this, 1.5F, true));
        this.goalSelector.add(4, new FollowOwnerGoal(this,1.0F, 5F, 1F, true));
//        this.goalSelector.add(5, this.eatLeekGoal);
        this.goalSelector.add(6, new TemptGoal(this, 1.5, Ingredient.ofItems(ModItems.CANUDINHO), false));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlushEntity.class, 8F));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8F));
        this.goalSelector.add(9, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
    }
    //ATTRIBUTES
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
            if (PlushEntity.this.isInSittingPose()){
                return state.setAndContinue(PlushEntity.this.isSongPlaying() ? SIT_DANCE : SIT);
            }

//            //EATING ANIMATION
//            else if (PlushEntity.this.isEatingLeek()) {
//                return state.setAndContinue(EAT);
//            }

            else {
                //DANCE WHEN SONG IS PLAYING NEARBY
                if (PlushEntity.this.isSongPlaying()){
                    return state.setAndContinue(SELECTED_DANCE);
                } else {
                    //ATTACK
                    if (PlushEntity.this.handSwinging){
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

    //EYE HEIGHT DEPENDING ON POSE
    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        if (pose.equals(EntityPose.STANDING)){
            return 0.6F;
        } else {
            return 0.85F;
        }
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

    //CAN PICK UP ITEMS
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
    }

    //IS SONG PLAYING FUNCTION
    public boolean isSongPlaying() {
        return this.songPlaying;
    }

    //NO CHILD
    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public void setVariantByBlock(String variant) {
    }

    //GET WORLD
    @Override
    public EntityView method_48926() {
        return this.getWorld();
    }
}
