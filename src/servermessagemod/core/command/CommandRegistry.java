package servermessagemod.core.command;

import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * Created by poppypoppop on 23/08/2014.
 */
public class CommandRegistry {
	@Subscribe
    public void registerCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandTPA());
        event.registerServerCommand(new CommandTPAReply());;
    }
}
