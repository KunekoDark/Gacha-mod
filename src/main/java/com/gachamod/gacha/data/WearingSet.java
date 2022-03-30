package com.gachamod.gacha.data;

import com.gachamod.gacha.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class WearingSet {

    public boolean wearingAllMeteorTechArmor(PlayerEntity player) {

        // ah ha!!!
        if(player.inventory.armorItemInSlot(0)==(new ItemStack(ModItems.METEORTECH_BOOTS.get())) &&
           player.inventory.armorItemInSlot(1)==(new ItemStack(ModItems.METEORTECH_LEGGINGS.get())) &&
           player.inventory.armorItemInSlot(2)==(new ItemStack(ModItems.METEORTECH_CHESTPLATE.get())) &&
           player.inventory.armorItemInSlot(3)==(new ItemStack(ModItems.METEORTECH_HEADGEAR.get()))){
            return true;
        }
        return false;
    }

}
