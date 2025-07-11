package com.any.mikuplushie.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents extends FoodComponents {
    public static final FoodComponent BAGUETTE = new FoodComponent.Builder().hunger(7).saturationModifier(0.6F).build();
}
