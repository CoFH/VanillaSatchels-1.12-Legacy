package cofh.vanillasatchels;

import cofh.vanillasatchels.gui.container.ContainerSatchel;
import cofh.vanillasatchels.gui.container.ContainerSatchelFilter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	public static final EventHandler INSTANCE = new EventHandler();

	@SubscribeEvent
	public void handleEntityItemPickup(EntityItemPickupEvent event) {

		if (event.isCanceled()) {
			return;
		}
		EntityPlayer player = event.getEntityPlayer();
		if (player.openContainer instanceof ContainerSatchel || player.openContainer instanceof ContainerSatchelFilter) {
			return;
		}
		InventoryPlayer inventory = player.inventory;
		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack stack = inventory.getStackInSlot(i);
			if (stack.getItem() instanceof ItemSatchel && ItemSatchel.onItemPickup(event, stack)) {
				event.setCanceled(true);
				return;
			}
		}
	}

}
