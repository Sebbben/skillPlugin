package me.Sebbben.skillPlugin.JobsClasses;

import org.bukkit.entity.Player;

public class PlayerData {
    private Player owner;
    private JobData minerData,diggerData, butcherData;
    private String job;

    public Player getOwner() {
        return owner;
    }
    public JobData getMinerData() {
        return minerData;
    }
    public JobData getDiggerData() {
        return diggerData;
    }
    public JobData getButcherData() {
        return butcherData;
    }
    public String getJob() {
        return job;
    }

    public PlayerData(Player player, String selectedJob) {
        owner = player;
        job = selectedJob;

        minerData = new JobData();
        diggerData = new JobData();
        butcherData = new JobData();
    }

    public void updateMiner() {
        minerData.update(owner);
    }
    public void updateDigger() {
        diggerData.update(owner);
    }

    public void updateButcher() {
        butcherData.update(owner);
    }
}
