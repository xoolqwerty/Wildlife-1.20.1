package net.random.wildlife;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.random.wildlife.block.ModBlocks;
import net.random.wildlife.entity.ModEntities;
import net.random.wildlife.entity.custom.ButterflyEntity;
import net.random.wildlife.entity.custom.SnakeEntity;
import net.random.wildlife.item.ModItemGroups;
import net.random.wildlife.item.ModItems;
import net.random.wildlife.util.ModLootTableModifiers;
import net.random.wildlife.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wildlife implements ModInitializer {
	public static final String MOD_ID = "wildlife";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(ModEntities.SNAKE, SnakeEntity.createSnakeAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BUTTERFLY, ButterflyEntity.createButterflyAttributes());
		ModWorldGeneration.generateModWorldGen();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModLootTableModifiers.modifyLootTables();
		ModBlocks.registerModBlocks();
	}
}