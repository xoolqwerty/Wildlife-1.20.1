package net.random.wildlife.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.random.wildlife.entity.animation.ModAnimations;
import net.random.wildlife.entity.custom.ButterflyEntity;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ButterflyModel<T extends ButterflyEntity> extends SinglePartEntityModel<T> {
	private final ModelPart butterfly;
	private final ModelPart bone3;

	public ButterflyModel(ModelPart root) {
		this.butterfly = root.getChild("butterfly");
		this.bone3 = butterfly.getChild("bone3");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData butterfly = modelPartData.addChild("butterfly", ModelPartBuilder.create(), ModelTransform.of(-0.5F, 21.0F, 0.5F, 1.5708F, 0.0F, 0.0F));

		ModelPartData bone3 = butterfly.addChild("bone3", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone2 = butterfly.addChild("bone2", ModelPartBuilder.create(), ModelTransform.of(-0.5F, 1.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData cube_r1 = bone2.addChild("cube_r1", ModelPartBuilder.create().uv(1, 1).cuboid(0.0F, -1.0F, -2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 4).cuboid(0.0F, -1.0F, -2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(0.0F, -3.0F, -2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 2.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r2 = bone2.addChild("cube_r2", ModelPartBuilder.create().uv(8, 2).cuboid(0.0F, -1.0F, -1.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 5).cuboid(0.0F, -3.0F, -1.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, 1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r3 = bone2.addChild("cube_r3", ModelPartBuilder.create().uv(4, 4).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData bone4 = butterfly.addChild("bone4", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, 1.0F, 0.0F));

		ModelPartData cube_r4 = bone4.addChild("cube_r4", ModelPartBuilder.create().uv(1, 1).cuboid(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 8).cuboid(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 0).cuboid(0.0F, -3.0F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 2.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r5 = bone4.addChild("cube_r5", ModelPartBuilder.create().uv(0, 8).cuboid(0.0F, -1.0F, 0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 5).cuboid(0.0F, -3.0F, 0.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r6 = bone4.addChild("cube_r6", ModelPartBuilder.create().uv(4, 0).cuboid(0.0F, -2.0F, 1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}
	@Override
	public void setAngles(ButterflyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw,headPitch);


		this.animateMovement(ModAnimations.Butterfly_Flying, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState2, ModAnimations.Butterfly_Hover, ageInTicks, 1f);


	}


	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw,-30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.bone3.yaw = headYaw * 0.017453292F;
		this.bone3.pitch = headPitch * 0.017453292F;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		butterfly.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return butterfly;
	}
}