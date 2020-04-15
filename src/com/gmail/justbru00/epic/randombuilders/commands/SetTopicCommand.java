package com.gmail.justbru00.epic.randombuilders.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.utils.TopicManager;

public class SetTopicCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("settopic")) {
			if (sender.hasPermission("epicrandombuilders.settopic")) {
				if (args.length != 1) {
					String possibleTopic = args[0];
					if (possibleTopic.length() <= 14) {
						TopicManager.setTopic(possibleTopic.replace('_', ' '));
						Messager.msgSender("&aSuccessfully set the topic to: " + possibleTopic.replace('_', ' '), sender);
						Messager.msgSender("&aThat topic will either be applied right now if the game is running or it will be the next topic.", sender);
						return true;
					} else {
						Messager.msgSender("&cPlease keep your topic shorter than 15 characters. Scoreboards are difficult man...", sender);
						return true;
					}					
				} else {
					Messager.msgSender("&cPlease provide one argument after /settopic. Use underscores instead of spaces.", sender);
					return true;
				}
			} else {
				Messager.msgSender("&cYou don't have permission.", sender);
				return true;
			}
		}
		
		return false;
	}

}
