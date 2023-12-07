package com.festivmacadamia.endgameplus.worldgen.biome.surface;

import com.festivmacadamia.endgameplus.block.ModBlocks;
import com.festivmacadamia.endgameplus.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource ENDERITE = makeStateRule(ModBlocks.ENDERITE_BLOCK.get());
    private static final SurfaceRules.RuleSource RAW_ENDERITE = makeStateRule(ModBlocks.RAW_ENDERITE.get());


    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return //SurfaceRules.sequence(
                //SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.LAVENDER_FOREST),
                                //SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, RAW_ENDERITE)),
                                //SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, ENDERITE)),


                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}