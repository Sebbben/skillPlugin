package me.Sebbben.skillPlugin;

import me.Sebbben.skillPlugin.Files.playerBackpacks;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHandler {

    public void saveData() {

        if (!Main.getBackpacks().isEmpty()) {
            this.saveBackpacks();
        }
    }

    public void loadData() {

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

    private void loadConfigValues() {
        Main.setLevelUpMultiplier((double) Main.getPlugin().getConfig().get("levelUpMultiplier"));

    }

}
