package com.gachamod.gacha.data.jei;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.data.recipes.engineertable.EngineerTableRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EngineerTableRecipeCategory implements IRecipeCategory<EngineerTableRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Gacha.MOD_ID, "engineer");
    public final static ResourceLocation TEXTURE = new ResourceLocation(Gacha.MOD_ID, "textures/gui/engineer_table_gui_jei.png");

    private  final IDrawable background;
    private  final IDrawable icon;

    public EngineerTableRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 86);
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.ENGINEER_TABLE.get()));
    }


    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends EngineerTableRecipe> getRecipeClass() {
        return EngineerTableRecipe.class;
    }

    @Override
    public String getTitle() {
        return ModBlocks.ENGINEER_TABLE.get().getTranslatedName().getString();
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
    public void setIngredients(EngineerTableRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, EngineerTableRecipe recipe, IIngredients ingredients) {

        recipeLayout.getItemStacks().init(0,true,43,31);
        recipeLayout.getItemStacks().init(1,true,61,31);
        recipeLayout.getItemStacks().init(2,true,79,31);
        recipeLayout.getItemStacks().init(3,true,52,49);
        recipeLayout.getItemStacks().init(4,true,70,49);

        recipeLayout.getItemStacks().init(5,false,115,31);
        recipeLayout.getItemStacks().set(ingredients);


    }

}
