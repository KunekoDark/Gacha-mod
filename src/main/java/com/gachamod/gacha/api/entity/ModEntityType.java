package com.gachamod.gacha.api.entity;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.api.entity.projectile.CannonFireEntity;
import com.gachamod.gacha.entitiys.mobs.KasaJizo;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITIES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, Gacha.MOD_ID);

    public static final RegistryObject<EntityType<CannonFireEntity>> CANNON_PROJECTILE = ENTITIES.register("cannon_projectile",
            () -> EntityType.Builder.<CannonFireEntity>create(CannonFireEntity::new, EntityClassification.MISC).size(0.25F, 0.25F)
                    .updateInterval(20)
                    .trackingRange(4)
                    .build(new ResourceLocation(Gacha.MOD_ID, "cannon_projectile").toString()));

    public static final RegistryObject<EntityType<KasaJizo>> KASAJIZO = ENTITIES.register("kasa_jizo",
            () -> EntityType.Builder.create(KasaJizo::new, EntityClassification.MONSTER).size(1.0F,1.5F)
                    .build(new ResourceLocation(Gacha.MOD_ID, "kasa_jizo").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }


}
