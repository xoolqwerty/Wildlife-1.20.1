package net.random.wildlife.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.random.wildlife.Wildlife;
import net.random.wildlife.entity.custom.BearEntity;

public class BearRenderer extends MobEntityRenderer<BearEntity,BearModel<BearEntity>> {
    private static final Identifier TEXTURE = new Identifier(Wildlife.MOD_ID,"textures/entity/bear/bear.png");

    public BearRenderer(EntityRendererFactory.Context context) {
        super(context,new BearModel<>(context.getPart(ModModelLayers.BEAR)),1.4f);
    }

    @Override
    public Identifier getTexture(BearEntity entity) {
        return TEXTURE;
    }
    @Override
    public void render(BearEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
