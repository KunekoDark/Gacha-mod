package com.gachamod.gacha.item.items.terrestrial;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
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
    public float getDestroySpeed(ItemStack stack, BlockState state) {

        if(this.getDamage(stack) > 998){

            return -5;

        }
        return super.getDestroySpeed(stack, state);
    }


}
