package me.Sebbben.skillPlugin.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        HumanEntity player = e.getPlayer();
        Material blockMat = e.getBlock().getType();

        globals.expHandeler.blockBreakingExp(player,blockMat);

    }
}
