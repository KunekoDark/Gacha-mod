package com.gachamod.gacha.data.recipes;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.data.recipes.engineertable.EngineerTableRecipe;
import com.gachamod.gacha.data.recipes.engineertable.EngineerTableSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeTypes implements IRecipeType {
    //https://www.youtube.com/watch?v=Ri0Mqv_FXA4
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Gacha.MOD_ID);

    public static final RegistryObject<EngineerTableSerializer> ENGINEER_SERIALIZER
            = RECIPE_SERIALIZER.register("engineer", EngineerTableSerializer::new);

    public static IRecipeType<EngineerTableRecipe> ENGINEER_RECIPE
            = new EngineerTableRecipe.EngineerRecipeType();

    public static void register(IEventBus eventBus){
        RECIPE_SERIALIZER.register(eventBus);

        Registry.register(Registry.RECIPE_TYPE, EngineerTableRecipe.TYPE_ID, ENGINEER_RECIPE);
    }
}
