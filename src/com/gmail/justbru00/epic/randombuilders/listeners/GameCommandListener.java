package com.gmail.justbru00.epic.randombuilders.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.game.GameAutoStartManager;
import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.game.GameState;
import com.gmail.justbru00.epic.randombuilders.gui.GameCommandGUI;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class GameCommandListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		if (e.getView().getTitle().equals(GameCommandGUI.getInstance().getName())) {
			
			e.setCancelled(true);
			
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getType().equals(Material.EMERALD_BLOCK)) {
					GameManager.setCurrentState(GameState.STARTUP);
					Messager.msgPlayer("&aGame started.", (Player) e.getWhoClicked(), "default");
				} else if (e.getCurrentItem().getType().equals(Material.REDSTONE_BLOCK)) {
					GameManager.setCurrentState(GameState.RESET);
					Messager.msgPlayer("&cGame stopped.", (Player) e.getWhoClicked(), "default");
				} else if (e.getCurrentItem().getType().equals(Material.CLOCK)) {
					// TODO open time set gui
					Messager.msgPlayer("&cThe countdown clock cannot be set at this time.", (Player) e.getWhoClicked(), "default");
				} else if (e.getCurrentItem().getType().equals(Material.ANVIL)) {
					// TODO topic selection. (via anvil gui?)
					Messager.msgPlayer("&cThe name of the spacecraft is not editable at this time.", (Player) e.getWhoClicked(), "default");
				} else if (e.getCurrentItem().getType().equals(Material.COMPARATOR)) {
					if (GameAutoStartManager.isAutoStartEnabled()) {
						GameAutoStartManager.setAutoStartEnabled(false);
						if (GameManager.getCurrentState().equals(GameState.STARTINGSOON)) {
							GameManager.setCurrentState(GameState.WAIT);
						}
						Messager.msgPlayer("&6Game auto toggled &coff&6.", (Player) e.getWhoClicked(), "default");
					} else {
						GameAutoStartManager.setAutoStartEnabled(true);
						Messager.msgPlayer("&6Game auto toggled &aon&6.", (Player) e.getWhoClicked(), "default");
					}
					
				}
			}
		}
		
	}
	
}
