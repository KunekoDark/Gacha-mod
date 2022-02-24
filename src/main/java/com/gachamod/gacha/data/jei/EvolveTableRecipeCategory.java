package com.gachamod.gacha.data.jei;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.data.recipes.engineertable.EngineerTableRecipe;
import com.gachamod.gacha.data.recipes.evolvetable.EvolveTableRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EvolveTableRecipeCategory implements IRecipeCategory<EvolveTableRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Gacha.MOD_ID, "evolve");
    public final static ResourceLocation TEXTURE = new ResourceLocation(Gacha.MOD_ID, "textures/gui/evolve_table_gui_jei.png");

    private  final IDrawable background;
    private  final IDrawable icon;

    public EvolveTableRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 113);
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.EVOLVE_TABLE.get()));
    }


    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends EvolveTableRecipe> getRecipeClass() {
        return EvolveTableRecipe.class;
    }

    @Override
    public String getTitle() {
        return ModBlocks.EVOLVE_TABLE.get().getTranslatedName().getString();
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setIngredients(EvolveTableRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, EvolveTableRecipe recipe, IIngredients ingredients) {

        recipeLayout.getItemStacks().init(0,true,33,21);
        recipeLayout.getItemStacks().init(1,true,59,21);
        recipeLayout.getItemStacks().init(2,true,20,47);
        recipeLayout.getItemStacks().init(3,true,46,47);
        recipeLayout.getItemStacks().init(4,true,72,47);
        recipeLayout.getItemStacks().init(5,true,33,73);
        recipeLayout.getItemStacks().init(6,true,59,73);

        recipeLayout.getItemStacks().init(7,false,132,47);
        recipeLayout.getItemStacks().set(ingredients);


    }

}