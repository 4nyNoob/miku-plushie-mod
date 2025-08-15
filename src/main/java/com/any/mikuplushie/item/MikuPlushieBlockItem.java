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
import net.minecraft.sound.SoundEvents;
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
		ItemStack stack = entity.getStackInHand(entity.getActiveHand());

		if (stack.isIn(ModTagProvider.BR_MIKU_ITEMS)) {
			entity.playSound(ModSoundEvents.MIKU_DOR, 1f, 1);
		}
		if (stack.isIn(ModTagProvider.AIKO_PLUSH)) {
			entity.playSound(ModSoundEvents.AIKO_DOR, 1f, 1);
		}
		if (stack.isIn(ModTagProvider.TETO_PLUSH)) {
			entity.playSound(ModSoundEvents.TETO_DOR, 1f, 1);
		}
		if (stack.isIn(ModTagProvider.AKITA_NERU_PLUSH)) {
			entity.playSound(ModSoundEvents.AKITA_NERU_DOR, 1f, 1);
		}
		if (stack.isIn(ModTagProvider.RIN_PLUSH)) {
			entity.playSound(ModSoundEvents.RIN_DOR, 1f, 1);
		}
		if (stack.isIn(ModTagProvider.LEN_PLUSH)) {
			entity.playSound(ModSoundEvents.LEN_DOR, 1f, 1);
		}
		if (stack.isIn(ModTagProvider.LUKA_PLUSH)) {
			entity.playSound(ModSoundEvents.LUKA_DOR, 1f, 1);
		}

	}

	@Override
	public EquipmentSlot getSlotType() {
		return EquipmentSlot.HEAD;
	}

	@Override
	public RegistryEntry<SoundEvent> getEquipSound() {
		ItemStack stack = this.getDefaultStack();

		if (stack.isIn(ModTagProvider.AIKO_PLUSH)) {
			return RegistryEntry.of(ModSoundEvents.AIKO_EQUIP);
		}
		if (stack.isIn(ModTagProvider.TETO_PLUSH)) {
			return RegistryEntry.of(ModSoundEvents.TETO_EQUIP);
		}
		if (stack.isIn(ModTagProvider.AKITA_NERU_PLUSH)) {
			return RegistryEntry.of(ModSoundEvents.AKITA_NERU_EQUIP);
		}
		if (stack.isIn(ModTagProvider.RIN_PLUSH)) {
			return RegistryEntry.of(ModSoundEvents.RIN_EQUIP);
		}
		if (stack.isIn(ModTagProvider.LEN_PLUSH)) {
			return RegistryEntry.of(ModSoundEvents.LEN_EQUIP);
		}
		if (stack.isIn(ModTagProvider.LUKA_PLUSH)) {
			return RegistryEntry.of(ModSoundEvents.LUKA_EQUIP);
		}
		if (stack.isIn(ModTagProvider.BR_MIKU_ITEMS)) {
            return RegistryEntry.of(ModSoundEvents.MIKU_EQUIP);
		}
        return RegistryEntry.of(SoundEvents.BLOCK_WOOL_PLACE);
	}
}