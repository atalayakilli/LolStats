package com.atalayakilli.lol.Models;

public class Masteries{
	private int championPointsUntilNextLevel;
	private boolean chestGranted;
	private int tokensEarned;
	private int championId;
	private long lastPlayTime;
	private int championLevel;
	private int playerId;
	private int championPoints;
	private int championPointsSinceLastLevel;

	public void setChampionPointsUntilNextLevel(int championPointsUntilNextLevel){
		this.championPointsUntilNextLevel = championPointsUntilNextLevel;
	}

	public int getChampionPointsUntilNextLevel(){
		return championPointsUntilNextLevel;
	}

	public void setChestGranted(boolean chestGranted){
		this.chestGranted = chestGranted;
	}

	public boolean isChestGranted(){
		return chestGranted;
	}

	public void setTokensEarned(int tokensEarned){
		this.tokensEarned = tokensEarned;
	}

	public int getTokensEarned(){
		return tokensEarned;
	}

	public void setChampionId(int championId){
		this.championId = championId;
	}

	public int getChampionId(){
		return championId;
	}

	public void setLastPlayTime(long lastPlayTime){
		this.lastPlayTime = lastPlayTime;
	}

	public long getLastPlayTime(){
		return lastPlayTime;
	}

	public void setChampionLevel(int championLevel){
		this.championLevel = championLevel;
	}

	public int getChampionLevel(){
		return championLevel;
	}

	public void setPlayerId(int playerId){
		this.playerId = playerId;
	}

	public int getPlayerId(){
		return playerId;
	}

	public void setChampionPoints(int championPoints){
		this.championPoints = championPoints;
	}

	public int getChampionPoints(){
		return championPoints;
	}

	public void setChampionPointsSinceLastLevel(int championPointsSinceLastLevel){
		this.championPointsSinceLastLevel = championPointsSinceLastLevel;
	}

	public int getChampionPointsSinceLastLevel(){
		return championPointsSinceLastLevel;
	}

	@Override
 	public String toString(){
		return 
			"Masteries{" + 
			"championPointsUntilNextLevel = '" + championPointsUntilNextLevel + '\'' + 
			",chestGranted = '" + chestGranted + '\'' + 
			",tokensEarned = '" + tokensEarned + '\'' + 
			",championId = '" + championId + '\'' + 
			",lastPlayTime = '" + lastPlayTime + '\'' + 
			",championLevel = '" + championLevel + '\'' + 
			",playerId = '" + playerId + '\'' + 
			",championPoints = '" + championPoints + '\'' + 
			",championPointsSinceLastLevel = '" + championPointsSinceLastLevel + '\'' + 
			"}";
		}
}
