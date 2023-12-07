package com.festivmacadamia.endgameplus.datagen;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.block.ModBlocks;
import com.festivmacadamia.endgameplus.item.ModItems;

import com.festivmacadamia.endgameplus.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, EndGamePlus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.ENDERITE_HELMET.get(),ModItems.ENDERITE_CHESTPLATE.get(),
                ModItems.ENDERITE_LEGGINGS.get(),ModItems.ENDERITE_BOOTS.get());

        this.tag(ModTags.Items.LAVENDER_LOGS_ITEM)
                .add(ModBlocks.LAVENDER_LOG.get().asItem(),
                        ModBlocks.STRIPPED_LAVENDER_LOG.get().asItem(),
                        ModBlocks.LAVENDER_WOOD.get().asItem(),
                        ModBlocks.STRIPPED_LAVENDER_WOOD.get().asItem());
        this.tag(ItemTags.LOGS_THAT_BURN)
                .addTags(ModTags.Items.LAVENDER_LOGS_ITEM);
        this.tag(ItemTags.LOGS)
                .addTags(ModTags.Items.LAVENDER_LOGS_ITEM);
        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.LAVENDER_PLANKS.get().asItem());
        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.AMONGUS_DRIP_DISC.get());
        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.AMONGUS_DRIP_DISC.get());

    }
}