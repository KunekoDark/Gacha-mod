package com.gachamod.gacha.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class CelestialChargerBlock extends Block {



    public CelestialChargerBlock(Properties properties, Object o) {
        super(properties);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {



        float particlePosCalcX;
        particlePosCalcX = (float) Math.random();

        float particlePosCalcZ;
        particlePosCalcZ = (float) Math.random();
        if(entityIn instanceof PlayerEntity){
            worldIn.playSound(null,pos,SoundEvents.BLOCK_BEACON_AMBIENT, SoundCategory.BLOCKS,0.2F,1);
            worldIn.addParticle(ParticleTypes.REVERSE_PORTAL,pos.getX()+particlePosCalcX,pos.getY()+1F,pos.getZ()+particlePosCalcZ,0,0.2F,0);
            worldIn.addParticle(ParticleTypes.REVERSE_PORTAL,pos.getX()+particlePosCalcX,pos.getY(),pos.getZ()+particlePosCalcZ,0,0.2F,0);
        }





        super.onEntityWalk(worldIn, pos, entityIn);
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.gacha.celestial_charger_tooltip"));
    }
}
