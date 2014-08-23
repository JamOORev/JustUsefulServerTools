package servermessagemod.core.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import servermessagemod.core.lib.ModInfo;
import servermessagemod.core.network.packets.PacketTPAAccept;

/**
 * Created by James Hollowell on 7/29/2014.
 */
public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MODID);

    public static void init() {
        INSTANCE.registerMessage(PacketTPAAccept.class, PacketTPAAccept.class, 0, Side.SERVER);
    }
}
