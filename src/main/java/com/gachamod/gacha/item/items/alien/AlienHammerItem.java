package com.gachamod.gacha.item.items.alien;

import com.gachamod.gacha.data.isOnCharger;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class AlienHammerItem extends PickaxeItem {
    public AlienHammerItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
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

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        PlayerEntity player = (PlayerEntity) entityLiving;

        BlockPos posBelow = pos.down();
        BlockPos posUp = pos.up();


        BlockPos posLeftFaceNorth = pos.west();
        BlockPos posRightFaceNorth = pos.east();
        BlockPos posDownLeftFaceNorth = pos.down().west();
        BlockPos posDownRightFaceNorth = pos.down().east();
        BlockPos posUpLeftFaceNorth = pos.up().west();
        BlockPos posUpRightFaceNorth = pos.up().east();

        BlockPos posLeftFaceSouth = pos.east();
        BlockPos posRightFaceSouth = pos.west();
        BlockPos posDownLeftFaceSouth = pos.down().east();
        BlockPos posDownRightFaceSouth = pos.down().west();
        BlockPos posUpLeftFaceSouth = pos.up().east();
        BlockPos posUpRightFaceSouth = pos.up().west();

        BlockPos posLeftFaceEast = pos.north();
        BlockPos posRightFaceEast = pos.south();
        BlockPos posDownLeftFaceEast = pos.down().north();
        BlockPos posDownRightFaceEast = pos.down().south();
        BlockPos posUpLeftFaceEast = pos.up().north();
        BlockPos posUpRightFaceEast = pos.up().south();

        BlockPos posLeftFaceWest = pos.south();
        BlockPos posRightFaceWest = pos.north();
        BlockPos posDownLeftFaceWest = pos.down().south();
        BlockPos posDownRightFaceWest = pos.down().north();
        BlockPos posUpLeftFaceWest = pos.up().south();
        BlockPos posUpRightFaceWest = pos.up().north();

        BlockPos posLeftFaceWestUp = pos.south();
        BlockPos posRightFaceWestUp = pos.north();
        BlockPos posDownLeftFaceWestUp = pos.down().south();
        BlockPos posDownRightFaceWestUp = pos.down().north();
        BlockPos posUpLeftFaceWestUp = pos.up().south();
        BlockPos posUpRightFaceWestUp = pos.up().north();
        BlockPos posUpFaceWestUp = pos.west();
        BlockPos posDownFaceWestUp = pos.east();


        boolean horizontalPatern = false;

        if(Material.ROCK.isSolid() || Material.IRON.isSolid()){
            if(worldIn.getBlockState(pos.up()).getMaterial() == Material.AIR || worldIn.getBlockState(pos.down()).getMaterial() == Material.AIR)
            {
                worldIn.destroyBlock(pos.east(), true);
                worldIn.destroyBlock(pos.west(),true);
                worldIn.destroyBlock(pos.north(), true);
                worldIn.destroyBlock(pos.south(), true);
                worldIn.destroyBlock(pos.south().west(), true);
                worldIn.destroyBlock(pos.south().east(), true);
                worldIn.destroyBlock(pos.north().west(), true);
                worldIn.destroyBlock(pos.north().east(), true);
                horizontalPatern = true;
            }
        }

        if(Material.ROCK.isSolid() || Material.IRON.isSolid()){
            if(player.getHorizontalFacing() == Direction.NORTH && !horizontalPatern){
                worldIn.destroyBlock(posBelow,true);
                worldIn.destroyBlock(posUp,true);
                worldIn.destroyBlock(posLeftFaceNorth, true);
                worldIn.destroyBlock(posRightFaceNorth,true);
                worldIn.destroyBlock(posDownLeftFaceNorth, true);
                worldIn.destroyBlock(posDownRightFaceNorth, true);
                worldIn.destroyBlock(posUpLeftFaceNorth, true);
                worldIn.destroyBlock(posUpRightFaceNorth, true);
            }
        }

        if(Material.ROCK.isSolid() || Material.IRON.isSolid()){
            if(player.getHorizontalFacing() == Direction.SOUTH&& !horizontalPatern){
                worldIn.destroyBlock(posBelow,true);
                worldIn.destroyBlock(posUp,true);
                worldIn.destroyBlock(posLeftFaceSouth, true);
                worldIn.destroyBlock(posRightFaceSouth,true);
                worldIn.destroyBlock(posDownLeftFaceSouth, true);
                worldIn.destroyBlock(posDownRightFaceSouth, true);
                worldIn.destroyBlock(posUpLeftFaceSouth, true);
                worldIn.destroyBlock(posUpRightFaceSouth, true);
            }
        }
        if(Material.ROCK.isSolid() || Material.IRON.isSolid()){
            if(player.getHorizontalFacing() == Direction.EAST&& !horizontalPatern){
                worldIn.destroyBlock(posBelow,true);
                worldIn.destroyBlock(posUp,true);
                worldIn.destroyBlock(posLeftFaceEast, true);
                worldIn.destroyBlock(posRightFaceEast,true);
                worldIn.destroyBlock(posDownLeftFaceEast, true);
                worldIn.destroyBlock(posDownRightFaceEast, true);
                worldIn.destroyBlock(posUpLeftFaceEast, true);
                worldIn.destroyBlock(posUpRightFaceEast, true);
            }
        }
        if(Material.ROCK.isSolid() || Material.IRON.isSolid()){
            if(player.getHorizontalFacing() == Direction.WEST&& !horizontalPatern){
                worldIn.destroyBlock(posBelow,true);
                worldIn.destroyBlock(posUp,true);
                worldIn.destroyBlock(posLeftFaceWest, true);
                worldIn.destroyBlock(posRightFaceWest,true);
                worldIn.destroyBlock(posDownLeftFaceWest, true);
                worldIn.destroyBlock(posDownRightFaceWest, true);
                worldIn.destroyBlock(posUpLeftFaceWest, true);
                worldIn.destroyBlock(posUpRightFaceWest, true);
            }
        }




        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
