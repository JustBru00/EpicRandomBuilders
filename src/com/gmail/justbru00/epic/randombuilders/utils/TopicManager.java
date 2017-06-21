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
