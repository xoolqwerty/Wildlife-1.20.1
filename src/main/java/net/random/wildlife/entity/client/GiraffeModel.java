package net.random.wildlife.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.random.wildlife.entity.animation.ModAnimations;
import net.random.wildlife.entity.custom.GiraffeEntity;

// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class GiraffeModel<T extends GiraffeEntity> extends SinglePartEntityModel<T> {
	private final ModelPart giraffe;
	private final ModelPart head;

	public GiraffeModel(ModelPart root) {
		this.giraffe = root.getChild("giraffe");
		this.head = giraffe.getChild("body").getChild("neck").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData giraffe = modelPartData.addChild("giraffe", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 6.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData leg1 = giraffe.addChild("leg1", ModelPartBuilder.create().uv(52, 56).cuboid(-4.0F, 0.0F, -4.0F, 8.0F, 26.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.0F, -26.0F, -9.0F));

		ModelPartData leg2 = giraffe.addChild("leg2", ModelPartBuilder.create().uv(0, 80).cuboid(-4.0F, 0.0F, -4.0F, 8.0F, 26.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.0F, -26.0F, 19.0F));

		ModelPartData leg3 = giraffe.addChild("leg3", ModelPartBuilder.create().uv(84, 56).cuboid(-4.0F, 0.0F, -4.0F, 8.0F, 26.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(9.0F, -26.0F, 19.0F));

		ModelPartData leg4 = giraffe.addChild("leg4", ModelPartBuilder.create().uv(32, 90).cuboid(-4.0F, 0.0F, -4.0F, 8.0F, 26.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(9.0F, -26.0F, -9.0F));

		ModelPartData body = giraffe.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-25.0F, -20.0F, -35.0F, 26.0F, 20.0F, 36.0F, new Dilation(0.0F)), ModelTransform.pivot(12.0F, -26.0F, 22.0F));

		ModelPartData neck = body.addChild("neck", ModelPartBuilder.create().uv(64, 90).cuboid(-7.0F, -12.0F, -4.0F, 15.0F, 12.0F, 7.0F, new Dilation(0.0F))
		.uv(108, 90).cuboid(-5.0F, -24.0F, -4.0F, 11.0F, 12.0F, 7.0F, new Dilation(0.0F))
		.uv(100, 109).cuboid(-3.0F, -36.0F, -4.0F, 7.0F, 12.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 114).cuboid(-2.0F, -48.0F, -4.0F, 5.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -20.0F, -2.0F, 0.0F, 0.0436F, 0.0F));

		ModelPartData head = neck.addChild("head", ModelPartBuilder.create().uv(0, 56).cuboid(-3.0F, -6.0F, -3.0F, 7.0F, 5.0F, 19.0F, new Dilation(0.0F))
		.uv(64, 109).cuboid(-3.0F, -11.0F, -3.0F, 7.0F, 5.0F, 11.0F, new Dilation(0.0F))
		.uv(32, 80).cuboid(-3.0F, -17.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F))
		.uv(40, 80).cuboid(2.0F, -17.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -47.0F, -1.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(116, 76).cuboid(4.0F, -1.0F, 0.0F, 5.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.0F, -1.0F, 0.0F, 0.0F, -0.4363F));

		ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(116, 73).cuboid(-9.0F, 1.0F, -2.0F, 5.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -12.0F, 1.0F, 0.0F, 0.0F, 0.3927F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(-12.0F, -19.0F, -35.0F));

		ModelPartData cube_r3 = tail.addChild("cube_r3", ModelPartBuilder.create().uv(116, 56).cuboid(-3.0F, 0.0F, 0.0F, 6.0F, 17.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, -0.5236F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}
	@Override
	public void setAngles(GiraffeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw,headPitch);

		this.animateMovement(ModAnimations.Giraffe_Walking,limbSwing,limbSwingAmount,2f,2.5f);
		this.updateAnimation(entity.idleAnimationState,ModAnimations.Giraffe_Idle,ageInTicks,1f);

	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		giraffe.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return giraffe;
	}
}