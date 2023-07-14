package fr.loferga.model.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import fr.loferga.DesperateMod;

public class MapRegistry {
	
	private static List<DesperateMap> registeredMaps = new ArrayList<>();
	
	public static void registerMap(DesperateMap map) {
		if (map == null) return;
		DesperateMod.LOGGER.info(map.getName() + " added to registry");
		registeredMaps.add(map);
	}
	
	public static void forEach(Consumer<DesperateMap> f) {
		registeredMaps.forEach(f);
	}
	
	public static Optional<DesperateMap> findMap(String mapName) {
		for (DesperateMap map : registeredMaps)
			if (map.getName().equals(mapName))
				return Optional.of(map);
		return Optional.empty();
	}
	
}