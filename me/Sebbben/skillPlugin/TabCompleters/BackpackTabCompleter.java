package me.Sebbben.skillPlugin.TabCompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackpackTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        List<String> list = new ArrayList<>();
        List<String> possibleCompletes = Arrays.asList("Miner","Logger");
        for (String i : possibleCompletes) {
            if (i.startsWith(args[0])) {
                list.add(i);
            }
        }
        return list;
    }
}
