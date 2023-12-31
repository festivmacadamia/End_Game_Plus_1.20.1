package com.festivmacadamia.endgameplus.item;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.block.ModBlocks;
import com.festivmacadamia.endgameplus.entity.ModEntities;
import com.festivmacadamia.endgameplus.item.custom.MetalDetectorItem;
import com.festivmacadamia.endgameplus.item.custom.ModArmorItem;

import com.festivmacadamia.endgameplus.item.custom.ModSmithingTemplateItem;
import com.festivmacadamia.endgameplus.sound.ModSoundEvents;
import com.festivmacadamia.endgameplus.util.ColorSwapper;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS,EndGamePlus.MOD_ID); 

    //plain items
    public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", 
        ()  -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap", 
        ()  -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENDERITE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("enderite_upgrade_smithing_template",
            ModSmithingTemplateItem::createEnderiteUpgradeTemplate);

    //food
    public static final RegistryObject<Item> GOLDEN_STEAK = ITEMS.register("golden_steak", 
        ()  -> new Item(new Item.Properties().food(ModFoods.GOLDEN_STEAK)));
    public static final RegistryObject<Item> POPPED_AMARANTH = ITEMS.register("popped_amaranth",
            ()  -> new Item(new Item.Properties().food(ModFoods.POPPED_AMARANTH)));
    public static final RegistryObject<Item> STRAWBERRY_PIE = ITEMS.register("strawberry_pie",
            ()  -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY_PIE)));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            ()  -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds",
            ()  -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> AMARANTH = ITEMS.register("amaranth", 
            ()  -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> AMARANTH_SEEDS = ITEMS.register("amaranth_seeds",
            ()  -> new ItemNameBlockItem(ModBlocks.AMARANTH_CROP.get(), new Item.Properties()));

    //special items
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector", 
        ()  -> new MetalDetectorItem(new Item.Properties().durability(128)));
    public static final RegistryObject<Item> AMONGUS_DRIP_DISC = ITEMS.register("amongus_drip_disc",
            ()  -> new RecordItem(6, ModSoundEvents.AMONGUS_DRIP, new Item.Properties().stacksTo(1), 880));

    //tools
    public static final RegistryObject<Item> ENDERITE_SWORD = ITEMS.register("enderite_sword", 
        ()  -> new SwordItem(Tiers.NETHERITE, 3, -2.4F, new Item.Properties()));    
    public static final RegistryObject<Item> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", 
        ()  -> new ShovelItem(Tiers.NETHERITE, 1.5f, -3.0F, new Item.Properties()));   
    public static final RegistryObject<Item> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", 
        ()  -> new PickaxeItem(Tiers.NETHERITE, 1, -2.8F, new Item.Properties()));  
    public static final RegistryObject<Item> ENDERITE_AXE = ITEMS.register("enderite_axe", 
        ()  -> new AxeItem(Tiers.NETHERITE, 5, -3.0F, new Item.Properties()));  
    public static final RegistryObject<Item> ENDERITE_HOE = ITEMS.register("enderite_hoe", 
        ()  -> new HoeItem(Tiers.NETHERITE, -4, -0.0F, new Item.Properties())); 

    //armor
    public static final RegistryObject<Item> ENDERITE_HELMET = ITEMS.register("enderite_helmet", 
        ()  -> new ModArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate", 
        ()  -> new ArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings", 
        ()  -> new ArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ENDERITE_BOOTS = ITEMS.register("enderite_boots", 
        ()  -> new ArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> MUNCHER_SPAWN_EGG = ITEMS.register("muncher_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MUNCHER, new ColorSwapper("#c7bb14").getMcColor(), new ColorSwapper("#4d1b05").getMcColor(), new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> CAPYBARA_SPAWN_EGG = ITEMS.register("capybara_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CAPYBARA, new ColorSwapper("#805332").getMcColor(), new ColorSwapper("#bf8f6b").getMcColor(), new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> HAMIS_SPAWN_EGG = ITEMS.register("hamis_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.HAMIS, new ColorSwapper("#5b17a3").getMcColor(), new ColorSwapper("#80db67").getMcColor(), new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
 