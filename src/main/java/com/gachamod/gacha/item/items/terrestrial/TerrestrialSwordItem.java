package com.gachamod.gacha.item.items.terrestrial;

import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.data.isOnCharger;
import com.gachamod.gacha.entity.ModEntityType;
import com.gachamod.gacha.entity.projectile.CannonFireEntity;
import com.gachamod.gacha.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
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
        boolean charging = new isOnCharger().isOnTopOfCharger(player);

        if(isSelected  && charging){
            setDamage(stack, getDamage(stack)- 1);
        }
        if(stack.getDamage() >= 1998 && isSelected){
            player.inventory.removeStackFromSlot(player.inventory.currentItem);
            player.inventory.placeItemBackInInventory(worldIn, new ItemStack(ModItems.CANNON_BASE.get()));
            player.sendStatusMessage(new StringTextComponent("Sword Seems Broken"), true);
        }

    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {

        if(this.getDamage(stack) > 1998){
            return -5;
        }
        return super.getDestroySpeed(stack, state);
    }

  //please help sword methods suck





}
