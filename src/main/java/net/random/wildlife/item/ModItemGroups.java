package net.random.wildlife.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.random.wildlife.Wildlife;
import net.random.wildlife.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup ANIMAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Wildlife.MOD_ID,"animals"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.animals"))
                    .icon(() -> new ItemStack(ModItems.FUR)).entries((displayContext, entries) -> {
                        entries.add(ModItems.SNAKE_SPAWN_EGG);
                        entries.add(ModItems.BUTTERFLY_SPAWN_EGG);
                        entries.add(ModItems.BEAR_SPAWN_EGG);
                        entries.add(ModItems.GIRAFFE_SPAWN_EGG);
                        entries.add(ModItems.SNAKE_FANG);
                        entries.add(ModItems.BUTTERFLY_WING);
                        entries.add(ModItems.POISON_DAGGER);
                        entries.add(ModItems.BUTTERFLY_ELYTRA);
                        entries.add(ModBlocks.FUR_CARPET);
                        entries.add(ModItems.FUR);
                        entries.add(ModItems.GIRAFFE_TONGUE);

                    }).build());
    public static void registerItemGroups(){
        Wildlife.LOGGER.info("Registering Item Groups for " + Wildlife.MOD_ID);

    }
}
