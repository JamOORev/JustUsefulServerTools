package servermessagemod.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import servermessagemod.ConfigHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class EventPlayerLogIn {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
		System.out.println("BACON");
		EntityPlayer player = event.player;
		player.addChatComponentMessage(new ChatComponentText(ConfigHandler.logInMessage + player.getDisplayName() + "!"));
	}
}
