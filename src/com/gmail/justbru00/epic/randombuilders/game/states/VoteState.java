package com.gmail.justbru00.epic.randombuilders.game.states;

import com.gmail.justbru00.epic.randombuilders.game.GameState;
import com.gmail.justbru00.epic.randombuilders.utils.BuildingManager;
import com.gmail.justbru00.epic.randombuilders.vote.VoteManager;
/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class VoteState extends BasicState {

	public VoteState() {
		super(GameState.VOTE, 0);
	}

	@Override
	public void codeOnStart() {
		
		/*
		 * Disable building, disable breaking, change players hot bars to voting items, let the VoteManager handle teleports and setting timer. VoteManager should use action bar to display your vote.
		 */
		BuildingManager.setCanBreak(false);
		BuildingManager.setCanPlace(false);
		
		VoteManager.voteOnAllBuilds();
		
	}

	@Override
	public void codeOnFinish() {
		// Do nothing. Let VoteManager handle it.
		
	}
	
}
