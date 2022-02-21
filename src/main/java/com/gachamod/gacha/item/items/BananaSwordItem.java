package com.gachamod.gacha.item.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class BananaSwordItem extends SwordItem {
    public BananaSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean isDamageable() {
        return true;
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 40, 2, false, false));
        playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 40, 2, false, false));
        playerIn.playSound(SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS, 1.0F, 1.0F);
        if(!playerIn.isCreative()){
            playerIn.getCooldownTracker().setCooldown(this.getItem(), 500);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
/**/