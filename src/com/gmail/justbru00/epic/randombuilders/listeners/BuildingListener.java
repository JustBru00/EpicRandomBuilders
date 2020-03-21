package com.gmail.justbru00.epic.randombuilders.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.map.MapManager;
import com.gmail.justbru00.epic.randombuilders.utils.BuildingManager;
import com.gmail.justbru00.epic.randombuilders.utils.ItemBuilder;

/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class BuildingListener implements Listener {
	
	@EventHandler
	public void onEntityChangeBlockEvent(EntityChangeBlockEvent event) {
	    if (event.getEntityType() == EntityType.FALLING_BLOCK) {
	       BuildingManager.addBlock(event.getBlock().getLocation());	        
	    }
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockDamage(BlockDamageEvent e) {
		if (BuildingManager.canBreak()) {
			if (BuildingManager.checkBlock(e.getBlock().getLocation())) {				
				e.setCancelled(false);
				e.getPlayer().getInventory().addItem(new ItemBuilder(e.getBlock().getType()).setDataValue(e.getBlock().getData()).build());
				e.getBlock().setType(Material.AIR);
				Messager.sendActionBar("&aBlock added to inventory", e.getPlayer());
			}
		} else if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
			
		} else {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		if (BuildingManager.canBreak()) {
			if (BuildingManager.checkBlock(e.getBlock().getLocation())) {
				// Make sure this works with fancy breaking
			} else {
				if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
					// uhhh stuff?
				} else {
					e.setCancelled(true);
					Messager.msgPlayer("&cThis block is protected.", e.getPlayer(), "game");
				}
			}
		} else {
			if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
				// uhhh stuff?
			} else {
				e.setCancelled(true);
			}
		}		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
			return;
		} else if (BuildingManager.canPlace()) {
			if (MapManager.getCurrentMap().isInsideArea(e.getBlock().getLocation())) {
				BuildingManager.addBlock(e.getBlock().getLocation());
			} else {
				e.setCancelled(true);			
				Messager.msgPlayer("&cThat is outside your area", e.getPlayer(), "game");
				return;
			}
		} else {
			if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
				// uhhhh stuff?
			}
		}
	}
	
}
