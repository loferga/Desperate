package fr.loferga.model.world;

import java.nio.file.Path;

import fr.loferga.DesperateMod;
import fr.loferga.model.DesperateGamemode;
import fr.loferga.model.world.configuration.ConfigurationHandler;

public class DesperateMap {
	
	//private World world;
	private DesperateGamemode[] sdgm; // suported desperate gamemodes
	private ConfigurationHandler cfgHandler;
	
	// TODO test-reserved field
	private Path worldDir;
	
	public DesperateMap(Path worldDir) {
		// if (world.isClient) throw new IllegalArgumentException("the world must be a multiplayer world");
		this.worldDir = worldDir;
		Path configPath = worldDir.resolve("config.yml");
		
		//RegistryKey.of(new Identifier("test"), World.CODEC);
		
		cfgHandler = new ConfigurationHandler(configPath);
		sdgm = cfgHandler.getSupportedGamemodes();
		
	}
	
	public void loadMap() {
		// should load the map
		DesperateMod.LOGGER.info("loading " + getName() + " ...");
		DesperateMod.LOGGER.info("map not loaded!");
	}
	
	public DesperateGamemode[] getSuportedDesperateGamemode() {
		return sdgm;
	}
	
	public ConfigurationHandler getConfigurationHandler() {
		return cfgHandler;
	}
	
	public boolean isConfigured() {
		return cfgHandler != null;
	}
	
	// TODO test function
	public String getName() {
		return worldDir.getFileName().toString().substring(5);
	}
	
}