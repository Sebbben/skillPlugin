package me.Sebbben.skillPlugin.commands;

import me.Sebbben.skillPlugin.main;
import me.Sebbben.skillPlugin.globals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class skillExp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] ars) {
        if(sender instanceof Player) {
            if(cmd.getName().equalsIgnoreCase("skillexp")){
                if(globals.playerData.get(((Player) sender).getUniqueId().toString()) != null) {
                    sender.sendMessage(String.valueOf(globals.playerData.get(((Player) sender).getUniqueId().toString()).getExp()));
                } else {
                    sender.sendMessage("You have no skill exps");
                }
            }
        }
        return true;
    }


}
