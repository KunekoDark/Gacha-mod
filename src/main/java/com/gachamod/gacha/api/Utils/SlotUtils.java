package com.gachamod.gacha.api.Utils;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
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