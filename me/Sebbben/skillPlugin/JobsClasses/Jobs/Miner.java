package me.Sebbben.skillPlugin.JobsClasses.Jobs;

import me.Sebbben.skillPlugin.JobsClasses.PlayerData;
import me.Sebbben.skillPlugin.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.HashMap;

public class Miner implements Listener {
    private final HashMap<Material,Integer> expMineableBlocks = new HashMap<>();

    public Miner() {
        expMineableBlocks.put(Material.STONE,1);
        expMineableBlocks.put(Material.DIORITE,1);
        expMineableBlocks.put(Material.ANDESITE,1);
        expMineableBlocks.put(Material.GRANITE,1);
        expMineableBlocks.put(Material.COAL_ORE,1);
        expMineableBlocks.put(Material.IRON_ORE,1);
        expMineableBlocks.put(Material.GOLD_ORE,1);
        expMineableBlocks.put(Material.LAPIS_ORE,1);
        expMineableBlocks.put(Material.DIAMOND_ORE,1);
        expMineableBlocks.put(Material.REDSTONE_ORE,1);
    }

    @EventHandler
    public void onMining(BlockBreakEvent e) {
        if (expMineableBlocks.get(e.getBlock().getType()) != null) {
            PlayerData playerData = Main.getPlayerData(e.getPlayer().getUniqueId().toString());
            playerData.getMinerData().addExp(expMineableBlocks.get(e.getBlock().getType()));
            playerData.updateMiner();
        }
    }
}
