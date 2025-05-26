package com.any.mikuplushie.block;

import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.datagen.ModTagProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class MikuPlushieBlock extends Block {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	protected static final VoxelShape SHAPE = Shapes.box(5.0/16D, 0.0, 5.0/16D, 11.0/16D, 13.0/16D, 11.0/16D);
	public MikuPlushieBlock(Properties settings) {
		super(settings);
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if(stack.getItem()== ModItems.CANUDINHO.get() && state.is(ModTagProvider.MIKU_PLUSH)){
			level.playSound(player,pos, ModSoundEvents.MIKU_CANUDINHO.value(), SoundSource.BLOCKS, 0.5F,1F);
			return ItemInteractionResult.SUCCESS;
		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
		if (state.is(ModTagProvider.AIKO_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.AIKO_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
		} else {
			level.playSound(null,pos,ModSoundEvents.MIKU_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		super.onPlace(state, level, pos, oldState, movedByPiston);
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
		if (state.is(ModTagProvider.AIKO_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.AIKO_BYE.value(), SoundSource.BLOCKS, 0.5F,1F);
		} else {
			level.playSound(null,pos,ModSoundEvents.MIKU_BYE.value(),SoundSource.BLOCKS,0.5F,1F);
		}
		super.onRemove(state, level, pos, newState, movedByPiston);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
		return state.setValue(FACING,direction.rotate(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
}
