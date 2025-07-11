package com.any.mikuplushie.item;

import com.any.mikuplushie.ModSoundEvents;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class LenPlushieBlockItem extends PlushieBlockItem{
    public LenPlushieBlockItem(Block block) {
        super(block);
    }

    @Override
    public Holder<SoundEvent> getEquipSound() {
        return ModSoundEvents.LEN_EQUIP;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        player.playSound(ModSoundEvents.LEN_DOR.value(), 0.5F, 1F);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
