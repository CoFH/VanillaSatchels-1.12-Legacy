package cofh.vanillasatchels.gui;

import cofh.core.util.helpers.ItemHelper;
import cofh.vanillasatchels.VanillaSatchels;
import cofh.vanillasatchels.gui.client.GuiSatchel;
import cofh.vanillasatchels.gui.client.GuiSatchelFilter;
import cofh.vanillasatchels.gui.container.ContainerSatchel;
import cofh.vanillasatchels.gui.container.ContainerSatchelFilter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int TILE_ID = 0;
	public static final int TILE_CONFIG_ID = 1;
	public static final int SATCHEL_ID = 16;
	public static final int SATCHEL_FILTER_ID = 17;

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

		switch (id) {
			case SATCHEL_ID:
				if (ItemHelper.isPlayerHoldingMainhand(VanillaSatchels.itemSatchel, player)) {
					return new GuiSatchel(player.inventory, new ContainerSatchel(player.getHeldItemMainhand(), player.inventory));
				}
				return null;
			case SATCHEL_FILTER_ID:
				if (ItemHelper.isPlayerHoldingMainhand(VanillaSatchels.itemSatchel, player)) {
					return new GuiSatchelFilter(player.inventory, new ContainerSatchelFilter(player.getHeldItemMainhand(), player.inventory));
				}
				return null;
			default:
				return null;
		}
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

		switch (id) {
			case SATCHEL_ID:
				if (ItemHelper.isPlayerHoldingMainhand(VanillaSatchels.itemSatchel, player)) {
					return new ContainerSatchel(player.getHeldItemMainhand(), player.inventory);
				}
				return null;
			case SATCHEL_FILTER_ID:
				if (ItemHelper.isPlayerHoldingMainhand(VanillaSatchels.itemSatchel, player)) {
					return new ContainerSatchelFilter(player.getHeldItemMainhand(), player.inventory);
				}
				return null;
			default:
				return null;
		}
	}

}
