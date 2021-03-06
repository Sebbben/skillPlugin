package me.Sebbben.skillPlugin.MenuSystem.Menus.BackPacks;

import me.Sebbben.skillPlugin.Main;
import me.Sebbben.skillPlugin.MenuSystem.BackPack;
import me.Sebbben.skillPlugin.MenuSystem.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinerBackpack extends BackPack {
    public MinerBackpack(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Miner Pack";
    }

    @Override
    public int getSlots() {
        return 36;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        e.setCancelled(false);
    }

    @Override
    public void menuClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();

        for(int i = 0; i < getSlots(); i++) {
            ItemStack item = inventory.getItem(i);
            if (item==null) continue;
            if (!allowedItems.contains(item.getType())) {
                player.getInventory().addItem(item);
                inventory.setItem(i, new ItemStack(Material.AIR,1));
            }
        }
        String playerUUID = playerMenuUtility.getOwner().getUniqueId().toString();

        if(Main.getBackpacks().get(playerUUID).isEmpty())
            Main.getBackpacks().put(playerUUID,new HashMap<>());

        Main.getBackpacks().get(playerUUID).put("Miner", inventory.getContents());

    }

    @Override
    public List<Material> getAllowedItems() {
        return Arrays.asList(
                Material.COBBLESTONE,
                Material.STONE,
                Material.ANDESITE,
                Material.GRANITE,
                Material.DIAMOND_ORE,
                Material.IRON_ORE,
                Material.GOLD_ORE,
                Material.REDSTONE_ORE
        );
    }

    @Override
    public void setMenuItems() {
        String playerUUID = playerMenuUtility.getOwner().getUniqueId().toString();

        if (!Main.getBackpacks().get(playerUUID).isEmpty()) {
            inventory.setContents(Main.getBackpacks().get(playerUUID).get("Miner"));
        }
    }
}
