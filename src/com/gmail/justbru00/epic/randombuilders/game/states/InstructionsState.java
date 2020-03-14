package com.gmail.justbru00.epic.randombuilders.game.states;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.game.GameState;
import com.gmail.justbru00.epic.randombuilders.main.Main;
import com.gmail.justbru00.epic.randombuilders.utils.TopicManager;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class InstructionsState extends BasicState {

	public InstructionsState() {
		super(GameState.INSTRUCTIONS, 10);		
	}

	@Override
	public void codeOnStart() {
		
		BukkitScheduler sched = Bukkit.getScheduler();
		for (Player p : Bukkit.getOnlinePlayers()) {
			Messager.sendTitle("&bEpic&fRandomBuilders", "&7&oGame idea SpeedShock, TheMaskedCheetah", p);
		}
		
		sched.runTaskLater(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					Messager.sendTitle("&5Topic: " + TopicManager.getCurrentTopic(), "&7&oBuild it the best you can", p);
				}				
			}
		}, 5*20);
		
	}

	@Override
	public void codeOnFinish() {
		
		GameManager.setCurrentState(GameState.BUILD);
		
	}

}
