package com.gmail.justbru00.epic.randombuilders.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.gmail.justbru00.epic.randombuilders.game.GameManager;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class GeneralListeners implements Listener {

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		e.setRespawnLocation(GameManager.LOBBY);
	}
	
	@EventHandler
	public void onHunger(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(20);
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntityType().equals(EntityType.PLAYER)) {
			if (e.getCause().equals(DamageCause.FALL) || e.getCause().equals(DamageCause.SUFFOCATION)) {
				e.setCancelled(true);
			}
		}
	}
	
}
