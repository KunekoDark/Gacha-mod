package com.gachamod.gacha.api.cannonitem;

import com.gachamod.gacha.api.entity.ModEntityType;
import com.gachamod.gacha.api.entity.projectile.CannonFireEntity;
import com.gachamod.gacha.item.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class CannonItem extends Item implements IVanishable {
    private int coolDown = 0;
    private int damage = 0;

    public CannonItem(Properties properties) {
        super(properties);
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.gacha.cannonitemtooltip"));
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(coolDown != 0) {
            coolDown--;
        }
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote){
            CannonFireEntity cannonFire = new CannonFireEntity(ModEntityType.CANNON_PROJECTILE.get(), playerIn.getPosX(),playerIn.getPosY()+1.5 ,playerIn.getPosZ() ,0.0F, -0.01F, 0.0F, worldIn);
            ItemStack newStack = new ItemStack(stack.getItem());

            if(coolDown == 0) {
                cannonFire.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 10.0F, 0.2F);
                worldIn.addEntity(cannonFire);
                worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.PLAYERS, 0.1F, 1.0F);
                worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_CAT_DEATH, SoundCategory.PLAYERS, 0.5F, 1.0F);
                coolDown = 100;
            }
            else {
                String timeleft = String.valueOf(coolDown/20);
                playerIn.sendStatusMessage(new StringTextComponent("Cooldown: " +timeleft),true);
            }
        }


        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}