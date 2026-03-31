package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.server.MinecraftServer;

public class CommandWeatherForecast extends CommandBase {
	public String getCommandName() {
		return "forecast";
	}

	public int getRequiredPermissionLevel() {
		return 0;
	}
	
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}

	public void processCommand(ICommandSender var1, String[] var2) {
		World world = ((Entity)var1).worldObj;
		WorldInfo info = world.getWorldInfo();
		if(!info.isRaining()) {
			int rain = info.getRainTime()/1200;
			var1.sendChatToPlayer("§6It should rain in " + rain + " minutes.");
		}
		else {
			int rain = info.getRainTime()/1200;
			int thunder = info.getThunderTime()/1200;
			var1.sendChatToPlayer("§6It should rain for " + rain + " minutes.");
			if(thunder<rain) {
				var1.sendChatToPlayer("§6It should thunder in " + thunder + " minutes.");
			}
		}
		if(info.isThundering())
		{
			int thunder = info.getThunderTime()/1200;
			int rain = info.getRainTime()/1200;
			if(thunder>rain) {
				thunder = rain;
			}
			var1.sendChatToPlayer("§6It should thunder for " + thunder + " minutes.");
		}
		
	}

}
