package com.any.mikuplushie.block;

import com.any.mikuplushie.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
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
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return new ItemStack(this.getSeedsItem());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Block.box(0,0,0,16,16,16);
    }

    @Override
    public BlockState updateShape(
        BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos
    ) {
        return !state.canSurvive(world, pos)
            ? Blocks.AIR.defaultBlockState()
            : super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        return this.canPlantOnTop(world.getBlockState(blockPos), world, blockPos);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter world, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return type == PathComputationType.AIR && !this.hasCollision || super.isPathfindable(state, type);
    }
}
