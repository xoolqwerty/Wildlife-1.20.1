package net.random.wildlife.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.random.wildlife.entity.ModEntities;
import net.random.wildlife.entity.custom.SnakeEntity;

public class ModEntityGeneration {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DESERT,BiomeKeys.FOREST,BiomeKeys.JUNGLE,
                        BiomeKeys.SPARSE_JUNGLE,BiomeKeys.BIRCH_FOREST,BiomeKeys.DARK_FOREST,BiomeKeys.BEACH), SpawnGroup.CREATURE,
                ModEntities.SNAKE, 15,2,5);

        SpawnRestriction.register(ModEntities.SNAKE, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SnakeEntity::canSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS,BiomeKeys.SUNFLOWER_PLAINS,BiomeKeys.MEADOW,
                BiomeKeys.FOREST,BiomeKeys.DARK_FOREST,BiomeKeys.BIRCH_FOREST,BiomeKeys.FLOWER_FOREST,BiomeKeys.OLD_GROWTH_BIRCH_FOREST,BiomeKeys.TAIGA,BiomeKeys.CHERRY_GROVE), SpawnGroup.CREATURE,
                ModEntities.BUTTERFLY,25,5,15);
        SpawnRestriction.register(ModEntities.BUTTERFLY, SpawnRestriction.Location.NO_RESTRICTIONS,Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }

}
