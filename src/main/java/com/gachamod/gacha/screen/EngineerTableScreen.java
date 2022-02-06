package com.gachamod.gacha.screen;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.container.EngineerTableContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class EngineerTableScreen extends ContainerScreen<EngineerTableContainer> {
    private final ResourceLocation GUI = new ResourceLocation(Gacha.MOD_ID,
            "textures/gui/engineer_table_gui.png");

    public EngineerTableScreen(EngineerTableContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float particalTicks){
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, particalTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f ,1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j,0, 0, this.xSize, this.ySize);

    }
}
