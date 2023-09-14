package com.festivmacadamia.endgameplus.block;

import java.util.function.Supplier;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.item.ModItems;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
