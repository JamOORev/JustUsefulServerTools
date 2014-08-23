package servermessagemod.core.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class CommandTPA extends CommandBase implements ICommand {
	
	private List aliases;
	public CommandTPA() {
    	this.aliases = new ArrayList();
        this.aliases.add("teleport");
        this.aliases.add("tpa");
    }

    @Override
    public String getCommandName() {
        return "tpa";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/tpa <recievername>";
    }

    @Override
    public List getCommandAliases() {
        return this.aliases;
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
    public boolean isUsernameIndex(String[] strings, int i) {
        return false;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] strings) {
    	return strings.length != 1 && strings.length != 2 ? null : getListOfStringsMatchingLastWord(strings, MinecraftServer.getServer().getAllUsernames());
    }

    @Override
    public void processCommand(ICommandSender sender, String[] strings) {
    	if(strings.length == 0)
        {
    		sender.addChatMessage(new ChatComponentText("Invalid arguments"));
    		return;
        }
    	sender.addChatMessage(new ChatComponentText("Attempting to contact player: " + strings[0]));
    	
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
