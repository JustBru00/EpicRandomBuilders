package com.gmail.justbru00.epic.randombuilders.teams;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class TeamManager {

	private static EpicTeam gamePlayers = new EpicTeam("gameplayers", ChatColor.GOLD);
	
	/**
	 * Call when the game is in startup
	 */
	public static void gameStarting() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			gamePlayers.addPlayer(p);
		}
		gamePlayers.update(true);
	}
	
	public static int getAmount() {
		return gamePlayers.getPlayers().size();
	}
	
	public static void reset() {
		ArrayList<String> temp = gamePlayers.getPlayers();
		temp.clear();
		gamePlayers.setPlayers(temp);
		gamePlayers.update(false);
	}
	
	public static void playerLeft(Player p) {
		gamePlayers.removePlayer(p);
		gamePlayers.update(false);
	}
	
}
