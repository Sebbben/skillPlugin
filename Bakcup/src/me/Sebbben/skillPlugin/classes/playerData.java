package me.Sebbben.skillPlugin.classes;

import org.bukkit.entity.HumanEntity;

import java.util.*;

public class playerData {
    private static final Map<String,Integer> playerStats = new HashMap<>();
    private static Map<String, Integer> skills = null;

    public playerData() {
        this.setPlayerStats("exp", 0);
        this.setPlayerStats("lvl",0);
        this.setPlayerStats("expReq", 100);
        this.setPlayerStats("skillPoints",0);
        skills = new HashMap<>();
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
    public void levelUp() {
        this.addPlayerStats("exp", -this.getExpRequiredForNextLvl());
        this.setPlayerStats("expReq", (int) (this.getPlayerStats().get("expReq") * globals.levelUpMultiplier));
        this.addPlayerStats("skillPoints", 1);
        this.addPlayerStats("lvl",1);
    }
    public void addSkill(String skill, int val) {
        skills.put(skill, val);
    }
    public int getExp() {
        return this.getPlayerStats().get("exp");
    }
    public int getExpRequiredForNextLvl() {
        return this.getPlayerStats().get("expReq");
    }
    public Map<String, Integer> getPlayerStats() {
        return playerStats;
    }
    public Map<String, Integer> getPlayerSkills() {
        return skills;
    }
    public int getSkillPoints() {
        return this.getPlayerStats().get("skillPoints");
    }
    public void listSkills(HumanEntity player) {
        for (Map.Entry<String, Integer> skill : skills.entrySet()) {
            player.sendMessage(String.valueOf(skill));
        }
    }
}