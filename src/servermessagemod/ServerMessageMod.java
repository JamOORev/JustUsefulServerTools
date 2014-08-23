package servermessagemod;

import net.minecraftforge.common.config.Configuration;
import servermessagemod.core.command.CommandTPA;
import servermessagemod.core.command.CommandTPAReply;
import servermessagemod.core.events.EventPlayerLogIn;
import servermessagemod.core.events.EventPlayerLogOut;
import servermessagemod.core.lib.ConfigHandler;
import servermessagemod.core.lib.ModInfo;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(name = ModInfo.NAME, modid = ModInfo.MODID, version = ModInfo.VERSION)
public class ServerMessageMod {
	Configuration config;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		ConfigHandler.configOptions(config);
		
		FMLCommonHandler.instance().bus().register(new EventPlayerLogIn());
		FMLCommonHandler.instance().bus().register(new EventPlayerLogOut());
	}
	
	@EventHandler
    public void registerCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandTPA());
        event.registerServerCommand(new CommandTPAReply());;
    }
}
