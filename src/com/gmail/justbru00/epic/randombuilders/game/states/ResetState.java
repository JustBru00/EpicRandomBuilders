package com.gmail.justbru00.epic.randombuilders.game.states;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.game.GameState;
import com.gmail.justbru00.epic.randombuilders.utils.BuildingManager;
import com.gmail.justbru00.epic.randombuilders.vote.VoteManager;

public class ResetState extends BasicState {

	public ResetState() {
		super(GameState.RESET, 0);		
	}

	@Override
	public void codeOnStart() {

		/*
		 * Reset building areas with the blocks placed list, teleport all players to the lobby, reset the VoteManager, 
		 * 
		 */
		BuildingManager.resetPlacedBlocks();
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.teleport(GameManager.LOBBY);
			p.getInventory().clear();
			p.setAllowFlight(false);
			p.setFlying(false);
			p.setGameMode(GameMode.SURVIVAL);
		}
		
		for (Entity e : Bukkit.getWorld("world").getEntities()) {
			if (e.getType().equals(EntityType.DROPPED_ITEM)) {
				e.remove();
			}
		}
		
		VoteManager.buildAreas.clear();
		VoteManager.inVotingMode = false;

	}

	@Override
	public void codeOnFinish() {
		
		GameManager.setCurrentState(GameState.WAIT);
		
	}

}
