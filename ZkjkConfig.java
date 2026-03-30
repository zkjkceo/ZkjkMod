package net.minecraft.src;

import net.minecraft.client.Minecraft;
import java.io.*;
import java.util.Properties;

public class ZkjkConfig {

    public static int logRotation = 0;
	public static int farEntities = 0;
	public static int thunder = 0;

    private static File configFile;

    public static void init() {
        try {
            File mcDir = Minecraft.getMinecraftDir();
            File configDir = new File(mcDir, "config");

            if (!configDir.exists()) {
                configDir.mkdir();
            }

            configFile = new File(configDir, "zkjkmod.properties");

            if (!configFile.exists()) {
                save();
            }

            load();
        }
		catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void load() {
		try {
			Properties props = new Properties();
			FileInputStream in = new FileInputStream(configFile);

			props.load(in);
			in.close();

			logRotation = Integer.parseInt(props.getProperty("logRotation", "0"));
			farEntities = Integer.parseInt(props.getProperty("farEntities", "0"));
			thunder = Integer.parseInt(props.getProperty("thunder", "0"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void save() {
		try {
			Properties props = new Properties();

			props.setProperty("logRotation", String.valueOf(logRotation));
			props.setProperty("farEntities", String.valueOf(farEntities));
			props.setProperty("thunder", String.valueOf(thunder));

			FileOutputStream out = new FileOutputStream(configFile);
			props.store(out, "ZkjkMod Config");
			out.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}