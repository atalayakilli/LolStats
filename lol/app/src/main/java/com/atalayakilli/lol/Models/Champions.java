package com.atalayakilli.lol.Models;

public class Champions {
    private int championId;
    private String championName;
    private String championPicture;


    public Champions(int championId, String championName, String championPicture) {
        this.championId = championId;
        this.championName = championName;
        this.championPicture = championPicture;

    }




    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public String getChampionPicture() {
        return championPicture;
    }

    public void setChampionPicture(String championPicture) {
        this.championPicture = championPicture;
    }
}
