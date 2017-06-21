package com.gmail.justbru00.epic.randombuilders.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.map.MapManager;
import com.gmail.justbru00.epic.randombuilders.utils.BuildingManager;
import com.gmail.justbru00.epic.randombuilders.utils.ItemBuilder;


public class BuildingListener implements Listener {
	
	@EventHandler
	public void onBlockDamage(BlockDamageEvent e) {
		if (BuildingManager.canBreak()) {
			if (BuildingManager.checkBlock(e.getBlock().getLocation())) {
				ItemStack silk = new ItemBuilder(Material.DIAMOND_PICKAXE).setAmount(1).build();
				silk.addEnchantment(Enchantment.SILK_TOUCH, 1);
				e.getBlock().breakNaturally(silk);	
				e.setCancelled(true);
			}
		} else if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
			
		} else {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		if (BuildingManager.canBreak()) {
			if (BuildingManager.checkBlock(e.getBlock().getLocation())) {
				// Make sure this works with fancy breaking
			} else {
				if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
					// uhhh stuff?
				} else {
					e.setCancelled(true);
					Messager.msgPlayer("&cThis block is protected.", e.getPlayer(), "game");
				}
			}
		} else {
			if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
				// uhhh stuff?
			} else {
				e.setCancelled(true);
			}
		}		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		if (BuildingManager.canPlace()) {
			if (MapManager.getCurrentMap().isInsideArea(e.getBlock().getLocation())) {
				BuildingManager.addBlock(e.getBlock().getLocation());
			} else {
				e.setCancelled(true);			
				Messager.msgPlayer("&cThat is outside your area", e.getPlayer(), "game");
				return;
			}
		} else {
			if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
				// uhhhh stuff?
			} else {
				e.setCancelled(true);
			}
		}
	}
	
}
