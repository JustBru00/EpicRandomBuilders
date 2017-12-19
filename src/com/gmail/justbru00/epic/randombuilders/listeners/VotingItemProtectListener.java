package com.gmail.justbru00.epic.randombuilders.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import com.gmail.justbru00.epic.randombuilders.vote.VoteManager;

public class VotingItemProtectListener implements Listener{

	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (VoteManager.inVotingMode) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		if (VoteManager.inVotingMode) {
			e.setCancelled(true);
		}
	}
	
}
