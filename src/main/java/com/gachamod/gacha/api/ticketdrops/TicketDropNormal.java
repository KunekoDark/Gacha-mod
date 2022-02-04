package com.gachamod.gacha.api.ticketdrops;

import io.netty.util.concurrent.DefaultEventExecutor;
import net.minecraft.client.particle.SweepAttackParticle;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

import static net.minecraft.loot.LootParameterSets.SELECTOR;


public class TicketDropNormal extends Item {


    public TicketDropNormal(Properties properties) {
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
        Random rand = new Random();
        int randId = rand.nextInt(500);
        playerIn.inventory.placeItemBackInInventory(worldIn, new ItemStack(Item.getItemById(randId)));
        playerIn.inventory.removeStackFromSlot(playerIn.inventory.currentItem);
        return super.onItemRightClick(worldIn, playerIn, handIn);

    }


   /* public ItemStack LootTStk(World world){
        Random rand = new Random();
        ResourceLocation location = new ResourceLocation("resources/data/gacha/loot_table/test_table.json");
        LootPredicateManager pred = new LootPredicateManager();
        LootTable table = new LootTableManager(pred).getLootTableFromLocation(location);
        List<ItemStack> stacks = table.generate();

        return stacks.get(0);
    }*/

}
