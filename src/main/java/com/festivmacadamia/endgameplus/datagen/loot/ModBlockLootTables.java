package com.festivmacadamia.endgameplus.datagen.loot;

import com.festivmacadamia.endgameplus.block.ModBlocks;
import com.festivmacadamia.endgameplus.block.custom.AmaranthCropBlock;
import com.festivmacadamia.endgameplus.block.custom.StrawberryCropBlock;
import com.festivmacadamia.endgameplus.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RAW_ENDERITE.get());
        this.dropSelf(ModBlocks.ENDERITE_BLOCK.get());

        this.dropSelf(ModBlocks.LAVENDER_WOOD.get());
        this.dropSelf(ModBlocks.LAVENDER_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_LAVENDER_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_LAVENDER_LOG.get());
        this.dropSelf(ModBlocks.LAVENDER_PLANKS.get());
        this.dropSelf(ModBlocks.LAVENDER_SAPLING.get());

        this.add(ModBlocks.LAVENDER_LEAVES.get(),(block) ->
                createLeavesDrops(block, ModBlocks.LAVENDER_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));


        this.add(ModBlocks.END_DIAMOND_ORE.get(),
                block -> createDiamondLikeOreDrops(ModBlocks.END_DIAMOND_ORE.get(), Items.DIAMOND));

        this.dropSelf(ModBlocks.LAVENDER_STAIRS.get());
        this.dropSelf(ModBlocks.LAVENDER_BUTTON.get());
        this.dropSelf(ModBlocks.LAVENDER_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.LAVENDER_FENCE.get());
        this.dropSelf(ModBlocks.LAVENDER_FENCE_GATE.get());
        this.dropSelf(ModBlocks.LAVENDER_TRAPDOOR.get());

        this.add(ModBlocks.LAVENDER_DOOR.get(),
                block -> createDoorTable(ModBlocks.LAVENDER_DOOR.get()));
        this.add(ModBlocks.LAVENDER_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LAVENDER_SLAB .get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 5));

        this.add(ModBlocks.STRAWBERRY_CROP.get(), createCropDrops(ModBlocks.STRAWBERRY_CROP.get(), ModItems.STRAWBERRY.get(),
                ModItems.STRAWBERRY_SEEDS.get(), lootitemcondition$builder));
        /*
        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.AMARANTH_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AmaranthCropBlock.AGE, 7))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.AMARANTH_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AmaranthCropBlock.AGE, 8)));
        */
        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                 .hasBlockStateProperties(ModBlocks.AMARANTH_CROP.get())
                 .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AmaranthCropBlock.AGE, 8));

        this.add(ModBlocks.AMARANTH_CROP.get(), createCropDrops(ModBlocks.AMARANTH_CROP.get(), ModItems.AMARANTH.get(),
                ModItems.AMARANTH_SEEDS.get(), lootitemcondition$builder2));
    }

    protected LootTable.Builder createDiamondLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}