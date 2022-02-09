package com.gachamod.gacha.api.events;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.api.entity.ModEntityType;
import com.gachamod.gacha.api.events.lootinject.TicketStructureAdditionModifier;
import com.gachamod.gacha.entitiys.mobs.KasaJizo;
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

    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final
                                                       RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(
                new TicketStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Gacha.MOD_ID,"ticket_in_simple_dungeon"))
        );
    }
}