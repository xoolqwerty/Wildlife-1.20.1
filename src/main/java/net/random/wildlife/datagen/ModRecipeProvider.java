package net.random.wildlife.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.random.wildlife.block.ModBlocks;
import net.random.wildlife.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.POISON_DAGGER,1)
                .pattern("X")
                .pattern("S")
                .input('X', ModItems.SNAKE_FANG)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SNAKE_FANG), conditionsFromItem(ModItems.SNAKE_FANG))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POISON_DAGGER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BUTTERFLY_ELYTRA,1)
                .pattern("SS")
                .input('S', ModItems.BUTTERFLY_WING)
                .criterion(hasItem(ModItems.BUTTERFLY_WING), conditionsFromItem(ModItems.BUTTERFLY_WING))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BUTTERFLY_ELYTRA)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.FUR_CARPET,1)
                .pattern("SS")
                .input('S',ModItems.FUR)
                .criterion(hasItem(ModItems.FUR),conditionsFromItem(ModItems.FUR))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FUR_CARPET)));



    }
}
