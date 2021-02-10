package me.Sebbben.skillPlugin.commands;

import me.Sebbben.skillPlugin.classes.menu;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class skill implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] ars) {
        if(sender instanceof Player) {
            if(cmd.getName().equalsIgnoreCase("skill")){
                menu main = new menu("Skills "+sender.getName(), 36);

                main.addItem(Material.WOODEN_PICKAXE,"Mining",Arrays.asList("Your mining skills"),10);
                main.addItem(Material.WOODEN_AXE,"Deforestation",Arrays.asList("Your deforestation skills"),12);
                main.addItem(Material.WOODEN_HOE,"Farming",Arrays.asList("Your farming skills"),14);
                main.addItem(Material.WOODEN_SHOVEL,"Excavation",Arrays.asList("Your excavation skills"),16);
                main.addItem(Material.FISHING_ROD,"Fishing",Arrays.asList("Your fishing skills"),22);



                main.open((Player) sender);
            }
        }
        return true;
    }


}
