package com.gachamod.gacha.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup GACHA_GROUP = new ItemGroup("gachaModTab"){

        @Override
        public ItemStack createIcon(){
            return new ItemStack(ModItems.LEGEND_TICKET.get());
        }


    };
}
