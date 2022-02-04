package com.gachamod.gacha.item;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.api.ticketdrops.TicketDropLegend;
import com.gachamod.gacha.api.ticketdrops.TicketDropNormal;
import com.gachamod.gacha.api.ticketdrops.TicketDropPlat;
import com.gachamod.gacha.api.ticketdrops.TicketDropRare;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Gacha.MOD_ID);

    public static final RegistryObject<TicketDropNormal> NORMAL_TICKET = ITEMS.register("normal_ticket",
        () -> new TicketDropNormal(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<TicketDropRare> RARE_TICKET = ITEMS.register("rare_ticket",
            () -> new TicketDropRare(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<TicketDropPlat> PLATINUM_TICKET = ITEMS.register("platinum_ticket",
            () -> new TicketDropPlat(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<TicketDropLegend> LEGEND_TICKET = ITEMS.register("legend_ticket",
            () -> new TicketDropLegend(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    //Normal Items

    public static final RegistryObject<Item> CANNON_BASE = ITEMS.register("cannon_base",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> CANNON_SHAFT = ITEMS.register("cannon_shaft",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> CANNON_POWER_MODULE = ITEMS.register("cannon_charge_module",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> CANNON_COMPONENT = ITEMS.register("cannon_component",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> CANNON_HANDHELD_MODULE = ITEMS.register("cannon_handheld_module",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> JIZO_GOLD = ITEMS.register("jizo_gold",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> METEORITE_CHUNK = ITEMS.register("meteorite_chunk",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> SPROCKETS = ITEMS.register("sprockets",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> BEAST_BONES = ITEMS.register("beast_bones",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> RELIC_FOSSIL = ITEMS.register("relic_fossil",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));







    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }

}
