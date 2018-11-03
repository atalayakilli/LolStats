package com.atalayakilli.lol.Models;

public class Summoner{
	private long accountId;
	private int profileIconId;
	private long revisionDate;
	private String name;
	private long id;
	private int summonerLevel;

	public void setAccountId(int accountId){
		this.accountId = accountId;
	}

	public long getAccountId(){
		return accountId;
	}

	public void setProfileIconId(int profileIconId){
		this.profileIconId = profileIconId;
	}

	public int getProfileIconId(){
		return profileIconId;
	}

	public void setRevisionDate(long revisionDate){
		this.revisionDate = revisionDate;
	}

	public long getRevisionDate(){
		return revisionDate;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setSummonerLevel(int summonerLevel){
		this.summonerLevel = summonerLevel;
	}

	public int getSummonerLevel(){
		return summonerLevel;
	}

	@Override
 	public String toString(){
		return 
			"Summoner{" + 
			"accountId = '" + accountId + '\'' + 
			",profileIconId = '" + profileIconId + '\'' + 
			",revisionDate = '" + revisionDate + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",summonerLevel = '" + summonerLevel + '\'' + 
			"}";
		}
}
