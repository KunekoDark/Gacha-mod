package com.gachamod.gacha.container;

import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.data.recipes.EngineerTableRecipe;
import com.gachamod.gacha.data.recipes.IEngineerTableRecipe;
import com.gachamod.gacha.data.recipes.ModRecipeTypes;
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
import net.minecraft.item.crafting.IRecipeType;
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

public class EngineerTableContainer extends RecipeBookContainer<CraftingInventory> {
    private final TileEntity tileEntity;
    private final PlayerEntity playerEntity;
    private final IItemHandler playerInventory;
    private final IWorldPosCallable worldPosCallable;
    private final CraftingInventory craftMatrix = new CraftingInventory(this, 3, 2);
    private final CraftResultInventory craftResult = new CraftResultInventory();



    public EngineerTableContainer(int windowId, World world, BlockPos pos,
                                  PlayerInventory playerInventory, PlayerEntity player, IWorldPosCallable worldPosCallable) {
        super(ModContainers.ENGINEER_TABLE_CONTAINER.get(), windowId);
        this.worldPosCallable = worldPosCallable;
        this.tileEntity = world.getTileEntity(pos);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventory);

        layoutPlayerInventorySlots(8,84);

        if(tileEntity != null){
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h ->{
                addSlot(new Slot(this.craftMatrix,0,44,32));
                addSlot(new Slot(this.craftMatrix,1,62,32));
                addSlot(new Slot(this.craftMatrix,2,80,32));
                addSlot(new Slot(this.craftMatrix,3,53,50));
                addSlot(new Slot(this.craftMatrix,4,71,50));


                addSlot(new CraftingResultSlot(playerInventory.player, this.craftMatrix, this.craftResult, 0, 116,32));

            });
        }
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()),
                playerIn, ModBlocks.ENGINEER_TABLE.get());
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
        addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);

        topRow += 58;
        addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
    }


    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index == 0) {
                this.worldPosCallable.consume((world, pos) -> {
                    itemstack1.getItem().onCreated(itemstack1, world, playerIn);
                });
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);
            if (index == 0) {
                playerIn.dropItem(itemstack2, false);
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
        /*if (!world.isRemote) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)player;
            ItemStack itemstack = ItemStack.EMPTY;
            Optional<EngineerTableRecipe> optional = world.getServer().getRecipeManager().getRecipe(ModRecipeTypes.ENGINEER_RECIPE, inventory, world);
            if (optional.isPresent()) {
                EngineerTableRecipe EngineerTableRecipe = optional.get();
                itemstack = EngineerTableRecipe.getRecipeOutput();
            }

            inventoryResult.setInventorySlotContents(5, itemstack);
            serverplayerentity.connection.sendPacket(new SSetSlotPacket(id, 41, itemstack));
        }*/
    }


    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        this.detectAndSendChanges();
        World world = this.playerEntity.world;
        updateCraftingResult(this.windowId, world, this.playerEntity, this.craftMatrix, this.craftResult);

    }

    @Override
    public int getOutputSlot() {
        return 5;
    }

    @Override
    public int getWidth() {
        return 3;
    }

    @Override
    public int getHeight() {
        return 2;
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public RecipeBookCategory func_241850_m() {
        return null;
    }
}

