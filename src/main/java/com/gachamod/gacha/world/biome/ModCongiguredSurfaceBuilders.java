package com.gachamod.gacha.world.biome;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModCongiguredSurfaceBuilders {

    public static  ConfiguredSurfaceBuilder<?> FUTURE_SURFACE = register("future_surface",
            SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(
                    ModBlocks.FUTURE_GRASS.get().getDefaultState(),
                    ModBlocks.FUTURE_STONE.get().getDefaultState(),
                    ModBlocks.DENSE_FUTURE_STONE.get().getDefaultState()
            )));


    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name,
                                                                                           ConfiguredSurfaceBuilder<SC>csb){
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(Gacha.MOD_ID, name), csb);

    }
}
