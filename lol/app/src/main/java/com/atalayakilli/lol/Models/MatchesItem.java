package com.atalayakilli.lol.Models;

public class MatchesItem{
	private long gameId;
	private String role;
	private int season;
	private String platformId;
	private int champion;
	private int queue;
	private String lane;
	private long timestamp;

	public void setGameId(int gameId){
		this.gameId = gameId;
	}

	public long getGameId(){
		return gameId;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setSeason(int season){
		this.season = season;
	}

	public int getSeason(){
		return season;
	}

	public void setPlatformId(String platformId){
		this.platformId = platformId;
	}

	public String getPlatformId(){
		return platformId;
	}

	public void setChampion(int champion){
		this.champion = champion;
	}

	public int getChampion(){
		return champion;
	}

	public void setQueue(int queue){
		this.queue = queue;
	}

	public int getQueue(){
		return queue;
	}

	public void setLane(String lane){
		this.lane = lane;
	}

	public String getLane(){
		return lane;
	}

	public void setTimestamp(long timestamp){
		this.timestamp = timestamp;
	}

	public long getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"MatchesItem{" + 
			"gameId = '" + gameId + '\'' + 
			",role = '" + role + '\'' + 
			",season = '" + season + '\'' + 
			",platformId = '" + platformId + '\'' + 
			",champion = '" + champion + '\'' + 
			",queue = '" + queue + '\'' + 
			",lane = '" + lane + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}
