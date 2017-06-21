package com.gmail.justbru00.epic.randombuilders.game.states;

import com.gmail.justbru00.epic.randombuilders.game.GameState;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class WaitState extends BasicState {

	public WaitState() {
		super(GameState.WAIT, 0);		
	}

	@Override
	public void codeOnStart() {
		
		// Shouldn't need any code here. Reset _should_ be run before this. Reset should go straight to this.

	}

	@Override
	public void codeOnFinish() {
		// Do nothing.
		
	}

}
