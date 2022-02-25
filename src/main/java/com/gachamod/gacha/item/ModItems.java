package com.gachamod.gacha.item;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.item.items.BananaSwordItem;
import com.gachamod.gacha.item.items.CannonItem;
import com.gachamod.gacha.item.items.IceSwordItem;
import com.gachamod.gacha.item.curio.JizosHatItem;
import com.gachamod.gacha.item.curio.JizosScarfItem;
import com.gachamod.gacha.entity.ModEntityType;
import com.gachamod.gacha.item.items.terrestrial.*;
import com.gachamod.gacha.item.ticketitems.TicketDropLegend;
import com.gachamod.gacha.item.ticketitems.TicketDropNormal;
import com.gachamod.gacha.item.ticketitems.TicketDropPlat;
import com.gachamod.gacha.item.ticketitems.TicketDropRare;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Gacha.MOD_ID);


    // curios items

    public static final RegistryObject<Item> JIZOS_STRAW_HAT = ITEMS.register("jizos_straw_hat",
            () -> new JizosHatItem(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> JIZOS_SCARF = ITEMS.register("jizos_scarf",
            () -> new JizosScarfItem(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP).rarity(Rarity.RARE)));

    // Tickets items

    public static final RegistryObject<TicketDropNormal> NORMAL_TICKET = ITEMS.register("normal_ticket",
        () -> new TicketDropNormal(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<TicketDropRare> RARE_TICKET = ITEMS.register("rare_ticket",
            () -> new TicketDropRare(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<TicketDropPlat> PLATINUM_TICKET = ITEMS.register("platinum_ticket",
            () -> new TicketDropPlat(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP).rarity(Rarity.RARE)));

    public static final RegistryObject<TicketDropLegend> LEGEND_TICKET = ITEMS.register("legend_ticket",
            () -> new TicketDropLegend(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP).rarity(Rarity.EPIC)));



    //Normal Items

    public static final RegistryObject<Item> CANNON_BASE = ITEMS.register("cannon_base",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> CANNON_SHAFT = ITEMS.register("cannon_shaft",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> CANNON_CHARGE_MODULE = ITEMS.register("cannon_charge_module",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> CANNON_COMPONENT = ITEMS.register("cannon_component",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> CANNON_HANDHELD_MODULE = ITEMS.register("cannon_handheld_module",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> METEORITE_CHUNK = ITEMS.register("meteorite_chunk",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> SPROCKETS = ITEMS.register("sprockets",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> BEAST_BONES = ITEMS.register("beast_bones",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> RELIC_FOSSIL = ITEMS.register("relic_fossil",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> JIZO_STEEL_INGOT = ITEMS.register("jizo_steel_ingot",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> ICE_SWORD_BLADE = ITEMS.register("ice_sword_blade",
            () -> new Item(new Item.Properties().maxStackSize(16).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> ICE_SWORD_HANDLE = ITEMS.register("ice_sword_handle",
            () -> new Item(new Item.Properties().maxStackSize(16).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> ICE_SWORD_CORE = ITEMS.register("ice_sword_core",
            () -> new Item(new Item.Properties().maxStackSize(16).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> TERRESTRIAL_CORE = ITEMS.register("terrestrial_core",
            () -> new Item(new Item.Properties().maxStackSize(16).group(ModItemGroup.GACHA_GROUP)));


    //weapons

    public static final RegistryObject<CannonItem> CAT_CANNON = ITEMS.register("cat_cannon",
            () -> new CannonItem(new Item.Properties().group(ModItemGroup.GACHA_GROUP).maxStackSize(1).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> ICE_SWORD = ITEMS.register("ice_sword",
            () -> new IceSwordItem(ModItemTier.SPECIAL, 0, -2.4F,new Item.Properties().group(ModItemGroup.GACHA_GROUP).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> BANANA_SWORD = ITEMS.register("banana_sword",
            () -> new BananaSwordItem(ModItemTier.SPECIAL, -1, -2.4F,new Item.Properties().group(ModItemGroup.GACHA_GROUP).rarity(Rarity.RARE)));


    //evolve orbs

    public static final RegistryObject<Item> BLUE_EVOLVE_ORB = ITEMS.register("blue_evolve_orb", //change to evolve orbs
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> PURPLE_EVOLVE_ORB = ITEMS.register("purple_evolve_orb",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> RED_EVOLVE_ORB = ITEMS.register("red_evolve_orb",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> YELLOW_EVOLVE_ORB = ITEMS.register("yellow_evolve_orb",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> GREEN_EVOLVE_ORB = ITEMS.register("green_evolve_orb",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> RAINBOW_EVOLVE_ORB = ITEMS.register("rainbow_evolve_orb",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> RELIC_EVOLVE_ORB = ITEMS.register("relic_evolve_orb",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP).rarity(Rarity.EPIC)));


    //upgrades and augments
    public static final RegistryObject<Item> CANNON_UPGRADE_BASE_T1 = ITEMS.register("cannon_upgrade_base_t1",
            () -> new Item(new Item.Properties().maxStackSize(4).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> CANNON_DAMAGE_UPGRADE_T1 = ITEMS.register("cannon_damage_upgrade_t1",
            () -> new Item(new Item.Properties().maxStackSize(4).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> CANNON_SPEED_UPGRADE_T1 = ITEMS.register("cannon_speed_upgrade_t1",
            () -> new Item(new Item.Properties().maxStackSize(4).group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> CANNON_RADIUS_UPGRADE_T1 = ITEMS.register("cannon_radius_upgrade_t1",
            () -> new Item(new Item.Properties().maxStackSize(4).group(ModItemGroup.GACHA_GROUP)));

    //tools
    public static final RegistryObject<Item> JIZO_STEEL_PICKAXE = ITEMS.register("jizo_steel_pickaxe",
            () -> new PickaxeItem(ModItemTier.JIZO_STEEL, -2, -2.8f,new Item.Properties().group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> JIZO_STEEL_AXE = ITEMS.register("jizo_steel_axe",
            () -> new AxeItem(ModItemTier.JIZO_STEEL, 2, -3f,new Item.Properties().group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> JIZO_STEEL_SHOVEL = ITEMS.register("jizo_steel_shovel",
            () -> new ShovelItem(ModItemTier.JIZO_STEEL, -3, -1f,new Item.Properties().group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> JIZO_STEEL_HOE = ITEMS.register("jizo_steel_hoe",
            () -> new HoeItem(ModItemTier.JIZO_STEEL, -4, 0f,new Item.Properties().group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> JIZO_STEEL_SWORD = ITEMS.register("jizo_steel_sword",
            () -> new SwordItem(ModItemTier.JIZO_STEEL, 0, -2.4f,new Item.Properties().group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> TERRESTRIAL_PICKAXE = ITEMS.register("terrestrial_pickaxe",
            () -> new TerrestrialPickaxeItem(ModItemTier.NORMAL, -2, -2.8f,new Item.Properties().group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> TERRESTRIAL_AXE = ITEMS.register("terrestrial_axe",
            () -> new TerrestrialAxeItem(ModItemTier.NORMAL, 2, -3f,new Item.Properties().group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> TERRESTRIAL_SWORD = ITEMS.register("terrestrial_sword",
            () -> new TerrestrialSwordItem(ModItemTier.NORMAL, 0, -2.4f,new Item.Properties().group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> TERRESTRIAL_SHOVEL = ITEMS.register("terrestrial_shovel",
            () -> new TerrestrialShovelItem(ModItemTier.NORMAL, -3, -1f,new Item.Properties().group(ModItemGroup.GACHA_GROUP)));

    public static final RegistryObject<Item> TERRESTRIAL_HOE = ITEMS.register("terrestrial_hoe",
            () -> new TerrestrialHoeItem(ModItemTier.NORMAL, -4, -0f,new Item.Properties().group(ModItemGroup.GACHA_GROUP)));

    //tiered stuff

    public static final RegistryObject<Item> TERRESTRIAL_INGOT = ITEMS.register("terrestrial_ingot",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.GACHA_GROUP)));






    //spawn eggs

    public static final RegistryObject<Item> KASAJIZO_SPAWN = ITEMS.register("kasajizo_spawnegg",
            () -> new ModSpawnEggItem(ModEntityType.KASAJIZO, 0x000000, 0xFFFFFF,
                    new Item.Properties().maxStackSize(1).group(ItemGroup.MISC).defaultMaxDamage(1)));


    public static final RegistryObject<Item> GOON_SPAWN = ITEMS.register("goon_spawnegg",
            () -> new ModSpawnEggItem(ModEntityType.GOONENTITY, 0x0000FF, 0xFFFAFF,
                    new Item.Properties().maxStackSize(1).group(ItemGroup.MISC).defaultMaxDamage(1)));


    //projectile items
    
    public static final RegistryObject<Item> CAT_CANNON_PROJECTILE = ITEMS.register("cat_cannon_projectile",
            () -> new Item(new Item.Properties()));







    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }

}
