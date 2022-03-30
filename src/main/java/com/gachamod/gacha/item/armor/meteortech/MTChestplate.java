package com.gachamod.gacha.item.armor.meteortech;

import com.gachamod.gacha.data.WearingSet;
import com.gachamod.gacha.data.isOnCharger;
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
        player.abilities.allowFlying = true;

    }

   @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        PlayerEntity player = (PlayerEntity)entityIn;
        if (player.inventory.armorItemInSlot(2) != stack ){
            player.abilities.allowFlying = false;
            player.abilities.isFlying = false;
        }



    }
}
