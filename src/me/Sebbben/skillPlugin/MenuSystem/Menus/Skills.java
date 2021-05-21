package me.Sebbben.skillPlugin.MenuSystem.Menus;

import me.Sebbben.skillPlugin.Main;
import me.Sebbben.skillPlugin.MenuSystem.Menu;
import me.Sebbben.skillPlugin.MenuSystem.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Skills extends Menu {
    public Skills(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Skills";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();
        switch (e.getCurrentItem().getType()) {
            case BARRIER:
                player.closeInventory();
                break;
            case ARROW:
                new MainMenu(Main.getPlayerMenuUtility(player)).open();
        }
    }

    @Override
    public void setMenuItems() {
        ItemStack close = new ItemStack(Material.BARRIER,1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED+"Close");
        close.setItemMeta(closeMeta);
        inventory.setItem(50, close);

        ItemStack back = new ItemStack(Material.ARROW,1);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.WHITE+"Back");
        back.setItemMeta(backMeta);
        inventory.setItem(48, back);

        addMenuGlass();
    }
}
