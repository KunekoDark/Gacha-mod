package com.gachamod.gacha.item.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class JizosScarfItem extends Item implements ICurioItem {
    public JizosScarfItem(Properties properties) {
        super(properties);
    }
    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
        PlayerEntity player = (PlayerEntity) livingEntity;
        player.addPotionEffect(new EffectInstance(Effects.SPEED, 201, 1, false, false));
    }
}
