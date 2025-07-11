package com.any.mikuplushie.block;

import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.datagen.ModTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MikuPlushieBlock extends Block {
	public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
	public MikuPlushieBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		if (!world.isClient){
			if (player.getActiveItem().isOf(ModItems.CANUDINHO) && this.asItem().getDefaultStack().isIn(ModTagProvider.BR_MIKU_ITEMS)){
				world.playSound(null, pos, ModSoundEvents.MIKU_CANUDINHO, SoundCategory.BLOCKS, 1F, 1F);
				return ActionResult.SUCCESS;
			}
		}
		return super.onUse(state, world, pos, player, hit);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		if(this.asItem().getDefaultStack().isIn(ModTagProvider.AIKO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.AIKO_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.TETO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.TETO_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.AKITA_NERU_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.AKITA_NERU_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.RIN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.RIN_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.LEN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.LEN_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.BR_MIKU_ITEMS)){
			world.playSound(null, pos, ModSoundEvents.MIKU_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		}
		super.onPlaced(world, pos, state, placer, itemStack);
	}

	@Override
	public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		if(this.asItem().getDefaultStack().isIn(ModTagProvider.AIKO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.AIKO_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.TETO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.TETO_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.AKITA_NERU_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.AKITA_NERU_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.RIN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.RIN_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.LEN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.LEN_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.BR_MIKU_ITEMS)){
			world.playSound(null, pos, ModSoundEvents.MIKU_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		}
        super.onBreak(world, pos, state, player);
		return state;
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(4.25, 0.0, 4.25, 11.5, 13.0, 11.5);
	}

	@Nullable
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
	}

	public BlockState rotate(BlockState state, BlockRotation rotation) {
		return state.with(FACING, rotation.rotate(state.get(FACING)));
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
}
