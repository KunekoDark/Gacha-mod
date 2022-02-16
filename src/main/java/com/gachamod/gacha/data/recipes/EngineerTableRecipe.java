package com.gachamod.gacha.data.recipes;

import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.world.gen.OreType;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class EngineerTableRecipe implements IEngineerTableRecipe{

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public EngineerTableRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        if(recipeItems.get(0).test(inv.getStackInSlot(0)) &&
                recipeItems.get(1).test(inv.getStackInSlot(1)) &&
                recipeItems.get(2).test(inv.getStackInSlot(2)) &&
                recipeItems.get(3).test(inv.getStackInSlot(3)) &&
                recipeItems.get(4).test(inv.getStackInSlot(4)) ){

            return true;//recipeItems.get(5).test(inv.getStackInSlot(5));
        }
        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients(){return recipeItems;}

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return output;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output.copy();
    }

    public ItemStack getIcon(){
        return new ItemStack(ModBlocks.ENGINEER_TABLE.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.ENGINEER_SERIALIZER.get();
    }

    public static class  EngineerRecipeType implements IRecipeType<EngineerTableRecipe>{
        @Override
        public String toString(){
            return EngineerTableRecipe.TYPE_ID.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
        implements IRecipeSerializer<EngineerTableRecipe>{

        @Override
        public EngineerTableRecipe read(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "output"));


            JsonArray ingredients = JSONUtils.getJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(5, Ingredient.EMPTY);


            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.deserialize(ingredients.get(i)));
            }

            return new EngineerTableRecipe(recipeId, output,
                    inputs);
        }

        @Nullable
        @Override
        public EngineerTableRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
              NonNullList<Ingredient> inputs = NonNullList.withSize(5, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.read(buffer));
            }

            ItemStack output = buffer.readItemStack();
            return new EngineerTableRecipe(recipeId, output,
                    inputs);
        }

        @Override
        public void write(PacketBuffer buffer, EngineerTableRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buffer);
            }
            buffer.writeItemStack(recipe.getRecipeOutput(), false);
        }
        }
    }

