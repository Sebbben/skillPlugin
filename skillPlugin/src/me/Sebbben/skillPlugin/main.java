package me.Sebbben.skillPlugin;

import me.Sebbben.skillPlugin.Files.DataManager;
import me.Sebbben.skillPlugin.Listeners.BlockBreak;
import me.Sebbben.skillPlugin.Listeners.InventoryClick;
import me.Sebbben.skillPlugin.classes.playerData;
import me.Sebbben.skillPlugin.commands.skill;
import me.Sebbben.skillPlugin.commands.skillExp;
import org.bukkit.Color;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class main extends JavaPlugin {

    public static Map<String, playerData> playerData = new HashMap<String, playerData>();
    public DataManager data;

    @Override
    public void onEnable() {
        this.getCommands();
        this.registerEvents();

        this.data = new DataManager(this);
        if(data.getConfig().contains("data")) {
            this.restoreInvs();
            this.getLogger().log(Level.SEVERE, "restored config");
        }
    }

    @Override
    public void onDisable() {
        if(!playerData.isEmpty()) {
            this.savePlayerExps();
            getLogger().info(Color.RED + "Saved player data to file");
        }
    }

    private void getCommands() {
        this.getCommand("skill").setExecutor(new skill());
        this.getCommand("skillexp").setExecutor(new skillExp());

    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new InventoryClick(),this);
        this.getServer().getPluginManager().registerEvents(new BlockBreak(),this);
    }

    private void savePlayerExps() {
        for (Map.Entry<String, playerData> entry : playerData.entrySet()) {
            List<String> vars = entry.getValue().getAllVars();
            this.data.getConfig().set("data." + entry.getKey() + ".exp", vars.get(0));
            this.data.getConfig().set("data." + entry.getKey() + ".lvl", vars.get(1));
            this.data.getConfig().set("data." + entry.getKey() + ".miningLvl", vars.get(2));
            this.data.getConfig().set("data." + entry.getKey() + ".excavationLvl", vars.get(3));
            this.data.getConfig().set("data." + entry.getKey() + ".farmingLvl", vars.get(4));
            this.data.getConfig().set("data." + entry.getKey() + ".deforestationLvl", vars.get(5));
            this.data.getConfig().set("data." + entry.getKey() + ".fishingLvl", vars.get(6));
        }

        this.data.saveConfig();
    }
    private void restoreInvs() {
        this.data.getConfig().getConfigurationSection("data").getKeys(false).forEach(key->{
            main.playerData.put(key, new playerData(
                    (String) this.data.getConfig().get("data."+key + "." + "exp"),
                    (String) this.data.getConfig().get("data."+key + "." + "lvl"),
                    (String) this.data.getConfig().get("data."+key + "." + "miningLvl"),
                    (String) this.data.getConfig().get("data."+key + "." + "excavationLvl"),
                    (String) this.data.getConfig().get("data."+key + "." + "farmingLvl"),
                    (String) this.data.getConfig().get("data."+key + "." + "deforestationLvl"),
                    (String) this.data.getConfig().get("data."+key + "." + "fishingLvl")
                    ));

        });
    }

}
