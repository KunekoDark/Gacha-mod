package com.gachamod.gacha.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    JIZO_STEEL(2,650,7f,6f,10,() -> Ingredient.fromItems(ModItems.JIZO_STEEL_INGOT.get())),
    SPECIAL(3,2500,10f,8f,10, () -> Ingredient.fromItems(ModItems.RARE_TICKET.get())),
    NORMAL(3,2000,9f,8f,10, () -> Ingredient.fromItems(ModItems.TERRESTRIAL_INGOT.get())),
    ALIEN(6,3000,9f,8f,10, () -> Ingredient.fromItems(ModItems.ALIEN_INGOT.get())),
    ALIENHAMMER(6,3000,5f,8f,10, () -> Ingredient.fromItems(ModItems.ALIEN_INGOT.get())),
    METEORTECH(7,10000,10f,15f,10, () -> Ingredient.fromItems(ModItems.ALIEN_INGOT.get())),
    //add new tier here
    ;


    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }
}
