package me.Sebbben.skillPlugin.BackpacksPlugin;

import me.Sebbben.BackpacksPlugin.Commands.BackpackCommand;
import me.Sebbben.BackpacksPlugin.Listeners.MenuListener;
import me.Sebbben.BackpacksPlugin.MenuSystem.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main extends JavaPlugin {

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    private static Main plugin;

    @Override
    public void onEnable() {

        plugin = this;

        this.getCommand("backpack").setExecutor(new BackpackCommand());
        this.getServer().getPluginManager().registerEvents(new MenuListener(),this);

        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        loadBackpackMats();
    }

    @Override
    public void onDisable() {

    }

    public static List<Material> getBackpackMats() {
        return backpackMats;
    }

    private void loadBackpackMats() {
        backpackMats.addAll(Arrays.asList(
                Material.STONE,
                Material.IRON_ORE
        ));
    }

    private static final List<Material> backpackMats = new ArrayList<>();

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

    public static Main getPlugin() {
        return plugin;
    }

}
