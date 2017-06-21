package com.gmail.justbru00.epic.randombuilders.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;
import com.gmail.justbru00.epic.randombuilders.chat.PrefixManager;
import com.gmail.justbru00.epic.randombuilders.commands.GameCommand;
import com.gmail.justbru00.epic.randombuilders.commands.LobbyAndHubCommand;
import com.gmail.justbru00.epic.randombuilders.commands.SetTimeCommand;
import com.gmail.justbru00.epic.randombuilders.commands.TestLocCommand;
import com.gmail.justbru00.epic.randombuilders.game.GameManager;
import com.gmail.justbru00.epic.randombuilders.gui.GUIInstanceManager;
import com.gmail.justbru00.epic.randombuilders.listeners.BuildingListener;
import com.gmail.justbru00.epic.randombuilders.listeners.GameCommandListener;
import com.gmail.justbru00.epic.randombuilders.listeners.GeneralListeners;
import com.gmail.justbru00.epic.randombuilders.listeners.OnJoinAndLeaveListener;
import com.gmail.justbru00.epic.randombuilders.listeners.VoteListener;
import com.gmail.justbru00.epic.randombuilders.map.MapManager;
import com.gmail.justbru00.epic.randombuilders.scoreboard.EpicScoreBoard;
import com.gmail.justbru00.epic.randombuilders.utils.RandomItemGiver;
import com.gmail.justbru00.epic.randombuilders.utils.TopicManager;
import com.gmail.justbru00.epic.randombuilders.vote.VoteManager;

public class Main extends JavaPlugin {	

	public static ConsoleCommandSender console = Bukkit.getConsoleSender();
	public static Logger log = Bukkit.getLogger();
	private static Main plugin;
	private static String VERSION;
	
	@Override
	public void onEnable() {
		plugin = this;
		PrefixManager.init();
		GameManager.initStates();
		saveDefaultConfig();
		VERSION = getDescription().getVersion();
		Messager.msgConsole("&aStarting to enable the plugin...");
		
		// REGISTER COMMANDS
		getCommand("game").setExecutor(new GameCommand());
		getCommand("testloc").setExecutor(new TestLocCommand());
		getCommand("settime").setExecutor(new SetTimeCommand());
		getCommand("lobby").setExecutor(new LobbyAndHubCommand());
		getCommand("hub").setExecutor(new LobbyAndHubCommand());
		
		PluginManager pm = Bukkit.getPluginManager();
		// REGISTER LISTENERS
		pm.registerEvents(new GameCommandListener(), plugin);
		pm.registerEvents(new BuildingListener(), plugin);
		pm.registerEvents(new OnJoinAndLeaveListener(), plugin);
		pm.registerEvents(new VoteListener(), plugin);
		pm.registerEvents(new GeneralListeners(), plugin);
		
		// REGISTER CUSTOM STUFF
		GUIInstanceManager.initAllGUIS();
		MapManager.init();
		VoteManager.init();
		TopicManager.init();
		RandomItemGiver.init();
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		// RUN GameManager.everySecond()
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {			
			@Override
			public void run() {
				GameManager.everySecond();												
			}
		}, 20, 20);
		
		// SCOREBOARD (SIDEBAR)
		GameManager.setEpicBoard(new EpicScoreBoard("&bProject&fRho", 10));
		GameManager.getEpicBoard().setVisible();
		GameManager.getEpicBoard().addLine("&b");
		GameManager.getEpicBoard().addLine("&b");
		GameManager.getEpicBoard().addLine("&b");
		GameManager.getEpicBoard().addLine("&b");
		GameManager.getEpicBoard().addLine("&b");
		GameManager.getEpicBoard().addLine("&e");
		
		Messager.msgConsole("&aAll systems are go for launch!!!");
	}

	
	@Override
	public void onDisable() {
		GameManager.getEpicBoard().runOnShutdown();
		plugin = null;
	}	
	
	public static String getVersion() {
		return VERSION;
	}
	
	/**
	 * Gets the current instance of the plugin.
	 * @return
	 */
	public static Main getInstance() {
		return plugin;
	}
	
}
