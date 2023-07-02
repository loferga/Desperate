package fr.loferga.model;

import java.util.ArrayList;
import java.util.List;

import fr.loferga.model.world.DesperateMap;
import net.minecraft.entity.player.PlayerEntity;

public class Game {
	
	public GameState state;
	
	private DesperateMap map;
	private List<PlayerEntity> players;
	
	public Game(DesperateMap map) {
		//if (map.isLoaded()) map.load();
		state = GameState.WAITING;
		players = new ArrayList<>();
	}
	
	public void join(PlayerEntity p) {
		players.add(p);
		// teleport Player to lobby
	}
	
}