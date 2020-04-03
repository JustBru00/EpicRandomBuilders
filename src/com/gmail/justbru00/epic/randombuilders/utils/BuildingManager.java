package com.gmail.justbru00.epic.randombuilders.utils;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.map.MapManager;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class BuildingManager {

	private static boolean canBreak = false;
	private static boolean canPlace = false;
	private static ArrayList<Location> placedBlocks = new ArrayList<Location>();
	
	public static boolean canBreak() {
		return canBreak;
	}
	
	public static boolean canPlace() {
		return canPlace;
	}
	
	public static void setCanBreak(boolean value) {
		canBreak = value;
	}
	
	public static void setCanPlace(boolean value) {
		canPlace = value;
	}
	
	public static void addBlock(Location loc) {
		placedBlocks.add(loc);
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.getUniqueId().equals(UUID.fromString("28f9bb08-b33c-4a7d-b098-ebf271383966"))) {
				Messager.msgPlayer("&aBlock placed: " + loc, p);
			}
		}
	}
	
	public static boolean checkBlock(Location loc) {
		return placedBlocks.contains(loc);
	}
	
	public static void resetPlacedBlocks() {
		for (Location loc : placedBlocks) {
			setBlock(Material.AIR, loc);
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (p.getUniqueId().equals(UUID.fromString("28f9bb08-b33c-4a7d-b098-ebf271383966"))) {
					Messager.msgPlayer("&aBlock reset: " + loc, p);
				}
			}
		}
		placedBlocks = new ArrayList<Location>();
	}
	
	public static void setBlock(Material m, Location l) {
		BlockState a = MapManager.getCurrentMap().getWorld().getBlockAt(l).getState();
		a.setType(m);
		a.update(true);
	}
	
}
