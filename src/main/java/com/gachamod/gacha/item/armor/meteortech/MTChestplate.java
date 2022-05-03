package com.gachamod.gacha.item.armor.meteortech;

import com.gachamod.gacha.data.WearingSet;
import com.gachamod.gacha.data.isOnCharger;
import com.gachamod.gacha.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MTChestplate extends ArmorItem {
    public MTChestplate(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
        super(materialIn, slot, builderIn);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.inventory.armorItemInSlot(1).equals(new ItemStack(ModItems.METEORTECH_HEADGEAR.get())) &&
                player.inventory.armorItemInSlot(2).equals(new ItemStack(ModItems.METEORTECH_CHESTPLATE.get())) &&
                player.inventory.armorItemInSlot(3).equals(new ItemStack(ModItems.METEORTECH_LEGGINGS.get())) &&
                player.inventory.armorItemInSlot(4).equals(new ItemStack(ModItems.METEORTECH_BOOTS.get()))){
                player.abilities.allowFlying = true;
                player.sendPlayerAbilities();
        } else{
            player.abilities.allowFlying = false;
            player.abilities.isFlying = false;
            player.sendPlayerAbilities();
        }


    }






}
