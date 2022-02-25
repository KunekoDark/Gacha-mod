package com.gachamod.gacha.item.items.terrestrial;

import com.gachamod.gacha.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Collection;

public class TerrestrialSwordItem extends SwordItem {
    public TerrestrialSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
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

        if(this.getDamage(stack) > 998){


            return -5;
        }
        return super.getDestroySpeed(stack, state);
    }

  //please help sword methods suck

    public boolean isOnTopOfCharger(PlayerEntity player){
        BlockPos posBelow = player.getPosition().down();
        BlockState blockStateBelow = player.world.getBlockState(posBelow);
        if(blockStateBelow.getBlock() == ModBlocks.CELESTIAL_CHARGER.get()){
            return true;
        }

        return false;
    }




}
