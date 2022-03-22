package com.gachamod.gacha.api.Utils;

import com.gachamod.gacha.data.recipes.ModRecipeTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.ForgeHooks;

public class SlotUtils {

    /**
     * Copied from SilentLib under MIT licensing all credit goes to SilentChaos512.
     * https://github.com/SilentChaos512/SilentLib
     */
    public static class FuelSlot extends Slot {

        public FuelSlot(IInventory blockInv, int index, int x, int y) {
            super(blockInv, index, x, y);
        }

        @Override
        public boolean isItemValid(ItemStack pStack) {
            return ForgeHooks.getBurnTime(pStack) > 0;
        }


    }


    public static class EvolveOuput extends Slot {
        private final CraftingInventory craftMatrix;
        private final PlayerEntity player;
        private int amountCrafted;

        public EvolveOuput(PlayerEntity player, CraftingInventory craftingInventory, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
            super(inventoryIn, slotIndex, xPosition, yPosition);
            this.player = player;
            this.craftMatrix = craftingInventory;
        }

        /**
         * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
         */
        public boolean isItemValid(ItemStack stack) {
            return false;
        }

        /**
         * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new stack.
         */
        public ItemStack decrStackSize(int amount) {
            if (this.getHasStack()) {
                this.amountCrafted += Math.min(amount, this.getStack().getCount());
            }

            return super.decrStackSize(amount);
        }

        /**
         * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
         * internal count then calls onCrafting(item).
         */
        protected void onCrafting(ItemStack stack, int amount) {
            this.amountCrafted += amount;
            this.onCrafting(stack);
        }

        protected void onSwapCraft(int numItemsCrafted) {
            this.amountCrafted += numItemsCrafted;
        }

        /**
         * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
         */
        protected void onCrafting(ItemStack stack) {
            if (this.amountCrafted > 0) {
                stack.onCrafting(this.player.world, this.player, this.amountCrafted);
                net.minecraftforge.fml.hooks.BasicEventHooks.firePlayerCraftingEvent(this.player, stack, this.craftMatrix);
            }

            if (this.inventory instanceof IRecipeHolder) {
                ((IRecipeHolder)this.inventory).onCrafting(this.player);
            }

            this.amountCrafted = 0;
        }

        public ItemStack onTake(PlayerEntity thePlayer, ItemStack stack) {
            this.onCrafting(stack);
            net.minecraftforge.common.ForgeHooks.setCraftingPlayer(thePlayer);
            NonNullList<ItemStack> nonnulllist = thePlayer.world.getRecipeManager().getRecipeNonNull(ModRecipeTypes.EVOLVE_RECIPE, this.craftMatrix, thePlayer.world);
            net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);
            for(int i = 0; i < nonnulllist.size(); ++i) {
                ItemStack itemstack = this.craftMatrix.getStackInSlot(i);
                ItemStack itemstack1 = nonnulllist.get(i);
                if (!itemstack.isEmpty()) {
                    this.craftMatrix.decrStackSize(i, 1);
                    itemstack = this.craftMatrix.getStackInSlot(i);
                }

                if (!itemstack1.isEmpty()) {
                    if (itemstack.isEmpty()) {
                        this.craftMatrix.setInventorySlotContents(i, itemstack1);
                    } else if (ItemStack.areItemsEqual(itemstack, itemstack1) && ItemStack.areItemStackTagsEqual(itemstack, itemstack1)) {
                        itemstack1.grow(itemstack.getCount());
                        this.craftMatrix.setInventorySlotContents(i, itemstack1);
                    } else if (!this.player.inventory.addItemStackToInventory(itemstack1)) {
                        this.player.dropItem(itemstack1, false);
                    }
                }
            }

            return stack;
        }
    }
    public static class MTFOutput extends Slot {
        private final CraftingInventory craftMatrix;
        private final PlayerEntity player;
        private int amountCrafted;

        public MTFOutput(PlayerEntity player, CraftingInventory craftingInventory, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
            super(inventoryIn, slotIndex, xPosition, yPosition);
            this.player = player;
            this.craftMatrix = craftingInventory;
        }

        /**
         * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
         */
        @Override
        public boolean isItemValid(ItemStack stack) {
            return false;
        }

        /**
         * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new stack.
         */
        @Override
        public ItemStack decrStackSize(int amount) {
            if (this.getHasStack()) {
                this.amountCrafted += Math.min(amount, this.getStack().getCount());
            }

            return super.decrStackSize(amount);
        }

        /**
         * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
         * internal count then calls onCrafting(item).
         */
        @Override
        protected void onCrafting(ItemStack stack, int amount) {
            this.amountCrafted += amount;
            this.onCrafting(stack);
        }

        protected void onSwapCraft(int numItemsCrafted) {
            this.amountCrafted += numItemsCrafted;
        }

        /**
         * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
         */
        @Override
        protected void onCrafting(ItemStack stack) {
            if (this.amountCrafted > 0) {
                stack.onCrafting(this.player.world, this.player, this.amountCrafted);
                net.minecraftforge.fml.hooks.BasicEventHooks.firePlayerCraftingEvent(this.player, stack, this.craftMatrix);
            }

            if (this.inventory instanceof IRecipeHolder) {
                ((IRecipeHolder)this.inventory).onCrafting(this.player);
            }

            this.amountCrafted = 0;
        }

        @Override
        public ItemStack onTake(PlayerEntity thePlayer, ItemStack stack) {
            this.onCrafting(stack);
            net.minecraftforge.common.ForgeHooks.setCraftingPlayer(thePlayer);
            NonNullList<ItemStack> nonnulllist = thePlayer.world.getRecipeManager().getRecipeNonNull(ModRecipeTypes.ENGINEER_RECIPE, this.craftMatrix, thePlayer.world);
            net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);
            for(int i = 0; i < nonnulllist.size(); ++i) {
                ItemStack itemstack = this.craftMatrix.getStackInSlot(i);
                ItemStack itemstack1 = nonnulllist.get(i);
                if (!itemstack.isEmpty()) {
                    this.craftMatrix.decrStackSize(i, 1);
                    itemstack = this.craftMatrix.getStackInSlot(i);
                }

                if (!itemstack1.isEmpty()) {
                    if (itemstack.isEmpty()) {
                        this.craftMatrix.setInventorySlotContents(i, itemstack1);
                    } else if (ItemStack.areItemsEqual(itemstack, itemstack1) && ItemStack.areItemStackTagsEqual(itemstack, itemstack1)) {
                        itemstack1.grow(itemstack.getCount());
                        this.craftMatrix.setInventorySlotContents(i, itemstack1);
                    } else if (!this.player.inventory.addItemStackToInventory(itemstack1)) {
                        this.player.dropItem(itemstack1, false);
                    }
                }
            }

            return stack;
        }
    }



    public static class OutputSlot extends Slot {

        public OutputSlot(IInventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        @Override
        public boolean isItemValid(ItemStack pStack) {
            return false;
        }
    }

}