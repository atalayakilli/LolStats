package com.atalayakilli.lol.Models;

import java.util.List;

public class FreeRotation{
	private int maxNewPlayerLevel;
	private List<Integer> freeChampionIdsForNewPlayers;
	private List<Integer> freeChampionIds;

	public void setMaxNewPlayerLevel(int maxNewPlayerLevel){
		this.maxNewPlayerLevel = maxNewPlayerLevel;
	}

	public int getMaxNewPlayerLevel(){
		return maxNewPlayerLevel;
	}

	public void setFreeChampionIdsForNewPlayers(List<Integer> freeChampionIdsForNewPlayers){
		this.freeChampionIdsForNewPlayers = freeChampionIdsForNewPlayers;
	}

	public List<Integer> getFreeChampionIdsForNewPlayers(){
		return freeChampionIdsForNewPlayers;
	}

	public void setFreeChampionIds(List<Integer> freeChampionIds){
		this.freeChampionIds = freeChampionIds;
	}

	public List<Integer> getFreeChampionIds(){
		return freeChampionIds;
	}

	@Override
 	public String toString(){
		return 
			"FreeRotation{" + 
			"maxNewPlayerLevel = '" + maxNewPlayerLevel + '\'' + 
			",freeChampionIdsForNewPlayers = '" + freeChampionIdsForNewPlayers + '\'' + 
			",freeChampionIds = '" + freeChampionIds + '\'' + 
			"}";
		}
}