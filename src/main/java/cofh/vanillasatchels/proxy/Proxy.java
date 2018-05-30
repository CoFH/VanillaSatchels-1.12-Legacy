package cofh.vanillasatchels.proxy;

import cofh.core.render.IModelRegister;
import cofh.vanillasatchels.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Proxy {

	/* INIT */
	public void preInit(FMLPreInitializationEvent event) {

		MinecraftForge.EVENT_BUS.register(EventHandler.INSTANCE);
	}

	public void initialize(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent event) {

	}

	/* HELPERS */
	public boolean addIModelRegister(IModelRegister modelRegister) {

		return false;
	}

}
