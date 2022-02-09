package com.gachamod.gacha.api.blocks;

import com.gachamod.gacha.api.entity.ModEntityType;
import com.gachamod.gacha.entitiys.mobs.KasaJizo;
import com.gachamod.gacha.entitiys.tileentity.EngineerTableTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SilverfishBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class JizoSummonBlock extends Block {
    public JizoSummonBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }


    private void spawnKasaJizo(ServerWorld world, BlockPos pos) {
        KasaJizo kasaJizo = ModEntityType.KASAJIZO.get().create(world);
        kasaJizo.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
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


