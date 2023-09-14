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
            
        
    }
    
}
