package me.Sebbben.skillPlugin.MenuSystem;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class PaginatedMenu extends Menu {

    protected int page = 0;
    protected int maxItemPerPage = 45;
    protected int index = 0;

    public PaginatedMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    public void addMenuBorder() {
        ItemStack left = new ItemStack(Material.ARROW,1);
        ItemMeta leftMeta = left.getItemMeta();
        leftMeta.setDisplayName(ChatColor.GREEN + "Left");
        left.setItemMeta(leftMeta);

        inventory.setItem(48, left);

        ItemStack close = new ItemStack(Material.BARRIER,1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        inventory.setItem(49, close);

        ItemStack right = new ItemStack(Material.ARROW,1);
        ItemMeta rightMeta = right.getItemMeta();
        rightMeta.setDisplayName(ChatColor.GREEN + "Right");
        right.setItemMeta(rightMeta);

        inventory.setItem(50, right);

        for (int i = 45; i < 54; i++) {
            if(inventory.getItem(i) == null) {
                inventory.setItem(i, super.FILLER_GLASS);
            }
        }

    }

}
