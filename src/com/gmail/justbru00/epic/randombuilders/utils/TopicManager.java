package com.gmail.justbru00.epic.randombuilders.utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.gmail.justbru00.epic.randombuilders.main.Main;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class TopicManager {
	
	private static String current = "None";
	private static List<String> topics;

	/**
	 * This method will choose a random topic from the config file.
	 * Unless the current topic is not 'None' then it will not change the topic.
	 */
	public static void chooseRandomTopic() {
		if (current.equalsIgnoreCase("None")) {
			current = topics.get(ThreadLocalRandom.current().nextInt(0, topics.size()-1));
		}
	}
	
	/**
	 * Sets the current topic to 'None'
	 */
	public static void resetTopic() {
		current = "None";
	}
	
	/**
	 * Sets the current topic.
	 * This will work no matter what state the game is currently in.
	 */
	public static void setTopic(String topic) {
		current = topic;
	}
	
	public static String getCurrentTopic() {
		return current;
	}
	
	public static void init() {
		topics = Main.getInstance().getConfig().getStringList("topics");
	}
	
}
