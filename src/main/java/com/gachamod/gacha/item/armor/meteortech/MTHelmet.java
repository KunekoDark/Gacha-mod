package com.gachamod.gacha.item.armor.meteortech;

import com.gachamod.gacha.item.ModItems;
import com.gachamod.gacha.item.armor.ModArmorMaterial;
import com.google.common.collect.ImmutableMap;
import com.ibm.icu.impl.TextTrieMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import java.util.Map;

public class MTHelmet extends ArmorItem {
    public MTHelmet(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
        super(materialIn, slot, builderIn);
    }



    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
            player.setAir(300);

    }

    private boolean wearingAllArmor(PlayerEntity player) {
        ItemStack boots = player.inventory.armorItemInSlot(0);
        ItemStack leggings = player.inventory.armorItemInSlot(1);
        ItemStack chestplate = player.inventory.armorItemInSlot(2);
        ItemStack helemet = player.inventory.armorItemInSlot(3);
        // ah ha!!!
        if(player.inventory.armorItemInSlot(0) == new ItemStack(ModItems.METEORTECH_BOOTS.get())){
            return true;
        }
        return false;
    }
}
