package com.gachamod.gacha.client.renderer.entity;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.api.entity.projectile.CannonFireEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.DragonFireballRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class CannonProjectileRender extends EntityRenderer<CannonFireEntity> {
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(Gacha.MOD_ID, "textures/entities/projectiles/cannon_projectile.png");
    public CannonProjectileRender(EntityRendererManager rendererManagerIn){
        super(rendererManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(CannonFireEntity entity) {
        return TEXTURE;
    }
}
