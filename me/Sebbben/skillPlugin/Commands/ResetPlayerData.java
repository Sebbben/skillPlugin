package me.Sebbben.skillPlugin.Commands;

import me.Sebbben.skillPlugin.Files.playerDataConfig;
import me.Sebbben.skillPlugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;


public class ResetPlayerData implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] ars) {
        if(sender instanceof Player) {
            if(cmd.getName().equalsIgnoreCase("resetPlayerData")){
                if (sender.hasPermission("skillplugin.totalWipe")) {
                    Main.setPlayerData(new HashMap<>());
                    playerDataConfig.get().set("data", "");
                    sender.sendMessage("All Data Wiped");
                }
            }
        }
        return true;
    }


}
