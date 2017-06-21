package com.gmail.justbru00.epic.randombuilders.utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.gmail.justbru00.epic.randombuilders.main.Main;

public class TopicManager {
	
	private static String current = "None";
	private static List<String> topics;

	public static void chooseRandomTopic() {
		current = topics.get(ThreadLocalRandom.current().nextInt(0, topics.size()-1));
	}
	
	public static String getCurrentTopic() {
		return current;
	}
	
	public static void init() {
		topics = Main.getInstance().getConfig().getStringList("topics");
	}
	
}
