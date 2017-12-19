package com.gmail.justbru00.epic.randombuilders.vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.game.GameState;
import com.gmail.justbru00.epic.randombuilders.main.Main;
import com.gmail.justbru00.epic.randombuilders.teams.TeamManager;
import com.gmail.justbru00.epic.randombuilders.utils.ItemBuilder;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class VoteManager {
	
	public static ArrayList<VoteManagerBuild> buildAreas = new ArrayList<VoteManagerBuild>();
	public static boolean inVotingMode = false;
	private static int timePerPlayer = 15;
	private static int counter = 0;
	private static int currentPlayer = -1;
	private static HashMap<UUID, Integer> votes = new HashMap<UUID, Integer>();
	public static ItemStack VOTE_0 = new ItemBuilder(Material.CONCRETE).setDataValue(14).setName("&c&lHorrible").build();
	public static ItemStack VOTE_1 = new ItemBuilder(Material.CONCRETE).setDataValue(1).setName("&6&lIrksome").build();
	public static ItemStack VOTE_2 = new ItemBuilder(Material.CONCRETE).setDataValue(4).setName("&e&lOkayish").build();
	public static ItemStack VOTE_3 = new ItemBuilder(Material.CONCRETE).setDataValue(5).setName("&a&lGood").build();
	public static ItemStack VOTE_4 = new ItemBuilder(Material.CONCRETE).setDataValue(13).setName("&2&lVery Good").build();
	public static ItemStack VOTE_5 = new ItemBuilder(Material.CONCRETE).setDataValue(3).setName("&b&lEpic").build();

	/**
	 * Records where this players building area is because we need to know for the teleporting later
	 * @param p
	 * @param spawnLocation
	 */
	public static void addBuild(Player p, Location spawnLocation) {
		buildAreas.add(new VoteManagerBuild(p.getUniqueId(), spawnLocation));
	}
	
	/**
	 * Removes a players build area from the ArrayList. Used on leave mostly
	 * @param p
	 * @param fromServerDisconnect If a message should be sent or not.
	 */
	public static void removeBuild(Player p, boolean fromServerDisconnect) {
		if (fromServerDisconnect) {
			if (GameManager.getCurrentState().equals(GameState.BUILD)) {
				Messager.sendTitleToAll("&6" + p.getName() + " left", "&7Their build has been removed");
			}
		} 
		
		for (VoteManagerBuild v : buildAreas) {
			if (v.getPlayer().getUniqueId().equals(p.getUniqueId())) {
				buildAreas.remove(v);
				break;
			}
		}
	}
	
	public static void addVote(int amount, Player p) {
		// DONE Make sure counter is not too low (below/= 3)| Put all votes in a HashMap of players with the vote they made
		if (counter > 3) {
			if (!p.getGameMode().equals(GameMode.SPECTATOR)) {
				if (p.getUniqueId().equals(getCurrentPlayer().getPlayer().getUniqueId())) {
					Messager.sendTitle("", "&cYou cannot vote for yourself!", p);
				} else {
					votes.put(p.getUniqueId(), amount);
					Messager.sendTitle("", "&aVote counted", p);
				}
			} else {
				Messager.msgPlayer("&cSorry you cannot vote as a spectator.", p, "game");
			}
		} else {
			Messager.msgPlayer("&cToo late to vote.", p, "game");
			return;
		}
	}
	
	public static Player announceWinner() {
		VoteManagerBuild top = new VoteManagerBuild(UUID.fromString("0b430b72-b024-46cb-9952-be930d6d5639"), new Location(Bukkit.getWorld("world"), 0, 0, 0));
		top.setCurrentVoteScore(-1);
		
		for (VoteManagerBuild v : buildAreas) {
			if (top.getCurrentVoteScore() < v.getCurrentVoteScore()) {
				top = v;
			}
		}
		
		Messager.sendTitleToAll("&a" + top.getPlayer().getName() + " won", "&7with a score of " + top.getCurrentVoteScore());
		
		Messager.sendBC("&6Winner: " + top.getPlayer().getName() + " -> " + top.getCurrentVoteScore());
		
		Messager.sendBC("&7All scores:");
		for (VoteManagerBuild build : buildAreas) {
			Messager.sendBC("&6" + build.getPlayer().getName() + " -> " + build.getCurrentVoteScore());
		}
		
		return top.getPlayer();
	}
	
	public static VoteManagerBuild getCurrentPlayer() {
		if (currentPlayer != -1) {
			return VoteManager.buildAreas.get(currentPlayer);
		} 
		return null;
	}
	
	public static void init() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				if (VoteManager.inVotingMode) {
					if (counter == 0) {
						if (TeamManager.getAmount() - 1 <= currentPlayer) {
							if (currentPlayer != -1) { // Last player
								// Record votes for this person 
								int total = 0;
								for (int i : votes.values()) {									
									total = total + i;
								}
								getCurrentPlayer().setCurrentVoteScore(total);
								votes.clear();
							}
							// Voting done
							GameManager.setCurrentState(GameState.ENDING);
							currentPlayer = -1;
							counter = 0;
							inVotingMode = false;
						} else {
							if (currentPlayer != -1) {
								// Record votes for this person 
								int total = 0;
								for (int i : votes.values()) {									
									total = total + i;
								}
								getCurrentPlayer().setCurrentVoteScore(total);
								votes.clear();
							}
							
							// Next person		
							currentPlayer = currentPlayer + 1;
							counter = timePerPlayer;
							
							for (Player p : Bukkit.getOnlinePlayers()) {
								Location loc = VoteManager.buildAreas.get(currentPlayer).getBuildAreaSpawn().clone();
								p.teleport(loc.add(0, 11, 0));		// .add(0, 11, 0)							
							}
							
							for (Player p : Bukkit.getOnlinePlayers()) {
								p.setAllowFlight(true);					
								p.setFlying(true);
							}
							
							Messager.sendBC("&6Vote for this build.");
						}
					} else {
						counter = counter - 1;
						if (currentPlayer != -1 && counter == 3) {
							Messager.sendTitleToAll("", "&f&oCreated by " + buildAreas.get(currentPlayer).getPlayer().getName());
						}
					}
				}								
			}
		}, 20, 20*1);
	}
	
	public static void voteOnAllBuilds() { // 15 seconds per build 0-5 voting score
		for (Player p : Bukkit.getOnlinePlayers()) {
			Inventory i = p.getInventory();
			i.clear();
			i.setItem(0, VOTE_0);
			i.setItem(1, VOTE_1);
			i.setItem(2, VOTE_2);
			i.setItem(3, VOTE_3);
			i.setItem(4, VOTE_4);
			i.setItem(5, VOTE_5);
		}
		inVotingMode = true;
	}
	
}
