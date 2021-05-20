package me.Sebbben.skillPlugin.commands;

import me.Sebbben.skillPlugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public class test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] ars) {
        if (cmd.getName().equalsIgnoreCase("test")) {
            // ((Player) sender).setWalkSpeed(0.2F); // player walk speed
            //((Player) sender).setCooldown();
            //Material mat = Material.matchMaterial("stone");
            //sender.sendMessage(String.valueOf(mat));
            Main.playerData.get(((Player) sender).getUniqueId().toString()).listSkills((HumanEntity) sender);
        }
        return true;
    }
}
