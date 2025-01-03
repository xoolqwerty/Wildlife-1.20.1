package net.random.wildlife.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.random.wildlife.Wildlife;
import net.random.wildlife.entity.custom.SnakeEntity;

public class ModEntities {
    public static final EntityType<SnakeEntity> SNAKE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Wildlife.MOD_ID, "snake"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SnakeEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.2f)).build());

}
