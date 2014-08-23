package servermessagemod.core.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

/**
 * Created by poppypoppop on 23/08/2014.
 */
public class CommandTPA extends CommandBase implements ICommand {

    public CommandTPA() {
    	
    }

    @Override
    public String getCommandName() {
        return "tpa";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "tpa <recievername>";
    }

    @Override
    public List getCommandAliases() {
        return null;
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
        System.err.println("Attempting to contact player");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
