package com.gmail.justbru00.epic.randombuilders.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.gui.GameCommandGUI;
import com.gmail.justbru00.epic.randombuilders.permissions.Permission;
import com.gmail.justbru00.epic.randombuilders.permissions.PermissionManager;

public class GameCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("game")) {
			if (PermissionManager.checkPerms(sender, Permission.ADMIN)) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					p.openInventory(GameCommandGUI.getInstance().getGUI());
				} else {
					// TEXT COMMANDS HERE SOON (TM)
				}
			} else {
				Messager.msgSender("&cUnfortunately, that command is reserved for master builders.", sender);
				return true;
			}
		}
		
		return false;
	}

}
