package com.any.mikuplushie.item;

import com.google.common.base.Suppliers;
import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum PlushToolMaterial implements Tier {

    PLUSH_TOOL_MATERIAL(
        BlockTags.INCORRECT_FOR_WOODEN_TOOL,
        500,
        15,
        0,
        25,
        () -> Ingredient.of(Items.DIAMOND));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private PlushToolMaterial(
        final TagKey<Block> inverseTag,
        final int itemDurability,
        final float miningSpeed,
        final float attackDamage,
        final int enchantability,
        final Supplier<Ingredient> repairIngredient
    ) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int getUses() {
        return this.itemDurability;
    }

    public float getSpeed() {
        return this.miningSpeed;
    }

    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.inverseTag;
    }

    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
