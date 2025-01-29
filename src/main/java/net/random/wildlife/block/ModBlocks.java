package net.random.wildlife.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.random.wildlife.Wildlife;
import net.random.wildlife.block.custom.BearCarpetBlock;

public class ModBlocks {

    public static final Block FUR_CARPET = registerBlock("fur_carpet",new BearCarpetBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).burnable()));

    private static Block registerBlock(String name,Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK,new Identifier(Wildlife.MOD_ID,name),block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM,new Identifier(Wildlife.MOD_ID,name),
                new BlockItem(block,new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        Wildlife.LOGGER.info("Registering ModBlocks for"+Wildlife.MOD_ID);
    }
}
