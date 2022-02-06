package com.gachamod.gacha.api.entity.renderer;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.api.entity.model.KasaJizoModel;
import com.gachamod.gacha.entitiys.mobs.KasaJizo;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class KasaJizoRenderer extends MobRenderer<KasaJizo, KasaJizoModel<KasaJizo>> {
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(Gacha.MOD_ID, "textures/entities/kasa_jizo.png");

    public KasaJizoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new KasaJizoModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getEntityTexture(KasaJizo entity) {
        return TEXTURE;
    }
}
