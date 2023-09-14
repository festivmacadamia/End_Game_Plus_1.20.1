package com.festivmacadamia.endgameplus.item;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.item.custom.MetalDetectorItem;
import com.festivmacadamia.endgameplus.item.custom.ModArmorItem;

import com.festivmacadamia.endgameplus.item.custom.ModSmithingTemplateItem;
import net.minecraft.world.item.*;
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

    //special items
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector", 
        ()  -> new MetalDetectorItem(new Item.Properties().durability(128)));

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


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
 