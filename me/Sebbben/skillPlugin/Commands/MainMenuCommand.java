package me.Sebbben.skillPlugin.Commands;

import me.Sebbben.skillPlugin.Main;
import me.Sebbben.skillPlugin.MenuSystem.Menus.Menus.MainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            new MainMenu(Main.getPlayerMenuUtility(player)).open();

        }

        return true;
    }
}
