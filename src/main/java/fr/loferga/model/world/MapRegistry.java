package fr.loferga.model.world;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import fr.loferga.model.DesperateGamemode;

public class MapRegistry {
	
	private static List<DesperateMap> registeredMaps = new ArrayList<>();
	
	public static void registerMap(DesperateMap map) {
		if (map == null) return;
		registeredMaps.add(map);
	}
	
	public static void dump(Logger logger) {
		for (DesperateMap map : registeredMaps) {
			logger.info(map.getName() + ": " + (map.isConfigured() ? "configured" : "unavailabla"));
			for (DesperateGamemode gm : map.getConfigurationHandler().getSupportedGamemodes())
				logger.info(gm.toString());
		}
	}
	
}