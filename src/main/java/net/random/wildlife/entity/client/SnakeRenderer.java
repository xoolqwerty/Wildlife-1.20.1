package net.random.wildlife.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.random.wildlife.Wildlife;
import net.random.wildlife.entity.custom.SnakeEntity;

public class SnakeRenderer extends MobEntityRenderer<SnakeEntity, SnakeModel<SnakeEntity>> {
    private static final Identifier TEXTURE = new Identifier(Wildlife.MOD_ID, "textures/entity/snake.png");


    public SnakeRenderer(EntityRendererFactory.Context context) {
        super(context, new SnakeModel<>(context.getPart(ModModelLayers.SNAKE)), 0.3f);
    }

    @Override
    public Identifier getTexture(SnakeEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(SnakeEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
