package com.gachamod.gacha.api.loottostk;

import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.ChestLootTables;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.resources.IFutureReloadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

import static net.minecraft.loot.LootParameterSets.SELECTOR;

public class lootToStk {
    public ItemStack LootTStk(ServerWorld world){
        ResourceLocation location = new ResourceLocation("resources/data/gacha/loot_table/test_table.json");
        LootPredicateManager pred = new LootPredicateManager();
        LootTable table = new LootTableManager(pred).getLootTableFromLocation(location);
        LootContext ctx = new LootContext.Builder(world).withLuck(0).build(SELECTOR);
        List<ItemStack> stacks = table.generate(ctx);

        return stacks.get(1);
    }
}
