package fr.loferga.model.world.configuration;

import java.util.List;

public class Configuration {
	
	private List<int[]> amnesia;
	
	private int[][] duel;
	
	private List<int[]> deathmatch;
	
	private List<int[]> one_for_all;
	
	private TeamedConfiguration slaughter;
	
	private TeamedConfiguration skirmish;

	public List<int[]> getAmnesia() {
		return amnesia;
	}

	public void addAmnesia(int[] location) {
		this.amnesia.add(location);
	}

	public int[][] getDuel() {
		return duel;
	}

	public void setDuel(boolean firstIndex, int[] location) {
		this.duel[firstIndex?0:1] = location;
	}

	public List<int[]> getDeathmatch() {
		return deathmatch;
	}

	public void addDeathmatch(int[] location) {
		this.deathmatch.add(location);
	}

	public List<int[]> getOneForAll() {
		return one_for_all;
	}

	public void addOneForAll(int[] location) {
		this.one_for_all.add(location);
	}

	public TeamedConfiguration getSlaughter() {
		return slaughter;
	}

	public TeamedConfiguration getSkirmish() {
		return skirmish;
	}
	
}