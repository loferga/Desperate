package fr.loferga.model.world.configuration;

import java.util.LinkedList;
import java.util.List;

public class TeamedConfiguration {
	
	private LinkedList<int[]> first_team;
	private LinkedList<int[]> second_team;
	
	private TeamedConfiguration() {}
	
	public List<int[]> getFirstTeam() {
		return first_team;
	}
	
	public List<int[]> getSecondTeam() {
		return second_team;
	}
	
}