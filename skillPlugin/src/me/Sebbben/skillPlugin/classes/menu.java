package me.Sebbben.skillPlugin.classes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class menu {
    private Inventory inv;
    private String title;

    public menu(String name,int size) {
        inv = Bukkit.createInventory(null,size, name);
        title = name;
    }

    public void addItem(Material mat, String title, List<String> lore, int pos) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        if(title != null) meta.setDisplayName(title); else meta.setDisplayName(" ");
        if(lore != null) meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(pos, item);
    }

    public ItemStack getItem(int i){
        return inv.getItem(i);
    }

    public Inventory getInventory() {
        return inv;
    }

    public void fill(Material mat) {
        ItemStack filler = new ItemStack(mat,1);
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.setDisplayName(" ");
        filler.setItemMeta(fillerMeta);

        for(int i=0; i<inv.getSize();i++) {
            if(inv.getItem(i) == null) {
                inv.setItem(i,filler);
            }
        }
    }

    public void open(Player player) {
        player.openInventory(inv);
    }
}
