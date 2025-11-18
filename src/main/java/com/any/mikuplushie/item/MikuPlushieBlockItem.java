package com.any.mikuplushie.item;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.datagen.ModTagProvider;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MikuPlushieBlockItem extends BlockItem implements Equipment {

	public MikuPlushieBlockItem(Block block, Settings settings) {
		super(block, settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("item." + MikuPlushie.MOD_ID + "." + stack.getItem().toString() + ".tooltip"));
		super.appendTooltip(stack, world, tooltip, context);
	}

	public static void PlayMikuSound(LivingEntity entity){
		ItemStack stack = entity.getStackInHand(entity.getActiveHand());

		if (stack.isIn(ModTagProvider.MIKU_PLUSH)){
			entity.playSound(ModSoundEvents.MIKU_DOR, 1f, 1);
		}
		if (stack.isIn(ModTagProvider.AIKO_PLUSH)) {
			entity.playSound(ModSoundEvents.AIKO_DOR, 1f, 1);
		}
		if (stack.isIn(ModTagProvider.TETO_PLUSH)) {
			entity.playSound(ModSoundEvents.TETO_DOR, 1f, 1);
		}
		if (stack.isIn(ModTagProvider.NERU_PLUSH)) {
			entity.playSound(ModSoundEvents.NERU_DOR, 1f, 1);
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
	public SoundEvent getEquipSound() {
		ItemStack stack = this.getDefaultStack();

		if (stack.isIn(ModTagProvider.AIKO_PLUSH)) {
			return ModSoundEvents.AIKO_EQUIP;
		}
		if (stack.isIn(ModTagProvider.TETO_PLUSH)) {
			return ModSoundEvents.TETO_EQUIP;
		}
		if (stack.isIn(ModTagProvider.NERU_PLUSH)) {
			return ModSoundEvents.NERU_EQUIP;
		}
		if (stack.isIn(ModTagProvider.RIN_PLUSH)) {
			return ModSoundEvents.RIN_EQUIP;
		}
		if (stack.isIn(ModTagProvider.LEN_PLUSH)) {
			return ModSoundEvents.LEN_EQUIP;
		}
		if (stack.isIn(ModTagProvider.LUKA_PLUSH)) {
			return ModSoundEvents.LUKA_EQUIP;
		}

		return ModSoundEvents.MIKU_EQUIP;
	}
}