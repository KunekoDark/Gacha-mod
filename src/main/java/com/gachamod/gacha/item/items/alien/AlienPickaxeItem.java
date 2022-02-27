package com.gachamod.gacha.item.items.alien;

import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.data.isOnCharger;
import com.gachamod.gacha.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class AlienPickaxeItem extends PickaxeItem {
    public AlienPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        PlayerEntity player = (PlayerEntity) entityIn;
        PlayerInventory inventory = player.inventory;

        boolean charging = new isOnCharger().isOnTopOfAlienCharger(player);
        if(isSelected && worldIn.isNightTime() && charging){
            setDamage(stack, getDamage(stack)- 4);
        }




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

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        PlayerEntity player = (PlayerEntity) entityLiving;
        ItemEntity item = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.METEORITE_CHUNK.get()));
        if(state.getBlock() == ModBlocks.CELESTIAL_CHARGER.get()){
            worldIn.addEntity(item);
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
