package com.festivmacadamia.endgameplus.datagen;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.block.ModBlocks;
import com.festivmacadamia.endgameplus.item.ModItems;
import com.festivmacadamia.endgameplus.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        oreSmelting(pWriter, List.of(ModBlocks.RAW_ENDERITE.get()), RecipeCategory.MISC,
            ModItems.ENDERITE_SCRAP.get(), 0.7f, 200, "enderite_scrap");
        oreBlasting(pWriter, List.of(ModBlocks.RAW_ENDERITE.get()), RecipeCategory.MISC,
            ModItems.ENDERITE_SCRAP.get(), 0.7f, 100, "enderite_scrap");
        oreSmelting(pWriter, List.of(ModBlocks.END_DIAMOND_ORE.get()), RecipeCategory.MISC,
            Items.DIAMOND, 0.7f, 200, "diamond");
        oreBlasting(pWriter, List.of(ModBlocks.END_DIAMOND_ORE.get()), RecipeCategory.MISC,
            Items.DIAMOND, 0.7f, 100, "diamond");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ENDERITE_BLOCK.get())
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            .define('S', ModItems.ENDERITE_INGOT.get())
            .unlockedBy(getHasName(ModItems.ENDERITE_INGOT.get()), has(ModItems.ENDERITE_INGOT.get()))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLDEN_STEAK.get())
            .pattern("SSS")
            .pattern("SDS")
            .pattern("SSS")
            .define('S', Items.GOLD_NUGGET)
            .define('D', Items.COOKED_BEEF)
            .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METAL_DETECTOR.get())
            .pattern("  S")
            .pattern(" D ")
            .pattern("F  ")
            .define('S', Items.NETHERITE_INGOT)
            .define('D', Items.NETHER_STAR)
            .define('F', ModItems.ENDERITE_INGOT.get())
            .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(),2)
                .pattern("SDS")
                .pattern("SFS")
                .pattern("SSS")
                .define('S', Items.DIAMOND)
                .define('D', ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get())
                .define('F', Blocks.END_STONE)
                .unlockedBy(getHasName(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get()), has(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter);

        enderiteSmithing(pWriter, Items.DIAMOND_CHESTPLATE, RecipeCategory.COMBAT, ModItems.ENDERITE_CHESTPLATE.get());
        enderiteSmithing(pWriter, Items.DIAMOND_LEGGINGS, RecipeCategory.COMBAT, ModItems.ENDERITE_LEGGINGS.get());
        enderiteSmithing(pWriter, Items.DIAMOND_HELMET, RecipeCategory.COMBAT, ModItems.ENDERITE_HELMET.get());
        enderiteSmithing(pWriter, Items.DIAMOND_BOOTS, RecipeCategory.COMBAT, ModItems.ENDERITE_BOOTS.get());
        enderiteSmithing(pWriter, Items.DIAMOND_SWORD, RecipeCategory.COMBAT, ModItems.ENDERITE_SWORD.get());
        enderiteSmithing(pWriter, Items.DIAMOND_AXE, RecipeCategory.TOOLS, ModItems.ENDERITE_AXE.get());
        enderiteSmithing(pWriter, Items.DIAMOND_PICKAXE, RecipeCategory.TOOLS, ModItems.ENDERITE_PICKAXE.get());
        enderiteSmithing(pWriter, Items.DIAMOND_HOE, RecipeCategory.TOOLS, ModItems.ENDERITE_HOE.get());
        enderiteSmithing(pWriter, Items.DIAMOND_SHOVEL, RecipeCategory.TOOLS, ModItems.ENDERITE_SHOVEL.get());

        planksFromLog(pWriter,ModBlocks.LAVENDER_PLANKS.get().asItem(), ModTags.Items.LAVENDER_LOGS_ITEM,4);
        
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }
    protected static void oreBlasting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.BLASTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_).group(p_251450_)
                    .unlockedBy(getHasName(itemlike), has(itemlike)).save(p_250791_, new ResourceLocation(EndGamePlus.MOD_ID, getItemName(p_250066_)) + p_249236_ + "_" + getItemName(itemlike));
        }
    }

    protected static void enderiteSmithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(pIngredientItem), Ingredient.of(ModItems.ENDERITE_INGOT.get()), pCategory, pResultItem).unlocks("has_enderite_ingot", has(ModItems.ENDERITE_INGOT.get())).save(pFinishedRecipeConsumer, getItemName(pResultItem) + "_smithing");
     }

    protected static void planksFromLog(Consumer<FinishedRecipe> pFinishedRecipeConsumer, Item pPlanks, TagKey<Item> pLogs, int pResultCount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, pPlanks, pResultCount).requires(pLogs).group("planks").unlockedBy("has_log", has(pLogs)).save(pFinishedRecipeConsumer);
    }

}