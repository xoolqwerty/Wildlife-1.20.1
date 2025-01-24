package net.random.wildlife.item.custom;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.random.wildlife.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ButterflyElytraItem extends ElytraItem implements FabricElytraItem {

    public ButterflyElytraItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.BUTTERFLY_WING);
    }

    @Override
    public boolean useCustomElytra(LivingEntity entity, ItemStack chestStack, boolean tickElytra) {
        return true;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.wildlife.butterfly_elytra.tooltip"));
        tooltip.add(Text.translatable("tooltip.wildlife.butterfly_elytra.tooltip2"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
