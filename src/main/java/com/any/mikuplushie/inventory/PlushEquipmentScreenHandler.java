package com.any.mikuplushie.inventory;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.HopperScreenHandler;
import net.minecraft.screen.slot.Slot;

/** Uses the vanilla five-slot screen and networking, with server-side equipment rules. */
public final class PlushEquipmentScreenHandler extends HopperScreenHandler {
    public PlushEquipmentScreenHandler(int syncId, PlayerInventory player, PlushEquipmentInventory equipment) {
        super(syncId, player, equipment);
        for (int i = 0; i < equipment.size(); i++) {
            Slot old = this.slots.get(i);
            Slot replacement = new Slot(equipment, i, old.x, old.y) {
                @Override public boolean canInsert(ItemStack stack) {
                    return this.inventory.isValid(this.getIndex(), stack);
                }
                @Override public int getMaxItemCount() { return 1; }
                @Override public boolean canTakeItems(net.minecraft.entity.player.PlayerEntity owner) {
                    return owner.isCreative() || !net.minecraft.enchantment.EnchantmentHelper.hasAnyEnchantmentsWith(
                        getStack(), net.minecraft.component.EnchantmentEffectComponentTypes.PREVENT_ARMOR_CHANGE);
                }
            };
            replacement.id = i;
            this.slots.set(i, replacement);
        }
    }
}
