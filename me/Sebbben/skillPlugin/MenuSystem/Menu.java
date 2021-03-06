package me.Sebbben.skillPlugin.MenuSystem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class Menu implements InventoryHolder {

    protected Inventory inventory;
    protected PlayerMenuUtility playerMenuUtility;
    protected ItemStack FILLER_GLASS = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
    protected ItemStack FILLER_GLASS_2 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);

    public Menu(PlayerMenuUtility playerMenuUtility) {
        this.playerMenuUtility = playerMenuUtility;
        ItemMeta fillerMeta = FILLER_GLASS.getItemMeta();
        fillerMeta.setDisplayName(" ");
        FILLER_GLASS.setItemMeta(fillerMeta);

        ItemMeta filler2Meta = FILLER_GLASS_2.getItemMeta();
        filler2Meta.setDisplayName(" ");
        FILLER_GLASS_2.setItemMeta(filler2Meta);
    }
    public abstract String getMenuName();
    public abstract int getSlots();
    public abstract void handleMenu(InventoryClickEvent e);
    public abstract void setMenuItems();


    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public void open() {
        inventory = Bukkit.createInventory(this,getSlots(),getMenuName());
        this.setMenuItems();

        this.playerMenuUtility.getOwner().openInventory(inventory);
    }

    protected void addMenuGlass() {
        for (int i = 45; i < 54; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i,FILLER_GLASS);
            }
        }
    }
}