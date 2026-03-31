package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class CommandShowSpawnpoint extends CommandBase {
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}

	public String getCommandName() {
		return "showspawnpoint";
	}

	public int getRequiredPermissionLevel() {
		return 0;
	}

	public void processCommand(ICommandSender sender, String[] args) {
		EntityPlayer player = (EntityPlayer) sender;

		ChunkCoordinates spawn = player.getBedLocation();

		if (spawn != null) {
			sender.sendChatToPlayer("§6Your spawnpoint is located at " + spawn.posX + " " + spawn.posY + " " + spawn.posZ);
		}
	}
}
