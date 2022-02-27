package com.gachamod.gacha.data;

import com.gachamod.gacha.Gacha;
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

    public static final RegistryObject<SoundEvent> CHIME =
            registerSoundEvent("chime");


    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Gacha.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
