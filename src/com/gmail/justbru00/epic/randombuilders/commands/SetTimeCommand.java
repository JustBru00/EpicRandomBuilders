package com.gmail.justbru00.epic.randombuilders.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.game.GameManager;

public class SetTimeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("settime")) {
			if (sender.hasPermission("a.permission.cool.stuff")) {
				if (args.length == 1) {
					int time = 0;
					try {
						time = Integer.parseInt(args[0]);
					} catch (Exception e) {
						
					}
					
					if (time != 0) {
						GameManager.setTimer(time);
					}
					
					Messager.msgSender("&aSet the time to: " + time, sender);
					return true;
				}
			}
		}
		return false;
	}

}
