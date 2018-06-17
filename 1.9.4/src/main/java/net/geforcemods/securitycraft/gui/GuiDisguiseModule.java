package net.geforcemods.securitycraft.gui;

import net.geforcemods.securitycraft.containers.ContainerDisguiseModule;
import net.geforcemods.securitycraft.containers.ModuleInventory;
import net.geforcemods.securitycraft.util.ClientUtils;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiDisguiseModule extends GuiContainer {

	public GuiDisguiseModule(EntityPlayer player, InventoryPlayer inventory) {
		super(new ContainerDisguiseModule(player, inventory, new ModuleInventory(player.inventory.getCurrentItem())));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		fontRendererObj.drawString(ClientUtils.localize("item.disguiseModule.name"), xSize / 2 - fontRendererObj.getStringWidth(ClientUtils.localize("item.disguiseModule.name")) / 2, 6, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(new ResourceLocation("securitycraft:textures/gui/container/customize1.png"));
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}

}