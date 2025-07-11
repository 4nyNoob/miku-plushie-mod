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
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class MikuPlushieBlock extends Block {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public MikuPlushieBlock(Properties settings) {
		super(settings);
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		ItemStack itemStack = state.getBlock().asItem().getDefaultInstance();

		if(stack.getItem()== ModItems.CANUDINHO.get() && itemStack.is(ModTagProvider.MIKU_PLUSH)){
			level.playSound(player,pos, ModSoundEvents.MIKU_CANUDINHO.value(), SoundSource.BLOCKS, 0.5F,1F);
			return ItemInteractionResult.SUCCESS;
		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
		ItemStack itemStack = state.getBlock().asItem().getDefaultInstance();

		if (itemStack.is(ModTagProvider.AIKO_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.AIKO_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		if (itemStack.is(ModTagProvider.TETO_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.TETO_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		if (itemStack.is(ModTagProvider.AKITA_NERU_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.NERU_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		if (itemStack.is(ModTagProvider.RIN_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.RIN_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		if (itemStack.is(ModTagProvider.LEN_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.LEN_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		if (itemStack.is(ModTagProvider.MIKU_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.MIKU_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		level.playSound(null,pos,ModSoundEvents.MIKU_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
		super.onPlace(state, level, pos, oldState, movedByPiston);
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
		ItemStack itemStack = state.getBlock().asItem().getDefaultInstance();

		if (itemStack.is(ModTagProvider.AIKO_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.AIKO_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		if (itemStack.is(ModTagProvider.TETO_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.TETO_BYE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		if (itemStack.is(ModTagProvider.AKITA_NERU_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.NERU_BYE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		if (itemStack.is(ModTagProvider.RIN_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.RIN_BYE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		if (itemStack.is(ModTagProvider.LEN_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.LEN_BYE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		if (itemStack.is(ModTagProvider.MIKU_PLUSH)){
			level.playSound(null,pos,ModSoundEvents.MIKU_BYE.value(), SoundSource.BLOCKS, 0.5F,1F);
		}
		super.onRemove(state, level, pos, newState, movedByPiston);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(4.5D, 0.0D, 4.5D, 11.5D, 13.5D, 11.5D);
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
