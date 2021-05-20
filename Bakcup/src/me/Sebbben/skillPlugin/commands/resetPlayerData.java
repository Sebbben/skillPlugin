package me.Sebbben.skillPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;


public class resetPlayerData implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] ars) {
        if(sender instanceof Player) {
            if(cmd.getName().equalsIgnoreCase("resetPlayerData")){
                if (sender.hasPermission("skillplugin.totalWipe")) {
                    globals.playerData = new HashMap<>();
                    globals.data.getConfig().set("data", "");
                    sender.sendMessage("All Data Wiped");
                }
            }
        }
        return true;
    }


}
