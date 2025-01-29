package net.random.wildlife.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.random.wildlife.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

public class BearEntity extends AnimalEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

    }

    public BearEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f,1.0f):0.0f;
        this.limbAnimator.updateLimbs(f,0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient());{
            setupAnimationStates();
        }
    }



    @Override
    protected void initGoals() {
        this.goalSelector.add(0,new SwimGoal(this));
        this.goalSelector.add(1,new AttackGoal(this));
        this.goalSelector.add(2,new AnimalMateGoal(this,1.15D));
        this.goalSelector.add(3,new TemptGoal(this,1.25D, Ingredient.ofItems(Items.HONEYCOMB),false));
        this.goalSelector.add(4,new FollowParentGoal(this,1.25));
        this.goalSelector.add(5,new WanderAroundGoal(this,1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1,new RevengeGoal(this));
        this.targetSelector.add(2, new BearEntity.ProtectBabiesGoal());
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, FoxEntity.class, 10, true, true, null));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, RabbitEntity.class, 10, true, true, null));



    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.HONEYCOMB);
    }

    public static DefaultAttributeContainer.Builder createBearAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.BEAR.create(world);
    }
    class ProtectBabiesGoal extends ActiveTargetGoal<PlayerEntity> {
        public ProtectBabiesGoal() {
            super(BearEntity.this, PlayerEntity.class, 20, true, true, null);
        }

        @Override
        public boolean canStart() {
            if (BearEntity.this.isBaby()) {
                return false;
            } else {
                if (super.canStart()) {
                    for (BearEntity bearEntity : BearEntity.this.getWorld()
                            .getNonSpectatingEntities(BearEntity.class, BearEntity.this.getBoundingBox().expand(8.0, 4.0, 8.0))) {
                        if (bearEntity.isBaby()) {
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        @Override
        protected double getFollowRange() {
            return super.getFollowRange() * 0.5;
        }
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_POLAR_BEAR_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_DEATH;
    }

}
