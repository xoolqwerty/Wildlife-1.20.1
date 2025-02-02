package net.random.wildlife.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.random.wildlife.Wildlife;
import net.random.wildlife.effect.ModEffects;

public class ModPotions {

    public static final Potion TONGUE_POTION = register("tongue_potion",new Potion(new StatusEffectInstance(ModEffects.TONGUE,1200,0)));

    private static Potion register(String name, Potion potion) {
        return Registry.register(Registries.POTION, name, potion);
    }

    public static void registerPotions(){
        Wildlife.LOGGER.info("Registering Mod Potions for "+Wildlife.MOD_ID);
    }
}
