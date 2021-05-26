package me.Sebbben.skillPlugin.JobsClasses;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class JobData {

    public JobData() {
        level = 0;
        exp = 0;
        expReq = 100;
        points = 0;
        skills = new ArrayList<>();
    }

    private int level,exp,expReq,points;
    private List<String> skills;

    public int getLevel() {
        return level;
    }
    public int getExp() {
        return exp;
    }
    public int getExpReq() {
        return expReq;
    }
    public int getPoints() {
        return points;
    }
    public List<String> getSkills() {
        return skills;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public void setExpReq(int expReq) {
        this.expReq = expReq;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }
    public void addExp(int amount) {
        this.exp += amount;
    }

    public void update(Player owner) {
        while (exp >= expReq) {
            exp -= expReq;
            level++;
            points++;

            owner.sendMessage("You leveled up to level " + level);
            owner.playSound(owner.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F,0.5F);
            owner.playSound(owner.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 0.5F,0.5F);
        }
    }
}
