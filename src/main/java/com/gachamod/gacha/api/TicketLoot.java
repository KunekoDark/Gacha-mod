package com.gachamod.gacha.api;

import com.gachamod.gacha.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

public class TicketLoot {

    public List<Item> getNormalTicketLoot() {
        List<Item> normalTicketLoot= new ArrayList<>();
        for(int i = 0; i <1; i++)
        {
            normalTicketLoot.add(ModItems.BLUE_EVOLVE_ORB.get());
            normalTicketLoot.add(ModItems.PURPLE_EVOLVE_ORB.get());
            normalTicketLoot.add(ModItems.YELLOW_EVOLVE_ORB.get());
            normalTicketLoot.add(ModItems.GREEN_EVOLVE_ORB.get());
            normalTicketLoot.add(ModItems.RED_EVOLVE_ORB.get());
            normalTicketLoot.add(Items.IRON_INGOT);
            normalTicketLoot.add(Items.DIAMOND);
            normalTicketLoot.add(Items.GOLD_INGOT);
            normalTicketLoot.add(Items.GOLDEN_CARROT);
        }

        /*
        normalTicketLoot.add(ModItems.RARE_TICKET.get());
        normalTicketLoot.add(ModItems.CANNON_BASE.get());
        normalTicketLoot.add(ModItems.CANNON_SHAFT.get());
        normalTicketLoot.add(ModItems.CANNON_CHARGE_MODULE.get());
        normalTicketLoot.add(ModItems.CANNON_COMPONENT.get());
        normalTicketLoot.add(ModItems.CANNON_HANDHELD_MODULE.get());
        */

        return normalTicketLoot;
    }


    public List<Item> getRareTicketLoot() {
        List<Item> rareTicketLoot= new ArrayList<>();
        for(int i = 0; i <5; i++)
        {
            
            rareTicketLoot.add(Items.IRON_INGOT);
            rareTicketLoot.add(Items.DIAMOND);
            rareTicketLoot.add(Items.GOLD_INGOT);

        }

        rareTicketLoot.add(ModItems.CANNON_BASE.get());
        rareTicketLoot.add(ModItems.CANNON_SHAFT.get());
        rareTicketLoot.add(ModItems.CANNON_CHARGE_MODULE.get());
        rareTicketLoot.add(ModItems.CANNON_COMPONENT.get());
        rareTicketLoot.add(ModItems.CANNON_HANDHELD_MODULE.get());
        rareTicketLoot.add(ModItems.ICE_SWORD_BLADE.get());
        rareTicketLoot.add(ModItems.ICE_SWORD_BLADE.get());
        rareTicketLoot.add(ModItems.ICE_SWORD_BLADE.get());


        rareTicketLoot.add(ModItems.PLATINUM_TICKET.get());


        return rareTicketLoot;
    }

    public List<Item> getPlatTicketLoot() {
        List<Item> platTicketLoot= new ArrayList<>();
        for(int i = 0; i <4; i++)
        {

            platTicketLoot.add(Items.DIAMOND);
            platTicketLoot.add(Items.ANCIENT_DEBRIS);

        }

        platTicketLoot.add(ModItems.CAT_CANNON.get());
        platTicketLoot.add(ModItems.ICE_SWORD.get());
        platTicketLoot.add(ModItems.BANANA_SWORD.get());
        platTicketLoot.add(Items.ENCHANTED_GOLDEN_APPLE);
        platTicketLoot.add(ModItems.LEGEND_TICKET.get());

        return platTicketLoot;
    }


    public List<Item> getLegendTicketLoot() {
        List<Item> legendTicketLoot= new ArrayList<>();
        for(int i = 0; i <8; i++)
        {
            legendTicketLoot.add(ModItems.BLUE_EVOLVE_ORB.get());
            legendTicketLoot.add(ModItems.PURPLE_EVOLVE_ORB.get());
            legendTicketLoot.add(ModItems.YELLOW_EVOLVE_ORB.get());
            legendTicketLoot.add(ModItems.GREEN_EVOLVE_ORB.get());
            legendTicketLoot.add(ModItems.RED_EVOLVE_ORB.get());
            legendTicketLoot.add(Items.IRON_INGOT);
            legendTicketLoot.add(Items.DIAMOND);
            legendTicketLoot.add(Items.GOLD_INGOT);
            legendTicketLoot.add(Items.GOLDEN_APPLE);
        }
        for(int i = 0; i <4; i++)
        {
            legendTicketLoot.add(ModItems.CANNON_BASE.get());
            legendTicketLoot.add(ModItems.CANNON_SHAFT.get());
            legendTicketLoot.add(ModItems.CANNON_CHARGE_MODULE.get());
            legendTicketLoot.add(ModItems.CANNON_COMPONENT.get());
            legendTicketLoot.add(ModItems.CANNON_HANDHELD_MODULE.get());
        }

        legendTicketLoot.add(Items.NETHER_STAR);


        return legendTicketLoot;
    }

    public List<Item> getRestrictedItems() {
        List<Item> getRestrictedItems= new ArrayList<>();

        getRestrictedItems.add(Items.NETHER_STAR);
        getRestrictedItems.add(ModItems.CANNON_BASE.get());
        getRestrictedItems.add(ModItems.CANNON_SHAFT.get());
        getRestrictedItems.add(ModItems.CANNON_CHARGE_MODULE.get());
        getRestrictedItems.add(ModItems.CANNON_COMPONENT.get());
        getRestrictedItems.add(ModItems.CANNON_HANDHELD_MODULE.get());
        getRestrictedItems.add(ModItems.LEGEND_TICKET.get());
        getRestrictedItems.add(ModItems.PLATINUM_TICKET.get());
        getRestrictedItems.add(ModItems.RARE_TICKET.get());
        getRestrictedItems.add(Items.ENCHANTED_GOLDEN_APPLE);
        getRestrictedItems.add(Items.GOLDEN_APPLE);
        getRestrictedItems.add(ModItems.ICE_SWORD_BLADE.get());
        getRestrictedItems.add(ModItems.ICE_SWORD_CORE.get());
        getRestrictedItems.add(ModItems.ICE_SWORD_HANDLE.get());
        getRestrictedItems.add(ModItems.ICE_SWORD.get());
        getRestrictedItems.add(ModItems.CAT_CANNON.get());
        getRestrictedItems.add(ModItems.BANANA_SWORD.get());

        return getRestrictedItems;
    }
}

