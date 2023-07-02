package fr.loferga.model.item.weapons;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class CustomSword extends HoeItem {
	
	private static final int ATTACK_DAMAGE = 3;
	private static final float ATTACK_SPEED = 1.2f;

	public CustomSword(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(material, ATTACK_DAMAGE, ATTACK_SPEED, settings);
	}
	
	// reverse knockback
	
}