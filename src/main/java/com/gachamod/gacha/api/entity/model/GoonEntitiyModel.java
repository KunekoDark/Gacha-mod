package com.gachamod.gacha.api.entity.model;


import com.gachamod.gacha.entitiys.mobs.GoonEntitiy;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GoonEntitiyModel<T extends GoonEntitiy> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer rightleg;
    private final ModelRenderer coat;
    private final ModelRenderer leftleg;

    public GoonEntitiyModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 21).addBox(-3.0F, -15.0F, -2.0F, 6.0F, 12.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 6.0F, 0.0F);
        head.setTextureOffset(0, 9).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 6.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(8, 39).addBox(-1.0F, -9.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 9).addBox(1.0F, -10.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(22, 9).addBox(-2.0F, -10.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(0, 5).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(28, 5).addBox(-2.0F, -7.0F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(28, 0).addBox(-3.0F, -6.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(20, 21).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 1.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-5.0F, -4.0F, -4.0F, 10.0F, 1.0F, 8.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(2.0F, 22.5F, 0.0F);
        rightleg.setTextureOffset(27, 28).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(-2.0F, 22.5F, 0.0F);
        leftleg.setTextureOffset(0, 0).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        coat = new ModelRenderer(this);
        coat.setRotationPoint(0.0F, 16.4375F, -0.5F);
        coat.setTextureOffset(28, 9).addBox(-4.0F, -6.4375F, 2.5F, 8.0F, 10.0F, 1.0F, 0.0F, false);
        coat.setTextureOffset(8, 37).addBox(-2.0F, -7.4375F, 2.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        coat.setTextureOffset(32, 28).addBox(-4.0F, -6.4375F, -2.5F, 1.0F, 11.0F, 5.0F, 0.0F, false);
        coat.setTextureOffset(20, 28).addBox(3.0F, -6.4375F, -2.5F, 1.0F, 11.0F, 5.0F, 0.0F, false);
        coat.setTextureOffset(4, 37).addBox(2.0F, -5.4375F, -2.5F, 1.0F, 11.0F, 1.0F, 0.0F, false);
        coat.setTextureOffset(0, 37).addBox(-3.0F, -5.4375F, -2.5F, 1.0F, 11.0F, 1.0F, 0.0F, false);
        coat.setTextureOffset(37, 5).addBox(-4.0F, 4.5625F, -2.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        coat.setTextureOffset(16, 21).addBox(3.0F, 4.5625F, -2.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
        coat.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}