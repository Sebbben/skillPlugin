package me.Sebbben.skillPlugin;

import me.Sebbben.skillPlugin.Files.DataManager;
import me.Sebbben.skillPlugin.Listeners.BlockBreak;
import me.Sebbben.skillPlugin.classes.playerData;
import me.Sebbben.skillPlugin.commands.resetPlayerData;
import me.Sebbben.skillPlugin.commands.test;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {

    public static Map<String, me.Sebbben.skillPlugin.classes.playerData> playerData = new HashMap<>();
    public static DataManager data;
    public static double levelUpMultiplier = 1.25;
    public static expHandeling expHandeler = new expHandeling();
    private static Main plugin;

    public static Main getPlugin(){
        return plugin;
    }

    public static void setPlugin(Main plugin) {
        Main.plugin = plugin;
    }

    @Override
    public void onEnable() {
        this.getCommands();
        this.registerEvents();

        Main.setPlugin(this);

        Main.data = new DataManager(this);
        if(Main.data.getConfig().contains("data")) {
            this.restoreData();
        }
    }

    @Override
    public void onDisable() {
        if(!playerData.isEmpty()) {
            this.savePlayerExps();
            getLogger().info(ChatColor.RED + "Saved player data to file");
        }
    }

    private void getCommands() {
        this.getCommand("resetPlayerData").setExecutor(new resetPlayerData());
        this.getCommand("test").setExecutor(new test());

    }
    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new BlockBreak(),this);
    }
    private void savePlayerExps() {

        // Loop through player uuid's
        for (Map.Entry<String, playerData> entry : playerData.entrySet()) {
            // Loop through all variables in player data map
            Map<String, Integer> vars = entry.getValue().getPlayerStats();
            for (Map.Entry<String, Integer> val : vars.entrySet()) {
                data.getConfig().set("data." + entry.getKey() + "." + val.getKey(), val.getValue());
            }
            Map<String, Integer> playerSkills = entry.getValue().getPlayerSkills();

            for (Map.Entry<String, Integer> skill : playerSkills.entrySet()) {
                data.getConfig().set("data."+entry.getKey() + ".skills." + skill.getKey(),skill.getValue());
            }
        }

        data.saveConfig();
    }
    private void restoreData() {

        FileConfiguration config = data.getConfig();

        config.getConfigurationSection("data").getKeys(false).forEach(player -> {
            playerData.put(player, new playerData());
            playerData pd = playerData.get(player);

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
