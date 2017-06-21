package com.gmail.justbru00.epic.randombuilders.chat;

import java.util.ArrayList;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class PrefixManager {
	
	private static ArrayList<Prefix> prefixes = new ArrayList<Prefix>();
	public static final Prefix DEFAULT = new Prefix("default", "&8[&bEpic&fRandomBuilders&8] &f");
	
	
	public static void init() {
		new Prefix("game", "&8[&9Game&8] &7»&6 ");
		new Prefix("tip", "&8[&cTip&8] &7»&6 ");
	}
	
	/**
	 * Adds a prefix to the list of useable ones
	 * @param p
	 */
	public static void addPrefix(Prefix p) {
		prefixes.add(p);
	}
	/**
	 * Finds the a prefix with the simple name provided.
	 * @param simpleName
	 * @return Returns the defualt if the prefix is not found.
	 */
	public static String getPrefix(String simpleName) {
		for (Prefix p : prefixes) {
			if (p.getSimpleName().equalsIgnoreCase(simpleName)) {
				return p.getPrefix();
			}
		}
		return DEFAULT.getPrefix();
	}
	
}
