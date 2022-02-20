package com.gachamod.gacha.entity.renderer;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.entity.model.GoonEntitiyModel;
import com.gachamod.gacha.entity.mobs.GoonEntitiy;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GoonEntityRenderer extends MobRenderer<GoonEntitiy, GoonEntitiyModel<GoonEntitiy>> {
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(Gacha.MOD_ID, "textures/entities/goon.png");

    public GoonEntityRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GoonEntitiyModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getEntityTexture(GoonEntitiy entity) {
        return TEXTURE;
    }
}
