package net.random.wildlife.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
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
    public static final Item SNAKE_SPAWN_EGG = registerItem("snake_spawn_egg", new SpawnEggItem(ModEntities.SNAKE, 0xa86518, 0x3b260f, new FabricItemSettings()));
    public static final Item SNAKE_FANG = registerItem("snake_fang",new Item(new FabricItemSettings()));
    public static final Item POISON_DAGGER = registerItem("poison_dagger", new PoisonDaggerItem(new FabricItemSettings()));

    public static final Item BUTTERFLY_SPAWN_EGG = registerItem("butterfly_spawn_egg",new SpawnEggItem(ModEntities.BUTTERFLY, 0xa75932,0x3b289f,new FabricItemSettings()));
    public static final Item BUTTERFLY_WING = registerItem("butterfly_wing",new Item(new FabricItemSettings()));
    public static final Item BUTTERFLY_ELYTRA = registerItem("butterfly_elytra",new ButterflyElytraItem((new FabricItemSettings())));



}
