package me.Sebbben.skillPlugin.Commands;

import me.Sebbben.skillPlugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetExpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player && args.length > 0) {
            if(args[0].equalsIgnoreCase("Miner"))
                sender.sendMessage(String.valueOf(Main.getPlayerData(((Player) sender).getUniqueId().toString()).getMinerData().getExp()));
            else if (args[0].equalsIgnoreCase("Digger"))
                sender.sendMessage(String.valueOf(Main.getPlayerData(((Player) sender).getUniqueId().toString()).getDiggerData().getExp()));
            else if (args[0].equalsIgnoreCase("Butcher"))
                sender.sendMessage(String.valueOf(Main.getPlayerData(((Player) sender).getUniqueId().toString()).getButcherData().getExp()));

        }

        return true;
    }
}
