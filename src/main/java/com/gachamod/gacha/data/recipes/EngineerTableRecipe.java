package com.gachamod.gacha.data.recipes;

import com.gachamod.gacha.block.ModBlocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
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
        if(
                input.get(0).test(inv.getStackInSlot(0)) &&
                input.get(1).test(inv.getStackInSlot(1)) &&
                input.get(2).test(inv.getStackInSlot(2)) &&
                input.get(3).test(inv.getStackInSlot(3)) &&
                input.get(4).test(inv.getStackInSlot(4))
        )
        {
            return true;
        }
        return false;
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
        return ModRecipeTypes.ENGINEER_SERIALIZER.get();
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

