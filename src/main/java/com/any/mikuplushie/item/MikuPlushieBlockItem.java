package com.any.mikuplushie.item;

import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.datagen.ModTagProvider;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;

import java.util.List;

public class MikuPlushieBlockItem extends BlockItem implements Equipment {

	public MikuPlushieBlockItem(Block block, Settings settings) {
		super(block, settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		tooltip.add(Text.translatable("item." + stack.getItem().toString().replace(":", ".") + ".tooltip"));
		super.appendTooltip(stack, context, tooltip, type);
	}

	public static void PlayMikuSound(LivingEntity entity) {
		if (entity.getStackInHand(entity.getActiveHand()).isIn(ModTagProvider.BR_MIKU_ITEMS)) {
			entity.playSound(ModSoundEvents.DOR, 1f, 1);
		}
	}

	@Override
	public EquipmentSlot getSlotType() {
		return EquipmentSlot.HEAD;
	}

	@Override
	public RegistryEntry<SoundEvent> getEquipSound() {
		return RegistryEntry.of(ModSoundEvents.EQUIP);
	}
}