package com.gachamod.gacha.data.recipes;

import com.gachamod.gacha.Gacha;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import static net.minecraft.item.crafting.IRecipeType.register;

public interface IEngineerTableRecipe extends IRecipe<IInventory> {
    ResourceLocation TYPE_ID = new ResourceLocation(Gacha.MOD_ID, "engineer");
    IRecipeType<EngineerTableRecipe> ENGINEERTABLE = register("engineer");

    @Override
    default IRecipeType<?> getType(){
        return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }

    @Override
    default boolean canFit(int width, int height) {
        return true;
    }

    @Override
    default boolean isDynamic(){
        return true;
    }
}
