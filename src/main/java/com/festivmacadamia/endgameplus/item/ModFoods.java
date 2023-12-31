package com.festivmacadamia.endgameplus.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties GOLDEN_STEAK = new FoodProperties.Builder()
        .nutrition(8).saturationMod(1.2f).build();
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.15f).build();
    public static final FoodProperties STRAWBERRY_PIE = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.45f).build();
    public static final FoodProperties POPPED_AMARANTH = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.1f).build();
}
