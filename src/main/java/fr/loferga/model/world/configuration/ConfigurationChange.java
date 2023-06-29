package fr.loferga.model.world.configuration;

import net.minecraft.util.math.BlockPos;

public class ConfigurationChange {
	
	private boolean remove;
	private String path;
	private int[] newValue;
	
	ConfigurationChange(boolean remove, String path, BlockPos pos) {
		this.remove = remove;
		this.path = path;
		newValue = new int[] {pos.getX(), pos.getY(), pos.getZ()};
	}
	
}