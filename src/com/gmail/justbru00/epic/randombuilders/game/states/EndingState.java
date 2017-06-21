package com.gmail.justbru00.epic.randombuilders.game.states;

import org.bukkit.Bukkit;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.game.GameState;
import com.gmail.justbru00.epic.randombuilders.main.Main;
import com.gmail.justbru00.epic.randombuilders.vote.VoteManager;

public class EndingState extends BasicState {

	public EndingState() {
		super(GameState.ENDING, 10);
	}
	
	@Override
	public void codeOnStart() {
		
		/*
		 * Announce winner from VoteManager, teleport to the winners build, display all scores in chat have delayed title say thanks for playing at 2 seconds till lobby.
		 */
		
		VoteManager.announceWinner();
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				Messager.sendTitleToAll("&aThanks for playing", "&7&oGame created by JustBru00");
				
			}
		}, 20*8);

	}

	@Override
	public void codeOnFinish() {
		
		// GOTO ResetState
		GameManager.setCurrentState(GameState.RESET);
	}

}
