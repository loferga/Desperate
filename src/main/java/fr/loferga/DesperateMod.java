package fr.loferga;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.loferga.model.world.DesperateMap;
import fr.loferga.model.world.MapRegistry;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;

public class DesperateMod implements ModInitializer, DedicatedServerModInitializer {
	
    public static final String MOD_ID = "desperate";
	// This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
    	
        LOGGER.info("Hello Fabric world!");
    }

	@Override
	public void onInitializeServer() {
		// TODO Auto-generated method stub
		LOGGER.info("### SERVER ###");
		
		EventListener.init();
		
		Path serverDir = FabricLoader.getInstance().getGameDir();

		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(serverDir)) {
			for (Path path : directoryStream)
				if (Files.isDirectory(path) && path.getFileName().toString().startsWith("-dsp-"))
					MapRegistry.registerMap(new DesperateMap(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ServerLifecycleEvents.SERVER_STARTED.register(server -> 
    		MapRegistry.forEach(map -> map.loadMap(server))
    	);
		
		ServerLifecycleEvents.SERVER_STOPPING.register(server ->
			MapRegistry.forEach(map -> map.getConfigurationHandler().flushChanges())
		);
		
		
	}
	
}