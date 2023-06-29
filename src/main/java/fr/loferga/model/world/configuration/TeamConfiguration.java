package fr.loferga.model.world.configuration;

public class TeamConfiguration {
	
	private int[][] first_team;
	private int[][] second_team;
	private int[] flag_position;
	
	public int[][] getFirst_team() {
		return first_team;
	}
	
	public void setFirst_team(int[][] first_team) {
		this.first_team = first_team;
	}
	
	public int[][] getSecond_team() {
		return second_team;
	}
	
	public void setSecond_team(int[][] second_team) {
		this.second_team = second_team;
	}
	
	public int[] getFlag_position() {
		return flag_position;
	}
	
	public void setFlag_position(int[] flag_position) {
		this.flag_position = flag_position;
	}
	
}