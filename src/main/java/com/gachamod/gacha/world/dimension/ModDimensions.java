package com.gachamod.gacha.world.dimension;

import com.gachamod.gacha.Gacha;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions {
    public  static RegistryKey<World> FutureDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(Gacha.MOD_ID,"futuredim"));
}
