package com.gachamod.gacha.block.blocks;

import com.gachamod.gacha.entity.ModEntityType;
import com.gachamod.gacha.entity.mobs.KasaJizo;
import com.gachamod.gacha.util.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

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

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {

        System.out.println("working?");
        worldIn.playSound(null, pos, ModSoundEvents.BATTLE_CATS_THEME_3.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
}


