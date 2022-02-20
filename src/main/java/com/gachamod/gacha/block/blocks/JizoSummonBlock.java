package com.gachamod.gacha.block.blocks;

import com.gachamod.gacha.entity.ModEntityType;
import com.gachamod.gacha.entity.mobs.KasaJizo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.server.ServerWorld;

import static net.minecraft.entity.SpawnReason.SPAWNER;

public class JizoSummonBlock extends Block {
    public JizoSummonBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }


    private void spawnKasaJizo(ServerWorld world, BlockPos pos) {
        KasaJizo kasaJizo = ModEntityType.KASAJIZO.get().create(world);
        kasaJizo.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
        kasaJizo.onInitialSpawn(world, world.getDifficultyForLocation(pos), SPAWNER, null, null);
        world.addEntity(kasaJizo);
        kasaJizo.spawnExplosionParticle();

    }
    @Override
    public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack) {
        super.spawnAdditionalDrops(state, worldIn, pos, stack);
        if (worldIn.getGameRules().getBoolean(GameRules.DO_TILE_DROPS)) {
            this.spawnKasaJizo(worldIn, pos);
        }

    }
}


