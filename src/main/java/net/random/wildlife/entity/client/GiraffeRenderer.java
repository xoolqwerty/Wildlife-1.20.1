package net.random.wildlife.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.random.wildlife.Wildlife;
import net.random.wildlife.entity.custom.GiraffeEntity;

public class GiraffeRenderer extends MobEntityRenderer<GiraffeEntity,GiraffeModel<GiraffeEntity>> {
    private static final Identifier TEXTURE = new Identifier(Wildlife.MOD_ID,"textures/entity/giraffe/giraffe.png");

    public GiraffeRenderer(EntityRendererFactory.Context context) {
        super(context,new GiraffeModel<>(context.getPart(ModModelLayers.GIRAFFE)),2f);
    }

    @Override
    public Identifier getTexture(GiraffeEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(GiraffeEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
