package com.gachamod.gacha.data.recipes.evolvetable;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class EvolveTableSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<EvolveTableRecipe>{
    @Override
    public EvolveTableRecipe read(ResourceLocation recipeId, JsonObject json) {
        ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json,"output"), true);
        JsonArray jsonArray = JSONUtils.getJsonArray(json, "ingredients");
        NonNullList<Ingredient> input = NonNullList.withSize(jsonArray.size(), Ingredient.EMPTY);
        for(int i =0; i != input.size(); i++){
            input.set(i, Ingredient.deserialize(jsonArray.get(i)));
        }

        return new EvolveTableRecipe(recipeId, output, input);
    }

    @Nullable
    @Override
    public EvolveTableRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
        ItemStack output = buffer.readItemStack();
        NonNullList<Ingredient> input = NonNullList.withSize(7, Ingredient.EMPTY);
        return new EvolveTableRecipe(recipeId, output, input);
    }

    @Override
    public void write(PacketBuffer buffer, EvolveTableRecipe recipe) {
        buffer.writeItemStack(recipe.getRecipeOutput(), false);
    }
}
