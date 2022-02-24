package com.gachamod.gacha.data.recipes.engineertable;

import com.gachamod.gacha.data.recipes.engineertable.EngineerTableRecipe;
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

public class EngineerTableSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<EngineerTableRecipe>{
    @Override
    public EngineerTableRecipe read(ResourceLocation recipeId, JsonObject json) {
        ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json,"output"), true);
        JsonArray jsonArray = JSONUtils.getJsonArray(json, "ingredients");
        NonNullList<Ingredient> input = NonNullList.withSize(jsonArray.size(), Ingredient.EMPTY);
        for(int i =0; i != input.size(); i++){
            input.set(i, Ingredient.deserialize(jsonArray.get(i)));
        }

        return new EngineerTableRecipe(recipeId, output, input);
    }

    @Nullable
    @Override
    public EngineerTableRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
        ItemStack output = buffer.readItemStack();
        int size = buffer.readVarInt();
        NonNullList<Ingredient> input = NonNullList.withSize(size, Ingredient.EMPTY);
        for(int i = 0; i < input.size(); ++i) {
            input.set(i,Ingredient.read(buffer));
        }
        return new EngineerTableRecipe(recipeId, output, input);
    }

    @Override
    public void write(PacketBuffer buffer, EngineerTableRecipe recipe) {
        buffer.writeItemStack(recipe.getRecipeOutput(), false);
        buffer.writeVarInt(recipe.getIngredients().size());
        for(Ingredient ingredient : recipe.getIngredients()) {
            ingredient.write(buffer);
        }

    }
}
