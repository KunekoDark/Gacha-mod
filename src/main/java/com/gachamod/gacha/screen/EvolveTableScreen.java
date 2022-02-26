package com.gachamod.gacha.screen;

import com.gachamod.gacha.Gacha;
import com.gachamod.gacha.container.containers.EvolveTableContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class EvolveTableScreen extends ContainerScreen<EvolveTableContainer> {
    private final ResourceLocation GUI = new ResourceLocation(Gacha.MOD_ID,
            "textures/gui/evolve_table_gui.png");
    public static final int evolveoffset = -3;

    public EvolveTableScreen(EvolveTableContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }


    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float particalTicks){
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, particalTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        this.font.func_238418_a_(new TranslationTextComponent("screen.gacha.evolve_table"), 8, 5+evolveoffset, 1000, 0xFFFFFF);
        this.font.func_238418_a_(new TranslationTextComponent("container.inventory"), 8, 100+evolveoffset, 1000, 0xFFFFFF);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f ,1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j+evolveoffset,0, 0, this.xSize, 193);
    }


}
