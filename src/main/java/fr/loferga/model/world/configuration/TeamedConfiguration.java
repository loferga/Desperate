package fr.loferga.model.world.configuration;

import java.util.List;

public class TeamedConfiguration {
	
	private List<int[]> first_team;
	private List<int[]> second_team;
	private int[] flag_position;
	
	public List<int[]> getFirstTeam() {
		return first_team;
	}
	
	public void setFirst_team(int[] location) {
		this.first_team.add(location);
	}
	
	public List<int[]> getSecondTeam() {
		return second_team;
	}
	
	public void setSecond_team(int[] location) {
		this.second_team.add(location);
	}
	
	public int[] getFlagPosition() {
		return flag_position;
	}
	
	public void setFlagPosition(int[] location) {
		this.flag_position = location;
	}
	
}