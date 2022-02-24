package com.gachamod.gacha.item.items.terrestrial;

import net.minecraft.block.BlockState;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class TerrestrialHoeItem extends HoeItem {
    public TerrestrialHoeItem(IItemTier itemTier, int attackDamage, float attackSpeed, Properties properties) {
        super(itemTier, attackDamage, attackSpeed, properties);

    }
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if(this.getDamage(stack) > 998){
            return -5;
        }
        return super.getDestroySpeed(stack, state);
    }
}
