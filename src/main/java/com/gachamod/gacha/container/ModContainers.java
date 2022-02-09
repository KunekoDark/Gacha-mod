package com.gachamod.gacha.container;

import com.gachamod.gacha.Gacha;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {
    public static DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, Gacha.MOD_ID);

    public static final RegistryObject<ContainerType<EngineerTableContainer>> ENGINEER_TABLE_CONTAINER
            = CONTAINERS.register("engineer_table_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new EngineerTableContainer(windowId, world, pos, inv, inv.player);
            })));

    public static final RegistryObject<ContainerType<UpgradeTableContainer>> UPGRADE_TABLE_CONTAINER
            = CONTAINERS.register("upgrade_table_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new UpgradeTableContainer(windowId, world, pos, inv, inv.player);
            })));

    public static final RegistryObject<ContainerType<GearTableContainer>> GEAR_TABLE_CONTAINER
            = CONTAINERS.register("gear_table_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new GearTableContainer(windowId, world, pos, inv, inv.player);
            })));





    public static void register(IEventBus eventBus){
        CONTAINERS.register(eventBus);
    }
}
