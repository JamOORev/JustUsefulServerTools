package servermessagemod.core.command;

import java.util.ArrayList;
import java.util.List;

import servermessagemod.ServerMessageMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class CommandPermissionsSet extends CommandBase implements ICommand {

	private List aliases;
	public CommandPermissionsSet() {
    	this.aliases = new ArrayList();
        this.aliases.add("permissions");
        this.aliases.add("perms");
    }

    @Override
    public String getCommandName() {
        return "permissionsadd";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/permissionsadd <level> <name>";
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
    	return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] strings) {
    	String level = strings[0];
    	int i = ServerMessageMod.permissions[1].length + 1;
    	int j = ServerMessageMod.permissions[2].length + 1;
    	int k = ServerMessageMod.permissions[3].length + 1;
    	level.toLowerCase();
    	if(strings.length == 0)
        {
    		sender.addChatMessage(new ChatComponentText("Invalid arguments"));
    		return;
        }
    	sender.addChatMessage(new ChatComponentText("Attempting to give player " + strings[1] + " permission level: " + strings[0]));
    	
    	switch (level) {
    	case "member": ServerMessageMod.permissions[1][i] = strings[1]; break;
    	case "operator": ServerMessageMod.permissions[2][j] = strings[1]; break;
    	case "admin": ServerMessageMod.permissions[3][k] = strings[1]; break;
    	}
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
