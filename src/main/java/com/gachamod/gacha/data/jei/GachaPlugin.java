package com.gachamod.gacha.data.jei;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.data.recipes.ModRecipeTypes;
import com.gachamod.gacha.data.recipes.engineertable.EngineerTableRecipe;
import com.gachamod.gacha.data.recipes.evolvetable.EvolveTableRecipe;
import com.gachamod.gacha.screen.EvolveTableScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

import java.util.Objects;
import java.util.stream.Collectors;

@JeiPlugin
public class GachaPlugin implements IModPlugin {
    public static final ResourceLocation ENGINEER_CATAGORY = new ResourceLocation(Gacha.MOD_ID, "engineer");
    public static final ResourceLocation EVOLVE_CATAGORY = new ResourceLocation(Gacha.MOD_ID, "evolve");
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Gacha.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new EngineerTableRecipeCategory(registration.getJeiHelpers().getGuiHelper())
        );
        registration.addRecipeCategories(
                new EvolveTableRecipeCategory(registration.getJeiHelpers().getGuiHelper())
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().world).getRecipeManager();
        registration.addRecipes(rm.getRecipesForType(ModRecipeTypes.ENGINEER_RECIPE).stream()
                        .filter(r -> r instanceof EngineerTableRecipe).collect(Collectors.toList()),
                EngineerTableRecipeCategory.UID);

        registration.addRecipes(rm.getRecipesForType(ModRecipeTypes.EVOLVE_RECIPE).stream()
                        .filter(r -> r instanceof EvolveTableRecipe).collect(Collectors.toList()),
                EvolveTableRecipeCategory.UID);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ENGINEER_TABLE.get()) ,  ENGINEER_CATAGORY);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.EVOLVE_TABLE.get()) ,  EVOLVE_CATAGORY);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(EvolveTableScreen.class, 96, 47+EvolveTableScreen.evolveoffset, 30, 15, EvolveTableRecipeCategory.UID);
    }
}
