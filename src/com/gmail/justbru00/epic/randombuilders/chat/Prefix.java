package com.gmail.justbru00.epic.randombuilders.chat;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class Prefix {

	private String prefix;
	private String simpleName;
	
	/**
	 * Creates a new prefix object. This will add itself to the {@link PrefixManager}
	 * @param _prefix The prefix that will be colored
	 * @param _simpleName The name to get the prefix from.
	 */
	public Prefix(String _simpleName, String _prefix) {
		prefix = Messager.color(_prefix);
		simpleName = _simpleName;
		PrefixManager.addPrefix(this);
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the simpleName
	 */
	public String getSimpleName() {
		return simpleName;
	}

	/**
	 * @param simpleName the simpleName to set
	 */
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	
	
	
}
