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
		if(stack.getItem()== ModItems.CANUDINHO.get() && this.getDescriptionId().split("[.]")[2].startsWith("miku")){
			level.playSound(player,pos, ModSoundEvents.MIKU_CANUDINHO.value(), SoundSource.BLOCKS, 0.5F,1F);
			return ItemInteractionResult.SUCCESS;
		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        String name=this.getDescriptionId().split("[.]")[2];
        if(name.startsWith("miku")) {
            level.playSound(null, pos, ModSoundEvents.MIKU_OIE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("aiko")){
            level.playSound(null, pos, ModSoundEvents.AIKO_OIE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("teto")){
            level.playSound(null, pos, ModSoundEvents.TETO_OIE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("akita_neru")){
            level.playSound(null, pos, ModSoundEvents.NERU_OIE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("rin")){
            level.playSound(null, pos, ModSoundEvents.RIN_OIE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("len")){
            level.playSound(null, pos, ModSoundEvents.LEN_OIE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("luka")){
            level.playSound(null, pos, ModSoundEvents.LUKA_OIE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("meiko")){
            level.playSound(null, pos, ModSoundEvents.MEIKO_OIE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("kaito")){
            level.playSound(null, pos, ModSoundEvents.KAITO_OIE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("gumi")) {
            level.playSound(null, pos, ModSoundEvents.GUMI_OIE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }
        super.onPlace(state, level, pos, oldState, movedByPiston);
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        String name=this.getDescriptionId().split("[.]")[2];
        if(name.startsWith("miku")) {
            level.playSound(null, pos, ModSoundEvents.MIKU_BYE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("aiko")){
            level.playSound(null, pos, ModSoundEvents.AIKO_BYE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("teto")){
            level.playSound(null, pos, ModSoundEvents.TETO_BYE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("akita_neru")){
            level.playSound(null, pos, ModSoundEvents.NERU_BYE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("rin")){
            level.playSound(null, pos, ModSoundEvents.RIN_BYE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("len")){
            level.playSound(null, pos, ModSoundEvents.LEN_BYE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("luka")){
            level.playSound(null, pos, ModSoundEvents.LUKA_BYE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("meiko")){
            level.playSound(null, pos, ModSoundEvents.MEIKO_BYE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("kaito")){
            level.playSound(null, pos, ModSoundEvents.KAITO_BYE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }else if(name.startsWith("gumi")) {
            level.playSound(null, pos, ModSoundEvents.GUMI_BYE.value(), SoundSource.BLOCKS, 0.5F, 1F);
        }
		super.onRemove(state, level, pos, newState, movedByPiston);
	}

}
