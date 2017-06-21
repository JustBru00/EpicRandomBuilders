package com.gmail.justbru00.epic.randombuilders.commands;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.randombuilders.main.Main;
import com.gmail.justbru00.epic.randombuilders.map.MapManager;

public class TestLocCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("testloc")) {
			if (sender.hasPermission("testloc.stuffz")) {
				if (sender instanceof Player) {
					final Player p = (Player) sender;
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
						
						@Override
						public void run() {
							
							for (Location l : MapManager.getCurrentMap().getSpawnLocations()) {
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
									
									@Override
									public void run() {
										teleport(l, p);										
									}								
								
									
								}, 1);
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						}
					});
				} 
			}
		}
		
		return false;
	}
	
	private void teleport(Location l, Player p) {
		p.teleport(l);
	}

}
