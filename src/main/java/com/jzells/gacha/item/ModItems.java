package com.jzells.gacha.item;

import com.jzells.gacha.Gacha;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Gacha.MOD_ID);

    public static final RegistryObject<Item> NORMAL_TICKET = ITEMS.register("normal_ticket",
        () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> RARE_TICKET = ITEMS.register("rare_ticket",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> PLATINUM_TICKET = ITEMS.register("platinum_ticket",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> LEGEND_TICKET = ITEMS.register("legend_ticket",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));



    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }

}
