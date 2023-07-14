package fr.loferga.model.world;

import java.nio.file.Path;

import fr.loferga.DesperateMod;
import fr.loferga.model.world.configuration.ConfigurationHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;

public class DesperateMap {
	
	private ServerWorld world;
	private ConfigurationHandler cfgHandler;
	
	// TODO test-reserved field
	private Path worldDir;
	
	public DesperateMap(Path worldDir) {
		// if (world.isClient) throw new IllegalArgumentException("the world must be a multiplayer world");
		this.worldDir = worldDir;
		Path configPath = worldDir.resolve("config.yml");
		
		//RegistryKey.of(new Identifier("test"), World.CODEC);
		
		cfgHandler = new ConfigurationHandler(configPath);
		
	}
	
	public void loadMap(MinecraftServer server) {
		DesperateMod.LOGGER.info("loading " + getName() + " ...");
		/*
		try (Session session = LevelStorage.create(worldDir).createSession(getName())) {
			Executor exec = null;
			ServerWorldProperties properties = session.readLevelProperties(null, null, null, null).getFirst().getMainWorldProperties();
			RegistryKey<World> key =
					RegistryKey.of(RegistryKeys.WORLD, new Identifier(worldDir.getFileName().toString()));
			RegistryEntry<DimensionType> dimKey = null;
			ChunkGenerator chunkGenerator = null;
			DimensionOptions dimOptions = new DimensionOptions(dimKey, chunkGenerator);
			WorldGenerationProgressListener progressListener = null;
			long seed = 0;
			List<Spawner> spawners = new ArrayList<>();
			RandomSequencesState randSeqState = null;
			
			world = new ServerWorld(server, exec, session, properties, key, dimOptions, progressListener, false, seed, spawners, false, randSeqState);
		} catch (Exception e) {
			DesperateMod.LOGGER.info("map loading failed!");
		}*/
		
		server.getWorldRegistryKeys().forEach(k -> {
			DesperateMod.LOGGER.info(k.toString());
		});
	}
	
	public ServerWorld getWorld() {
		return world;
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