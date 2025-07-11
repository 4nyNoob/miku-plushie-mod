package com.any.mikuplushie.block;

import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MikuPlushieBlock extends PlushieBlock {
	public MikuPlushieBlock(Properties settings) {
		super(settings);
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if(stack.getItem()== ModItems.CANUDINHO.get()){
			level.playSound(player,pos, ModSoundEvents.MIKU_CANUDINHO.value(), SoundSource.BLOCKS, 0.5F,1F);
			return ItemInteractionResult.SUCCESS;
		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
			level.playSound(null,pos,ModSoundEvents.MIKU_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
		super.onPlace(state, level, pos, oldState, movedByPiston);
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
			level.playSound(null,pos,ModSoundEvents.MIKU_BYE.value(), SoundSource.BLOCKS, 0.5F,1F);
		super.onRemove(state, level, pos, newState, movedByPiston);
	}

}
