package com.festivmacadamia.endgameplus.worldgen.biome;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.entity.ModEntities;
import com.festivmacadamia.endgameplus.sound.ModSoundEvents;
import com.festivmacadamia.endgameplus.util.ColorSwapper;
import com.festivmacadamia.endgameplus.worldgen.ModPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes {
    public static final ResourceKey<Biome> LAVENDER_FOREST = ResourceKey.create(Registries.BIOME,
        new ResourceLocation(EndGamePlus.MOD_ID, "lavender_forest"));

    public static void bootstrap(BootstapContext<Biome> context){
        context.register(LAVENDER_FOREST, lavenderForest(context));
    }

    private static Biome lavenderForest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MUNCHER.get(), 2, 3, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.CAPYBARA.get(), 5, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.HAMIS.get(), 5, 4, 4));
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        //globalOverworldGeneration(biomeBuilder);
        //BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        //BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        //biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_FLOWER_FOREST);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LAVENDER_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x5c4f9c)
                        .waterFogColor(0x382c72)
                        .skyColor(0xe5ccf4)
                        .grassColorOverride(0xb7c2c6)
                        .foliageColorOverride(0xb7c2c6)
                        .fogColor(0x382c72)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(ModSoundEvents.AMONGUS_DRIP.getHolder().get())).build())
                .build();
    }
}


