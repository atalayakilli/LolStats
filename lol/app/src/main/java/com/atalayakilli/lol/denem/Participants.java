package com.atalayakilli.lol.denem;

import java.util.List;

public class Participants {
	private int championId;
	private int profileIconId;
	private boolean bot;
	private int teamId;
	private String summonerName;
	private int spell1Id;
	private int summonerId;
	private int spell2Id;
	private Perks perks;
	private List<Object> gameCustomizationObjects;

	public void setChampionId(int championId){
		this.championId = championId;
	}

	public int getChampionId(){
		return championId;
	}

	public void setProfileIconId(int profileIconId){
		this.profileIconId = profileIconId;
	}

	public int getProfileIconId(){
		return profileIconId;
	}

	public void setBot(boolean bot){
		this.bot = bot;
	}

	public boolean isBot(){
		return bot;
	}

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	public void setSummonerName(String summonerName){
		this.summonerName = summonerName;
	}

	public String getSummonerName(){
		return summonerName;
	}

	public void setSpell1Id(int spell1Id){
		this.spell1Id = spell1Id;
	}

	public int getSpell1Id(){
		return spell1Id;
	}

	public void setSummonerId(int summonerId){
		this.summonerId = summonerId;
	}

	public int getSummonerId(){
		return summonerId;
	}

	public void setSpell2Id(int spell2Id){
		this.spell2Id = spell2Id;
	}

	public int getSpell2Id(){
		return spell2Id;
	}

	public void setPerks(Perks perks){
		this.perks = perks;
	}

	public Perks getPerks(){
		return perks;
	}

	public void setGameCustomizationObjects(List<Object> gameCustomizationObjects){
		this.gameCustomizationObjects = gameCustomizationObjects;
	}

	public List<Object> getGameCustomizationObjects(){
		return gameCustomizationObjects;
	}

	@Override
 	public String toString(){
		return 
			"ParticipantsItem{" + 
			"championId = '" + championId + '\'' + 
			",profileIconId = '" + profileIconId + '\'' + 
			",bot = '" + bot + '\'' + 
			",teamId = '" + teamId + '\'' + 
			",summonerName = '" + summonerName + '\'' + 
			",spell1Id = '" + spell1Id + '\'' + 
			",summonerId = '" + summonerId + '\'' + 
			",spell2Id = '" + spell2Id + '\'' + 
			",perks = '" + perks + '\'' + 
			",gameCustomizationObjects = '" + gameCustomizationObjects + '\'' + 
			"}";
		}
}