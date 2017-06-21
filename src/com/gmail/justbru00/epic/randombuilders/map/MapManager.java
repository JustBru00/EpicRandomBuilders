package com.gmail.justbru00.epic.randombuilders.map;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class MapManager {
	
	private static Map currentMap;
	private static ArrayList<Map> maps = new ArrayList<Map>();

	public static void init() {
		Map normal = new Map("Original", "world");
		World w = normal.getWorld();
		normal.addSpawnLoc(new Location(w, 20.5, 2, -74.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 55.5, 2, -74.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 90.5, 2, -74.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 125.5, 2, -74.5, -180, 0)); // First row left to right
		
		normal.addSpawnLoc(new Location(w, 20.5, 2, -109.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 55.5, 2, -109.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 90.5, 2, -109.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 125.5, 2, -109.5, -180, 0)); // Second row left to right
		
		normal.addSpawnLoc(new Location(w, 20.5, 2, -144.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 55.5, 2, -144.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 90.5, 2, -144.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 125.5, 2, -144.5, -180, 0)); // Third row left to right
		
		normal.addSpawnLoc(new Location(w, 20.5, 2, -179.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 55.5, 2, -179.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 90.5, 2, -179.5, -180, 0));
		normal.addSpawnLoc(new Location(w, 125.5, 2, -179.5, -180, 0)); // Fourth row left to right
		maps.add(normal);
		currentMap = maps.get(0);
	}
	
	public static Map getCurrentMap() {
		return currentMap;
	}
	
}
