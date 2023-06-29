package fr.loferga.model.world.configuration;

public class Configuration {
	
	private int[][] amnesia;
	
	private int[][] duel;
	
	private int[][] deathmatch;
	
	private int[][] one_for_all;
	
	private TeamConfiguration slaughter;
	
	private TeamConfiguration skirmish;

	public int[][] getAmnesia() {
		return amnesia;
	}

	public void setAmnesia(int[][] amnesia) {
		this.amnesia = amnesia;
	}

	public int[][] getDuel() {
		return duel;
	}

	public void setDuel(int[][] duel) {
		this.duel = duel;
	}

	public int[][] getDeathmatch() {
		return deathmatch;
	}

	public void setDeathmatch(int[][] deathmatch) {
		this.deathmatch = deathmatch;
	}

	public int[][] getOneForAll() {
		return one_for_all;
	}

	public void setOneForAll(int[][] oneForAll) {
		this.one_for_all = oneForAll;
	}

	public TeamConfiguration getSlaughter() {
		return slaughter;
	}

	public void setSlaughter(TeamConfiguration slaughter) {
		this.slaughter = slaughter;
	}

	public TeamConfiguration getSkirmish() {
		return skirmish;
	}

	public void setSkirmish(TeamConfiguration skirmish) {
		this.skirmish = skirmish;
	}
	
}