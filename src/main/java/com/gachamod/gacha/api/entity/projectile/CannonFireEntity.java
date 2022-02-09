package com.gachamod.gacha.api.entity.projectile;

import com.gachamod.gacha.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn(
        value = Dist.CLIENT,
        _interface = IRendersAsItem.class
)

public class CannonFireEntity extends DamagingProjectileEntity implements IRendersAsItem {
    private static final DataParameter<ItemStack> STACK = EntityDataManager.createKey(CannonFireEntity.class, DataSerializers.ITEMSTACK);

    public CannonFireEntity(EntityType<? extends DamagingProjectileEntity> p_i50163_1_, World p_i50163_2_) {
        super(p_i50163_1_, p_i50163_2_);
    }

    public CannonFireEntity(EntityType<? extends DamagingProjectileEntity> p_i50167_1_, double p_i50167_2_, double p_i50167_4_, double p_i50167_6_, double p_i50167_8_, double p_i50167_10_, double p_i50167_12_, World p_i50167_14_) {
        super(p_i50167_1_, p_i50167_2_, p_i50167_4_, p_i50167_6_, p_i50167_8_, p_i50167_10_, p_i50167_12_, p_i50167_14_);
    }

    public CannonFireEntity(EntityType<? extends DamagingProjectileEntity> p_i50168_1_, LivingEntity p_i50168_2_, double p_i50168_3_, double p_i50168_5_, double p_i50168_7_, World p_i50168_9_) {
        super(p_i50168_1_, p_i50168_2_, p_i50168_3_, p_i50168_5_, p_i50168_7_, p_i50168_9_);
    }

    protected ItemStack getStack() {
        return new ItemStack(ModItems.CAT_CANNON_PROJECTILE.get().getItem());
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() {
        ItemStack itemstack = this.getStack();
        return itemstack.isEmpty() ? new ItemStack(ModItems.CAT_CANNON_PROJECTILE.get().asItem()) : itemstack;
    }


    @Override
    protected boolean isFireballFiery() {
        return false;
    }

    public void setStack(ItemStack stack) {
        if (stack.getItem() != ModItems.CAT_CANNON_PROJECTILE.get().asItem() || stack.hasTag()) {
            this.getDataManager().set(STACK, Util.make(stack.copy(), (p_213897_0_) -> {
                stack.setCount(1);
            }));
        }

    }


    @Override
    protected void onEntityHit(EntityRayTraceResult result) {
        super.onEntityHit(result);
        if (!this.world.isRemote) {
            Entity entity = result.getEntity();
            this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 3.0F, false, Explosion.Mode.NONE);
            entity.attackEntityFrom(DamageSource.GENERIC, 20.0F);
        }
    }



    @Override
    protected void registerData() {
        this.getDataManager().register(STACK, ItemStack.EMPTY);
    }


    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 3.0F, false, Explosion.Mode.NONE);
            this.remove();
        }
    }
}
