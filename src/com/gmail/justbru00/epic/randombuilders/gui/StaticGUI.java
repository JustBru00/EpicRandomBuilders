package com.gmail.justbru00.epic.randombuilders.gui;

import org.bukkit.inventory.Inventory;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public abstract class StaticGUI {
	
	public Inventory gui;
	String name;
	private static StaticGUI instance = null;
	
	public StaticGUI() {
		initGUI();
		instance = this;
	}
	
	public static StaticGUI getInstance() {
		return instance;
	}

	public Inventory getGUI() {
		return gui;		
	}
	
	public String getName() {
		return name;
	}
		
	/**
	 * Setup the gui items in this method. This includes the setup of the {@link gui} varible.
	 * Make sure to set the {@link #name}
	 */
	public abstract void initGUI();
	
}
