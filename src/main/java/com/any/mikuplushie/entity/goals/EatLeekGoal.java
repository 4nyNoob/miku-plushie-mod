package com.any.mikuplushie.entity.goals;

import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModItems;
import com.any.mikuplushie.registry.ModSoundEvents;
import com.any.mikuplushie.block.LeekCropBlock;
import com.any.mikuplushie.entity.MikuEntity;
import com.any.mikuplushie.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.spongepowered.include.com.google.common.base.Predicates;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

//EAT LEEK GOAL
public class EatLeekGoal extends Goal {

    private static final int MAX_TIMER = 40;
    private static final Predicate<BlockState> LEEK_PREDICATE = BlockStatePredicate.forBlock(ModBlocks.LEEK_CROP).with(LeekCropBlock.AGE, Predicates.equalTo(7));
    private final MikuEntity miku;
    private final World world;
    private int timer;
    BlockState fullyGrownLeekCrop = ModBlocks.LEEK_CROP.withAge(7);


    public EatLeekGoal(MikuEntity miku) {
        this.miku = miku;
        this.world = miku.getWorld();
        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK, Goal.Control.JUMP));
    }


    @Override
    public boolean canStart() {
        BlockPos blockPos = this.miku.getBlockPos();
        boolean adjacentToLeek = !locateFullyGrownLeek(blockPos).equals(blockPos);
        boolean healthNotMaxed = this.miku.getHealth() < this.miku.getMaxHealth();
        return adjacentToLeek && healthNotMaxed;
    }

    @Override
    public void start() {
        this.timer = this.getTickCount(MAX_TIMER);
        this.miku.lookAt(this.miku.getCommandSource().getEntityAnchor(), locateFullyGrownLeek(this.miku.getBlockPos()).toCenterPos());
        this.world.sendEntityStatus(this.miku, EntityStatuses.SET_SHEEP_EAT_GRASS_TIMER_OR_PRIME_TNT_MINECART);
        this.miku.getNavigation().stop();
    }


    @Override
    public void stop() {
        this.timer = 0;
    }

    @Override
    public boolean shouldContinue() {
        return this.timer > 0;
    }

    public int getTimer() {
        return this.timer;
    }

    @Override
    public void tick() {
        this.timer = Math.max(0, this.timer - 1);

        if (this.timer % 4 == 1 && this.timer > 4) {
            this.miku.playSound(SoundEvents.ENTITY_GENERIC_EAT, 0.5F, 1);
            this.miku.playSound(ModUtil.getPlushSoundEvent("miku_plush", "eat"), 1, 1);
        }

        if (this.timer == this.getTickCount(4)) {
            BlockPos mobPos = this.miku.getBlockPos();

            if (LEEK_PREDICATE.test(this.world.getBlockState(mobPos))) {
                if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                    this.world.breakBlock(mobPos, false);
                }
                this.miku.onEatingGrass();

            } else {
                BlockPos blockPos2 = mobPos;

                if (!locateFullyGrownLeek(mobPos).equals(mobPos))
                    blockPos2 = locateFullyGrownLeek(mobPos);

                if (this.world.getBlockState(blockPos2).equals(ModBlocks.LEEK_CROP.withAge(7))) {
                    if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                        this.world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, blockPos2, Block.getRawIdFromState(ModBlocks.LEEK_CROP.getDefaultState()));
                        this.world.setBlockState(blockPos2, Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                        this.miku.setEatingLeek(false);
                        this.miku.heal(4);
                    }
                    this.miku.onEatingGrass();
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
            mobPos.up(),
            mobPos.up().east(),
            mobPos.up().west(),
            mobPos.up().north(),
            mobPos.up().south()
        );
        for (BlockPos testPos : POSITION_CHECKS) {
            if (this.world.getBlockState(testPos).equals(fullyGrownLeekCrop))
                return testPos;
        }
        return mobPos;
    }
}
