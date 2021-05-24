package me.Sebbben.skillPlugin.MenuSystem;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.List;

public abstract class BackPack extends Menu {
    protected final List<Material> allowedItems;
    public BackPack(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
        allowedItems = getAllowedItems();
    }
    public abstract void menuClose(InventoryCloseEvent e);
    public abstract List<Material> getAllowedItems();
}
