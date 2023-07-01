package fr.loferga.model.world.configuration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.introspector.BeanAccess;

import fr.loferga.DesperateMod;
import fr.loferga.model.DesperateGamemode;
import net.fabricmc.loader.api.FabricLoader;

public class ConfigurationHandler {
	
	private static final Path DEFAULT_CONFIG_PATH = FabricLoader.getInstance()
			.getModContainer(DesperateMod.MOD_ID).orElseThrow()
			.findPath("assets/desperate/default-config.yml").orElseThrow();
	
	private Path configPath;
	private Configuration config;
	
	public ConfigurationHandler(Path configPath) {
		
		// create config file if don't exist
		if (!Files.exists(configPath) || !Files.isRegularFile(configPath)) {
			try {
				DesperateMod.LOGGER.info("Config File don't exist, beginning default config copy.");
				Files.copy(DEFAULT_CONFIG_PATH, configPath);
				DesperateMod.LOGGER.info("Default config successfully copied!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		this.configPath = configPath;
		
		try (final BufferedReader reader = Files.newBufferedReader(configPath)) {
			DesperateMod.LOGGER.info("Beginning config.yml reading.");
			Yaml yaml = new Yaml(ConfigurationRepresenter.DEFAULT_REPRESENTER);
			yaml.setBeanAccess(BeanAccess.FIELD);
			config = yaml.loadAs(reader, Configuration.class);
			DesperateMod.LOGGER.info("Parsing's result: ");
			if (config == null) DesperateMod.LOGGER.debug("Config is null");
			else DesperateMod.LOGGER.info(config.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void flushChanges() {
		try (final BufferedWriter writer = Files.newBufferedWriter(configPath)) {
			Yaml yaml = new Yaml(ConfigurationRepresenter.DEFAULT_REPRESENTER);
			yaml.setBeanAccess(BeanAccess.FIELD);
			yaml.dump(config, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// TODO refactor
	public DesperateGamemode[] getSupportedGamemodes() {
		if (config == null) return new DesperateGamemode[0];
		boolean amnesia = config.getAmnesia() != null;
		boolean duel = config.getDuel() != null;
		boolean deathmatch = config.getDeathmatch() != null;
		boolean oneForAll = config.getOneForAll() != null;
		boolean slaughter = config.getSlaughter() != null;
		boolean skirmish = config.getSkirmish() != null;
		int count = (amnesia?1:0) + (duel?1:0) + (deathmatch?1:0) + (oneForAll?1:0) + (slaughter?1:0) + (skirmish?1:0);
		DesperateGamemode[] toReturn = new DesperateGamemode[count];
		int i = 0;
		if (amnesia) toReturn[i++] = DesperateGamemode.AMNESIA;
		if (duel) toReturn[i++] = DesperateGamemode.DUEL;
		if (deathmatch) toReturn[i++] = DesperateGamemode.DEATHMATCH;
		if (oneForAll) toReturn[i++] = DesperateGamemode.ONE_FOR_ALL;
		if (slaughter) toReturn[i++] = DesperateGamemode.SLAUGHTER;
		if (skirmish) toReturn[i++] = DesperateGamemode.SKIRMISH;
		return toReturn;
	}
	
	public Configuration getConfiguration() {
		return config;
	}
	
}