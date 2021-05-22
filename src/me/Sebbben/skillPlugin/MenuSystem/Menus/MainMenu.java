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

public class MainMenu extends Menu {

    public MainMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Main Menu";
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
            case CRAFTING_TABLE:
                new Info(Main.getPlayerMenuUtility(player)).open();
                break;
            case ARMOR_STAND:
                new Skills(Main.getPlayerMenuUtility(player)).open();
                break;
            case EMERALD:
                new SkillShop(Main.getPlayerMenuUtility(player)).open();
                break;
            case CHEST:
                new Backpacks(Main.getPlayerMenuUtility(player)).open();
                break;
            case DIAMOND:
                new Prestige(Main.getPlayerMenuUtility(player)).open();
                break;
            case BARRIER:
                player.closeInventory();
                break;
        }

    }

    @Override
    public void setMenuItems() {
        ItemStack info = new ItemStack(Material.CRAFTING_TABLE,1);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.WHITE+"Info");
        info.setItemMeta(infoMeta);
        inventory.setItem(10, info);

        ItemStack skills = new ItemStack(Material.ARMOR_STAND,1);
        ItemMeta skillsMeta = skills.getItemMeta();
        skillsMeta.setDisplayName(ChatColor.WHITE+"Skills");
        skills.setItemMeta(skillsMeta);
        inventory.setItem(12, skills);

        ItemStack skillshop = new ItemStack(Material.EMERALD,1);
        ItemMeta skillshopMeta = skillshop.getItemMeta();
        skillshopMeta.setDisplayName(ChatColor.WHITE+"Skill shop");
        skillshop.setItemMeta(skillshopMeta);
        inventory.setItem(14, skillshop);

        ItemStack backpacks = new ItemStack(Material.CHEST,1);
        ItemMeta backpacksMeta = backpacks.getItemMeta();
        backpacksMeta.setDisplayName(ChatColor.WHITE+"Backpacks");
        backpacks.setItemMeta(backpacksMeta);
        inventory.setItem(16, backpacks);

        ItemStack prestige = new ItemStack(Material.DIAMOND,1);
        ItemMeta prestigeMeta = prestige.getItemMeta();
        prestigeMeta.setDisplayName(ChatColor.GOLD+"Prestige");
        prestige.setItemMeta(prestigeMeta);
        inventory.setItem(31, prestige);

        ItemStack close = new ItemStack(Material.BARRIER,1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED+"Close");
        close.setItemMeta(closeMeta);
        inventory.setItem(49, close);

        for (int i = 0; i < 45; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i,FILLER_GLASS_2);
            }
        }

        addMenuGlass();
    }
}
