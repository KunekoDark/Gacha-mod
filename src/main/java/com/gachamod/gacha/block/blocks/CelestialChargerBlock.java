package com.gachamod.gacha.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Stream;

public class CelestialChargerBlock extends Block {



    public CelestialChargerBlock(Properties properties, Object o) {
        super(properties);
    }



    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        float particlePosCalcX;
        particlePosCalcX = (float) Math.random();

        float particlePosCalcZ;
        particlePosCalcZ = (float) Math.random();
        if(entityIn instanceof PlayerEntity){
            worldIn.playSound(null,pos,SoundEvents.BLOCK_BEACON_AMBIENT, SoundCategory.BLOCKS,0.2F,1);
            worldIn.addParticle(ParticleTypes.REVERSE_PORTAL,pos.getX()+particlePosCalcX,pos.getY()+1F,pos.getZ()+particlePosCalcZ,0,0.2F,0);
            worldIn.addParticle(ParticleTypes.REVERSE_PORTAL,pos.getX()+particlePosCalcX,pos.getY(),pos.getZ()+particlePosCalcZ,0,0.2F,0);
        }
        super.onEntityCollision(state, worldIn, pos, entityIn);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(0, 0, 7, 16, 1, 9),
            Block.makeCuboidShape(7, 0, 0, 9, 1, 7),
            Block.makeCuboidShape(7, 0, 9, 9, 1, 16),
            Block.makeCuboidShape(1, 0, 1, 7, 1, 7),
            Block.makeCuboidShape(9, 0, 1, 15, 1, 7),
            Block.makeCuboidShape(9, 0, 9, 15, 1, 15),
            Block.makeCuboidShape(1, 0, 9, 7, 1, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.gacha.celestial_charger_tooltip"));
    }
}
