package me.Sebbben.skillPlugin.Listeners;

import me.Sebbben.skillPlugin.classes.playerData;
import me.Sebbben.skillPlugin.main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class BlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        HumanEntity player = e.getPlayer();
        Block block = e.getBlock();
        Material blockMat = block.getType();
        ItemStack mainHand = player.getInventory().getItemInMainHand();


        List<Material> mining = Arrays.asList(
                Material.STONE,
                Material.ANDESITE,
                Material.DIORITE,
                Material.GRANITE,
                Material.COAL_ORE,
                Material.IRON_ORE,
                Material.GOLD_ORE,
                Material.DIAMOND_ORE
        );

        List<Material> miningTools = Arrays.asList(
                Material.WOODEN_PICKAXE,
                Material.STONE_PICKAXE,
                Material.IRON_PICKAXE,
                Material.GOLDEN_PICKAXE,
                Material.DIAMOND_PICKAXE,
                Material.NETHERITE_PICKAXE
        );

        List<Material> excavation = Arrays.asList(
                Material.DIRT,
                Material.GRASS_BLOCK,
                Material.GRAVEL,
                Material.SAND,
                Material.RED_SAND
        );
        if(mining.contains(blockMat) && miningTools.contains(mainHand.getType())) {
            if(main.playerData.get(player.getUniqueId().toString()) != null) {
                player.sendMessage("mining");
                main.playerData.get(player.getUniqueId().toString()).addExp(1);
            } else {
                main.playerData.put(player.getUniqueId().toString(),new playerData("0","0","0","0","0","0","0"));
            }
        }

    }
}
