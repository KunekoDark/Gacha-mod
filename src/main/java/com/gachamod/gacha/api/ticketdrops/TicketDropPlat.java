package com.gachamod.gacha.api.ticketdrops;

import com.gachamod.gacha.api.ticketloot.TicketLoot;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TicketDropPlat extends Item {
    List<Item> loot = new ArrayList<>();


    public TicketDropPlat(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.gacha.ticket_tooltip"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.giveExperiencePoints(10);
        TicketLoot loot = new TicketLoot();
        Random rand = new Random();
        int randAmtDrop = rand.nextInt(4);
        playerIn.inventory.removeStackFromSlot(playerIn.inventory.currentItem);
        for(int i =0; i != randAmtDrop; i++){
            int randId = rand.nextInt(loot.getPlatTicketLoot().size());
            playerIn.inventory.placeItemBackInInventory(worldIn, new ItemStack(loot.getPlatTicketLoot().get(randId)));
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);

    }
}
