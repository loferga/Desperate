package fr.loferga.model.world;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.slf4j.Logger;

import fr.loferga.model.DesperateGamemode;

public class MapRegistry {
	
	private static List<DesperateMap> registeredMaps = new ArrayList<>();
	
	public static void registerMap(DesperateMap map) {
		if (map == null) return;
		System.out.println(map.getName() + " added to registry");
		registeredMaps.add(map);
	}
	
	public static void forEach(Consumer<DesperateMap> f) {
		registeredMaps.forEach(f);
	}
	
	// TODO test function
	public static void dump(Logger logger) {
		for (DesperateMap map : registeredMaps) {
			String message = String.format("%s: %s", map.getName(), (map.isConfigured() ? "configured" : "unavailable"));
			logger.info(message);
			for (DesperateGamemode gm : map.getConfigurationHandler().getSupportedGamemodes())
				logger.info(gm.toString());
		}
	}
	
}