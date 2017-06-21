package com.gmail.justbru00.epic.randombuilders.game.states;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.game.GameState;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class StartingSoonState extends BasicState {

	public StartingSoonState() {
		super(GameState.STARTINGSOON, 20);
	}

	@Override
	public void codeOnStart() {
		
		// Set to this state by GameAutoStartManager
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			Messager.msgPlayer("&aGame starting in 20 seconds.", p, "game");
		}
		Messager.msgConsole("&aGame has been set to GameState.STARTINGSOON");
		
		// Nothing else				
	}

	@Override
	public void codeOnFinish() {
		// If this code is run it is okay to start.
		if(Bukkit.getOnlinePlayers().size() >= GameManager.getMinPlayers()) { // Double checking. This really should never happen.
			GameManager.setCurrentState(GameState.STARTUP);
		} else {
			GameManager.setCurrentState(GameState.WAIT);			
			for (Player p : Bukkit.getOnlinePlayers()) {
				Messager.msgPlayer("&cGame is waiting for more players.", p, "game");
			}
			Messager.msgConsole("&cGame is waiting for more players. (StartingSoonState.class#codeOnFinish())");
		}
	}
	
}
