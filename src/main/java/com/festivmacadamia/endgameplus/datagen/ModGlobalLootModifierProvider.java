package com.festivmacadamia.endgameplus.datagen;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.block.ModBlocks;
import com.festivmacadamia.endgameplus.item.ModItems;
import com.festivmacadamia.endgameplus.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, EndGamePlus.MOD_ID);
    }

    @Override
    protected void start() {

        /*
        //random drops from block
        add("CHOOSENAME", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CHOOSEBLOCK).build(),
                LootItemRandomChanceCondition.randomChance(CHOOSECHANCEf).build()}, ModItems.CHOOSEITEM.get()));

        //guaranteed drops from block
        add("CHOOSENAME", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CHOOSEBLOCK).build()}, ModItems.CHOOSEITEM.get()));

        //random drops from mob
        add("CHOOSENAME", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entity/CHOOSEMOB")).build(),
                LootItemRandomChanceCondition.randomChance(CHOOSECHANCEf).build() }, ModItems.CHOOSEITEM.get()));

        //guaranteed drops from mob
        add("CHOOSENAME", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entity/CHOOSEMOB")).build() }, ModItems.CHOOSEITEM.get()));

        //random drop from chest
        add("CHOOSENAME", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/CHOOSECHEST")).build(),
                 LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.CHOOSEITEM.get()));

        //guaranteed drop from chest
        add("CHOOSENAME", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/CHOOSECHEST")).build() }, ModItems.CHOOSEITEM.get()));
        */

        add("amaranth_seed_from_tall_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.AMARANTH_SEEDS.get()));
        add("enderite_smithing_template_from_end_city_chest", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()}, ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get()));
        add("raw_enderite_from_end_city_chest", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.33f).build()}, ModBlocks.RAW_ENDERITE.get().asItem()));
        add("enderite_ingot_from_end_city_chest", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build() }, ModItems.ENDERITE_SCRAP.get()));
        add("enderite_scrap_from_end_city_chest", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()}, ModItems.ENDERITE_INGOT.get()));
        add("metal_detector_from_mineshaft_chest", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.014f).build() }, ModItems.METAL_DETECTOR.get()));
    }
}
