package com.any.mikuplushie.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;

public class ModFoodComponents extends FoodComponents {
    public static final FoodComponent BAGUETTE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.6F).build();
    public static final FoodComponent LEEK = new FoodComponent.Builder().nutrition(4).saturationModifier(0.6F).build();
}
