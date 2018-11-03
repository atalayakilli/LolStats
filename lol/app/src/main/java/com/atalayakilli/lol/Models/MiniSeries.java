package com.atalayakilli.lol.Models;

import android.support.annotation.Nullable;

public class MiniSeries {
    private int target;
    private int wins;
    private int losses;
    private String progress;

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "MiniSeries{" +
                "target=" + target +
                ", wins=" + wins +
                ", losses=" + losses +
                ", progress='" + progress + '\'' +
                '}';
    }
}
