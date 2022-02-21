package com.gachamod.gacha.util;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.item.ModItemGroup;
import com.gachamod.gacha.item.curio.JizosHatItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Gacha.MOD_ID);


    //Content Author is PONOS GAMES - http://www.ponos.co.jp
    public static final RegistryObject<SoundEvent> BATTLE_CATS_THEME_3 =
            registerSoundEvent("jizo_batle");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Gacha.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
