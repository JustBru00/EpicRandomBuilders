package com.gmail.justbru00.epic.randombuilders.game.states;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.game.GameState;
import com.gmail.justbru00.epic.randombuilders.main.Main;
import com.gmail.justbru00.epic.randombuilders.utils.TopicManager;

public class InstructionsState extends BasicState {

	public InstructionsState() {
		super(GameState.INSTRUCTIONS, 10);		
	}

	@Override
	public void codeOnStart() {
		
		BukkitScheduler sched = Bukkit.getScheduler();
		for (Player p : Bukkit.getOnlinePlayers()) {
			Messager.sendTitle("&bEpic&fRandomBuilders", "&7&oGame idea _BlazeCraft, TheMaskedCheetah", p);
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
