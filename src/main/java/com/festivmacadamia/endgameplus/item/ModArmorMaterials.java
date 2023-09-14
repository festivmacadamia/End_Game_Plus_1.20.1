package com.festivmacadamia.endgameplus.item;

import java.util.function.Supplier;

import com.festivmacadamia.endgameplus.EndGamePlus;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModArmorMaterials implements ArmorMaterial{
    
    ENDERITE("enderite",37, new int[] {3,8,6,3},15,
        SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0f, 0.1f,
            () -> Ingredient.of(ModItems.ENDERITE_INGOT.get())),
    INTERDIMENSIONAL("interdimensional",50, new int[] {5,7,9,4},21,
        SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0f, 0.15f,
            () -> Ingredient.of(ModItems.ENDERITE_INGOT.get())); //placehodler ingot


    private final String name;
    private final int durabilityMultiplier;
    private final  int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DRUABILITY = {11, 16, 16, 13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue,
        SoundEvent equipSound, float toughness, float knockbackResistance,
            Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }



    @Override
    public int getDurabilityForType(Type pType) {
        return BASE_DRUABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
            return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return EndGamePlus.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
    
}
