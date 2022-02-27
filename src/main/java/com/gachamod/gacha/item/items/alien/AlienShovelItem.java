package com.gachamod.gacha.item.items.alien;

import com.gachamod.gacha.data.isOnCharger;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class AlienShovelItem extends ShovelItem {
    public AlienShovelItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        PlayerEntity player = (PlayerEntity) entityIn;
        PlayerInventory inventory = player.inventory;

        boolean charging = new isOnCharger().isOnTopOfAlienCharger(player);
        if(isSelected  && charging){
            setDamage(stack, getDamage(stack)- 4);
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
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        float particlePosCalcX;
        float particlePosCalcZ;
        float particlePosCalcY;

        if(playerIn.getHeldItem(handIn).getDamage() < 2998){
            playerIn.getCooldownTracker().setCooldown(this, 400);
            playerIn.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS, 0.2F, 1.0F);

            for(int i = 0; i < 50; i++){
                particlePosCalcX = (float) Math.random();
                particlePosCalcZ = (float) Math.random();
                particlePosCalcY = (float) Math.random();
                worldIn.addParticle(ParticleTypes.ENCHANT,playerIn.getPosX()-particlePosCalcX+0.5F,playerIn.getPosY()+particlePosCalcY+1,playerIn.getPosZ()-particlePosCalcZ+0.5F,0.0F,0.2F,0.0F);
                worldIn.addParticle(ParticleTypes.ENCHANT,playerIn.getPosX()-particlePosCalcX+0.5F,playerIn.getPosY()+particlePosCalcY,playerIn.getPosZ()-particlePosCalcZ+0.5F,0.0F,0.2F,0.0F);
                worldIn.addParticle(ParticleTypes.ENCHANT,playerIn.getPosX()-particlePosCalcX+0.5F,playerIn.getPosY()+particlePosCalcY,playerIn.getPosZ()-particlePosCalcZ+0.5F,0.0F,0.2F,0.0F);

            }



            playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 100, 3, false, false));
        } else{
            playerIn.sendStatusMessage(new StringTextComponent("Tool is broken! Repair at anvil or charger!"),true);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }




}
