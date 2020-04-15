package com.gmail.justbru00.epic.randombuilders.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;
import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.game.GameState;
import com.gmail.justbru00.epic.randombuilders.teams.TeamManager;
import com.gmail.justbru00.epic.randombuilders.vote.VoteManager;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class OnJoinAndLeaveListener implements Listener {
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		VoteManager.removeBuild(e.getPlayer(), true);
		TeamManager.playerLeft(e.getPlayer());
		if (Bukkit.getOnlinePlayers().size() - 1 < GameManager.getMinPlayers()) {
			GameManager.setCurrentState(GameState.RESET);
			Messager.sendTitleToAll("&cThere is not enough players", "");
		}
	}
	
	@EventHandler
	public void preJoinevent(PlayerLoginEvent e) {
		if (Bukkit.getOnlinePlayers().size() > GameManager.getMaxPlayers()) {
			e.disallow(Result.KICK_FULL, Messager.color("&cSorry this server is full. Please wait until there are less than " + GameManager.getMaxPlayers() + " players online."));
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.getPlayer().teleport(GameManager.LOBBY);
		e.getPlayer().getInventory().clear();
		e.getPlayer().setGameMode(GameMode.SURVIVAL);
		
		if (GameManager.getCurrentState().equals(GameState.WAIT) || GameManager.getCurrentState().equals(GameState.STARTINGSOON)) { // Not During a game
			e.getPlayer().setGameMode(GameMode.SURVIVAL);
		} else {
			e.getPlayer().setGameMode(GameMode.SPECTATOR);
			Messager.sendTitle("&6The game is in progress", "&7You will join next round", e.getPlayer());			
		}
	}
	
}
