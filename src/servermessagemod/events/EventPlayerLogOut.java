package servermessagemod.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import servermessagemod.ConfigHandler;
import servermessagemod.TextHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;

public class EventPlayerLogOut {
	@SubscribeEvent
	public void onPlayerLogOut(PlayerLoggedOutEvent event) {
		EntityPlayer player = event.player;
		String message = ConfigHandler.logOutMessage;
		switch(ConfigHandler.colour) {
		case "black": message = TextHelper.BLACK + message; break;
		case "blue": message = TextHelper.BLUE + message; break;
		case "green": message = TextHelper.GREEN + message; break;
		case "teal": message = TextHelper.TEAL + message; break;
		case "red": message = TextHelper.RED + message; break;
		case "purple": message = TextHelper.PURPLE + message; break;
		case "orange": message = TextHelper.ORANGE + message; break;
		case "light gray": message = TextHelper.LIGHT_GRAY + message; break;
		case "gray": message = TextHelper.GRAY + message; break;
		case "light blue": message = TextHelper.LIGHT_BLUE + message; break;
		case "bright green": message = TextHelper.BRIGHT_GREEN + message; break;
		case "bright blue": message = TextHelper.BRIGHT_BLUE + message; break;
		case "light red": message = TextHelper.LIGHT_RED + message; break;
		case "pink": message = TextHelper.PINK + message; break;
		case "yellow": message = TextHelper.YELLOW + message; break;
		case "white": message = TextHelper.WHITE + message; break;
		default: break;
		}
		
		MinecraftServer.getServer().addChatMessage(new ChatComponentText(message + player.getDisplayName()));
	}
}
