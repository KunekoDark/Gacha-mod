package com.gachamod.gacha.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CelestialChargerBlock extends Block {



    public CelestialChargerBlock(Properties properties, Object o) {
        super(properties);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {

        worldIn.playSound(null,pos,SoundEvents.BLOCK_BEACON_AMBIENT, SoundCategory.BLOCKS,0.2F,1);
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
