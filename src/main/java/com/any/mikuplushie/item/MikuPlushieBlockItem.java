package com.any.mikuplushie.item;

import com.any.mikuplushie.ModSoundEvents;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class MikuPlushieBlockItem extends PlushieBlockItem {
	public MikuPlushieBlockItem(Block block) {
		super(block);
	}

	@Override
	public Holder<SoundEvent> getEquipSound() {
        String name=this.getDescriptionId().split("[.]")[2];
        if(name.startsWith("miku")) {
            return ModSoundEvents.MIKU_EQUIP;
        }else if(name.startsWith("aiko")){
            return ModSoundEvents.AIKO_EQUIP;
        }else if(name.startsWith("teto")){
            return ModSoundEvents.TETO_EQUIP;
        }else if(name.startsWith("akita_neru")){
            return ModSoundEvents.NERU_EQUIP;
        }else if(name.startsWith("rin")){
            return ModSoundEvents.RIN_EQUIP;
        }else if(name.startsWith("len")){
            return ModSoundEvents.LEN_EQUIP;
        }else if(name.startsWith("luka")){
            return ModSoundEvents.LUKA_EQUIP;
        }else if(name.startsWith("meiko")){
            return ModSoundEvents.MEIKO_EQUIP;
        }else if(name.startsWith("kaito")){
            return ModSoundEvents.KAITO_EQUIP;
        }else if(name.startsWith("gumi")) {
            return ModSoundEvents.GUMI_EQUIP;
        }
		return ModSoundEvents.MIKU_EQUIP;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        String name=this.getDescriptionId().split("[.]")[2];
        if(name.startsWith("miku")) {
            player.playSound(ModSoundEvents.MIKU_DOR.value(), 0.5F, 1F);
        }else if(name.startsWith("aiko")){
            player.playSound(ModSoundEvents.AIKO_DOR.value(), 0.5F, 1F);
        }else if(name.startsWith("teto")){
            player.playSound(ModSoundEvents.TETO_DOR.value(), 0.5F, 1F);
        }else if(name.startsWith("akita_neru")){
            player.playSound(ModSoundEvents.NERU_DOR.value(), 0.5F, 1F);
        }else if(name.startsWith("rin")){
            player.playSound(ModSoundEvents.RIN_DOR.value(), 0.5F, 1F);
        }else if(name.startsWith("len")){
            player.playSound(ModSoundEvents.LEN_DOR.value(), 0.5F, 1F);
        }else if(name.startsWith("luka")){
            player.playSound(ModSoundEvents.LUKA_DOR.value(), 0.5F, 1F);
        }else if(name.startsWith("meiko")){
            player.playSound(ModSoundEvents.MEIKO_DOR.value(), 0.5F, 1F);
        }else if(name.startsWith("kaito")){
            player.playSound(ModSoundEvents.KAITO_DOR.value(), 0.5F, 1F);
        }else if(name.startsWith("gumi")) {
            player.playSound(ModSoundEvents.GUMI_DOR.value(), 0.5F, 1F);
        }
		return super.onLeftClickEntity(stack, player, entity);
	}

}