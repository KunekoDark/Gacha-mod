package com.gachamod.gacha.item.items.Misc;

import com.gachamod.gacha.world.dimension.DimensionTeleporter;
import com.gachamod.gacha.world.dimension.ModDimensions;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class HandHeldTimeMachineItem extends Item {
    public HandHeldTimeMachineItem(Properties properties) {
        super(properties);
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.gacha.right_click_use"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        if (!worldIn.isRemote()) {
            if (!playerIn.isCrouching()) {
                MinecraftServer server = worldIn.getServer();

                if (server != null) {
                    if (worldIn.getDimensionKey() == ModDimensions.FutureDim) {
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        if (overWorld != null) {
                            playerIn.changeDimension(overWorld, new DimensionTeleporter(playerIn.getPosition(), false));
                        }
                    } else {
                        ServerWorld kjDim = server.getWorld(ModDimensions.FutureDim);
                        if (kjDim != null) {
                            playerIn.changeDimension(kjDim, new DimensionTeleporter(playerIn.getPosition(), true));
                        }
                    }

                }
            }
        }
        playerIn.getCooldownTracker().setCooldown(this.getItem(), 600);
        return ActionResult.resultSuccess(new ItemStack(this.getItem()));
    }
}
