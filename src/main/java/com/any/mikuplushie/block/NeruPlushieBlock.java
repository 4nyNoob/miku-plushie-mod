package com.any.mikuplushie.block;

import com.any.mikuplushie.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class NeruPlushieBlock extends PlushieBlock{
    public NeruPlushieBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        level.playSound(null,pos,ModSoundEvents.NERU_OIE.value(), SoundSource.BLOCKS, 0.5F,1F);
        super.onPlace(state, level, pos, oldState, movedByPiston);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        level.playSound(null,pos,ModSoundEvents.NERU_BYE.value(), SoundSource.BLOCKS, 0.5F,1F);
        super.onRemove(state, level, pos, newState, movedByPiston);
    }
}
