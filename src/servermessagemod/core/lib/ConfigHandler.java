package servermessagemod.core.lib;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	//Categories
	public static String general = "General";

	//Options
	public static String logInMessage;
	public static String logOutMessage;
	public static String colour;

    public static void configOptions(Configuration config) {
        config.load();
        
        config.addCustomCategoryComment(general, "NOTE: the colours and formats MUST be written in lowercase.\nNOTE: after the log in and log out message the player's name will be displayed.");
        logInMessage = config.get(general, "The message the server will send when the player logs into the server", "Welcome to the server, ").getString();
        logOutMessage = config.get(general, "The message the server will send to everyone when a player logs out", "Goodbye, ").getString();
        colour = config.get(general, "What colour would you like your message to be?", "white", "The possibilities are: black, blue, green, teal, red, purple,"
        		+ " orange, light gray, gray,\nlight blue, bright green, bright blue, light red, pink, yellow, white").getString();
        
        if (config.hasChanged()) config.save();
    }
}