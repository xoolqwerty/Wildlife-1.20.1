package net.random.wildlife.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.random.wildlife.Wildlife;
import net.random.wildlife.entity.custom.ButterflyEntity;
import net.random.wildlife.entity.custom.ButterflyVariant;
import net.random.wildlife.entity.custom.SnakeVariant;

import java.util.Map;

public class ButterflyRenderer extends MobEntityRenderer<ButterflyEntity, ButterflyModel<ButterflyEntity>> {

    private static final Map<ButterflyVariant, Identifier> LOCATION_BY_VARIANT_2 =
            Util.make(Maps.newEnumMap(ButterflyVariant.class), map ->{
                map.put(ButterflyVariant.HEART,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/butterfly/heart.png"));
                map.put(ButterflyVariant.MONARCH,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/butterfly/monarch.png"));
                map.put(ButterflyVariant.OWL,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/butterfly/owl.png"));
                map.put(ButterflyVariant.BLUEISH,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/butterfly/blueish.png"));
                map.put(ButterflyVariant.RED,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/butterfly/red.png"));
                map.put(ButterflyVariant.YELLOW,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/butterfly/yellow.png"));
                map.put(ButterflyVariant.CORAL,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/butterfly/coral.png"));
                map.put(ButterflyVariant.GRAY,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/butterfly/grayscale.png"));
                map.put(ButterflyVariant.RAINBOW,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/butterfly/rainbow.png"));
                map.put(ButterflyVariant.BLACK,
                        Identifier.of(Wildlife.MOD_ID, "textures/entity/butterfly/black.png"));
            });



    public ButterflyRenderer(EntityRendererFactory.Context context) {
        super(context, new ButterflyModel<>(context.getPart(ModModelLayers.BUTTERFLY)), 0.1f);
    }


    @Override
    public Identifier getTexture(ButterflyEntity entity) {
        return LOCATION_BY_VARIANT_2.get(entity.getVariant());
    }

    @Override
    public void render(ButterflyEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
