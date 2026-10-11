package com.any.mikuplushie.item;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.registry.ModItemTags;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import java.util.function.Consumer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;

import java.util.List;

public class MikuPlushieBlockItem extends BlockItem {

	public MikuPlushieBlockItem(Block block, Settings settings) {
		super(block, settings.component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.HEAD).equipSound(RegistryEntry.of(equipSoundFor(block))).damageOnHurt(false).build()));
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, net.minecraft.component.type.TooltipDisplayComponent display, Consumer<Text> tooltip, TooltipType type) {
		tooltip.accept(Text.translatable("item." + MikuPlushie.MOD_ID + "." + stack.getItem().toString() + ".tooltip"));
		super.appendTooltip(stack, context, display, tooltip, type);
	}

	public static void PlayMikuSound(LivingEntity entity){
		ItemStack stack = entity.getStackInHand(entity.getActiveHand());

		if (stack.isIn(ModItemTags.PLUSHIES)){
			String currentPlush = ModUtil.getBlockIdFromItem(stack.getItem());
			ModUtil.playPlushSound(entity.getEntityWorld(), entity.getBlockPos(), currentPlush, "dor");
		}

	}

    private static SoundEvent equipSoundFor(Block block) {
        String name = ModUtil.getBlockIdFromBlock(block);
        return name.equals("konoha_plush") ? SoundEvents.BLOCK_WOOL_PLACE : ModUtil.getPlushSoundEvent(name, "equip");
    }
}
