package fr.loferga.model.world.configuration;

import java.util.List;

public class Configuration {
	
	private List<int[]> amnesia;
	
	private int[][] duel;
	
	private List<int[]> deathmatch;
	
	private List<int[]> one_for_all;
	
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
	
	// ### for debug use only
	private String toString(List<int[]> list) {
		if (list == null) return "";
		StringBuilder str = new StringBuilder();
		list.forEach(e -> str.append("\n\t[" + e[0] + ", " + e[1] + ", " + e[2] + ']'));
		return str.toString();
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\namnesia:");
		str.append(toString(amnesia));
		str.append("\nduel:");
		if (duel != null) for (int[] e : duel) str.append("\n\t[" + e[0] + ", " + e[1] + ", " + e[2] + ']');
		str.append("\ndeathmatch:");
		str.append(toString(deathmatch));
		str.append("\none_for_all:");
		str.append(toString(one_for_all));
		str.append("\nslaughter:");
		if (slaughter!=null) str.append(slaughter.toString());
		str.append("\nskirmish:");
		if (skirmish!=null) str.append(skirmish.toString());
		return str.toString();
	}
	// ###
}