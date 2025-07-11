package com.any.mikuplushie.item;

import com.any.mikuplushie.ModSoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class TetoPickaxeItem extends PickaxeItem {
    public TetoPickaxeItem(Tier p_42961_, Properties p_42964_) {
        super(p_42961_, p_42964_);
    }

    @Override
    public SoundEvent getBreakingSound() {
        return ModSoundEvents.TETO_BYE.value();
    }
}
