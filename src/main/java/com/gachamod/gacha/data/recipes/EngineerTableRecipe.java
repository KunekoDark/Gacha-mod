package com.gachamod.gacha.data.recipes;

import com.gachamod.gacha.block.ModBlocks;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class EngineerTableRecipe implements IEngineerTableRecipe {

    private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient input;

    public EngineerTableRecipe(ResourceLocation id, ItemStack output,Ingredient input) {
        this.id = id;
        this.output = output;
        this.input = input;

    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        if(this.input.test(inv.getStackInSlot(0)) &&
                this.input.test(inv.getStackInSlot(1)) &&
                this.input.test(inv.getStackInSlot(2)) &&
                this.input.test(inv.getStackInSlot(3)) &&
                this.input.test(inv.getStackInSlot(4)) )
        {
            return true;
        }
        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients(){
        return NonNullList.from(null, this.input);
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return output;
    }

    @Override
    public boolean canFit(int width, int height) {
        return false;
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

    @Override
    public Ingredient getInput() {
        return this.input;
    }

    @Override
    public IRecipeType<?> getType() {
        return null;
    }

    public static class EngineerRecipeType implements IRecipeType<EngineerTableRecipe>{
        @Override
        public String toString(){
            return EngineerTableRecipe.TYPE_ID.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<EngineerTableRecipe>{

        @Override
        public EngineerTableRecipe read(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output"),true);

            JsonArray ingredients = JSONUtils.getJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(5, Ingredient.EMPTY);


            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.deserialize(ingredients.get(i)));
            }

            return new EngineerTableRecipe(recipeId, output,
                    inputs.get(1));//FIX https://www.youtube.com/watch?v=Ri0Mqv_FXA4
        }

        @Nullable
        @Override
        public EngineerTableRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            ItemStack output = buffer.readItemStack();
            NonNullList<Ingredient> inputs = NonNullList.withSize(5, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.read(buffer));
            }

            return new EngineerTableRecipe(recipeId, output,
                    inputs.get(1)); //FIX
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

