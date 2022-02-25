package com.gachamod.gacha.item.items.alien;

import com.gachamod.gacha.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AlienPickaxeItem extends PickaxeItem {
    public AlienPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        PlayerEntity player = (PlayerEntity) entityIn;
        PlayerInventory inventory = player.inventory;

        if(isSelected && worldIn.isNightTime() && isOnTopOfCharger(player)){
            setDamage(stack, getDamage(stack)- 4);
        }
        if(isSelected){
            player.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 1, 0, false, false));
        }


//MAKE ALIEN CHARGER BACKWARDS COMPATIBLE WITH TERRESTRIAL STUFF
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if(this.getDamage(stack) > 2998){
            return -5;
        }
        return super.getDestroySpeed(stack, state);
    }

    public boolean isOnTopOfCharger(PlayerEntity player){
        BlockPos posBelow = player.getPosition().down();
        BlockState blockStateBelow = player.world.getBlockState(posBelow);
        if(blockStateBelow.getBlock() == ModBlocks.ALIEN_CHARGER.get()){
            return true;
        }
        return false;
    }

}
