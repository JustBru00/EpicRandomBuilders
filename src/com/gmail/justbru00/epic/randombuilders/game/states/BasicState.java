package com.gmail.justbru00.epic.randombuilders.game.states;

import com.gmail.justbru00.epic.randombuilders.game.GameState;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public abstract class BasicState {

	private GameState myState;
	private int timeForMyState;
	private static BasicState instance;
	
	public BasicState(GameState s, int timeITake) {
		instance = this;
		myState = s;
		timeForMyState = timeITake;
	}
	
	public static BasicState getInstance() {
		return instance;		
	}
	
	public GameState getState() {
		return myState;
	}
	
	public int getTimeForState() {
		return timeForMyState;
	}
	
	public abstract void codeOnStart();
	
	public abstract void codeOnFinish();
	
}
