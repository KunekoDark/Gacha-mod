package com.gachamod.gacha.block.blocks;

import com.gachamod.gacha.container.containers.NormalTicketCapsuleContainer;
import com.gachamod.gacha.entity.ModTileEntities;
import com.gachamod.gacha.entity.tileentity.NormalTicketCapsuleTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.stream.Stream;

public class NormalTicketCapsuleBlock extends Block {
    public NormalTicketCapsuleBlock(Properties properties) {
        super(properties);
    }
    private static final DirectionProperty FACEING = HorizontalBlock.HORIZONTAL_FACING;
    int cooldown = 0;

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACEING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACEING, rot.rotate(state.get(FACEING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACEING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACEING);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(2, 0, 2, 14, 12, 14)


    ).reduce((v1, v2) ->  {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if (random.nextInt(10) != 0) {
            ((NormalTicketCapsuleTile) tileEntity).canGetTicket();
            worldIn.playSound(null, pos, SoundEvents.ENTITY_CAT_AMBIENT, SoundCategory.BLOCKS, 0.1F, 1.0F);
            super.tick(state, worldIn, pos, random);
        }
    }


    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()){
            TileEntity tileEntity = worldIn.getTileEntity(pos);

            if(!player.isCrouching()) {
                if (tileEntity instanceof NormalTicketCapsuleTile) {
                    INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);

                    NetworkHooks.openGui(((ServerPlayerEntity) player), containerProvider, tileEntity.getPos());
                } else {
                    throw new IllegalStateException("Container provider is missing");
                }
            }

        }
        return ActionResultType.SUCCESS;
    }


    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.gacha.normal_ticket_capsule");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new NormalTicketCapsuleContainer(i , worldIn, pos, playerInventory, playerEntity);
            }
        };
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.NORMAL_TICKET_CAPSULE_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}

