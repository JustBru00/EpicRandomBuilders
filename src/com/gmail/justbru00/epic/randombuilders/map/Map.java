package com.gmail.justbru00.epic.randombuilders.map;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;


/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class Map {

	private String mapName = "Unset Name";
	private String worldName = "world";
	private ArrayList<Location> spawnLocations = new ArrayList<Location>(); // Must be north west center corner	
	
	public Map(String name, String world) {
		mapName = name;
		worldName = world;
	}
	
	public void addSpawnLoc(Location l) {
		spawnLocations.add(l);
	}
	
	public boolean isInsideArea(Location l) {
		
		for (Location loc : spawnLocations) {
			
			double max_x = 0;
			double max_z = 0;
			double max_y = 0;
			double min_x = 0;
			double min_y = 0;
			double min_z = 0;
			
			max_x = loc.getX() + 14; // Towards pos x
			max_z = loc.getZ() + 14; // Towards pos z
			
			min_x = loc.getX() - 14; // Towards neg x 
			min_z = loc.getZ() - 14; // Towards neg z
			
			min_y = loc.getY();
			max_y = loc.getY() + 15;
			
			if (max_x >= l.getX() && min_x <= l.getX()) { // Inside x
				if (max_z >= l.getZ() && min_z <= l.getZ()) { // Inside z
					if (max_y >= l.getY() && min_y <= l.getY()) { // Inside y
						return true;
					}
				}
			}			
		}
		
		return false;
	}
	
	public String getName() {
		return mapName;
	}
	
	public World getWorld() {
		return Bukkit.getWorld(worldName);
	}
	
	public ArrayList<Location> getSpawnLocations() {
		return spawnLocations;
		
	}
	
	
}
