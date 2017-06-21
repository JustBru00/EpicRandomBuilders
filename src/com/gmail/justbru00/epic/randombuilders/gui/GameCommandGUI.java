package com.gmail.justbru00.epic.randombuilders.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.utils.ItemBuilder;

public class GameCommandGUI extends StaticGUI {

	@Override
	public void initGUI() {
		gui = Bukkit.createInventory(null, 27, Messager.color("&aControls"));

		gui.setItem(9, new ItemBuilder(Material.EMERALD_BLOCK).setName("&aStart Game").build());
		
		gui.setItem(11, new ItemBuilder(Material.WATCH).setName("&6Set time").build());
		
		gui.setItem(13, new ItemBuilder(Material.ANVIL).setName("&6Set topic").build());
		
		gui.setItem(15, new ItemBuilder(Material.REDSTONE_COMPARATOR).setName("&6Game Auto").build());		
		
		gui.setItem(17, new ItemBuilder(Material.REDSTONE_BLOCK).setName("&cStop/Reset Game").build());
		
	}

}
