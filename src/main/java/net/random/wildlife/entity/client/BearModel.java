package net.random.wildlife.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.random.wildlife.entity.animation.ModAnimations;
import net.random.wildlife.entity.custom.BearEntity;

// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BearModel<T extends BearEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bear;
	private final ModelPart head;

	public BearModel(ModelPart root) {
		this.bear = root.getChild("bear");
		this.head = bear.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bear = modelPartData.addChild("bear", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, 22.0F, 13.0F));

		ModelPartData body = bear.addChild("body", ModelPartBuilder.create().uv(0, 38).cuboid(-6.0F, -21.0F, -31.0F, 21.0F, 15.0F, 15.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-7.0F, -22.0F, -16.0F, 23.0F, 17.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 68).cuboid(-11.0F, -10.0F, -4.0F, 13.0F, 11.0F, 10.0F, new Dilation(0.0F))
		.uv(72, 81).cuboid(-8.0F, -6.0F, -9.0F, 7.0F, 5.0F, 5.0F, new Dilation(0.0F))
		.uv(46, 83).cuboid(-11.0F, -13.0F, 2.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(56, 83).cuboid(-1.0F, -13.0F, 2.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(9.0F, -9.0F, -37.0F));

		ModelPartData leg4 = bear.addChild("leg4", ModelPartBuilder.create().uv(72, 53).cuboid(-3.0F, -1.0F, -3.0F, 7.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -5.0F, -1.0F));

		ModelPartData leg3 = bear.addChild("leg3", ModelPartBuilder.create().uv(72, 67).cuboid(-3.0F, -1.0F, -3.0F, 7.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(11.0F, -5.0F, -1.0F));

		ModelPartData leg2 = bear.addChild("leg2", ModelPartBuilder.create().uv(72, 38).cuboid(-3.0F, -1.0F, -3.0F, 7.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -6.0F, -25.0F));

		ModelPartData leg1 = bear.addChild("leg1", ModelPartBuilder.create().uv(46, 68).cuboid(-4.0F, -1.0F, -3.0F, 7.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(11.0F, -6.0F, -25.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(BearEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw,headPitch);

		this.animateMovement(ModAnimations.Bear_Walking,limbSwing,limbSwingAmount,2f,2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.Bear_Idle ,ageInTicks,1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bear.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return bear;
	}
}