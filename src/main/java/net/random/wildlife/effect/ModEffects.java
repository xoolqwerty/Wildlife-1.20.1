package net.random.wildlife.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.random.wildlife.Wildlife;

public class ModEffects {
    public static final StatusEffect TONGUE = registerStatusEffect("tongue",
            new TongueEffect(StatusEffectCategory.NEUTRAL, 0x36ebab));


    private static StatusEffect registerStatusEffect(String id, StatusEffect entry) {
        return Registry.register(Registries.STATUS_EFFECT,id,entry);
    }

    public static void registerEffects() {
        Wildlife.LOGGER.info("Registering Mod Effects for " + Wildlife.MOD_ID);
    }
}
