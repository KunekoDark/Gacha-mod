package com.gachamod.gacha.block.blocks;

import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.world.dimension.DimensionTeleporter;
import com.gachamod.gacha.world.dimension.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.stream.Stream;

public class TimeMachineBlock extends Block {
    public TimeMachineBlock(Properties properties, Object o) {
        super(properties);
    }


    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        float particlePosCalcX;
        particlePosCalcX = (float) Math.random();

        float particlePosCalcZ;
        particlePosCalcZ = (float) Math.random();
        for(int i = 0; i <20; i++){
            worldIn.addParticle(ParticleTypes.END_ROD,pos.getX()+particlePosCalcX,pos.getY()+1,pos.getZ()+particlePosCalcZ,0,2F,0);
            worldIn.addParticle(ParticleTypes.END_ROD,pos.getX()+particlePosCalcX,pos.getY(),pos.getZ()+particlePosCalcZ,0,2F,0);

        }

    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        PlayerEntity player = (PlayerEntity) entityIn;

        if (!worldIn.isRemote()) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();

                if (server != null) {
                    if (worldIn.getDimensionKey() == ModDimensions.FutureDim) {
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        if (overWorld != null) {
                            player.changeDimension(overWorld, new DimensionTeleporter(pos, false));
                        }
                    } else {
                        ServerWorld futureDim = server.getWorld(ModDimensions.FutureDim);
                        if (futureDim != null) {
                            player.changeDimension(futureDim, new DimensionTeleporter(pos, true));
                        }
                    }

                }
            }
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote()) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();

                if (server != null) {
                    if (worldIn.getDimensionKey() == ModDimensions.FutureDim) {
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        if (overWorld != null) {
                            player.changeDimension(overWorld, new DimensionTeleporter(pos, false));
                        }
                    } else {
                        ServerWorld futureDim = server.getWorld(ModDimensions.FutureDim);
                        if (futureDim != null) {
                            player.changeDimension(futureDim, new DimensionTeleporter(pos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(1, 1, 3, 3, 1, 5),
            Block.makeCuboidShape(7, 1, 0, 9, 1, 16),
            Block.makeCuboidShape(0, 1, 5, 7, 1, 11),
            Block.makeCuboidShape(9, 1, 5, 16, 1, 11),
            Block.makeCuboidShape(5, 1, 0, 7, 1, 5),
            Block.makeCuboidShape(9, 1, 0, 11, 1, 5),
            Block.makeCuboidShape(5, 1, 11, 7, 1, 16),
            Block.makeCuboidShape(9, 1, 11, 11, 1, 16),
            Block.makeCuboidShape(3, 1, 1, 5, 1, 5),
            Block.makeCuboidShape(11, 1, 1, 13, 1, 5),
            Block.makeCuboidShape(11, 1, 11, 13, 1, 15),
            Block.makeCuboidShape(3, 1, 11, 5, 1, 15),
            Block.makeCuboidShape(1, 1, 11, 3, 1, 13),
            Block.makeCuboidShape(13, 1, 11, 15, 1, 13),
            Block.makeCuboidShape(13, 1, 3, 15, 1, 5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
