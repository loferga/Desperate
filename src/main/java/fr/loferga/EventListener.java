package fr.loferga;

import java.util.Set;

import fr.loferga.model.world.MapRegistry;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;

public class EventListener {
	
	public static void init() {
		UseItemCallback.EVENT.register((player, world, hand) -> {
			DesperateMod.LOGGER.info(player.getEntityName() + " used an item");
			player.teleport(MapRegistry.findMap("test").orElseThrow().getWorld(), 0.5, 75.0, 0.5, Set.of(), 0.0f, 0.0f);
			return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, player.getMainHandStack());
		});
	}
	
}