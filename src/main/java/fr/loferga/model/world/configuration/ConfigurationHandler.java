package fr.loferga.model.world.configuration;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.introspector.BeanAccess;

import fr.loferga.model.DesperateGamemode;

public class ConfigurationHandler {
	
	private File configFile;
	private Configuration config;
	
	public static void printArr(int[][] arr) {
		for (int[] e : arr) {
			for (int n : e)
				System.out.print(n + " ");
			System.out.println();
		}
	}
	
	public ConfigurationHandler(File configFile) {
		this.configFile = configFile;
		System.out.println("creation of ConfigurationHandler for file " + configFile.getAbsolutePath());
		
		try (final FileReader fileReader = new FileReader(configFile)) {
			Yaml yaml = new Yaml(ConfigurationRepresenter.DEFAULT_REPRESENTER);
			yaml.setBeanAccess(BeanAccess.FIELD);
			config = yaml.loadAs(fileReader, Configuration.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void flushChanges() {
		try (final FileWriter fileWriter = new FileWriter(configFile)) {
			Yaml yaml = new Yaml(ConfigurationRepresenter.DEFAULT_REPRESENTER);
			yaml.setBeanAccess(BeanAccess.FIELD);
			yaml.dump(config, fileWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DesperateGamemode[] getSupportedGamemodes() {
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