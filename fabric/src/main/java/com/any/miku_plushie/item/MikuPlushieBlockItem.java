package com.any.miku_plushie.item;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.datagen.ModItemTagProvider;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.impl.common.util.ModUtil;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

public class MikuPlushieBlockItem extends BlockItem implements Equipable {

  public MikuPlushieBlockItem(Block block, Properties settings) {
    super(block, settings);
  }

  public static void PlayMikuSound(LivingEntity entity) {
    ItemStack stack = entity.getItemInHand(entity.getUsedItemHand());

    if (stack.is(ModItemTagProvider.PLUSHIES)) {
      String currentPlush = ModUtil.getBlockIdFromItem(stack.getItem());
      ModUtil.playPlushSound(entity.level(), entity.blockPosition(), currentPlush, "dor");
    }

  }

  @Override
  public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
    tooltip.add(Component.translatable("item." + Constants.MOD_ID + "." + stack.getItem() + ".tooltip"));
    super.appendHoverText(stack, context, tooltip, type);
  }

  @Override
  public EquipmentSlot getEquipmentSlot() {
    return EquipmentSlot.HEAD;
  }

  @Override
  public Holder<SoundEvent> getEquipSound() {
    ItemStack stack = this.getDefaultInstance();

    if (stack.is(ModItemTagProvider.PLUSHIES)) {
      if (!stack.is(ModBlocks.KONOHA_PLUSH.asItem())) {
        String currentPlush = ModUtil.getBlockIdFromItem(stack.getItem());
        return Holder.direct(ModUtil.getPlushSoundEvent(currentPlush, "equip"));
      }
    }
    return Holder.direct(SoundEvents.WOOL_PLACE);
  }
}