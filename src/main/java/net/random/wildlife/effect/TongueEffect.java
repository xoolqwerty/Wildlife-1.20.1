package net.random.wildlife.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.Vec3d;

public class TongueEffect extends StatusEffect {

    public TongueEffect(StatusEffectCategory category,int color) {
        super(StatusEffectCategory.BENEFICIAL, 0x3e226a);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity.isSneaking()){
            if (entity.getHealth() < entity.getMaxHealth()) {
                entity.heal(1.0F);
            }
        }

        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
