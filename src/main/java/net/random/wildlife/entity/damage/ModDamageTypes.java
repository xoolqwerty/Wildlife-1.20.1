package net.random.wildlife.entity.damage;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDamageTypes {
   public static final RegistryKey<DamageType> TRAMPLE_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("wildlife", "trample"));

   public static DamageSource of(World world, RegistryKey<DamageType> key) {
      return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
   }
}
