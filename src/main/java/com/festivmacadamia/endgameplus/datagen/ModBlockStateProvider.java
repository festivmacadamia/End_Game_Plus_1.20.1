package com.festivmacadamia.endgameplus.datagen;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.block.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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

    }
    
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
