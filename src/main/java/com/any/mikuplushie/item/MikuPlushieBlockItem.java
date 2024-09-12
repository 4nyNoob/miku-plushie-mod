package com.any.mikuplushie.item;

import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.datagen.ModTagProvider;
import net.minecraft.block.Block;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class MikuPlushieBlockItem extends BlockItem {

	public MikuPlushieBlockItem(Block block, Settings settings) {
		super(block, settings);
	}

	public static AttributeModifiersComponent createAttributeModifiers(float attackSpeed) {
		return AttributeModifiersComponent.builder()
				.add(
						EntityAttributes.GENERIC_ATTACK_SPEED,
						new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, (double)attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
						AttributeModifierSlot.MAINHAND
				)
				.build();
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		tooltip.add(Text.translatable("item." + stack.getItem().toString().replace(":", ".") + ".tooltip"));
		super.appendTooltip(stack, context, tooltip, type);
	}

	public static void PlayMikuSound(LivingEntity entity){
		if (entity.getStackInHand(entity.getActiveHand()).isIn(ModTagProvider.BR_MIKU_ITEMS)){
			entity.playSound(ModSoundEvents.DOR, 1f, 1);
		}
	}
}
