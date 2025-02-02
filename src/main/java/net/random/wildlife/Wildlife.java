package net.random.wildlife;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.random.wildlife.block.ModBlocks;
import net.random.wildlife.effect.ModEffects;
import net.random.wildlife.entity.ModEntities;
import net.random.wildlife.entity.custom.BearEntity;
import net.random.wildlife.entity.custom.ButterflyEntity;
import net.random.wildlife.entity.custom.GiraffeEntity;
import net.random.wildlife.entity.custom.SnakeEntity;
import net.random.wildlife.item.ModItemGroups;
import net.random.wildlife.item.ModItems;
import net.random.wildlife.potion.ModPotions;
import net.random.wildlife.sound.ModSounds;
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
		FabricDefaultAttributeRegistry.register(ModEntities.BEAR, BearEntity.createBearAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GIRAFFE, GiraffeEntity.createGiraffeAttributes());
		ModWorldGeneration.generateModWorldGen();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModLootTableModifiers.modifyLootTables();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();

		BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD,ModItems.GIRAFFE_TONGUE,ModPotions.TONGUE_POTION);
	}
}