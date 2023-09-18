package com.festivmacadamia.endgameplus.util;

import com.festivmacadamia.endgameplus.EndGamePlus;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{

        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> LAVENDER_LOGS = tag("lavender_logs");
        public static final TagKey<Block> NEEDS_INTERDIMENSIONAL_TOOL = tag("needs_interdimensional_tool");
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(EndGamePlus.MOD_ID, name));
        }
    
    }
    public static class Items{

        public static final TagKey<Item> LAVENDER_LOGS_ITEM = tag("lavender_logs_item");
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(EndGamePlus.MOD_ID, name));
        }
    }
}
