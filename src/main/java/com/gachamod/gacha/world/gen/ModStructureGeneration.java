package com.gachamod.gacha.world.gen;

import com.gachamod.gacha.world.structure.ModStructures;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModStructureGeneration {
    public static void generateStructures(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(types.contains(BiomeDictionary.Type.OVERWORLD)) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.JIZO_CASTLE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(types.contains(BiomeDictionary.Type.OVERWORLD)) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CAT_PALACE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(!types.contains(BiomeDictionary.Type.OVERWORLD)&&!types.contains(BiomeDictionary.Type.NETHER)&&!types.contains(BiomeDictionary.Type.END)) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.BROKEN_LAB.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
    }
}