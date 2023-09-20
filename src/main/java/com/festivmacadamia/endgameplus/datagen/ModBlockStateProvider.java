package com.festivmacadamia.endgameplus.datagen;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.block.ModBlocks;

import com.festivmacadamia.endgameplus.block.custom.AmaranthCropBlock;
import com.festivmacadamia.endgameplus.block.custom.StrawberryCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output,EndGamePlus.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ENDERITE_BLOCK);
        blockWithItem(ModBlocks.RAW_ENDERITE);
        blockWithItem(ModBlocks.END_DIAMOND_ORE);

        logBlock(((RotatedPillarBlock) ModBlocks.LAVENDER_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.LAVENDER_WOOD.get(), blockTexture(ModBlocks.LAVENDER_LOG.get()), blockTexture(ModBlocks.LAVENDER_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_LAVENDER_LOG.get(), new ResourceLocation(EndGamePlus.MOD_ID, "block/stripped_lavender_log"),
                new ResourceLocation(EndGamePlus.MOD_ID, "block/stripped_lavender_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_LAVENDER_WOOD.get(), new ResourceLocation(EndGamePlus.MOD_ID, "block/stripped_lavender_log"),
                new ResourceLocation(EndGamePlus.MOD_ID, "block/stripped_lavender_log"));
        simpleBlockItem(ModBlocks.LAVENDER_LOG.get(), models().withExistingParent("endgameplus:lavender_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.LAVENDER_WOOD.get(), models().withExistingParent("endgameplus:lavender_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_LAVENDER_LOG.get(), models().withExistingParent("endgameplus:stripped_lavender_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_LAVENDER_WOOD.get(), models().withExistingParent("endgameplus:stripped_lavender_wood", "minecraft:block/cube_column"));
        blockWithItem(ModBlocks.LAVENDER_PLANKS);
        blockWithItem(ModBlocks.LAVENDER_LEAVES);
        saplingBlock(ModBlocks.LAVENDER_SAPLING);

        stairsBlock((StairBlock) ModBlocks.LAVENDER_STAIRS.get(),blockTexture(ModBlocks.LAVENDER_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.LAVENDER_SLAB.get(), blockTexture(ModBlocks.LAVENDER_PLANKS.get()), blockTexture(ModBlocks.LAVENDER_PLANKS.get()));

        buttonBlock((ButtonBlock) ModBlocks.LAVENDER_BUTTON.get(),blockTexture(ModBlocks.LAVENDER_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.LAVENDER_PRESSURE_PLATE.get(),blockTexture(ModBlocks.LAVENDER_PLANKS.get()));

        fenceBlock((FenceBlock) ModBlocks.LAVENDER_FENCE.get(),blockTexture(ModBlocks.LAVENDER_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.LAVENDER_FENCE_GATE.get(),blockTexture(ModBlocks.LAVENDER_PLANKS.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.LAVENDER_DOOR.get(), modLoc("block/lavender_door_bottom"), modLoc("block/lavender_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.LAVENDER_TRAPDOOR.get(), modLoc("block/lavender_trapdoor"), true, "cutout");

        makeStrawberryCrop((CropBlock) ModBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
        makeAmaranthCrop(((CropBlock) ModBlocks.AMARANTH_CROP.get()), "amaranth_stage", "amaranth_stage");

        simpleBlockWithItem(ModBlocks.PINK_ORCHID.get(), models().cross(blockTexture(ModBlocks.PINK_ORCHID.get()).getPath(),
                blockTexture(ModBlocks.PINK_ORCHID.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_PINK_ORCHID.get(), models().singleTexture("potted_pink_orchid", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.PINK_ORCHID.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.WILD_STRAWBERRY.get(), models().cross(blockTexture(ModBlocks.WILD_STRAWBERRY.get()).getPath(),
                blockTexture(ModBlocks.WILD_STRAWBERRY.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.CATMINT.get(), models().cross(blockTexture(ModBlocks.CATMINT.get()).getPath(),
                blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_CATMINT.get(), models().singleTexture("potted_catmint", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.AZURRI_BLUE_SATIN.get(), models().cross(blockTexture(ModBlocks.AZURRI_BLUE_SATIN.get()).getPath(),
                blockTexture(ModBlocks.AZURRI_BLUE_SATIN.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_AZURI_BLUE_SATIN.get(), models().singleTexture("potted_azuri_blue_satin", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.AZURRI_BLUE_SATIN.get())).renderType("cutout"));
    }
    
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(EndGamePlus.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeAmaranthCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> amaranthStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] amaranthStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((AmaranthCropBlock) block).getAgeProperty()),
                new ResourceLocation(EndGamePlus.MOD_ID, "block/" + textureName + state.getValue(((AmaranthCropBlock) block).getAgeProperty()))).renderType("cutout"));
        return models;
    }
}
