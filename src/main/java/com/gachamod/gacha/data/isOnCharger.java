package com.gachamod.gacha.data;

import com.gachamod.gacha.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public class isOnCharger {
    public boolean isOnTopOfCharger(PlayerEntity player){
        BlockPos posBelow = player.getPosition().down();
        BlockState blockStateBelow = player.world.getBlockState(posBelow);
        if(blockStateBelow.getBlock() == ModBlocks.CELESTIAL_CHARGER.get() || blockStateBelow.getBlock() == ModBlocks.ALIEN_CHARGER.get()){
            return true;
        }
        return false;
    }
    public boolean isOnTopOfAlienCharger(PlayerEntity player){
        BlockPos posBelow = player.getPosition().down();
        BlockState blockStateBelow = player.world.getBlockState(posBelow);
        if(blockStateBelow.getBlock() == ModBlocks.ALIEN_CHARGER.get()){
            return true;
        }
        return false;
    }

}
