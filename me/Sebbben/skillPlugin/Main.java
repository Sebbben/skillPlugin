package me.Sebbben.skillPlugin;

import me.Sebbben.skillPlugin.Commands.BackpackCommand;
import me.Sebbben.skillPlugin.Commands.MainMenuCommand;
import me.Sebbben.skillPlugin.Commands.ResetPlayerData;
import me.Sebbben.skillPlugin.Files.playerBackpacks;
import me.Sebbben.skillPlugin.Files.playerBackpacksMaterials;
import me.Sebbben.skillPlugin.Files.playerDataConfig;
import me.Sebbben.skillPlugin.JobsClasses.Jobs.Butcher;
import me.Sebbben.skillPlugin.JobsClasses.Jobs.Digger;
import me.Sebbben.skillPlugin.JobsClasses.Jobs.Miner;
import me.Sebbben.skillPlugin.JobsClasses.PlayerData;
import me.Sebbben.skillPlugin.Listeners.MenuListener;
import me.Sebbben.skillPlugin.MenuSystem.PlayerMenuUtility;
import me.Sebbben.skillPlugin.TabCompleters.BackpackTabCompleter;
import me.Sebbben.skillPlugin.TabCompleters.GetExpTabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin {

    private static HashMap<String, PlayerData> playerDataHashMap = new HashMap<>();
    private static double levelUpMultiplier;
    private static Main plugin;
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    private static HashMap<String, HashMap<String, ItemStack[]>> backpacks = new HashMap<>();
    private static DataHandler dataHandler;


    public static double getLevelUpMultiplier() {
        return levelUpMultiplier;
    }
    public static HashMap<Player, PlayerMenuUtility> getPlayerMenuUtilityMap() {
        return playerMenuUtilityMap;
    }
    public static HashMap<String, HashMap<String, ItemStack[]>> getBackpacks() {
        return backpacks;
    }
    public static Main getPlugin() {
        return plugin;
    }
    public static DataHandler getDataHandler() {
        return dataHandler;
    }
    public static PlayerData getPlayerData(String uuid) {
        if (playerDataHashMap.get(uuid) == null) {
            playerDataHashMap.put(uuid, new PlayerData(plugin.getServer().getPlayer(UUID.fromString(uuid)), "Miner"));
        }
        return playerDataHashMap.get(uuid);
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

    public static void setLevelUpMultiplier(double lvlUpMultiplier) {
        levelUpMultiplier = lvlUpMultiplier;
    }

    public static void resetPlayerData() {
        playerDataHashMap = new HashMap<>();
    }

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        this.loadConfigs();

        this.getCommands();
        this.registerEvents();
        this.registerTabCompleters();

        dataHandler = new DataHandler();
        dataHandler.loadData();

    }



    @Override
    public void onDisable() {
        dataHandler.saveData();
    }

    private void loadConfigs() {
        saveDefaultConfig();

        playerDataConfig.setup();
        playerDataConfig.save();

        playerBackpacks.setup();
        playerBackpacks.save();

        playerBackpacksMaterials.setup();
        playerBackpacksMaterials.save();
    }
    private void registerTabCompleters() {
        this.getCommand("backpack").setTabCompleter(new BackpackTabCompleter());
        this.getCommand("exp").setTabCompleter(new GetExpTabCompleter());
    }
    private void getCommands() {
        this.getCommand("resetPlayerData").setExecutor(new ResetPlayerData());
        this.getCommand("mainMenu").setExecutor(new MainMenuCommand());
        this.getCommand("backpack").setExecutor(new BackpackCommand());
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new MenuListener(), this);

        this.getServer().getPluginManager().registerEvents(new Miner(),this);
        this.getServer().getPluginManager().registerEvents(new Digger(),this);
        this.getServer().getPluginManager().registerEvents(new Butcher(),this);

    }

}