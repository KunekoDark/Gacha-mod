package com.gachamod.gacha.entitiys.tileentity;

import com.gachamod.gacha.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class UpgradeTableTile extends TileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public UpgradeTableTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public UpgradeTableTile(){
        this(ModTileEntities.UPGRADE_TABLE_TILE.get());
    }

    // read and write save nbt data/ the contents into the world
    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }

    private ItemStackHandler createHandler(){
        return new ItemStackHandler(6){
            @Override
            protected void onContentsChanged(int slot){
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack){
                switch (slot){
                    //input slots
                    case 0: return stack.getItem() == ModItems.CANNON_BASE.get();
                    case 1: return stack.getItem() == ModItems.CANNON_COMPONENT.get();
                    case 2: return stack.getItem() == ModItems.CANNON_HANDHELD_MODULE.get();


                    default:
                        return false;
                }
            }

            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }
            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate){
                if(!isItemValid(slot, stack)){
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }

        return super.getCapability(cap, side);
    }

    public void allComponentsInSlots(){
        boolean hasCannonBaseInFirstSlot = this.itemHandler.getStackInSlot(0).getItem() == ModItems.CANNON_BASE.get();
        boolean hasCannonComponentInSecondSlot = this.itemHandler.getStackInSlot(1).getItem() == ModItems.CANNON_COMPONENT.get();
        boolean hasCannonHandheldModuleInThirdSlot = this.itemHandler.getStackInSlot(2).getItem() == ModItems.CANNON_HANDHELD_MODULE.get();
        boolean hasCannonBaseInFourthSlot = this.itemHandler.getStackInSlot(3).getItem() == ModItems.CANNON_SHAFT.get();
        boolean hasCannonBaseInFifthSlot = this.itemHandler.getStackInSlot(4).getItem() == ModItems.CANNON_CHARGE_MODULE.get();

        boolean hasCannonBaseInSixthSlot = this.itemHandler.getStackInSlot(5).getItem() == ModItems.CAT_CANNON.get();

        if(hasCannonBaseInFirstSlot && hasCannonComponentInSecondSlot && hasCannonHandheldModuleInThirdSlot && hasCannonBaseInFourthSlot && hasCannonBaseInFifthSlot){
            if(hasCannonBaseInSixthSlot){
                return;
            } else {
                this.itemHandler.getStackInSlot(0).shrink(1);
                this.itemHandler.getStackInSlot(1).shrink(1);
                this.itemHandler.getStackInSlot(2).shrink(1);
                this.itemHandler.getStackInSlot(3).shrink(1);
                this.itemHandler.getStackInSlot(4).shrink(1);

                this.itemHandler.insertItem(5, new ItemStack(ModItems.CAT_CANNON.get()), false);

            }
        }
    }
}
