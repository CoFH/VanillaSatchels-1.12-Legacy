package cofh.vanillasatchels;

import cofh.CoFHCore;
import cofh.core.init.CoreEnchantments;
import cofh.core.init.CoreProps;
import cofh.core.util.ConfigHandler;
import cofh.vanillasatchels.gui.GuiHandler;
import cofh.vanillasatchels.proxy.Proxy;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod (modid = VanillaSatchels.MOD_ID, name = VanillaSatchels.MOD_NAME, version = VanillaSatchels.VERSION, dependencies = VanillaSatchels.DEPENDENCIES, updateJSON = VanillaSatchels.UPDATE_URL, certificateFingerprint = "8a6abf2cb9e141b866580d369ba6548732eff25f")
public class VanillaSatchels {

	public static final String MOD_ID = "vanillasatchels";
	public static final String MOD_NAME = "CoFH: Vanilla+ Satchels";

	public static final String VERSION = "1.0.1";
	public static final String VERSION_MAX = "1.1.0";
	public static final String VERSION_GROUP = "required-after:" + MOD_ID + "@[" + VERSION + "," + VERSION_MAX + ");";
	public static final String UPDATE_URL = "https://raw.github.com/cofh/version/master/" + MOD_ID + "_update.json";

	public static final String DEPENDENCIES = CoFHCore.VERSION_GROUP;

	@Instance (MOD_ID)
	public static VanillaSatchels instance;

	@SidedProxy (clientSide = "cofh.vanillasatchels.proxy.ProxyClient", serverSide = "cofh.vanillasatchels.proxy.Proxy")
	public static Proxy proxy;

	public static final Logger LOG = LogManager.getLogger(MOD_ID);
	public static final ConfigHandler CONFIG = new ConfigHandler(VERSION);
	public static final GuiHandler GUI_HANDLER = new GuiHandler();

	public VanillaSatchels() {

		super();
	}

	/* INIT */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		CONFIG.setConfiguration(new Configuration(new File(CoreProps.configDir, "/cofh/vanillaplus/satchels.cfg"), true));

		itemSatchel = new ItemSatchel();
		itemSatchel.preInit();

		CoreEnchantments.register();

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, GUI_HANDLER);

		proxy.preInit(event);
	}

	@EventHandler
	public void initialize(FMLInitializationEvent event) {

		itemSatchel.initialize();

		proxy.initialize(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		proxy.postInit(event);
	}

	@EventHandler
	public void loadComplete(FMLLoadCompleteEvent event) {

		CONFIG.cleanUp(false, true);

		LOG.info(MOD_NAME + ": Load Complete.");
	}

	public static ItemSatchel itemSatchel;

}
