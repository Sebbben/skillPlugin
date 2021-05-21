package me.Sebbben.skillPlugin.Listeners;


import me.Sebbben.skillPlugin.MenuSystem.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        InventoryHolder holder = e.getClickedInventory().getHolder();

        if (holder instanceof Menu) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) return;

            Menu menu = (Menu) holder;
            menu.handleMenu(e);
        }
    }
}