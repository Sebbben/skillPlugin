package me.Sebbben.skillPlugin.JobsClasses.Jobs;

import me.Sebbben.skillPlugin.JobsClasses.PlayerData;
import me.Sebbben.skillPlugin.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.HashMap;

public class Digger implements Listener {
    private final HashMap<Material,Integer> expDiggableBlocks = new HashMap<>();

    public Digger() {
        expDiggableBlocks.put(Material.DIRT,1);
        expDiggableBlocks.put(Material.COARSE_DIRT,1);
        expDiggableBlocks.put(Material.PODZOL,1);
        expDiggableBlocks.put(Material.MYCELIUM,1);
        expDiggableBlocks.put(Material.GRAVEL,1);
        expDiggableBlocks.put(Material.SAND,1);
        expDiggableBlocks.put(Material.RED_SAND,1);
    }

    @EventHandler
    public void onDigging(BlockBreakEvent e) {
        if (expDiggableBlocks.get(e.getBlock().getType()) != null) {
            PlayerData playerData = Main.getPlayerData(e.getPlayer().getUniqueId().toString());
            playerData.getDiggerData().addExp(expDiggableBlocks.get(e.getBlock().getType()));
            playerData.updateDigger();
        }
    }
}
