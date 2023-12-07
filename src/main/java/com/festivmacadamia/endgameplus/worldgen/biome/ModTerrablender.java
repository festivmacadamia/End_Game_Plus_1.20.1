package com.festivmacadamia.endgameplus.worldgen.biome;

import com.festivmacadamia.endgameplus.EndGamePlus;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(EndGamePlus.MOD_ID, "overworld"), 5));
    }
}
