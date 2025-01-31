package net.random.wildlife.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.random.wildlife.entity.ModEntities;
import net.random.wildlife.entity.damage.ModDamageTypes;
import org.jetbrains.annotations.Nullable;

public class GiraffeEntity extends AnimalEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

    }


    public GiraffeEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta*6.0f,1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f,0.2f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0,new SwimGoal(this));
        this.goalSelector.add(1,new EscapeDangerGoal(this,2));
        this.goalSelector.add(2, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        onPlayerCollision(player,getWorld());
    }

    public void onPlayerCollision(PlayerEntity player, World world) {
        player.damage(ModDamageTypes.of(world,ModDamageTypes.TRAMPLE_DAMAGE),10.0f);
    }

    public static DefaultAttributeContainer.Builder createGiraffeAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,30.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.25f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,20.0);
    }


    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.GIRAFFE.create(world);
    }

}
