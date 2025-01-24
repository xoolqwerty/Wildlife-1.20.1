package net.random.wildlife.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.random.wildlife.Wildlife;
import net.random.wildlife.entity.custom.SnakeEntity;
import net.random.wildlife.entity.custom.SnakeVariant;


import java.util.Map;

public class SnakeRenderer extends MobEntityRenderer<SnakeEntity, SnakeModel<SnakeEntity>> {

    private static final Map<SnakeVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SnakeVariant.class), map -> {
                map.put(SnakeVariant.DEFAULT,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/snake.png"));
                map.put(SnakeVariant.WARM,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/desert.png"));
                map.put(SnakeVariant.JUNGLE,
                        Identifier.of(Wildlife.MOD_ID,"textures/entity/coral.png"));
            });

    public SnakeRenderer(EntityRendererFactory.Context context) {
        super(context, new SnakeModel<>(context.getPart(ModModelLayers.SNAKE)), 0.3f);
    }

    @Override
    public Identifier getTexture(SnakeEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
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
