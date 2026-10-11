package com.any.mikuplushie.inventory;

import com.any.mikuplushie.entity.AbstractPlushEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;

/** Live view of the entity's equipment; no second storage or close-time copying. */
public final class PlushEquipmentInventory implements Inventory {
    public static final EquipmentSlot[] EQUIPMENT = {
        EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS,
        EquipmentSlot.FEET, EquipmentSlot.MAINHAND
    };
    private final AbstractPlushEntity plush;
    public PlushEquipmentInventory(AbstractPlushEntity plush) { this.plush = plush; }
    @Override public int size() { return EQUIPMENT.length; }
    @Override public int getMaxCountPerStack() { return 1; }
    @Override public boolean isEmpty() {
        for (int i = 0; i < size(); i++) if (!getStack(i).isEmpty()) return false;
        return true;
    }
    @Override public ItemStack getStack(int slot) { return plush.getEquippedStack(EQUIPMENT[slot]); }
    @Override public ItemStack removeStack(int slot, int count) {
        ItemStack result = getStack(slot).split(count);
        if (getStack(slot).isEmpty()) setStack(slot, ItemStack.EMPTY);
        markDirty();
        return result;
    }
    @Override public ItemStack removeStack(int slot) {
        ItemStack result = getStack(slot);
        setStack(slot, ItemStack.EMPTY);
        return result;
    }
    @Override public void setStack(int slot, ItemStack stack) {
        plush.equipStack(EQUIPMENT[slot], stack);
        plush.setEquipmentDropChance(EQUIPMENT[slot], 2.0F);
    }
    @Override public void markDirty() { }
    @Override public boolean canPlayerUse(PlayerEntity player) {
        return plush.isAlive() && plush.isTamed() && plush.isOwner(player)
            && player.squaredDistanceTo(plush) <= 64;
    }
    @Override public boolean isValid(int slot, ItemStack stack) {
        if (slot == 4) return stack.isIn(ItemTags.SWORDS);
        var equippable = stack.get(DataComponentTypes.EQUIPPABLE);
        return equippable != null && equippable.slot() == EQUIPMENT[slot];
    }
    @Override public void clear() {
        for (int i = 0; i < size(); i++) setStack(i, ItemStack.EMPTY);
    }
}
