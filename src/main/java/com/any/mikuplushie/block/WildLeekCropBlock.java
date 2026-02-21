package com.any.mikuplushie.block;

import com.any.mikuplushie.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WildLeekCropBlock extends Block {
    public WildLeekCropBlock(Properties settings) {
        super(settings);
    }

    protected boolean canPlantOnTop(BlockState floor, BlockGetter world, BlockPos pos) {
        return floor.is(Blocks.GRASS_BLOCK) || floor.is(Blocks.PODZOL);
    }

    protected ItemLike getSeedsItem() {
        return ModItems.LEEK_SEEDS;
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state, boolean bl) {
        return new ItemStack(this.getSeedsItem());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Block.box(0,0,0,16,16,16);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos blockPos2, BlockState blockState2, RandomSource randomSource) {
        return !state.canSurvive(world, pos)
            ? Blocks.AIR.defaultBlockState()
            : super.updateShape(state, world, scheduledTickAccess, pos, direction, blockPos2, blockState2, randomSource);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        return this.canPlantOnTop(world.getBlockState(blockPos), world, blockPos);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state) {
        return state.getFluidState().isEmpty();
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return type == PathComputationType.AIR && !this.hasCollision || super.isPathfindable(state, type);
    }
}
