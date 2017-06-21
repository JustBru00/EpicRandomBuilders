package com.gmail.justbru00.epic.randombuilders.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.justbru00.epic.randombuilders.vote.VoteManager;

public class VoteListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {

		if (e.getItem() != null) {
			if (e.getItem().getType() != Material.AIR) {
				if (e.getItem().hasItemMeta()) {
					if (e.getItem().getItemMeta().hasDisplayName()) {
						if (e.getItem().getItemMeta().getDisplayName()
								.equals(VoteManager.VOTE_0.getItemMeta().getDisplayName())) {
							VoteManager.addVote(0, e.getPlayer());
						} else if (e.getItem().getItemMeta().getDisplayName()
								.equals(VoteManager.VOTE_1.getItemMeta().getDisplayName())) {
							VoteManager.addVote(1, e.getPlayer());
						} else if (e.getItem().getItemMeta().getDisplayName()
								.equals(VoteManager.VOTE_2.getItemMeta().getDisplayName())) {
							VoteManager.addVote(2, e.getPlayer());
						} else if (e.getItem().getItemMeta().getDisplayName()
								.equals(VoteManager.VOTE_3.getItemMeta().getDisplayName())) {
							VoteManager.addVote(3, e.getPlayer());
						} else if (e.getItem().getItemMeta().getDisplayName()
								.equals(VoteManager.VOTE_4.getItemMeta().getDisplayName())) {
							VoteManager.addVote(4, e.getPlayer());
						} else if (e.getItem().getItemMeta().getDisplayName()
								.equals(VoteManager.VOTE_5.getItemMeta().getDisplayName())) {
							VoteManager.addVote(5, e.getPlayer());
						}
					}
				}
			}
		}

	}

}
