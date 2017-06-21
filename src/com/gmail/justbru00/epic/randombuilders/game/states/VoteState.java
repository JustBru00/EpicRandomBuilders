package com.gmail.justbru00.epic.randombuilders.game.states;

import com.gmail.justbru00.epic.randombuilders.game.GameState;
import com.gmail.justbru00.epic.randombuilders.utils.BuildingManager;
import com.gmail.justbru00.epic.randombuilders.vote.VoteManager;

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
