package net.random.wildlife.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.random.wildlife.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

public class ButterflyEntity extends AnimalEntity {

    public final AnimationState idleAnimationState2 = new AnimationState();
    private int idleAnimationTimeout2 = 0;

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout2 <= 0){
            this.idleAnimationTimeout2 = this.random.nextInt(40) + 80;
            this.idleAnimationState2.start(this.age);
        } else {
            --this.idleAnimationTimeout2;
        }

    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }

    }

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT_2 =
            DataTracker.registerData(ButterflyEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public ButterflyEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this,20,true);
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world) {
            @Override
            public boolean isValidPosition(BlockPos pos) {
                return !this.world.getBlockState(pos.down()).isAir();
            }

        };
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(false);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f,0.2f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1,new FlyGoal(this,1f));
        this.goalSelector.add(2,new EscapeDangerGoal(this,1.5));
        this.goalSelector.add(3,new AnimalMateGoal(this,1.15D));
        this.goalSelector.add(4,new FollowParentGoal(this, 1.15D));

    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.HONEYCOMB);
    }

    public static DefaultAttributeContainer.Builder createButterflyAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.3f);

    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.BUTTERFLY.create(world);
    }

    /*Variant*/
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT_2, 0);
    }

    public ButterflyVariant getVariant(){
        return ButterflyVariant.byId(this.getTypeVariant());
    }

    private int getTypeVariant(){
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT_2);
    }

    private void setVariant(ButterflyVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT_2, variant.getId()&255);
    }
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant2", this.getTypeVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT_2, nbt.getInt("Variant2"));
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        ButterflyVariant variant = Util.getRandom(ButterflyVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

}
