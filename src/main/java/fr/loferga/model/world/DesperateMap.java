package fr.loferga.model.world;

import java.io.File;
import java.io.IOException;

import fr.loferga.model.world.configuration.ConfigurationHandler;
import net.minecraft.server.MinecraftServer;

public class DesperateMap {
	
	//private World world;
	//private DesperateGamemode[] sdgm; // suported desperate gamemodes
	private ConfigurationHandler cfgHandler;
	
	public DesperateMap(MinecraftServer server, File worldDir) {
		// if (world.isClient) throw new IllegalArgumentException("the world must be a multiplayer world");
		File configFile = worldDir.toPath().resolve("config.yml").toFile();
		
		//RegistryKey.of(new Identifier("test"), World.CODEC);
		
		// create config file if don't exist
		if (!configFile.exists() || !configFile.isFile()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else cfgHandler = new ConfigurationHandler(configFile);
	}
	
	public ConfigurationHandler getConfigurationHandler() {
		return cfgHandler;
	}
	
	public boolean isConfigured() {
		return cfgHandler != null;
	}
	
	// TODO test function
	public String getName() {
		return "test";
	}
	
}