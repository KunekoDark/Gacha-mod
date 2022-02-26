package com.gachamod.gacha.item.items.terrestrial;

import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.data.isOnCharger;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TerrestrialShovelItem extends ShovelItem {
    public TerrestrialShovelItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        PlayerEntity player = (PlayerEntity) entityIn;
        PlayerInventory inventory = player.inventory;

        boolean charging = new isOnCharger().isOnTopOfCharger(player);

        if(isSelected  && charging){
            setDamage(stack, getDamage(stack)- 1);
        }



    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if(this.getDamage(stack) > 1998){
            return -5;
        }
        return super.getDestroySpeed(stack, state);
    }



}
