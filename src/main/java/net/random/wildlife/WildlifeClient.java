package net.random.wildlife;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.random.wildlife.entity.ModEntities;
import net.random.wildlife.entity.client.*;

public class WildlifeClient implements ClientModInitializer{
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SNAKE, SnakeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SNAKE, SnakeModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BUTTERFLY, ButterflyRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BUTTERFLY, ButterflyModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BEAR,BearRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BEAR, BearModel::getTexturedModelData);


    }
}
