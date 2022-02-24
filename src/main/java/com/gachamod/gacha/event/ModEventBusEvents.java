package com.gachamod.gacha.event;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.entity.ModEntityType;
import com.gachamod.gacha.event.events.lootinject.RareTicketStructureAdditionModifier;
import com.gachamod.gacha.event.events.lootinject.EvolveOrbAdditionModifier;
import com.gachamod.gacha.event.events.lootinject.TicketStructureAdditionModifier;
import com.gachamod.gacha.entity.mobs.GoonEntitiy;
import com.gachamod.gacha.entity.mobs.KasaJizo;
import com.gachamod.gacha.item.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Gacha.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityType.KASAJIZO.get(), KasaJizo.setCustomeAtrebutes().create());
        event.put(ModEntityType.GOONENTITY.get(), GoonEntitiy.setCustomeAtrebutes().create());

    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        //normal loot inject
        event.getRegistry().registerAll(
                new TicketStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"ticket_in_simple_dungeon"))
        );
        event.getRegistry().registerAll(
                new TicketStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"ticket_in_abandoned_mineshaft"))
        );
        event.getRegistry().registerAll(
                new TicketStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"ticket_in_desert_pyramid"))
        );
        event.getRegistry().registerAll(
                new TicketStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"ticket_in_jungle_temple"))
        );
        event.getRegistry().registerAll(
                new TicketStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"ticket_in_ruined_portal"))
        );

        //rare ticket injects
        event.getRegistry().registerAll(
                new RareTicketStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"rare_ticket_in_nether_bridge"))
        );
        event.getRegistry().registerAll(
                new RareTicketStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"rare_ticket_in_bastion_bridge"))
        );
        event.getRegistry().registerAll(
                new RareTicketStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"rare_ticket_in_bastion_hoglin_stable"))
        );
        event.getRegistry().registerAll(
                new RareTicketStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"rare_ticket_in_bastion_other"))
        );
        event.getRegistry().registerAll(
                new RareTicketStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"rare_ticket_in_bastion_treasure"))
        );

        event.getRegistry().registerAll(
                new EvolveOrbAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"red_evolve_orb_zombie"))
        );
    }
}
