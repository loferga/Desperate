package fr.loferga.model.world.configuration;

import java.util.LinkedList;
import java.util.List;

public class Configuration {
	
	public class TeamedConfiguration {
		
		private LinkedList<int[]> first_team;
		private LinkedList<int[]> second_team;
		
		private TeamedConfiguration() {
			first_team = new LinkedList<>();
			second_team = new LinkedList<>();
		}
		
		public List<int[]> getFirstTeam() {
			return first_team;
		}
		
		public List<int[]> getSecondTeam() {
			return second_team;
		}
		
	}
	
	private LinkedList<int[]> amnesia;
	
	private int[][] duel;
	
	private LinkedList<int[]> deathmatch;
	
	private LinkedList<int[]> one_for_all;
	
	private TeamedConfiguration slaughter;
	
	private TeamedConfiguration skirmish;
	
	Configuration() {}

	public List<int[]> getAmnesia() {
		return amnesia;
	}
	
	public void initAmnesia() {
		amnesia = new LinkedList<>();
	}

	public int[][] getDuel() {
		return duel;
	}
	
	public void initDuel() {
		duel = new int[2][3];
	}

	public List<int[]> getDeathmatch() {
		return deathmatch;
	}
	
	public void initDeathmatch() {
		deathmatch = new LinkedList<>();
	}

	public List<int[]> getOneForAll() {
		return one_for_all;
	}
	
	public void initOneForAll() {
		one_for_all = new LinkedList<>();
	}

	public TeamedConfiguration getSlaughter() {
		return slaughter;
	}
	
	public void initSlaughter() {
		slaughter = new TeamedConfiguration();
	}

	public TeamedConfiguration getSkirmish() {
		return skirmish;
	}
	
	public void initSkirmish() {
		skirmish = new TeamedConfiguration();
	}
	
}