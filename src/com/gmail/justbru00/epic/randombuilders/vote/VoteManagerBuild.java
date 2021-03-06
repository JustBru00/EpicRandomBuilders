package com.gmail.justbru00.epic.randombuilders.vote;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class VoteManagerBuild {

	private UUID player;
	private Location buildAreaSpawn;
	private int currentVoteScore = 0;
	
	
	public VoteManagerBuild(UUID playerUUID, Location _buildAreaSpawn) {
		player = playerUUID;
		buildAreaSpawn = _buildAreaSpawn;
	}


	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return Bukkit.getPlayer(player);
	}


	/**
	 * @param player the player to set
	 */
	public void setPlayer(UUID player) {
		this.player = player;
	}


	/**
	 * @return the buildAreaSpawn
	 */
	public Location getBuildAreaSpawn() {
		return buildAreaSpawn;
	}


	/**
	 * @param buildAreaSpawn the buildAreaSpawn to set
	 */
	public void setBuildAreaSpawn(Location buildAreaSpawn) {
		this.buildAreaSpawn = buildAreaSpawn;
	}


	/**
	 * @return the currentVoteScore
	 */
	public int getCurrentVoteScore() {
		return currentVoteScore;
	}


	/**
	 * @param currentVoteScore the currentVoteScore to set
	 */
	public void setCurrentVoteScore(int currentVoteScore) {
		this.currentVoteScore = currentVoteScore;
	}
	
	public void addToCurrentVoteScore(int amount) {
		currentVoteScore = currentVoteScore + amount;
	}
	
	
}
