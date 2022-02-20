package com.gachamod.gacha.item.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class JizosHatItem extends Item implements ICurioItem {
    public JizosHatItem(Properties properties) {
        super(properties);
    }



    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
        PlayerEntity player = (PlayerEntity) livingEntity;
        player.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 201, 2, false, false));



              /*  if(random.nextFloat() > 0.6f){
                    stack.damageItem(1,player, p -> CuriosApi.getCuriosHelper().onBrokenCurio(SlotTypePreset.HEAD.getIdentifier(), index, p));
                }  */ //used to damage the item in slot
            }



        }


