package fr.loferga.model.world.configuration;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

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
		
		this.configPath = configPath;
		
		try (final Reader reader = Files.newBufferedReader(configPath)) {
			DesperateMod.LOGGER.info("Configuration file detected, beginning reading ...");
			Yaml yaml = new Yaml(ConfigurationRepresenter.DEFAULT_REPRESENTER);
			yaml.setBeanAccess(BeanAccess.FIELD);
			config = yaml.loadAs(reader, Configuration.class);
			setSupportedGamemodes();
		} catch (IOException e) {
			DesperateMod.LOGGER.info("Configuration file not detected");
			try {
				Files.createFile(configPath);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			// all modes are set as not configured (false by default)
		}
		
	}
	
	private void setSupportedGamemodes() {
		
	}
	
	public void flushChanges() {
		try (final Writer writer = Files.newBufferedWriter(configPath, StandardOpenOption.TRUNCATE_EXISTING)) {
			Yaml yaml = new Yaml(ConfigurationRepresenter.DEFAULT_REPRESENTER);
			yaml.setBeanAccess(BeanAccess.FIELD);
			yaml.dump(config, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}