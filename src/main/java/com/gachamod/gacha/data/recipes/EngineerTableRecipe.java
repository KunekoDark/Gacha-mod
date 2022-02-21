package com.gachamod.gacha.data.recipes;

import com.gachamod.gacha.block.ModBlocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EngineerTableRecipe implements IEngineerTableRecipe {

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> input;

    public EngineerTableRecipe(ResourceLocation id, ItemStack output,NonNullList<Ingredient> input) {
        this.id = id;
        this.output = output;
        this.input = input;

    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        int correctItems = 0;
        for(int i =0; i !=input.size(); i++){
            if(input.get(i).test(inv.getStackInSlot(i))){
                correctItems++;
            }
        }
        return correctItems == input.size();
    }

    @Override
    public NonNullList<Ingredient> getIngredients(){
        return input;
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
        return ShapedRecipe.Serializer.CRAFTING_SHAPELESS;
    }

    @Override
    public IRecipeType<?> getType() {
        return ModRecipeTypes.ENGINEER_RECIPE;
    }

    public static class EngineerRecipeType implements IRecipeType<EngineerTableRecipe>{
        @Override
        public String toString(){
            return EngineerTableRecipe.TYPE_ID.toString();
        }
    }

}

