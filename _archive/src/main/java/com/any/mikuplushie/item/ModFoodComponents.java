package com.any.mikuplushie.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

public class ModFoodComponents extends Foods {
    public static final FoodProperties BAGUETTE = new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).build();
    public static final FoodProperties LEEK = new FoodProperties.Builder().nutrition(4).saturationModifier(0.6F).build();
}
