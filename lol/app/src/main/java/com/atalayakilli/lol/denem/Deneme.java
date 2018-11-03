package com.atalayakilli.lol.denem;

import java.util.List;

public class Deneme {
	private long gameId;
	private String gameType;
	private long gameStartTime;
	private int mapId;
	private String platformId;
	private int gameLength;
	private String gameMode;
	private int gameQueueConfigId;
	private List<BannedChampions> bannedChampions;
	private Observers observers;
	private List<Participants> participants;

	public void setGameId(int gameId){
		this.gameId = gameId;
	}

	public long getGameId(){
		return gameId;
	}

	public void setGameType(String gameType){
		this.gameType = gameType;
	}

	public String getGameType(){
		return gameType;
	}

	public void setGameStartTime(long gameStartTime){
		this.gameStartTime = gameStartTime;
	}

	public long getGameStartTime(){
		return gameStartTime;
	}

	public void setMapId(int mapId){
		this.mapId = mapId;
	}

	public int getMapId(){
		return mapId;
	}

	public void setPlatformId(String platformId){
		this.platformId = platformId;
	}

	public String getPlatformId(){
		return platformId;
	}

	public void setGameLength(int gameLength){
		this.gameLength = gameLength;
	}

	public int getGameLength(){
		return gameLength;
	}

	public void setGameMode(String gameMode){
		this.gameMode = gameMode;
	}

	public String getGameMode(){
		return gameMode;
	}

	public void setGameQueueConfigId(int gameQueueConfigId){
		this.gameQueueConfigId = gameQueueConfigId;
	}

	public int getGameQueueConfigId(){
		return gameQueueConfigId;
	}

	public void setBannedChampions(List<BannedChampions> bannedChampions){
		this.bannedChampions = bannedChampions;
	}

	public List<BannedChampions> getBannedChampions(){
		return bannedChampions;
	}

	public void setObservers(Observers observers){
		this.observers = observers;
	}

	public Observers getObservers(){
		return observers;
	}

	public void setParticipants(List<Participants> participants){
		this.participants = participants;
	}

	public List<Participants> getParticipants(){
		return participants;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"gameId = '" + gameId + '\'' + 
			",gameType = '" + gameType + '\'' + 
			",gameStartTime = '" + gameStartTime + '\'' + 
			",mapId = '" + mapId + '\'' + 
			",platformId = '" + platformId + '\'' + 
			",gameLength = '" + gameLength + '\'' + 
			",gameMode = '" + gameMode + '\'' + 
			",gameQueueConfigId = '" + gameQueueConfigId + '\'' + 
			",bannedChampions = '" + bannedChampions + '\'' + 
			",observers = '" + observers + '\'' + 
			",participants = '" + participants + '\'' + 
			"}";
		}
}