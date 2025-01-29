package net.random.wildlife.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.random.wildlife.Wildlife;
import net.random.wildlife.entity.ModEntities;
import net.random.wildlife.item.custom.ButterflyElytraItem;
import net.random.wildlife.item.custom.PoisonDaggerItem;

public class ModItems {


    public static void registerModItems() {
        Wildlife.LOGGER.info("Registering Mod Items for "+ Wildlife.MOD_ID);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Wildlife.MOD_ID, name),item);
    }
    public static final Item SNAKE_SPAWN_EGG = registerItem("snake_spawn_egg", new SpawnEggItem(ModEntities.SNAKE, 0x10933c, 0x29e64d, new FabricItemSettings()));
    public static final Item SNAKE_FANG = registerItem("snake_fang",new Item(new FabricItemSettings()));
    public static final Item POISON_DAGGER = registerItem("poison_dagger", new PoisonDaggerItem(new Item.Settings().maxDamage(100)));

    public static final Item BUTTERFLY_SPAWN_EGG = registerItem("butterfly_spawn_egg",new SpawnEggItem(ModEntities.BUTTERFLY, 0x9a0810,0x000000,new FabricItemSettings()));
    public static final Item BUTTERFLY_WING = registerItem("butterfly_wing",new Item(new FabricItemSettings()));
    public static final Item BUTTERFLY_ELYTRA = registerItem("butterfly_elytra",new ButterflyElytraItem(new Item.Settings().maxDamage(216).maxDamageIfAbsent(216)));

    public static final Item BEAR_SPAWN_EGG = registerItem("bear_spawn_egg",new SpawnEggItem(ModEntities.BEAR, 0x452a10,0x2e1c03,new FabricItemSettings()));
    public static final Item FUR = registerItem("fur",new Item(new FabricItemSettings()));



}
