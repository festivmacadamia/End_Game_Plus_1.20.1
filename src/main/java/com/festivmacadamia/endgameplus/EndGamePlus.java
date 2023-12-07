package com.festivmacadamia.endgameplus;

import com.festivmacadamia.endgameplus.block.ModBlocks;
import com.festivmacadamia.endgameplus.entity.ModEntities;
import com.festivmacadamia.endgameplus.entity.client.CapybaraRenderer;
import com.festivmacadamia.endgameplus.entity.client.HamisRenderer;
import com.festivmacadamia.endgameplus.entity.client.MuncherRenderer;
import com.festivmacadamia.endgameplus.item.ModCreativeModeTabs;
import com.festivmacadamia.endgameplus.item.ModItems;
import com.festivmacadamia.endgameplus.loot.ModLootModifiers;
import com.festivmacadamia.endgameplus.sound.ModSoundEvents;
import com.festivmacadamia.endgameplus.worldgen.biome.ModTerrablender;
import com.festivmacadamia.endgameplus.worldgen.biome.surface.ModSurfaceRules;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;
import terrablender.api.SurfaceRuleManager;


@Mod(EndGamePlus.MOD_ID)
public class EndGamePlus{

    public static final String MOD_ID = "endgameplus";
    private static final Logger LOGGER = LogUtils.getLogger(); 

    public EndGamePlus(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSoundEvents.register(modEventBus);
        ModTerrablender.registerBiomes();
        GeckoLib.initialize();

 
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative); 
    }

    private void commonSetup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ORCHID.getId(), ModBlocks.POTTED_PINK_ORCHID);
        });
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CATMINT.getId(), ModBlocks.POTTED_CATMINT);
        });
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.AZURRI_BLUE_SATIN.getId(), ModBlocks.POTTED_AZURI_BLUE_SATIN);
        });
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event){
        
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.MUNCHER.get(), MuncherRenderer::new);
            EntityRenderers.register(ModEntities.CAPYBARA.get(), CapybaraRenderer::new);
            EntityRenderers.register(ModEntities.HAMIS.get(), HamisRenderer::new);
        }
    }
}
