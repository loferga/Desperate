package fr.loferga.model.world.configuration;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import fr.loferga.DesperateMod;
import net.fabricmc.loader.api.FabricLoader;

public class ConfigurationHandler {
	
	private static class ConfigurationRepresenter extends Representer {
		
		public static final ConfigurationRepresenter DEFAULT_REPRESENTER = new ConfigurationRepresenter(new DumperOptions());

		private ConfigurationRepresenter(DumperOptions dumpOptions) {
			super(dumpOptions);
			super.addClassTag(Configuration.class, Tag.MAP);
		}
		
		@Override
	    protected NodeTuple representJavaBeanProperty(Object javaBean, Property property, Object propertyValue, Tag customTag) {
	        if (propertyValue == null)
	            return null; // Exclude null-valued properties
	        return super.representJavaBeanProperty(javaBean, property, propertyValue, customTag);
	    }
		
	}
	
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
		} catch (IOException e) {
			DesperateMod.LOGGER.info("Configuration file not detected");
			try {
				Files.copy(DEFAULT_CONFIG_PATH, configPath);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			DesperateMod.LOGGER.info("A default configuration file has been written");
		}
		
		if (config == null) {
			// config file is empty
			config = new Configuration(); // create empty Configuration Object
			DesperateMod.LOGGER.warn("The Configuration file of " + configPath.getParent().getFileName().toString() + " is empty");
		}
		
	}
	
	public Configuration getConfiguration() {
		return config;
	}
	
	private boolean isConfigWorthDumping() {
		return config.getAmnesia() == null ||
			config.getDuel() != null ||
			config.getDeathmatch() != null ||
			config.getOneForAll() != null ||
			config.getSlaughter() != null ||
			config.getSkirmish() != null;
	}
	
	public void save() {
		try (final Writer writer = Files.newBufferedWriter(configPath, StandardOpenOption.TRUNCATE_EXISTING)) {
			if (isConfigWorthDumping()) {
				DesperateMod.LOGGER.info("Configuration dumping ...");
				Yaml yaml = new Yaml(ConfigurationRepresenter.DEFAULT_REPRESENTER);
				yaml.setBeanAccess(BeanAccess.FIELD);
				yaml.dump(config, writer);
			} else writer.write("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
