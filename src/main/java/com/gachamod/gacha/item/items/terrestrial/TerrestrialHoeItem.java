package com.gachamod.gacha.item.items.terrestrial;

import com.gachamod.gacha.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TerrestrialHoeItem extends HoeItem {
    public TerrestrialHoeItem(IItemTier itemTier, int attackDamage, float attackSpeed, Properties properties) {
        super(itemTier, attackDamage, attackSpeed, properties);

    }
    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        PlayerEntity player = (PlayerEntity) entityIn;
        PlayerInventory inventory = player.inventory;

        if(isSelected && worldIn.isNightTime() && isOnTopOfCharger(player)){
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

    public boolean isOnTopOfCharger(PlayerEntity player){
        BlockPos posBelow = player.getPosition().down();
        BlockState blockStateBelow = player.world.getBlockState(posBelow);
        if(blockStateBelow.getBlock() == ModBlocks.CELESTIAL_CHARGER.get()){
            return true;
        }
        return false;
    }

}
