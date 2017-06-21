package com.gmail.justbru00.epic.randombuilders.game.states;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.game.GameState;

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
