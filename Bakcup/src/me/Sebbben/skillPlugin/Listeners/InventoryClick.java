package me.Sebbben.skillPlugin.Listeners;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class InventoryClick implements Listener {

    public menuHandler invs = new menuHandler();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        HumanEntity player = e.getWhoClicked();

        if(Arrays.asList(
                "Skills "+player.getName(),
                "Mining",
                "Deforestation",
                "Fishing",
                "Farming",
                "Excavation"
        ).contains(e.getView().getTitle())) e.setCancelled(true);

        if(e.getView().getTitle().equalsIgnoreCase("Skills "+player.getName())) {
            switch (e.getCurrentItem().getItemMeta().getDisplayName().toLowerCase(Locale.ROOT)) {
                case "mining":
                    invs.openMining(player);
                    break;
                case "deforestation":
                    invs.openDeforestation(player);
                    break;
                case "framing":
                    invs.openFarming(player);
                    break;
                case "excavation":
                    invs.openExcavation(player);
                    break;
                case "fishing":
                    invs.openFishing(player);
                    break;
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("Mining")) {
            List<String> lvl1 = Arrays.asList("Skill");
            if(lvl1.contains(e.getCurrentItem().getItemMeta().getDisplayName())
                    && globals.playerData.get(player.getUniqueId().toString()).getSkillPoints() >= 2) {
                globals.playerData.get(player.getUniqueId().toString()).addPlayerStats("skillPoints",-2);
                globals.playerData.get(player.getUniqueId().toString()).addSkill("testSkill",1);
                player.sendMessage("Skill acquired!!");
                player.closeInventory();

            }
        }
    }
}
