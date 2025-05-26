package com.any.mikuplushie.item;

import com.any.mikuplushie.ModSoundEvents;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class MikuPlushieBlockItem extends BlockItem implements Equipable {

	public MikuPlushieBlockItem(Block block, Properties settings) {
		super(block, settings);
	}

	public MikuPlushieBlockItem(Block block) {
		super(block, new Properties());
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		tooltipComponents.add(Component.translatable("item."+stack.getItem().toString().replace(":",".")+".tooltip"));
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}

	@Override
	public EquipmentSlot getEquipmentSlot() {
		return EquipmentSlot.HEAD;
	}

	@Override
	public Holder<SoundEvent> getEquipSound() {
		return ModSoundEvents.MIKU_EQUIP;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
		player.playSound(ModSoundEvents.MIKU_DOR.value(), 0.5F, 1F);
		return super.onLeftClickEntity(stack, player, entity);
	}

}