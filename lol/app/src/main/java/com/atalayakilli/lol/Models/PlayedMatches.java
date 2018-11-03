package com.atalayakilli.lol.Models;

import java.util.List;

public class PlayedMatches{
	private int startIndex;
	private int totalGames;
	private int endIndex;
	private List<MatchesItem> matches;

	public void setStartIndex(int startIndex){
		this.startIndex = startIndex;
	}

	public int getStartIndex(){
		return startIndex;
	}

	public void setTotalGames(int totalGames){
		this.totalGames = totalGames;
	}

	public int getTotalGames(){
		return totalGames;
	}

	public void setEndIndex(int endIndex){
		this.endIndex = endIndex;
	}

	public int getEndIndex(){
		return endIndex;
	}

	public void setMatches(List<MatchesItem> matches){
		this.matches = matches;
	}

	public List<MatchesItem> getMatches(){
		return matches;
	}

	@Override
 	public String toString(){
		return 
			"PlayedMatches{" + 
			"startIndex = '" + startIndex + '\'' + 
			",totalGames = '" + totalGames + '\'' + 
			",endIndex = '" + endIndex + '\'' + 
			",matches = '" + matches + '\'' + 
			"}";
		}
}