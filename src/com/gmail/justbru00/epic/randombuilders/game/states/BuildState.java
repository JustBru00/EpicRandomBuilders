package com.gmail.justbru00.epic.randombuilders.game.states;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.game.GameState;
import com.gmail.justbru00.epic.randombuilders.utils.BuildingManager;
import com.gmail.justbru00.epic.randombuilders.utils.RandomItemGiver;

public class BuildState extends BasicState {

	public BuildState() {
		super(GameState.BUILD, 300);
	}
	
	@Override
	public void codeOnStart() {

		/*
		 * Give players the items, update scoreboard to show the topic, allow building, enable block place logging (for the quick break feature and reset)
		 * Display timer on the scoreboard display name.
		 */
		
		RandomItemGiver.giveRandomItemsToAll();
		
		BuildingManager.setCanBreak(true);
		BuildingManager.setCanPlace(true);
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.setAllowFlight(true);
		}

	}

	@Override
	public void codeOnFinish() {
		
		GameManager.setCurrentState(GameState.VOTE);
		
	}

}
