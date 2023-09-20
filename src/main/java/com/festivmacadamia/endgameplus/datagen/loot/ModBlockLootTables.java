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
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
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

        this.dropSelf(ModBlocks.PINK_ORCHID.get());
        this.add(ModBlocks.POTTED_PINK_ORCHID.get(),createPotFlowerItemTable(ModBlocks.PINK_ORCHID.get()));

        this.add(ModBlocks.WILD_STRAWBERRY.get(),(block) ->
                createWildStrawberryDrops(block, ModItems.STRAWBERRY.get(), ModItems.STRAWBERRY_SEEDS.get()));

        this.dropSelf(ModBlocks.CATMINT.get());
        this.add(ModBlocks.POTTED_CATMINT.get(),createPotFlowerItemTable(ModBlocks.CATMINT.get()));

        this.dropSelf(ModBlocks.AZURRI_BLUE_SATIN.get());
        this.add(ModBlocks.POTTED_AZURI_BLUE_SATIN.get(),createPotFlowerItemTable(ModBlocks.AZURRI_BLUE_SATIN.get()));
    }

    protected LootTable.Builder createDiamondLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();
    protected LootTable.Builder createWildStrawberryDrops(Block pBlock, Item pMain, Item pAux) {
        return createSilkTouchOrShearsDispatchTable(pBlock, this.applyExplosionCondition(pBlock, LootItem.lootTableItem(pMain))
                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 1.0f)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pAux)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.5f))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}