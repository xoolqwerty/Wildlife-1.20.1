package net.random.wildlife.entity.custom;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;
import net.random.wildlife.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

public class SnakeEntity extends AnimalEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(SnakeEntity.class, TrackedDataHandlerRegistry.INTEGER);


    public SnakeEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout <= 0 ) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f,1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f,0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();

        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AttackGoal(this));
        this.goalSelector.add(2, new AnimalMateGoal(this,1.15D));
        this.goalSelector.add(3, new FollowParentGoal(this, 1.15D));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1d));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class,4f));
        this.targetSelector.add(0, new RevengeGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, ChickenEntity.class, true));
        this.targetSelector.add(1,new ActiveTargetGoal<>(this, RabbitEntity.class,true));
    }

    public static DefaultAttributeContainer.Builder createSnakeAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1);

    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.RABBIT_FOOT);
    }




    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        SnakeEntity baby = ModEntities.SNAKE.create(world);
        RegistryEntry<Biome> registryEntry = world.getBiome(this.getBlockPos());
        if(registryEntry.isIn(BiomeTags.DESERT_PYRAMID_HAS_STRUCTURE)){
            baby.setVariant(SnakeVariant.WARM);
        } else if(registryEntry.isIn(BiomeTags.SHIPWRECK_BEACHED_HAS_STRUCTURE)){
            baby.setVariant(SnakeVariant.WARM);
        } else if(registryEntry.isIn(BiomeTags.JUNGLE_TEMPLE_HAS_STRUCTURE)){
            baby.setVariant(SnakeVariant.JUNGLE);
        } else {
            baby.setVariant(SnakeVariant.DEFAULT);
        }
        return baby;
    }

    public boolean tryAttack(Entity target) {
        if (super.tryAttack(target)) {
            if (target instanceof LivingEntity) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 1), this);
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 10), this);
            }

            return true;
        } else {
            return false;
        }
    }
    public static boolean canSpawn(EntityType<SnakeEntity> entity, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isIn(BlockTags.RABBITS_SPAWNABLE_ON) && isLightLevelValidForNaturalSpawn(world, pos);
    }

    /*Variant*/

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
    }

    public SnakeVariant getVariant(){
        return SnakeVariant.byId(this.getTypeVariant());
    }

    private int getTypeVariant(){
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(SnakeVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId()&255);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
       RegistryEntry<Biome> registryEntry = world.getBiome(this.getBlockPos());
       if(registryEntry.isIn(BiomeTags.DESERT_PYRAMID_HAS_STRUCTURE)){
           this.setVariant(SnakeVariant.WARM);
       } else if(registryEntry.isIn(BiomeTags.SHIPWRECK_BEACHED_HAS_STRUCTURE)){
           this.setVariant(SnakeVariant.WARM);
       } else if(registryEntry.isIn(BiomeTags.JUNGLE_TEMPLE_HAS_STRUCTURE)){
           this.setVariant(SnakeVariant.JUNGLE);
       } else {
           this.setVariant(SnakeVariant.DEFAULT);
       }
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }
}