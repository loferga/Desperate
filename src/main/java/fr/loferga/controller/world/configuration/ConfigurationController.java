package fr.loferga.controller.world.configuration;

import java.util.List;

import fr.loferga.model.world.configuration.Configuration;

public class ConfigurationController {

	private Configuration config;
	
	private boolean amnesia;
	private boolean duel;
	private boolean deathmatch;
	private boolean oneForAll;
	private boolean slaughter;
	private boolean skirmish;
	
	public ConfigurationController(Configuration config) {
		if (config == null) throw new IllegalArgumentException("Configuration can't be null");
		this.config = config;
		amnesia = config.getAmnesia() != null;
		duel = config.getDuel() != null;
		deathmatch = config.getDeathmatch() != null;
		oneForAll = config.getOneForAll() != null;
		slaughter = config.getSlaughter() != null;
		skirmish = config.getSkirmish() != null;
	}
	
	// AMNESIA
	public boolean isAmnesiaSet() {
		return amnesia;
	}
	
	public List<int[]> getAmnesiaChest() {
		if (!amnesia) throw new IllegalStateException("This map is not configured for Amnesia");
		return config.getAmnesia();
	}
	
	public void initAmnesiaChest() {
		if (amnesia) return;
		amnesia = true;
		config.initAmnesia();
	}
	
	// DUEL
	public boolean isDuelSet() {
		return duel;
	}
	
	public int[][] getDuel() {
		if (!duel) throw new IllegalStateException("This map is not configured for Duel");
		return config.getDuel();
	}
	
	public void initDuelLocation() {
		if (duel) return;
		duel = true;
		config.initDuel();
	}
	
	// DEATHMATCH
	public boolean isDeathmatchSet() {
		return deathmatch;
	}
	
	public List<int[]> getDeathmatchSpawns() {
		if (!deathmatch) throw new IllegalStateException("This map is not configured for Deathmatch");
		return config.getDeathmatch();
	}
	
	public void initDeathmatchSpawn() {
		if (deathmatch) return;
		deathmatch = true;
		config.initDeathmatch();
	}
	
	// ONE FOR ALL
	public boolean isOneForAllSet() {
		return oneForAll;
	}
	
	public List<int[]> getOneForAllSpawns() {
		if (!oneForAll) throw new IllegalStateException("This map is not configured for One for All");
		return config.getOneForAll();
	}
	
	public void initOneForAllSpawn() {
		if (oneForAll) return;
		oneForAll = true;
		config.initOneForAll();
	}
	
	// SLAUGHTER
	public boolean isSlaughterSet() {
		return slaughter;
	}
	
	public List<int[]> getSlaughterFirstTeamSpawns() {
		if (!slaughter) throw new IllegalStateException("This map is not configured for Slaughter");
		return config.getSlaughter().getFirstTeam();
	}
	
	public List<int[]> getSlaughterSecondTeamSpawns() {
		if (!slaughter) throw new IllegalStateException("This map is not configured for Slaughter");
		return config.getSlaughter().getSecondTeam();
	}
	
	public void initSlaughter() {
		if (slaughter) return;
		slaughter = true;
		config.initSlaughter();
	}
	
	// SKIRMISH
	public boolean isSkirmishSet() {
		return skirmish;
	}
	
	public List<int[]> getSkirmishFirstTeamSpawns() {
		if (!skirmish) throw new IllegalStateException("This map is not configured for Slaughter");
		return config.getSkirmish().getFirstTeam();
	}
	
	public List<int[]> getSkirmishSecondTeamSpawns() {
		if (!skirmish) throw new IllegalStateException("This map is not configured for Slaughter");
		return config.getSkirmish().getSecondTeam();
	}
	
	public void initSkirmish() {
		if (skirmish) return;
		skirmish = true;
		config.initSkirmish();
	}
	
}