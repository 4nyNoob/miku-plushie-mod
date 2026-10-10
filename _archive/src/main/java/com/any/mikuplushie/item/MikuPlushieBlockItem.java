package com.any.mikuplushie.item;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.datagen.ModItemTagProvider;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.util.ModUtil;
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
		tooltip.add(Text.translatable("item." + MikuPlushie.MOD_ID + "." + stack.getItem().toString() + ".tooltip"));
		super.appendTooltip(stack, context, tooltip, type);
	}

	public static void PlayMikuSound(LivingEntity entity){
		ItemStack stack = entity.getStackInHand(entity.getActiveHand());

		if (stack.isIn(ModItemTagProvider.PLUSHIES)){
			String currentPlush = ModUtil.getBlockIdFromItem(stack.getItem());
			ModUtil.playPlushSound(entity.getWorld(), entity.getBlockPos(), currentPlush, "dor");
		}

	}

	@Override
	public EquipmentSlot getSlotType() {
		return EquipmentSlot.HEAD;
	}

	@Override
	public RegistryEntry<SoundEvent> getEquipSound() {
		ItemStack stack = this.getDefaultStack();

		if (stack.isIn(ModItemTagProvider.PLUSHIES)){
			if (!stack.isOf(ModBlocks.KONOHA_PLUSH.asItem())){
				String currentPlush = ModUtil.getBlockIdFromItem(stack.getItem());
				return RegistryEntry.of(ModUtil.getPlushSoundEvent(currentPlush, "equip"));
			}
		}
        return RegistryEntry.of(SoundEvents.BLOCK_WOOL_PLACE);
    }
}