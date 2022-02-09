package com.gachamod.gacha.api.ticketloot;

import com.gachamod.gacha.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.List;

public class TicketLoot {

    public List<Item> getNormalTicketLoot() {
        List<Item> normalTicketLoot= new ArrayList<>();
        for(int i = 0; i <3; i++)
        {
        normalTicketLoot.add(ModItems.BLUE_CATFRUIT.get());
        normalTicketLoot.add(ModItems.PURPLE_CATFRUIT.get());
        normalTicketLoot.add(ModItems.YELLOW_CATFRUIT.get());
        normalTicketLoot.add(ModItems.GREEN_CATFRUIT.get());
        normalTicketLoot.add(ModItems.RED_CATFRUIT.get());
        normalTicketLoot.add(Items.IRON_INGOT);
        normalTicketLoot.add(Items.DIAMOND);
        normalTicketLoot.add(Items.GOLD_INGOT);
        normalTicketLoot.add(Items.GOLDEN_CARROT);
        }

        normalTicketLoot.add(ModItems.RARE_TICKET.get());


        return normalTicketLoot;
    }


    public List<Item> getRareTicketLoot() {
        List<Item> rareTicketLoot= new ArrayList<>();
        for(int i = 0; i <3; i++)
        {
            rareTicketLoot.add(ModItems.BLUE_CATFRUIT.get());
            rareTicketLoot.add(ModItems.PURPLE_CATFRUIT.get());
            rareTicketLoot.add(ModItems.YELLOW_CATFRUIT.get());
            rareTicketLoot.add(ModItems.GREEN_CATFRUIT.get());
            rareTicketLoot.add(ModItems.RED_CATFRUIT.get());
            rareTicketLoot.add(Items.IRON_INGOT);
            rareTicketLoot.add(Items.DIAMOND);
            rareTicketLoot.add(Items.GOLD_INGOT);
            rareTicketLoot.add(Items.GOLDEN_APPLE);
        }

        rareTicketLoot.add(ModItems.PLATINUM_TICKET.get());


        return rareTicketLoot;
    }

    public List<Item> getPlatTicketLoot() {
        List<Item> platTicketLoot= new ArrayList<>();
        for(int i = 0; i <3; i++)
        {
            platTicketLoot.add(ModItems.BLUE_CATFRUIT.get());
            platTicketLoot.add(ModItems.PURPLE_CATFRUIT.get());
            platTicketLoot.add(ModItems.YELLOW_CATFRUIT.get());
            platTicketLoot.add(ModItems.GREEN_CATFRUIT.get());
            platTicketLoot.add(ModItems.RED_CATFRUIT.get());
            platTicketLoot.add(Items.IRON_INGOT);
            platTicketLoot.add(Items.DIAMOND);
            platTicketLoot.add(Items.GOLD_INGOT);
        }
        platTicketLoot.add(Items.ENCHANTED_GOLDEN_APPLE);

        platTicketLoot.add(ModItems.LEGEND_TICKET.get());

        return platTicketLoot;
    }


    public List<Item> getLegendTicketLoot() {
        List<Item> legendTicketLoot= new ArrayList<>();
        for(int i = 0; i <3; i++)
        {
            legendTicketLoot.add(ModItems.BLUE_CATFRUIT.get());
            legendTicketLoot.add(ModItems.PURPLE_CATFRUIT.get());
            legendTicketLoot.add(ModItems.YELLOW_CATFRUIT.get());
            legendTicketLoot.add(ModItems.GREEN_CATFRUIT.get());
            legendTicketLoot.add(ModItems.RED_CATFRUIT.get());
            legendTicketLoot.add(Items.IRON_INGOT);
            legendTicketLoot.add(Items.DIAMOND);
            legendTicketLoot.add(Items.GOLD_INGOT);
            legendTicketLoot.add(Items.GOLDEN_CARROT);
        }

        legendTicketLoot.add(ModItems.RARE_TICKET.get());


        return legendTicketLoot;
    }
}

