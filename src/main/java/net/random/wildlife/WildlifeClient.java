package net.random.wildlife;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.random.wildlife.entity.ModEntities;
import net.random.wildlife.entity.client.ModModelLayers;
import net.random.wildlife.entity.client.SnakeModel;
import net.random.wildlife.entity.client.SnakeRenderer;

public class WildlifeClient implements ClientModInitializer{
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SNAKE, SnakeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SNAKE, SnakeModel::getTexturedModelData);


    }
}
