package me.Sebbben.skillPlugin;

import me.Sebbben.skillPlugin.Classes.PlayerData;
import me.Sebbben.skillPlugin.Commands.BackpackCommand;
import me.Sebbben.skillPlugin.Commands.MainMenuCommand;
import me.Sebbben.skillPlugin.Commands.ResetPlayerData;
import me.Sebbben.skillPlugin.Files.playerBackpacks;
import me.Sebbben.skillPlugin.Files.playerBackpacksMaterials;
import me.Sebbben.skillPlugin.Files.playerDataConfig;
import me.Sebbben.skillPlugin.Listeners.BlockBreak;
import me.Sebbben.skillPlugin.Listeners.MenuListener;
import me.Sebbben.skillPlugin.MenuSystem.PlayerMenuUtility;
import me.Sebbben.skillPlugin.TabCompleters.BackpackTabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {

    private static Map<String, PlayerData> playerData = new HashMap<>();
    private static double levelUpMultiplier;
    private static ExpHandling expHandler = new ExpHandling();
    private static Main plugin;
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    private static HashMap<String, HashMap<String, ItemStack[]>> backpacks = new HashMap<>();
    private static DataHandler dataHandler;

    public static Map<String, PlayerData> getPlayerData() {
        return playerData;
    }
    public static double getLevelUpMultiplier() {
        return levelUpMultiplier;
    }
    public static ExpHandling getExpHandler() {
        return expHandler;
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

    public static void setPlayerData(Map<String, PlayerData> playerData) {
        Main.playerData = playerData;
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

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();

        playerDataConfig.setup();
        playerDataConfig.save();

        playerBackpacks.setup();
        playerBackpacks.save();

        playerBackpacksMaterials.setup();
        playerBackpacksMaterials.save();

        this.getCommands();
        this.registerEvents();

        dataHandler = new DataHandler();
        dataHandler.loadData();

        this.getCommand("backpack").setTabCompleter(new BackpackTabCompleter());
    }


    @Override
    public void onDisable() {
        dataHandler.saveData();
    }

    private void getCommands() {
        this.getCommand("resetPlayerData").setExecutor(new ResetPlayerData());
        this.getCommand("mainMenu").setExecutor(new MainMenuCommand());
        this.getCommand("backpack").setExecutor(new BackpackCommand());
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        this.getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

}