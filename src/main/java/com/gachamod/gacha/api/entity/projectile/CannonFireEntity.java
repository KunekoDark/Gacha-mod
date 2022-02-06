package com.gachamod.gacha.api.entity.projectile;

import com.gachamod.gacha.api.entity.ModEntityType;
import com.gachamod.gacha.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class CannonFireEntity extends ProjectileItemEntity {
    public CannonFireEntity(EntityType<CannonFireEntity> type, World world) {
        super(type, world);
    }

    public CannonFireEntity(LivingEntity entity, World world) {
        super(ModEntityType.CANNON_PROJECTILE.get(), entity, world);
    }

    public CannonFireEntity(double x, double y, double z, World world) {
        super(ModEntityType.CANNON_PROJECTILE.get(), x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.PLATINUM_TICKET.get().asItem();
    }
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    @Override
    protected void onImpact(RayTraceResult result) {
        this.remove();
    }
}
