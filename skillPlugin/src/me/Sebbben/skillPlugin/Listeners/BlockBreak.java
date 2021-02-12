package me.Sebbben.skillPlugin.Listeners;

import me.Sebbben.skillPlugin.classes.playerData;
import me.Sebbben.skillPlugin.globals;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Arrays;
import java.util.List;

public class BlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        HumanEntity player = e.getPlayer();
        Block block = e.getBlock();
        Material blockMat = block.getType();


        List<Material> tier1 = Arrays.asList(
                Material.GRASS_BLOCK,
                Material.SAND,
                Material.DIRT,
                Material.ANDESITE,
                Material.DIORITE,
                Material.GRANITE,
                Material.RED_SAND,
                Material.STONE,
                Material.GRAVEL,
                Material.NETHERRACK
                );

        List<Material> tier2 = Arrays.asList(
                Material.WARPED_ROOTS,
                Material.CRIMSON_ROOTS,
                Material.SPRUCE_LOG,
                Material.ACACIA_LOG,
                Material.JUNGLE_LOG,
                Material.BIRCH_LOG,
                Material.DARK_OAK_LOG,
                Material.OAK_LOG
                );

        List<Material> tier3 = Arrays.asList(
                Material.REDSTONE_ORE,
                Material.LAPIS_ORE,
                Material.NETHER_GOLD_ORE,
                Material.COAL_ORE,
                Material.IRON_ORE,
                Material.GOLD_ORE
                );

        List<Material> tier4 = Arrays.asList(
                Material.DIAMOND_ORE,
                Material.EMERALD_ORE,
                Material.ANCIENT_DEBRIS
        );

        playerData playerData = globals.playerData.get(player.getUniqueId().toString());
        if(playerData == null) {
            globals.playerData.put(player.getUniqueId().toString(),new playerData());
            playerData = globals.playerData.get(player.getUniqueId().toString());
        }


        if (tier1.contains(blockMat)) {
            playerData.addExp(1);
        } else if (tier2.contains(blockMat)) {
            playerData.addExp(10);
        } else if (tier3.contains(blockMat)) {
            playerData.addExp(100);
        } else if (tier4.contains(blockMat)) {
            playerData.addExp(1000);
        }

        while (playerData.getExp() >= playerData.getExpRequiredForNextLvl()) {
            player.sendMessage("You leveled up to level " + playerData.getPlayerStats().get("lvl"));
            playerData.levelUp();
            ((Player) player).playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5F,0.5F);
        }
    }
}
