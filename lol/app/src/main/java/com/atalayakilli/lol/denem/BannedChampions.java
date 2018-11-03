package com.atalayakilli.lol.denem;

public class BannedChampions {
	private int championId;
	private int pickTurn;
	private int teamId;

	public void setChampionId(int championId){
		this.championId = championId;
	}

	public int getChampionId(){
		return championId;
	}

	public void setPickTurn(int pickTurn){
		this.pickTurn = pickTurn;
	}

	public int getPickTurn(){
		return pickTurn;
	}

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	@Override
 	public String toString(){
		return 
			"BannedChampionsItem{" + 
			"championId = '" + championId + '\'' + 
			",pickTurn = '" + pickTurn + '\'' + 
			",teamId = '" + teamId + '\'' + 
			"}";
		}
}
