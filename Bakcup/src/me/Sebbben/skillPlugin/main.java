package me.Sebbben.skillPlugin;

import me.Sebbben.skillPlugin.Listeners.BlockBreak;
import me.Sebbben.skillPlugin.classes.playerData;
import me.Sebbben.skillPlugin.commands.resetPlayerData;
import me.Sebbben.skillPlugin.commands.test;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public class main extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getCommands();
        this.registerEvents();

        globals.data = new DataManager(this);
        if(globals.data.getConfig().contains("data")) {
            this.restoreData();
        }
    }
    @Override
    public void onDisable() {
        if(!globals.playerData.isEmpty()) {
            this.savePlayerExps();
            getLogger().info(ChatColor.RED + "Saved player data to file");
        }
    }
    private void getCommands() {
        this.getCommand("skill").setExecutor(new skill());
        this.getCommand("skillexp").setExecutor(new skillExp());
        this.getCommand("resetPlayerData").setExecutor(new resetPlayerData());
        this.getCommand("test").setExecutor(new test());

    }
    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new InventoryClick(),this);
        this.getServer().getPluginManager().registerEvents(new BlockBreak(),this);
    }
    private void savePlayerExps() {

        // Loop through player uuid's
        for (Map.Entry<String, playerData> entry : globals.playerData.entrySet()) {
            // Loop through all variables in player data map
            Map<String, Integer> vars = entry.getValue().getPlayerStats();
            for (Map.Entry<String, Integer> val : vars.entrySet()) {
                globals.data.getConfig().set("data." + entry.getKey() + "." + val.getKey(), val.getValue());
            }
            Map<String, Integer> playerSkills = entry.getValue().getPlayerSkills();

            for (Map.Entry<String, Integer> skill : playerSkills.entrySet()) {
                globals.data.getConfig().set("data."+entry.getKey() + ".skills." + skill.getKey(),skill.getValue());
            }
        }

        globals.data.saveConfig();
    }
    private void restoreData() {

        FileConfiguration config = globals.data.getConfig();

        config.getConfigurationSection("data").getKeys(false).forEach(player -> {
            globals.playerData.put(player, new playerData());
            playerData pd = globals.playerData.get(player);

            config.getConfigurationSection("data." + player + ".").getKeys(false).forEach(data -> {
                if (config.get("data." + player + "." + data) instanceof Integer) {
                    pd.setPlayerStats(data, (Integer) config.get("data." + player + "." + data));
                }
            });
            config.getConfigurationSection("data." + player + ".skills.").getKeys(false).forEach(skill -> {
                pd.addSkill(skill, (Integer) config.get("data." + player + ".skills." + skill));
            });
        });
    }

}
