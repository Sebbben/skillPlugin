package me.Sebbben.skillPlugin;

import me.Sebbben.skillPlugin.Classes.PlayerData;
import me.Sebbben.skillPlugin.Files.playerBackpacks;
import me.Sebbben.skillPlugin.Files.playerDataConfig;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHandler {

    public void saveData() {
        if (!Main.getPlayerData().isEmpty()) {
            this.savePlayerExps();
        }

        if (!Main.getBackpacks().isEmpty()) {
            this.saveBackpacks();
        }
    }

    public void loadData() {
        if (playerDataConfig.get().contains("data")) {
            this.restoreData();
        }

        if (playerBackpacks.get().contains("data")) {
            this.loadBackpacks();
        }

        this.loadConfigValues();

    }

    private void loadBackpacks() {
        FileConfiguration config = playerBackpacks.get();

        config.getConfigurationSection("data").getKeys(false).forEach(player -> {
            Main.getBackpacks().put(player, new HashMap<>());
            config.getConfigurationSection("data." + player).getKeys(false).forEach(backpack -> {
                ItemStack[] content = ((List<ItemStack>) config.get("data." + player + "." + backpack)).toArray(new ItemStack[0]);
                Main.getBackpacks().get(player).put(backpack, content);
            });

        });
    }
    private void saveBackpacks() {
        HashMap<String, HashMap<String, ItemStack[]>> backpacks = Main.getBackpacks();
        for (Map.Entry<String, HashMap<String, ItemStack[]>> player : backpacks.entrySet()) {
            for (Map.Entry<String, ItemStack[]> backpack : player.getValue().entrySet()) {
                playerBackpacks.get().set("data." + player.getKey() + "." + backpack.getKey(), backpack.getValue());
            }
        }
        playerBackpacks.save();
    }

    private void savePlayerExps() {

        // Loop through player uuid's
        for (Map.Entry<String, PlayerData> entry : Main.getPlayerData().entrySet()) {
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
            Main.getPlayerData().put(player, new PlayerData());
            PlayerData pd = Main.getPlayerData().get(player);

            config.getConfigurationSection("data." + player + ".").getKeys(false).forEach(data -> {
                if (config.get("data." + player + "." + data) instanceof Integer) {
                    pd.setPlayerStats(data, (Integer) config.get("data." + player + "." + data));
                }
            });
        });
    }

    private void loadConfigValues() {
        Main.setLevelUpMultiplier((double) Main.getPlugin().getConfig().get("levelUpMultiplier"));

    }

}
