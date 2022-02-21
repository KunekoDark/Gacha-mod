package com.gachamod.gacha.entity;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.entity.tileentity.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Gacha.MOD_ID);

    public static RegistryObject<TileEntityType<EngineerTableTile>> ENGINEER_TABLE_TILE =
            TILE_ENTITIES.register("engineer_table_tile", () -> TileEntityType.Builder.create(
                    EngineerTableTile::new, ModBlocks.ENGINEER_TABLE.get()).build(null));

    public static RegistryObject<TileEntityType<UpgradeTableTile>> UPGRADE_TABLE_TILE =
            TILE_ENTITIES.register("upgrade_table_tile", () -> TileEntityType.Builder.create(
                    UpgradeTableTile::new, ModBlocks.UPGRADE_TABLE.get()).build(null));

    public static RegistryObject<TileEntityType<GearTableTile>> GEAR_TABLE_TILE =
            TILE_ENTITIES.register("gear_table_tile", () -> TileEntityType.Builder.create(
                    GearTableTile::new, ModBlocks.GEAR_TABLE.get()).build(null));

    public static RegistryObject<TileEntityType<JizoFurnaceTile>> JIZO_FURNACE_TILE =
            TILE_ENTITIES.register("jizo_furnace_tile", () -> TileEntityType.Builder.create(
                    JizoFurnaceTile::new, ModBlocks.JIZO_FURNACE.get()).build(null));

    public static RegistryObject<TileEntityType<NormalTicketCapsuleTile>> NORMAL_TICKET_CAPSULE_TILE =
            TILE_ENTITIES.register("normal_ticket_capsule_tile", () -> TileEntityType.Builder.create(
                    NormalTicketCapsuleTile::new, ModBlocks.JIZO_FURNACE.get()).build(null));

    public static RegistryObject<TileEntityType<EvolveTableTile>> EVOLVE_TABLE_TILE =
            TILE_ENTITIES.register("evolve_table_tile", () -> TileEntityType.Builder.create(
                    EvolveTableTile::new, ModBlocks.EVOLVE_TABLE.get()).build(null));





    public static void register(IEventBus eventbus){
        TILE_ENTITIES.register(eventbus);
    }
}
