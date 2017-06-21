package com.gmail.justbru00.epic.randombuilders.game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;

public class GameAutoStartManager {

	private static boolean autoStartEnabled = true;
	
	public static void setAutoStartEnabled(boolean b) {
		autoStartEnabled = b;
	}
	
	public static boolean isAutoStartEnabled() {
		return autoStartEnabled;
	}
	
	/**
	 * Should be run every second
	 */
	public static void checkAutoStart() {
		if (!autoStartEnabled) {
			return;
		}
		if (GameManager.getCurrentState().equals(GameState.WAIT)) {
			if(Bukkit.getOnlinePlayers().size() >= GameManager.getMinPlayers()) {
				GameManager.setCurrentState(GameState.STARTINGSOON);
				return;
			} 
		} else if (GameManager.getCurrentState().equals(GameState.STARTINGSOON)) {
			if (Bukkit.getOnlinePlayers().size() < GameManager.getMinPlayers()) {				
					GameManager.setCurrentState(GameState.WAIT);	
					for (Player p : Bukkit.getOnlinePlayers()) {
						Messager.msgPlayer("&cGame is waiting for more players.", p, "game");
					}
					Messager.msgConsole("&cGame is waiting for more players.");
					return;				
			} else {
				return;
			}
		} else {
			return;
		}
	}
	
}
