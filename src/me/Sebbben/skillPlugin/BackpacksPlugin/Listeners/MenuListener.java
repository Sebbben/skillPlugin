package me.Sebbben.skillPlugin.BackpacksPlugin.Listeners;

import me.Sebbben.BackpacksPlugin.MenuSystem.BackPack;
import me.Sebbben.BackpacksPlugin.MenuSystem.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        InventoryHolder holder = e.getClickedInventory().getHolder();

        if (holder instanceof Menu) {
            e.setCancelled(true);
            Menu menu = (Menu) holder;
            menu.handleMenu(e);
        }
    }
    @EventHandler
    public void onBackpackClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();

        InventoryHolder holder = e.getInventory().getHolder();

        if (holder instanceof Menu) {
            BackPack backpack = (BackPack) holder;
            backpack.menuClose(e);
        }
    }
}
