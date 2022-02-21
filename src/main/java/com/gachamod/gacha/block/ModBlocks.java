package com.gachamod.gacha.block;

import com.gachamod.gacha.Gacha;

import com.gachamod.gacha.block.blocks.*;
import com.gachamod.gacha.item.ModItemGroup;
import com.gachamod.gacha.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, Gacha.MOD_ID);


    //Normal Blocks
    public static final RegistryObject<Block> JIZO_STEEL_BLOCK = registerBlock("jizo_steel_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f).sound(SoundType.METAL)));

    //Crafting Interfaces

    public static final RegistryObject<Block> ENGINEER_TABLE = registerBlock("engineer_table",
            () -> new EngineerTableBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.2f).sound(SoundType.WOOD), null));

    public static final RegistryObject<Block> UPGRADE_TABLE = wipblocks("upgrade_table",
            () -> new UpgradeTableBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.2f).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GEAR_TABLE = wipblocks("gear_table",
            () -> new GearTableBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.2f).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> JIZO_FURNACE = wipblocks("jizo_furnace",
            () -> new JizoFurnaceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.2f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> NORMAL_TICKET_CAPSULE = registerBlock("normal_ticket_capsule",
            () -> new NormalTicketCapsuleBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.2f).sound(SoundType.WOOD).tickRandomly()));

    public static final RegistryObject<Block> EVOLVE_TABLE = registerBlock("evolve_table",
            () -> new EngineerTableBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.2f).sound(SoundType.WOOD), null));

    //Boss Spawn Block

    public static final RegistryObject<Block> JIZO_SUMMON_BLOCK = registerSpawnBlock("jizo_summon_block",
            () -> new JizoSummonBlock(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.2f).sound(SoundType.SHROOMLIGHT)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.GACHA_GROUP)));
    }

    //spawn block and item register
    private static <T extends Block>RegistryObject<T> registerSpawnBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerSpawnBlockItem(name, toReturn);

        return toReturn;
    }
    private static <T extends Block> void registerSpawnBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().rarity(Rarity.EPIC)));
    }

    //WIP
    private static <T extends Block>RegistryObject<T> wipblocks(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerSpawnBlockItem(name, toReturn);

        return toReturn;
    }
    private static <T extends Block> void wipblocksItme(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }



    public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }
}
