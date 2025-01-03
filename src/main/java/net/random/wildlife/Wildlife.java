package net.random.wildlife;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.random.wildlife.entity.ModEntities;
import net.random.wildlife.entity.custom.SnakeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wildlife implements ModInitializer {
	public static final String MOD_ID = "wildlife";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(ModEntities.SNAKE, SnakeEntity.createSnakeAttributes());
	}
}