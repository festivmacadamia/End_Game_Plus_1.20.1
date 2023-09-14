package com.festivmacadamia.endgameplus.item;

import java.util.List;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.util.ModTags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public class ModToolTiers {
    public static final Tier INTERDIMENSIONAL = TierSortingRegistry.registerTier(
        new ForgeTier(5, 2678, 10f, 5f, 22, 
            ModTags.Blocks.NEEDS_INTERDIMENSIONAL_TOOL, () -> Ingredient.of(ModItems.ENDERITE_INGOT.get())),
        new ResourceLocation(EndGamePlus.MOD_ID, "interdimensional"), List.of(Tiers.NETHERITE), List.of());
    //enderite is a placeholder for interdimensional ingot
}
