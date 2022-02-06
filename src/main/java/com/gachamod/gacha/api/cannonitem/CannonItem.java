package com.gachamod.gacha.api.cannonitem;

import com.gachamod.gacha.api.entity.ModEntityType;
import com.gachamod.gacha.api.entity.projectile.CannonFireEntity;
import com.gachamod.gacha.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class CannonItem extends Item {

    public CannonItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote){
            CannonFireEntity cannonFire = new CannonFireEntity(playerIn, worldIn);
            cannonFire.setShooter(playerIn);
            cannonFire.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.addEntity(cannonFire);
            worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.PLAYERS, 0.2F, 1.0F);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}