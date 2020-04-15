package com.gmail.justbru00.epic.randombuilders.game.states;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.game.GameState;
import com.gmail.justbru00.epic.randombuilders.map.MapManager;
import com.gmail.justbru00.epic.randombuilders.teams.TeamManager;
import com.gmail.justbru00.epic.randombuilders.utils.TopicManager;
import com.gmail.justbru00.epic.randombuilders.vote.VoteManager;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class StartupState extends BasicState {

	public StartupState() {
		super(GameState.STARTUP, 0);
	}

	@Override
	public void codeOnStart() {
		
		/* Run all startup stuff here
		 *  Teleport players, set to the players team, choose topic, choose map?, 
		 *  Set to Instructions after this.
		 */
		
		// TODO Choose map
		
		if (MapManager.getCurrentMap().getSpawnLocations().size() < Bukkit.getOnlinePlayers().size()) { // Make sure every player can have an arena
			Messager.sendTitleToAll("&cIt appears JustBru00", "&cMessed up on the map spawns");
			Messager.sendBC("&8[&cERROR&8] &cToo many players for the current map (" + MapManager.getCurrentMap().getName() + "). " + getClass().getName() + ".codeOnStart()");
		}
		
		// Startup
		
		
		int current = 0;
		// Teleport players and tell vote manager where each player is
		for (Player p : Bukkit.getOnlinePlayers()) {
			// TODO TeamManager game team stuffz
			VoteManager.addBuild(p, MapManager.getCurrentMap().getSpawnLocations().get(current));
			p.teleport(MapManager.getCurrentMap().getSpawnLocations().get(current));
			current++;
		}
		
		// -> Announce during INSTRUCTIONS
		TopicManager.chooseRandomTopic();		
		
		TeamManager.gameStarting();
	}

	@Override
	public void codeOnFinish() {
		GameManager.setCurrentState(GameState.INSTRUCTIONS);		
	}	
	
}
