package me.Sebbben.skillPlugin.Commands;

import me.Sebbben.skillPlugin.Main;
import me.Sebbben.skillPlugin.MenuSystem.Menus.BackPacks.MinerBackpack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BackpackCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            new MinerBackpack(Main.getPlayerMenuUtility(player)).open();
        }

        return true;
    }
}
