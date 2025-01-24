package net.random.wildlife.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.random.wildlife.entity.animation.ModAnimations;
import net.random.wildlife.entity.custom.SnakeEntity;

import javax.swing.text.html.parser.Entity;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SnakeModel<T extends SnakeEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Snake;
	private final ModelPart head;

	public SnakeModel(ModelPart root) {
		this.Snake = root.getChild("Snake");
		this.head = Snake.getChild("head");

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Snake = modelPartData.addChild("Snake", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData bone2 = Snake.addChild("bone2", ModelPartBuilder.create().uv(10, 0).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -8.0F));

		ModelPartData bone3 = Snake.addChild("bone3", ModelPartBuilder.create().uv(0, 8).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -6.0F));

		ModelPartData bone4 = Snake.addChild("bone4", ModelPartBuilder.create().uv(8, 8).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -4.0F));

		ModelPartData bone5 = Snake.addChild("bone5", ModelPartBuilder.create().uv(10, 3).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -2.0F));

		ModelPartData bone6 = Snake.addChild("bone6", ModelPartBuilder.create().uv(0, 11).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone7 = Snake.addChild("bone7", ModelPartBuilder.create().uv(8, 11).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 2.0F));

		ModelPartData bone8 = Snake.addChild("bone8", ModelPartBuilder.create().uv(0, 14).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 4.0F));

		ModelPartData bone9 = Snake.addChild("bone9", ModelPartBuilder.create().uv(8, 14).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 6.0F));

		ModelPartData bone10 = Snake.addChild("bone10", ModelPartBuilder.create().uv(16, 6).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, 7.0F));

		ModelPartData head = Snake.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -10.0F));

		ModelPartData bone11 = head.addChild("bone11", ModelPartBuilder.create().uv(0, 4).cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone = head.addChild("bone", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}


	@Override
	public void setAngles(SnakeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw,headPitch);


		this.animateMovement(ModAnimations.slithering, limbSwing, limbSwingAmount, 3f, 10f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.idle, ageInTicks, 1f);

	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw,-30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Snake.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return Snake;
	}
}