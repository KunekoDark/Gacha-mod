package com.gachamod.gacha.data;

import com.gachamod.gacha.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class WearingSet {

    public static boolean wearingAllMeteorTechArmor(PlayerEntity player) {

        // ah ha!!!
        if(player.inventory.armorItemInSlot(0).equals(new ItemStack(ModItems.METEORTECH_BOOTS.get())) &&
                player.inventory.armorItemInSlot(1).equals(new ItemStack(ModItems.METEORTECH_LEGGINGS.get())) &&
                player.inventory.armorItemInSlot(2).equals(new ItemStack(ModItems.METEORTECH_CHESTPLATE.get())) &&
                player.inventory.armorItemInSlot(3).equals(new ItemStack(ModItems.METEORTECH_HEADGEAR.get()))){
            return true;
        }
        return false;
    }

}
