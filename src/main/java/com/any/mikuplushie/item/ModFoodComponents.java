package com.any.mikuplushie.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents extends FoodComponents {
    public static final FoodComponent BAGUETTE = new FoodComponent.Builder().hunger(8).saturationModifier(0.6F).build();
    public static final FoodComponent LEEK = new FoodComponent.Builder().hunger(4).saturationModifier(0.6F).build();
}
