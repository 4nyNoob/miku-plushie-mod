package com.any.mikuplushie.entity.goals;

import com.any.mikuplushie.block.LeekCropBlock;
import com.any.mikuplushie.entity.MikuEntity;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.util.ModUtil;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.level.gamerules.GameRules;
import org.spongepowered.include.com.google.common.base.Predicates;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;

//EAT LEEK GOAL
public class EatLeekGoal extends Goal {

    private static final int MAX_TIMER = 40;
    private static final Predicate<BlockState> LEEK_PREDICATE = BlockStatePredicate.forBlock(ModBlocks.LEEK_CROP).where(LeekCropBlock.AGE, Predicates.equalTo(7));
    private final MikuEntity miku;
    private final Level world;
    private int timer;
    BlockState fullyGrownLeekCrop = ModBlocks.LEEK_CROP.getStateForAge(7);


    public EatLeekGoal(MikuEntity miku) {
        this.miku = miku;
        this.world = miku.level();
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }


    @Override
    public boolean canUse() {
        BlockPos blockPos = this.miku.blockPosition();
        boolean adjacentToLeek = !locateFullyGrownLeek(blockPos).equals(blockPos);
        boolean healthNotMaxed = this.miku.getHealth() < this.miku.getMaxHealth();
        return adjacentToLeek && healthNotMaxed;
    }

    @Override
    public void start() {
        this.timer = this.adjustedTickDelay(MAX_TIMER);
        this.miku.lookAt(EntityAnchorArgument.Anchor.EYES, locateFullyGrownLeek(this.miku.blockPosition()).getCenter());
        this.world.broadcastEntityEvent(this.miku, EntityEvent.EAT_GRASS);
        this.miku.getNavigation().stop();
    }


    @Override
    public void stop() {
        this.timer = 0;
    }

    @Override
    public boolean canContinueToUse() {
        return this.timer > 0;
    }

    public int getTimer() {
        return this.timer;
    }

    @Override
    public void tick() {
        this.timer = Math.max(0, this.timer - 1);

        if (this.timer % 4 == 1 && this.timer > 4) {
            this.miku.playSound(SoundEvents.GENERIC_EAT.value(), 0.5F, 1);
            this.miku.playSound(ModUtil.getPlushSoundEvent("miku_plush", "eat"), 1, 1);
        }

        if (this.timer == this.adjustedTickDelay(4)) {
            BlockPos mobPos = this.miku.blockPosition();

            if (LEEK_PREDICATE.test(this.world.getBlockState(mobPos))) {
                if (getServerLevel(this.miku.level()).getGameRules().get(GameRules.MOB_GRIEFING)) {
                    this.world.destroyBlock(mobPos, false);
                }
                this.miku.ate();

            } else {
                BlockPos blockPos2 = mobPos;

                if (!locateFullyGrownLeek(mobPos).equals(mobPos))
                    blockPos2 = locateFullyGrownLeek(mobPos);

                if (this.world.getBlockState(blockPos2).equals(ModBlocks.LEEK_CROP.getStateForAge(7))) {
                    if (getServerLevel(this.miku.level()).getGameRules().get(GameRules.MOB_GRIEFING)) {
                        this.world.levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, blockPos2, Block.getId(ModBlocks.LEEK_CROP.defaultBlockState()));
                        this.world.setBlock(blockPos2, Blocks.AIR.defaultBlockState(), Block.UPDATE_CLIENTS);
                        this.miku.setEatingLeek(false);
                        this.miku.heal(4);
                    }
                    this.miku.ate();
                }
            }
        }

    }

    public BlockPos locateFullyGrownLeek(BlockPos mobPos) {
        List<BlockPos> POSITION_CHECKS = List.of(
            //ALL CARDINAL DIRECTIONS ON SAME LEVEL
            mobPos.east(),
            mobPos.west(),
            mobPos.north(),
            mobPos.south(),
            //SAME AS BEFORE BUT ONE BLOCK UP
            mobPos.above(),
            mobPos.above().east(),
            mobPos.above().west(),
            mobPos.above().north(),
            mobPos.above().south()
        );
        for (BlockPos testPos : POSITION_CHECKS) {
            if (this.world.getBlockState(testPos).equals(fullyGrownLeekCrop))
                return testPos;
        }
        return mobPos;
    }
}
