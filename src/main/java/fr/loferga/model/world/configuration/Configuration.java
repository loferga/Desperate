package fr.loferga.model.world.configuration;

import java.util.LinkedList;
import java.util.List;

public class Configuration {
	
	private LinkedList<int[]> amnesia;
	
	private int[][] duel;
	
	private LinkedList<int[]> deathmatch;
	
	private LinkedList<int[]> one_for_all;
	
	private TeamedConfiguration slaughter;
	
	private TeamedConfiguration skirmish;
	
	private Configuration() {}

	public List<int[]> getAmnesia() {
		return amnesia;
	}

	public int[][] getDuel() {
		return duel;
	}

	public List<int[]> getDeathmatch() {
		return deathmatch;
	}

	public List<int[]> getOneForAll() {
		return one_for_all;
	}

	public TeamedConfiguration getSlaughter() {
		return slaughter;
	}

	public TeamedConfiguration getSkirmish() {
		return skirmish;
	}
	
}