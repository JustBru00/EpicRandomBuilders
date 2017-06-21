package com.gmail.justbru00.epic.randombuilders.utils;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;

import com.gmail.justbru00.epic.randombuilders.map.MapManager;

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
	}
	
	public static boolean checkBlock(Location loc) {
		return placedBlocks.contains(loc);
	}
	
	public static void resetPlacedBlocks() {
		for (Location loc : placedBlocks) {
			setBlock(Material.AIR, loc);
		}
		placedBlocks = new ArrayList<Location>();
	}
	
	public static void setBlock(Material m, Location l) {
		BlockState a = MapManager.getCurrentMap().getWorld().getBlockAt(l).getState();
		a.setType(m);
		a.update(true);
	}
	
}
