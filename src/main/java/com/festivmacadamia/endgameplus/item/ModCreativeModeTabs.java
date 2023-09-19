package com.festivmacadamia.endgameplus.item;


import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.block.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EndGamePlus.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("egp_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ENDERITE_INGOT.get()))
                    .title(Component.translatable("creativetab.egp_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ENDERITE_INGOT.get());
                        pOutput.accept(ModItems.ENDERITE_SCRAP.get());
                        pOutput.accept(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get());

                        pOutput.accept(ModItems.ENDERITE_AXE.get());
                        pOutput.accept(ModItems.ENDERITE_HOE.get());
                        pOutput.accept(ModItems.ENDERITE_PICKAXE.get());
                        pOutput.accept(ModItems.ENDERITE_SHOVEL.get());
                        pOutput.accept(ModItems.ENDERITE_SWORD.get());

                        pOutput.accept(ModItems.ENDERITE_HELMET.get());
                        pOutput.accept(ModItems.ENDERITE_CHESTPLATE.get());
                        pOutput.accept(ModItems.ENDERITE_LEGGINGS.get());
                        pOutput.accept(ModItems.ENDERITE_BOOTS.get());

                        pOutput.accept(ModBlocks.ENDERITE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_ENDERITE.get());
                        pOutput.accept(ModBlocks.END_DIAMOND_ORE.get());

                        pOutput.accept(ModItems.GOLDEN_STEAK.get());
                        pOutput.accept(ModItems.POPPED_AMARANTH.get());
                        pOutput.accept(ModItems.STRAWBERRY_PIE.get());
                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());
                        pOutput.accept(ModItems.AMARANTH.get());
                        pOutput.accept(ModItems.AMARANTH_SEEDS.get());

                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        pOutput.accept(ModBlocks.LAVENDER_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_LAVENDER_LOG.get());
                        pOutput.accept(ModBlocks.LAVENDER_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_LAVENDER_WOOD.get());
                        pOutput.accept(ModBlocks.LAVENDER_PLANKS.get());
                        pOutput.accept(ModBlocks.LAVENDER_LEAVES.get());
                        pOutput.accept(ModBlocks.LAVENDER_SAPLING.get());

                        pOutput.accept(ModBlocks.LAVENDER_STAIRS.get());
                        pOutput.accept(ModBlocks.LAVENDER_SLAB.get());
                        pOutput.accept(ModBlocks.LAVENDER_BUTTON.get());
                        pOutput.accept(ModBlocks.LAVENDER_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.LAVENDER_FENCE.get());
                        pOutput.accept(ModBlocks.LAVENDER_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.LAVENDER_DOOR.get());
                        pOutput.accept(ModBlocks.LAVENDER_TRAPDOOR.get());

                        pOutput.accept(ModItems.MUNCHER_SPAWN_EGG.get());
                        pOutput.accept(ModItems.CAPYBARA_SPAWN_EGG.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}