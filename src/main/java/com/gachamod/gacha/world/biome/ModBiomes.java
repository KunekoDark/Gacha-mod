package com.gachamod.gacha.world.biome;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.data.ModSoundEvents;
import com.gachamod.gacha.entity.ModEntityType;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, Gacha.MOD_ID);


    public  static  final RegistryObject<Biome> FUTURE_BIOME = BIOMES.register("future_biome",
            () -> makeFutureBiome(() -> ModCongiguredSurfaceBuilders.FUTURE_SURFACE, 0.125f, 0.02f));

    private  static  Biome makeFutureBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale){
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withPassiveMobs(mobspawninfo$builder);
        DefaultBiomeFeatures.withBatsAndHostiles(mobspawninfo$builder);
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(ModEntityType.KASAJIZO.get(), 100, 7, 10));


        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);




        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).category(Biome.Category.DESERT).depth(depth).scale(scale)
                .temperature(0.0F).downfall(0.9F).setEffects((new BiomeAmbience.Builder()).setWaterColor(43690).setWaterFogColor(43690)
                        .setFogColor(5592575)

                        .withFoliageColor(-43690)
                        .withGrassColor(43690)
                        .withSkyColor(5636095)
                        .setMoodSound(new MoodSoundAmbience(ModSoundEvents.CHIME.get(), 2000, 8, 2.0D))
                        .setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(ModSoundEvents.FUTURE_MUSIC.get()))
                        .build())
                .withMobSpawnSettings(mobspawninfo$builder.build()).withGenerationSettings(biomegenerationsettings$builder.build()).build();
    }


    public static void  register(IEventBus eventBus){
        BIOMES.register(eventBus);
    }
}
