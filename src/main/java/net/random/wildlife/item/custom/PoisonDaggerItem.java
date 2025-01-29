package net.random.wildlife.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.random.wildlife.item.ModItems;
import net.random.wildlife.item.ModToolMaterial;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PoisonDaggerItem extends SwordItem{
    

    public PoisonDaggerItem(Settings settings) {
        super(ModToolMaterial.FANG,0,2,new FabricItemSettings());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target instanceof LivingEntity){
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,150,1));
        }
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.wildlife.poison_dagger.tooltip"));
        tooltip.add(Text.translatable("tooltip.wildlife.poison_dagger.tooltip2"));
        tooltip.add(Text.translatable("tooltip.wildlife.poison_dagger.tooltip3"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
