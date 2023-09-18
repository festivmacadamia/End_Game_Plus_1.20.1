package com.festivmacadamia.endgameplus.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.block.ModBlocks;
import com.festivmacadamia.endgameplus.util.ModTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagGenerator extends BlockTagsProvider{

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider,EndGamePlus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
            .add(ModBlocks.RAW_ENDERITE.get(),
                ModBlocks.END_DIAMOND_ORE.get())
            .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.END_DIAMOND_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.RAW_ENDERITE.get(),
                ModBlocks.ENDERITE_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.RAW_ENDERITE.get(),
                ModBlocks.END_DIAMOND_ORE.get(),
                ModBlocks.ENDERITE_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.LAVENDER_LOG.get(),
                    ModBlocks.LAVENDER_WOOD.get(),
                    ModBlocks.STRIPPED_LAVENDER_LOG.get(),
                    ModBlocks.STRIPPED_LAVENDER_WOOD.get(),
                    ModBlocks.LAVENDER_PLANKS.get(),
                        ModBlocks.LAVENDER_STAIRS.get(),
                        ModBlocks.LAVENDER_SLAB.get(),
                        ModBlocks.LAVENDER_BUTTON.get(),
                        ModBlocks.LAVENDER_PRESSURE_PLATE.get(),
                        ModBlocks.LAVENDER_FENCE.get(),
                        ModBlocks.LAVENDER_FENCE_GATE.get(),
                        ModBlocks.LAVENDER_DOOR.get(),
                        ModBlocks.LAVENDER_TRAPDOOR.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.LAVENDER_LEAVES.get());
            
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.LAVENDER_PLANKS.get());

        this.tag(BlockTags.SAPLINGS)
                .add(ModBlocks.LAVENDER_SAPLING.get());

        this.tag(ModTags.Blocks.LAVENDER_LOGS)
                .add(ModBlocks.LAVENDER_LOG.get(),
                    ModBlocks.STRIPPED_LAVENDER_LOG.get(),
                    ModBlocks.LAVENDER_WOOD.get(),
                    ModBlocks.STRIPPED_LAVENDER_WOOD.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTags(ModTags.Blocks.LAVENDER_LOGS);

        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.LAVENDER_LEAVES.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.LAVENDER_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.LAVENDER_FENCE_GATE.get());
        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.LAVENDER_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.LAVENDER_STAIRS.get());
        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.LAVENDER_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.LAVENDER_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.LAVENDER_BUTTON.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.LAVENDER_PRESSURE_PLATE.get());
    }
    
}
