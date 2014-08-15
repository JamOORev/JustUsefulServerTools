package servermessagemod;

import net.minecraftforge.common.config.Configuration;
import servermessagemod.events.EventPlayerLogIn;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(name = "Server Message Mod", modid = "servermessagemod", version = "1.0")
public class ServerMessageMod {
	Configuration config;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		ConfigHandler.configOptions(config);
		
		FMLCommonHandler.instance().bus().register(new EventPlayerLogIn());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
