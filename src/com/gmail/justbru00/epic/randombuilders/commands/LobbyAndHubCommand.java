package com.gmail.justbru00.epic.randombuilders.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.randombuilders.main.Main;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class LobbyAndHubCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("lobby") || command.getName().equalsIgnoreCase("hub")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("Lobby"); 
            
				player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
			}
		}
		
		return false;
	}

}
