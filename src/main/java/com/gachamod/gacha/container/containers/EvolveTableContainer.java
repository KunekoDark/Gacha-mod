package com.gachamod.gacha.container.containers;

import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.container.ModContainers;
import com.gachamod.gacha.data.recipes.ModRecipeTypes;
import com.gachamod.gacha.data.recipes.evolvetable.EvolveTableRecipe;
import com.gachamod.gacha.screen.EvolveTableScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import java.util.Optional;

public class EvolveTableContainer extends RecipeBookContainer<CraftingInventory> {
    private final TileEntity tileEntity;
    private final PlayerEntity playerEntity;
    private final IItemHandler playerInventory;
    private final CraftingInventory craftMatrix = new CraftingInventory(this, 3, 3);
    private final CraftResultInventory craftResult = new CraftResultInventory();
    public static final int offset = EvolveTableScreen.evolveoffset;




    public EvolveTableContainer(int windowId, World world, BlockPos pos,
                                  PlayerInventory playerInventory, PlayerEntity player) {
        super(ModContainers.EVOLVE_TABLE_CONTAINER.get(), windowId);
        this.tileEntity = world.getTileEntity(pos);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventory);

        if(tileEntity != null){
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h ->{
                addSlot(new Slot(this.craftMatrix,0,34,22+offset));
                addSlot(new Slot(this.craftMatrix,1,60,22+offset));
                addSlot(new Slot(this.craftMatrix,2,21,48+offset));
                addSlot(new Slot(this.craftMatrix,3,47,48+offset));
                addSlot(new Slot(this.craftMatrix,4,73,48+offset));
                addSlot(new Slot(this.craftMatrix,5,34,74+offset));
                addSlot(new Slot(this.craftMatrix,6,60,74+offset));


                addSlot(new CraftingResultSlot(playerInventory.player, this.craftMatrix, this.craftResult, 0, 133,48+offset));

            });

            layoutPlayerInventorySlots(8,111);
        }
    }


    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()),
                playerIn, ModBlocks.EVOLVE_TABLE.get());
    }

    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for (int i = 0; i < amount; i++) {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }

        return index;
    }


    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0; j < verAmount; j++) {
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }

        return index;
    }


    private void layoutPlayerInventorySlots(int leftCol, int topRow) {
        addSlotBox(playerInventory, 9, leftCol, topRow+offset, 9, 18, 3, 18);

        topRow += 58;
        addSlotRange(playerInventory, 0, leftCol, topRow+offset, 9, 18);
    }


    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < this.craftMatrix.getSizeInventory()) {
                if (!this.mergeItemStack(itemstack1, this.craftMatrix.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, this.craftMatrix.getSizeInventory(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }


    @Override
    public void fillStackedContents(RecipeItemHelper itemHelperIn) {
        this.craftMatrix.fillStackedContents(itemHelperIn);
    }

    @Override
    public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }

    @Override
    public void clear() {
        this.craftMatrix.clear();
        this.craftResult.clear();
    }

    @Override
    public boolean matches(IRecipe<? super CraftingInventory> recipeIn) {
        return recipeIn.matches(this.craftMatrix, this.playerEntity.world);
    }



    protected static void updateCraftingResult(int id, World world, PlayerEntity player, CraftingInventory inventory, CraftResultInventory inventoryResult) {
        if (!world.isRemote) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)player;
            ItemStack itemstack = ItemStack.EMPTY;
            Optional<EvolveTableRecipe> optional = world.getServer().getRecipeManager().getRecipe(ModRecipeTypes.EVOLVE_RECIPE, inventory, world);
            if (optional.isPresent()) {
                EvolveTableRecipe evolveTableRecipe = optional.get();
                itemstack = evolveTableRecipe.getRecipeOutput();

            }

            inventoryResult.setInventorySlotContents(7, itemstack);
            serverplayerentity.connection.sendPacket(new SSetSlotPacket(id, 7, itemstack));

        }
    }



    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        this.detectAndSendChanges();
        World world = this.playerEntity.world;
        updateCraftingResult(this.windowId, world, this.playerEntity, this.craftMatrix, this.craftResult);

    }

    @Override
    public int getOutputSlot() {
        return 7;
    }

    @Override
    public int getWidth() {
        return 3;
    }

    @Override
    public int getHeight() {
        return 3;
    }

    @Override
    public int getSize() {
        return 7;
    }

    @Override
    public RecipeBookCategory func_241850_m() {
        return null;
    }

    @Override
    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        if (!playerIn.world.isRemote) {
            if (!playerIn.isAlive() || playerIn instanceof ServerPlayerEntity && ((ServerPlayerEntity)playerIn).hasDisconnected()) {
                ItemStack itemstack = this.craftMatrix.removeStackFromSlot(0);
                if (!itemstack.isEmpty()) {
                    playerIn.dropItem(itemstack, false);
                }
                itemstack = this.craftMatrix.removeStackFromSlot(1);
                if (!itemstack.isEmpty()) {
                    playerIn.dropItem(itemstack, false);
                }
                itemstack = this.craftMatrix.removeStackFromSlot(2);
                if (!itemstack.isEmpty()) {
                    playerIn.dropItem(itemstack, false);
                }
                itemstack = this.craftMatrix.removeStackFromSlot(3);
                if (!itemstack.isEmpty()) {
                    playerIn.dropItem(itemstack, false);
                }
                itemstack = this.craftMatrix.removeStackFromSlot(4);
                if (!itemstack.isEmpty()) {
                    playerIn.dropItem(itemstack, false);
                }
                itemstack = this.craftMatrix.removeStackFromSlot(5);
                if (!itemstack.isEmpty()) {
                    playerIn.dropItem(itemstack, false);
                }
                itemstack = this.craftMatrix.removeStackFromSlot(6);
                if (!itemstack.isEmpty()) {
                    playerIn.dropItem(itemstack, false);
                }

            } else {
                playerIn.inventory.placeItemBackInInventory(playerIn.world, this.craftMatrix.removeStackFromSlot(0));
                playerIn.inventory.placeItemBackInInventory(playerIn.world, this.craftMatrix.removeStackFromSlot(1));
                playerIn.inventory.placeItemBackInInventory(playerIn.world, this.craftMatrix.removeStackFromSlot(2));
                playerIn.inventory.placeItemBackInInventory(playerIn.world, this.craftMatrix.removeStackFromSlot(3));
                playerIn.inventory.placeItemBackInInventory(playerIn.world, this.craftMatrix.removeStackFromSlot(4));
                playerIn.inventory.placeItemBackInInventory(playerIn.world, this.craftMatrix.removeStackFromSlot(5));
                playerIn.inventory.placeItemBackInInventory(playerIn.world, this.craftMatrix.removeStackFromSlot(6));

            }

        }
    }


}

