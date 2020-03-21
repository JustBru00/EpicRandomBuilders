package com.gmail.justbru00.epic.randombuilders.scoreboard;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * A class to handle creating and showing a flickerless scoreboard.
 * @author Justin "JustBru00" Brubaker
 *
 */
public class EpicScoreBoard {
	
	public String objectiveName;
	public String title;
	public int numberOfLines = 0;
	public ArrayList<String> textLines = new ArrayList<String>();
	public ArrayList<Team> lineTeams = new ArrayList<Team>();
	public ArrayList<String> fakePlayerNames = new ArrayList<String>();
	public Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
	public Objective obj;
	private final String[] colors = {"a", "b", "c", "d", "7mc.com", "e"}; 

	public EpicScoreBoard(String _title, int _numberOfLines) {
		title = color(_title);
		numberOfLines = _numberOfLines;
		
		objectiveName = UUID.randomUUID().toString().substring(0, 4);
		
		obj = sb.registerNewObjective(objectiveName, "dummy");
		obj.setDisplayName(title);		
		fillFakePlayersList();
		fillRandomTeams();		
	}
	
	/**
	 * Sets this scoreboard to visible	 *
	 */
	public void setVisible() {		
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);			
	}
	
	public void setTitle(String s) {
		obj.setDisplayName(color(s));
	}
	/**
	 * Run this after setting the lines. This will display on the scoreboard.
	 */
	public void updateScoreboard() {
		if (textLines.isEmpty()) {
			return;
		}
		
		int i = 0;
		
		
		for (String s : textLines) {			
			lineTeams.get(i).setPrefix(s);					
			i++;
		}
		i = 15;
		for (String s : fakePlayerNames) {
			Score score = obj.getScore(s);
			score.setScore(i);
			i--;
		}
		
	}	
	
	public void addLine(String text) {	
		textLines.add(color(text));
	
	}
	
	public void setLine(int line, String text) {
		textLines.set(line, color(text));
	}
	
	private void fillFakePlayersList() {
		for (String s : colors) {
			fakePlayerNames.add(color("&" + s));
		}
	}
	
	private void fillRandomTeams() {
		for (int i = 0; i < 6; i++) {
			Team t = sb.registerNewTeam(UUID.randomUUID().toString().substring(0, 4));
			lineTeams.add(t);
		}
		int i = 0;
		for (Team team : lineTeams) {
			team.addEntry(fakePlayerNames.get(i));
			i++;
		}
	}
	
	public void runOnShutdown() {
		textLines = null;
		fakePlayerNames = null;
		obj.unregister();
		for (Team t : lineTeams) {
			t.unregister();
		}
	}
	
	public String color(String toColor) {
		return ChatColor.translateAlternateColorCodes('&', toColor);
	}
	
}
