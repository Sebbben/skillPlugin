package me.Sebbben.skillPlugin;

import me.Sebbben.skillPlugin.Files.DataManager;
import me.Sebbben.skillPlugin.Listeners.BlockBreak;
import me.Sebbben.skillPlugin.Listeners.InventoryClick;
import me.Sebbben.skillPlugin.classes.playerData;
import me.Sebbben.skillPlugin.commands.resetPlayerData;
import me.Sebbben.skillPlugin.commands.skill;
import me.Sebbben.skillPlugin.commands.skillExp;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public class main extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getCommands();
        this.registerEvents();

        globals.data = new DataManager(this);
        if(globals.data.getConfig().contains("data")) {
            this.restoreInvs();
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
    }
    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new InventoryClick(),this);
        this.getServer().getPluginManager().registerEvents(new BlockBreak(),this);
    }
    private void savePlayerExps() {
        for (Map.Entry<String, playerData> entry : globals.playerData.entrySet()) {
            Map<String, Integer> vars = entry.getValue().getPlayerStats();
            for (Map.Entry<String, Integer> val : vars.entrySet()) {
                globals.data.getConfig().set("data." + entry.getKey() + "." + val.getKey(), val.getValue());
            }
        }

        globals.data.saveConfig();
    }
    private void restoreInvs() {
        globals.data.getConfig().getConfigurationSection("data").getKeys(false).forEach(key->{
            globals.playerData.put(key, new playerData());
            playerData pd = globals.playerData.get(key);
            globals.data.getConfig().getConfigurationSection("data."+key+".").getKeys(false).forEach(key2-> {
                pd.setPlayerStats(key2, (Integer) globals.data.getConfig().get("data."+ key + "." + key2));
            });
        });
    }

}
