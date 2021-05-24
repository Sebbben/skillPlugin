package me.Sebbben.skillPlugin.Files;

import me.Sebbben.skillPlugin.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class playerBackpacks {
    private static File file;
    private static FileConfiguration customFile;

    public static void setup() {
        file = new File(Main.getPlugin().getDataFolder(), "playerBackpacks.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ignore) {}
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return customFile;
    }

    public static void save() {
        try {
            customFile.save(file);
        } catch (IOException ignore) {}
    }

    public static void reload() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
