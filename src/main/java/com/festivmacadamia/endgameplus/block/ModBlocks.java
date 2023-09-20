package com.festivmacadamia.endgameplus.block;

import java.util.function.Supplier;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.block.custom.AmaranthCropBlock;
import com.festivmacadamia.endgameplus.block.custom.ModFlammableRotatedPillarBlock;
import com.festivmacadamia.endgameplus.block.custom.StrawberryCropBlock;
import com.festivmacadamia.endgameplus.item.ModItems;

import com.festivmacadamia.endgameplus.worldgen.tree.LavenderTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, EndGamePlus.MOD_ID);
    
    public static final RegistryObject<Block> ENDERITE_BLOCK = registerBlock("enderite_block", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> RAW_ENDERITE = registerBlock("raw_enderite", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)));
        
    public static final RegistryObject<Block> END_DIAMOND_ORE = registerBlock("end_diamond_ore", 
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
            .strength(6f, 4.5f), UniformInt.of(3, 7)));


    public static final RegistryObject<Block> LAVENDER_LOG = registerBlock("lavender_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> LAVENDER_WOOD = registerBlock("lavender_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_LAVENDER_LOG = registerBlock("stripped_lavender_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_LAVENDER_WOOD = registerBlock("stripped_lavender_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> LAVENDER_PLANKS = registerBlock("lavender_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });

    public static final RegistryObject<Block> LAVENDER_LEAVES = registerBlock("lavender_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> LAVENDER_SAPLING = registerBlock("lavender_sapling",
            () -> new SaplingBlock(new LavenderTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> LAVENDER_STAIRS = registerBlock("lavender_stairs",
            () -> new StairBlock(() -> ModBlocks.LAVENDER_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> LAVENDER_SLAB = registerBlock("lavender_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });

    public static final RegistryObject<Block> LAVENDER_BUTTON = registerBlock("lavender_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> LAVENDER_PRESSURE_PLATE = registerBlock("lavender_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> LAVENDER_FENCE = registerBlock("lavender_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> LAVENDER_FENCE_GATE = registerBlock("lavender_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN,SoundEvents.FENCE_GATE_CLOSE){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });

    public static final RegistryObject<Block> LAVENDER_DOOR = registerBlock("lavender_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> LAVENDER_TRAPDOOR = registerBlock("lavender_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> STRAWBERRY_CROP = BLOCKS.register("strawberry_crop",
            () -> new StrawberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> AMARANTH_CROP = BLOCKS.register("amaranth_crop",
            () -> new AmaranthCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> PINK_ORCHID = registerBlock("pink_orchid",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.POPPY).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_PINK_ORCHID = BLOCKS.register("potted_pink_orchid",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ModBlocks.PINK_ORCHID,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));
    public static final RegistryObject<Block> WILD_STRAWBERRY = registerBlock("wild_strawberry",
            () -> new FlowerBlock(() -> MobEffects.POISON, 5, BlockBehaviour.Properties.copy(Blocks.POPPY).noOcclusion().noCollission()));

    public static final RegistryObject<Block> CATMINT = registerBlock("catmint",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5, BlockBehaviour.Properties.copy(Blocks.POPPY).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_CATMINT = BLOCKS.register("potted_catmint",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ModBlocks.CATMINT,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));

    public static final RegistryObject<Block> AZURRI_BLUE_SATIN = registerBlock("azuri_blue_satin",
            () -> new FlowerBlock(() -> MobEffects.NIGHT_VISION, 5, BlockBehaviour.Properties.copy(Blocks.POPPY).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_AZURI_BLUE_SATIN = BLOCKS.register("potted_azuri_blue_satin",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ModBlocks.AZURRI_BLUE_SATIN,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}