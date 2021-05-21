package me.Sebbben.skillPlugin.Listeners;

import me.Sebbben.skillPlugin.Main;
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

        Main.expHandler.blockBreakingExp(player,blockMat);

    }
}
