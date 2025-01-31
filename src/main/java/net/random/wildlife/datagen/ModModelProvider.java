package net.random.wildlife.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.random.wildlife.block.ModBlocks;
import net.random.wildlife.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FUR_CARPET);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


        itemModelGenerator.register(ModItems.SNAKE_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.BUTTERFLY_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.BEAR_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.GIRAFFE_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.SNAKE_FANG, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BUTTERFLY_WING, Models.HANDHELD);
        itemModelGenerator.register(ModItems.POISON_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BUTTERFLY_ELYTRA, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FUR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GIRAFFE_TONGUE,Models.HANDHELD);
    }
}
