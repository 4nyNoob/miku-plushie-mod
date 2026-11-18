package com.any.miku_plushie.impl.common.block;

import com.any.miku_plushie.impl.common.registry.ModItems;
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
  protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
    return new ItemStack(this.getSeedsItem());
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
    return Block.box(0, 0, 0, 16, 16, 16);
  }

  @Override
  protected BlockState updateShape(
    BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
    return !state.canSurvive(level, pos)
      ? Blocks.AIR.defaultBlockState()
      :super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
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
