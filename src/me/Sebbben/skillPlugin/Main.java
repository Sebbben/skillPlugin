package me.Sebbben.skillPlugin;

import me.Sebbben.skillPlugin.Files.playerDataConfig;
import me.Sebbben.skillPlugin.Listeners.BlockBreak;
import me.Sebbben.skillPlugin.Listeners.MenuListener;
import me.Sebbben.skillPlugin.MenuSystem.PlayerMenuUtility;
import me.Sebbben.skillPlugin.classes.PlayerData;
import me.Sebbben.skillPlugin.commands.MainMenuCommand;
import me.Sebbben.skillPlugin.commands.resetPlayerData;
import me.Sebbben.skillPlugin.commands.test;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {

    public static Map<String, PlayerData> playerData = new HashMap<>();
    public static double levelUpMultiplier;
    public static ExpHandling expHandler = new ExpHandling();
    private static Main plugin;
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();


    public static Main getPlugin() {
        return plugin;
    }

    public static void setPlugin(Main plugin) {
        Main.plugin = plugin;
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player player) {
        PlayerMenuUtility playerMenuUtility;

        if(playerMenuUtilityMap.containsKey(player)) {
            return playerMenuUtilityMap.get(player);
        }else{
            playerMenuUtility = new PlayerMenuUtility(player);
            playerMenuUtilityMap.put(player, playerMenuUtility);
            return playerMenuUtility;
        }
    }

    @Override
    public void onLoad() {
        Main.setPlugin(this);
    }

    @Override
    public void onEnable() {
        this.getCommands();
        this.registerEvents();
        this.loadConfigValues();

        saveDefaultConfig();
        playerDataConfig.setup();
        playerDataConfig.save();

        if (playerDataConfig.get().contains("data")) {
            this.restoreData();
        }
    }

    private void loadConfigValues() {
        levelUpMultiplier = (double) getConfig().get("levelUpMultiplier");
    }

    @Override
    public void onDisable() {
        if (!playerData.isEmpty()) {
            this.savePlayerExps();
        }
    }

    private void getCommands() {
        this.getCommand("resetPlayerData").setExecutor(new resetPlayerData());
        this.getCommand("test").setExecutor(new test());
        this.getCommand("mainMenu").setExecutor(new MainMenuCommand());

    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        this.getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    private void savePlayerExps() {

        // Loop through player uuid's
        for (Map.Entry<String, PlayerData> entry : playerData.entrySet()) {
            // Loop through all variables in player data map
            Map<String, Integer> vars = entry.getValue().getPlayerStats();
            for (Map.Entry<String, Integer> val : vars.entrySet()) {
                playerDataConfig.get().set("data." + entry.getKey() + "." + val.getKey(), val.getValue());
            }
            Map<String, Integer> playerSkills = entry.getValue().getPlayerSkills();

            for (Map.Entry<String, Integer> skill : playerSkills.entrySet()) {
                playerDataConfig.get().set("data." + entry.getKey() + ".skills." + skill.getKey(), skill.getValue());
            }
        }

        playerDataConfig.save();
    }

    private void restoreData() {

        FileConfiguration config = playerDataConfig.get();

        config.getConfigurationSection("data").getKeys(false).forEach(player -> {
            playerData.put(player, new PlayerData());
            PlayerData pd = playerData.get(player);

            config.getConfigurationSection("data." + player + ".").getKeys(false).forEach(data -> {
                if (config.get("data." + player + "." + data) instanceof Integer) {
                    pd.setPlayerStats(data, (Integer) config.get("data." + player + "." + data));
                }
            });
        });
    }

}
