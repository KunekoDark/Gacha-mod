package com.gachamod.gacha.api.entity.model;


import com.gachamod.gacha.entitiys.mobs.KasaJizo;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class KasaJizoModel<T extends KasaJizo> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer ears;
	private final ModelRenderer legs;
	private final ModelRenderer arms;
	private final ModelRenderer arm1;
	private final ModelRenderer arm2;
	private final ModelRenderer backpack;
	private final ModelRenderer handle1;
	private final ModelRenderer handle2;
	private final ModelRenderer thegoon;
	private final ModelRenderer coat;
	private final ModelRenderer head2;
	private final ModelRenderer body2;
	private final ModelRenderer arms2;
	private final ModelRenderer gun;
	private final ModelRenderer hat;

	public KasaJizoModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, -14.0F, -5.0F, 9.0F, 11.0F, 9.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(29, 23).addBox(-3.0F, -20.0F, -4.0F, 7.0F, 6.0F, 7.0F, 0.0F, false);

		ears = new ModelRenderer(this);
		ears.setRotationPoint(0.0F, 23.0F, -1.0F);
		ears.setTextureOffset(20, 34).addBox(-3.0F, -21.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		ears.setTextureOffset(32, 21).addBox(1.0F, -21.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		ears.setTextureOffset(52, 51).addBox(-2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ears.setTextureOffset(48, 2).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 23.0F, 0.0F);
		legs.setTextureOffset(36, 47).addBox(-3.0F, -3.0F, -2.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		legs.setTextureOffset(24, 46).addBox(1.0F, -3.0F, -2.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, 23.0F, 0.0F);
		

		arm1 = new ModelRenderer(this);
		arm1.setRotationPoint(0.0F, 0.0F, 0.0F);
		arms.addChild(arm1);
		arm1.setTextureOffset(50, 25).addBox(-6.0F, -10.0F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		arm1.setTextureOffset(48, 51).addBox(-7.0F, -9.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		arm1.setTextureOffset(50, 21).addBox(-6.0F, -7.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		arm1.setTextureOffset(48, 5).addBox(-6.0F, -8.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		arm2 = new ModelRenderer(this);
		arm2.setRotationPoint(11.0F, 0.0F, 0.0F);
		arms.addChild(arm2);
		arm2.setTextureOffset(20, 30).addBox(-6.0F, -10.0F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		arm2.setTextureOffset(0, 30).addBox(-4.0F, -9.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		arm2.setTextureOffset(48, 47).addBox(-6.0F, -7.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		arm2.setTextureOffset(46, 21).addBox(-6.0F, -8.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		backpack = new ModelRenderer(this);
		backpack.setRotationPoint(11.0F, 23.0F, 0.0F);
		backpack.setTextureOffset(0, 30).addBox(-14.0F, -14.0F, 4.0F, 7.0F, 7.0F, 6.0F, 0.0F, false);

		handle1 = new ModelRenderer(this);
		handle1.setRotationPoint(0.0F, 0.0F, 0.0F);
		backpack.addChild(handle1);
		handle1.setTextureOffset(0, 54).addBox(-7.0F, -10.0F, 4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		handle1.setTextureOffset(12, 43).addBox(-6.0F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		handle1.setTextureOffset(30, 53).addBox(-6.0F, -9.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		handle1.setTextureOffset(42, 8).addBox(-6.0F, -8.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		handle1.setTextureOffset(27, 25).addBox(-6.0F, -11.0F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		handle1.setTextureOffset(27, 21).addBox(-6.0F, -8.0F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		handle1.setTextureOffset(26, 38).addBox(-6.0F, -7.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		handle1.setTextureOffset(24, 53).addBox(-6.0F, -6.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		handle2 = new ModelRenderer(this);
		handle2.setRotationPoint(-10.0F, 0.0F, 0.0F);
		backpack.addChild(handle2);
		handle2.setTextureOffset(50, 8).addBox(-6.0F, -10.0F, 4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		handle2.setTextureOffset(26, 36).addBox(-6.0F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		handle2.setTextureOffset(49, 37).addBox(-6.0F, -9.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		handle2.setTextureOffset(32, 25).addBox(-6.0F, -8.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		handle2.setTextureOffset(0, 24).addBox(-6.0F, -11.0F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		handle2.setTextureOffset(0, 20).addBox(-6.0F, -8.0F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		handle2.setTextureOffset(5, 24).addBox(-6.0F, -7.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		handle2.setTextureOffset(45, 47).addBox(-6.0F, -6.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		thegoon = new ModelRenderer(this);
		thegoon.setRotationPoint(0.0F, 23.0F, 0.0F);
		

		coat = new ModelRenderer(this);
		coat.setRotationPoint(0.0F, 1.0F, 0.0F);
		thegoon.addChild(coat);
		coat.setTextureOffset(0, 43).addBox(-2.0F, -25.0F, 7.0F, 5.0F, 9.0F, 2.0F, 0.0F, false);
		coat.setTextureOffset(4, 0).addBox(-2.0F, -24.0F, 6.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		coat.setTextureOffset(0, 0).addBox(2.0F, -25.0F, 6.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(0.0F, 0.0F, 0.0F);
		thegoon.addChild(head2);
		head2.setTextureOffset(26, 37).addBox(-2.0F, -30.0F, 5.0F, 5.0F, 5.0F, 4.0F, 0.0F, false);

		body2 = new ModelRenderer(this);
		body2.setRotationPoint(0.0F, 0.0F, 0.0F);
		thegoon.addChild(body2);
		body2.setTextureOffset(14, 43).addBox(-1.0F, -25.0F, 6.0F, 3.0F, 11.0F, 2.0F, 0.0F, false);

		arms2 = new ModelRenderer(this);
		arms2.setRotationPoint(0.0F, 1.0F, 0.0F);
		thegoon.addChild(arms2);
		arms2.setTextureOffset(33, 46).addBox(-2.0F, -25.0F, 5.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		arms2.setTextureOffset(44, 8).addBox(-2.0F, -24.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		gun = new ModelRenderer(this);
		gun.setRotationPoint(0.0F, 1.0F, 0.0F);
		thegoon.addChild(gun);
		gun.setTextureOffset(48, 0).addBox(-2.0F, -26.0F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		gun.setTextureOffset(27, 0).addBox(-2.0F, -26.0F, 2.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		gun.setTextureOffset(40, 21).addBox(-2.0F, -25.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		gun.setTextureOffset(27, 5).addBox(-2.0F, -27.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		gun.setTextureOffset(0, 34).addBox(-2.0F, -24.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(11.0F, 21.0F, 0.0F);
		hat.setTextureOffset(39, 41).addBox(-13.0F, -19.0F, -3.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		hat.setTextureOffset(40, 37).addBox(-12.0F, -20.0F, -2.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		hat.setTextureOffset(5, 20).addBox(-11.0F, -21.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(27, 0).addBox(-14.0F, -18.0F, -4.0F, 7.0F, 1.0F, 7.0F, 0.0F, false);
		hat.setTextureOffset(0, 20).addBox(-15.0F, -17.0F, -5.0F, 9.0F, 1.0F, 9.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}


	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		ears.render(matrixStack, buffer, packedLight, packedOverlay);
		legs.render(matrixStack, buffer, packedLight, packedOverlay);
		arms.render(matrixStack, buffer, packedLight, packedOverlay);
		backpack.render(matrixStack, buffer, packedLight, packedOverlay);
		thegoon.render(matrixStack, buffer, packedLight, packedOverlay);
		hat.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}