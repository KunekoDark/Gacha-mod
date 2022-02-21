package com.gachamod.gacha;

import com.gachamod.gacha.entity.ModEntityType;
import com.gachamod.gacha.entity.renderer.GoonEntityRenderer;
import com.gachamod.gacha.entity.renderer.KasaJizoRenderer;
import com.gachamod.gacha.block.ModBlocks;
import com.gachamod.gacha.container.ModContainers;
import com.gachamod.gacha.data.recipes.ModRecipeTypes;
import com.gachamod.gacha.entity.ModTileEntities;
import com.gachamod.gacha.item.ModItems;
import com.gachamod.gacha.screen.*;
import com.gachamod.gacha.data.ModSoundEvents;
import com.gachamod.gacha.world.structure.ModStructures;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.util.function.Supplier;
import java.util.stream.Collectors;



// The value here should match an entry in the META-INF/mods.toml file
@Mod(Gacha.MOD_ID)
public class Gacha
{
    public static final String MOD_ID = "gacha";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Gacha() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModContainers.register(eventBus);
        ModTileEntities.register(eventBus);
        ModEntityType.register(eventBus);
        ModStructures.register(eventBus);
        ModRecipeTypes.register(eventBus);
        ModSoundEvents.register(eventBus);
        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        event.enqueueWork(() ->
                        ModStructures.setupStructures()
                );

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        registerEntityModles(event.getMinecraftSupplier());
        ScreenManager.registerFactory(ModContainers.ENGINEER_TABLE_CONTAINER.get(),
                EngineerTableScreen::new);
        ScreenManager.registerFactory(ModContainers.UPGRADE_TABLE_CONTAINER.get(),
                UpgradeTableScreen::new);
        ScreenManager.registerFactory(ModContainers.GEAR_TABLE_CONTAINER.get(),
                GearTableScreen::new);
        ScreenManager.registerFactory(ModContainers.JIZO_FURNACE_CONTAINER.get(),
                JizoFurnaceScreen::new);
        ScreenManager.registerFactory(ModContainers.NORMAL_TICKET_CAPSULE_CONTAINER.get(),
                NormalTicketCapsuleScreen::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.KASAJIZO.get(),
                KasaJizoRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.GOONENTITY.get(),
                GoonEntityRenderer::new);

    }
    @OnlyIn(Dist.CLIENT)
    private void registerEntityModles(Supplier<Minecraft> minecraft){
        ItemRenderer renderer = minecraft.get().getItemRenderer();
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.CANNON_PROJECTILE.get(), (rendererManager)-> new SpriteRenderer<>(rendererManager,renderer));

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                () ->SlotTypePreset.HEAD.getMessageBuilder().build());

        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                () ->SlotTypePreset.NECKLACE.getMessageBuilder().build());


    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("gacha to install rng bs");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
