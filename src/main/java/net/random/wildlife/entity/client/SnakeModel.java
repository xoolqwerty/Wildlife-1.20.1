package net.random.wildlife.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.random.wildlife.entity.custom.SnakeEntity;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SnakeModel<T extends SnakeEntity> extends SinglePartEntityModel<T> {
	private final ModelPart snake;
	private final ModelPart head;
	public SnakeModel(ModelPart root) {
		this.snake = root.getChild("snake");
		this.head = snake.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData snake = modelPartData.addChild("snake", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, -5.0F));

		ModelPartData head = snake.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 9.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, -11.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData part5 = snake.addChild("part5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r2 = part5.addChild("cube_r2", ModelPartBuilder.create().uv(0, 12).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData part4 = snake.addChild("part4", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0F, 4.0F));

		ModelPartData cube_r3 = part4.addChild("cube_r3", ModelPartBuilder.create().uv(8, 9).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData part2 = snake.addChild("part2", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, 6.0F));

		ModelPartData cube_r4 = part2.addChild("cube_r4", ModelPartBuilder.create().uv(8, 6).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData part1 = snake.addChild("part1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 8.0F));

		ModelPartData cube_r5 = part1.addChild("cube_r5", ModelPartBuilder.create().uv(0, 6).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -0.5F, -4.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData part3 = snake.addChild("part3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 5.0F));

		ModelPartData cube_r6 = part3.addChild("cube_r6", ModelPartBuilder.create().uv(0, 9).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData tongue = snake.addChild("tongue", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, 11.0F));

		ModelPartData cube_r7 = tongue.addChild("cube_r7", ModelPartBuilder.create().uv(8, 12).cuboid(0.0F, 0.0F, 0.5F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, -14.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData part6 = snake.addChild("part6", ModelPartBuilder.create().uv(0, 15).cuboid(-2.0F, -1.0F, 6.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 5.0F));
		return TexturedModelData.of(modelData, 20, 20);
	}
	@Override
	public void setAngles(SnakeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		snake.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return snake;
	}



}