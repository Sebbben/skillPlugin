package me.Sebbben.skillPlugin.classes;

import me.Sebbben.skillPlugin.globals;

import java.util.HashMap;
import java.util.Map;

public class playerData {
    private static final Map<String,Integer> playerStats = new HashMap<>();

    public playerData() {
        this.setPlayerStats("exp", 0);
        this.setPlayerStats("lvl",0);
        this.setPlayerStats("expReq", 100);
        this.setPlayerStats("skillPoints",0);
    }

    public void setPlayerStats(String key,int val) {
        playerStats.put(key,val);
    }
    public void addPlayerStats(String key, int val) {
        this.setPlayerStats(key, this.getPlayerStats().get(key) + val);
    }

    public void addExp(int amount) {
        amount += this.getPlayerStats().get("exp");
        this.setPlayerStats("exp", amount);
    }

    public Map<String, Integer> getPlayerStats() {
        return playerStats;
    }

    public int getExp() {
        return this.getPlayerStats().get("exp");
    }


    public int getExpRequiredForNextLvl() {
        return this.getPlayerStats().get("expReq");
    }

    public void levelUp() {
        this.addPlayerStats("exp", -this.getExpRequiredForNextLvl());
        this.setPlayerStats("expReq", (int) (this.getPlayerStats().get("expReq") * globals.levelUpMultiplier));
        this.addPlayerStats("skillPoints", 1);
        this.addPlayerStats("lvl",1);
    }
}
