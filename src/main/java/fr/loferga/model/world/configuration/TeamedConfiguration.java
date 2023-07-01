package fr.loferga.model.world.configuration;

import java.util.List;

public class TeamedConfiguration {
	
	private List<int[]> first_team;
	private List<int[]> second_team;
	
	private TeamedConfiguration() {}
	
	public List<int[]> getFirstTeam() {
		return first_team;
	}
	
	public List<int[]> getSecondTeam() {
		return second_team;
	}
	
	// ### for debug use only
	private String toString(List<int[]> list) {
		if (list == null) return "";
		StringBuilder str = new StringBuilder();
		list.forEach(e -> str.append("\n\t\t[" + e[0] + ", " + e[1] + ", " + e[2] + ']'));
		return str.toString();
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\tfirst_team:");
		str.append(toString(first_team));
		str.append("\tsecond_team:");
		str.append(toString(second_team));
		return str.toString();
	}
	// ###
	
}