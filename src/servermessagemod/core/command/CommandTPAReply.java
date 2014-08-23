package servermessagemod.core.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import servermessagemod.core.network.packets.PacketTPAAccept;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class CommandTPAReply extends CommandBase implements ICommand, IMessageHandler<PacketTPAAccept, IMessage> {
	
	private String[] replies = {"accept", "deny"};
	private List aliases;
	
    public CommandTPAReply() {
    	this.aliases = new ArrayList();
    	this.aliases.add("teleportreply");
        this.aliases.add("tpareply");
    }

    @Override
    public String getCommandName() {
        return "tpareply";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/tpareply <accept:deny>";
    }

    @Override
    public List getCommandAliases() {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] strings) {
    	if (strings[0] == "accept") {
    		
    	} else {
    		return;
    	}
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        if (sender instanceof EntityPlayer) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] strings) {
    	return strings.length != 1 && strings.length != 2 ? null : getListOfStringsMatchingLastWord(strings, replies);
    }

    @Override
    public boolean isUsernameIndex(String[] strings, int i) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

	@Override
	public IMessage onMessage(PacketTPAAccept message, MessageContext ctx) {
		int x = message.x;
		int y = message.y;
		int z = message.z;
		EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
		if (player.lastTickPosX != x) {
			player.chunkCoordX = x;
		}
		if (player.lastTickPosY != y) {
			player.chunkCoordY = y;
		}
		if (player.lastTickPosZ != z) {
			player.chunkCoordZ = z;
		}
		return null;
	}
}
