package com.gachamod.gacha.data.recipes.evolvetable;

import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.data.recipes.ModRecipeTypes;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EvolveTableRecipe implements IEvolveTableRecipe{
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> input;

    public EvolveTableRecipe(ResourceLocation id, ItemStack output,NonNullList<Ingredient> input) {
        this.id = id;
        this.output = output;
        this.input = input;

    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        int correctItems = 0;
        int total = input.size();
        for(int i =0; i != input.size(); i++){
            if(input.get(i).test(inv.getStackInSlot(i))){
                correctItems++;
            }
        }
        if(input.size() != inv.getSizeInventory()-1){
            for(int i =input.size(); i != inv.getSizeInventory()-1; i++){
                if(!inv.getStackInSlot(i).isEmpty()){
                    total++;
                }
            }
        }
        return correctItems == total;
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
        return new ItemStack(ModBlocks.EVOLVE_TABLE.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.EVOLVE_SERIALIZER.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return ModRecipeTypes.EVOLVE_RECIPE;
    }

    public static class EvolveRecipeType implements IRecipeType<EvolveTableRecipe>{
        @Override
        public String toString(){
            return EvolveTableRecipe.TYPE_ID.toString();
        }
    }
}
