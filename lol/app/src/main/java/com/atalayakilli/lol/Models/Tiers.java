package com.atalayakilli.lol.Models;

public class Tiers {
    private String tier;
    private String rank;
    private int point;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Tiers{" +
                "tier='" + tier + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
