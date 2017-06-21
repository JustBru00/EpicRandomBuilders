package com.gmail.justbru00.epic.randombuilders.game;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.gmail.justbru00.epic.randombuilders.game.states.*;
import com.gmail.justbru00.epic.randombuilders.main.Main;
import com.gmail.justbru00.epic.randombuilders.scoreboard.EpicScoreBoard;
import com.gmail.justbru00.epic.randombuilders.utils.TopicManager;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class GameManager {

	private static BasicState currentState;
	private static int min_players;
	private static int max_players;
	private static int timer = 0;
	private static HashMap<GameState, BasicState> states = new HashMap<GameState, BasicState>();
	public static final Location LOBBY = new Location(Bukkit.getWorld("world"), 0, 4, 0, 180, -10);
	private static EpicScoreBoard epicboard;
	
	public static GameState getCurrentState() {
		return currentState.getState();
	}
	
	/**
	 * Use for settings the current state. Time and starting code is run automaticly.
	 * @param g The game state you want to set to.
	 */
	public static void setCurrentState(GameState g) {		
		currentState = states.get(g);		
		currentState.codeOnStart();		
		timer = currentState.getTimeForState();
	}
	
	public static void everySecond() {		
		if (timer != 0) {
			timer--;
		} else {
			currentState.codeOnFinish();
		}
		updateDisplays();
		GameAutoStartManager.checkAutoStart();
	}
	
	public static void updateDisplays() {
		
		GameManager.getEpicBoard().setTitle(getTimeLeftFormated());
		
		GameManager.getEpicBoard().setLine(0, "&d");		
		
		if (getCurrentState().equals(GameState.BUILD) || getCurrentState().equals(GameState.VOTE)) {
			GameManager.getEpicBoard().setLine(1, "&6Topic:");
			GameManager.getEpicBoard().setLine(2, "&5" + TopicManager.getCurrentTopic()); 
		} else {
			GameManager.getEpicBoard().setLine(1, "&6");
			GameManager.getEpicBoard().setLine(2, "&5"); 
		}
		
		
		GameManager.getEpicBoard().setLine(3, "&e");	
		GameManager.getEpicBoard().setLine(4, "&bEpic&fRealm");
		GameManager.getEpicBoard().setLine(5, "&6" + Main.getVersion());
		
		GameManager.getEpicBoard().updateScoreboard();
	}
	
	public static String getTimeLeftFormated() {
		if (timer == 0) {
			return "&bEpic&fRandomBuilders";
		}

		// int hours;
		int mins;
		int seconds;
		// hours = (counter % 86400 ) / 3600 ;
		mins = ((timer % 86400) % 3600) / 60;
		seconds = ((timer % 86400) % 3600) % 60;

		if (seconds <= 9) {
			return "&6Time Left: " + mins + ":0" + seconds;
		} else {		
			return "&6Time Left: " + mins + ":" + seconds;
		}
	}
	
	public static void setTimer(int seconds) {
		timer = seconds;
	}
	
	public static int getMinPlayers() {
		return min_players;
	}
	
	public static int getMaxPlayers() {
		return max_players;
	}
	
	public static EpicScoreBoard getEpicBoard()	 {
		return epicboard;
	}
	
	public static void setEpicBoard(EpicScoreBoard e) {
		epicboard = e;
	}
	
	public static void initStates() {
		states.put(GameState.WAIT, new WaitState());
		states.put(GameState.STARTINGSOON, new StartingSoonState());
		states.put(GameState.STARTUP, new StartupState());
		states.put(GameState.INSTRUCTIONS, new InstructionsState());
		states.put(GameState.BUILD, new BuildState());
		states.put(GameState.VOTE, new VoteState());
		states.put(GameState.ENDING, new EndingState());
		states.put(GameState.RESET, new ResetState());
		GameManager.setCurrentState(GameState.WAIT);	
		min_players = Main.getInstance().getConfig().getInt("game.min_players");
		max_players = Main.getInstance().getConfig().getInt("game.max_players");
	}
	
}
