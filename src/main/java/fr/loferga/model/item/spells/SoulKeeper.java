package fr.loferga.model.item.spells;

import fr.loferga.model.item.TriggerItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

public class SoulKeeper extends Item implements TriggerItem {

	public SoulKeeper(Settings settings) {
		super(settings);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void fire(PlayerEntity p) {
		// create a DoT area around player
	}
	
}