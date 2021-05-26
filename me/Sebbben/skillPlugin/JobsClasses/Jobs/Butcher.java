package me.Sebbben.skillPlugin.JobsClasses.Jobs;

import me.Sebbben.skillPlugin.JobsClasses.PlayerData;
import me.Sebbben.skillPlugin.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.HashMap;

public class Butcher implements Listener {
    private final HashMap<EntityType,Integer> expKillableMobs = new HashMap<>();

    public Butcher() {
        expKillableMobs.put(EntityType.SKELETON,1);
        expKillableMobs.put(EntityType.ZOMBIE,1);
        expKillableMobs.put(EntityType.CREEPER,1);
        expKillableMobs.put(EntityType.COW,1);
        expKillableMobs.put(EntityType.CHICKEN,1);
        expKillableMobs.put(EntityType.SHEEP,1);
    }

    @EventHandler
    public void onMurder(EntityDeathEvent e) {
        if (expKillableMobs.get(e.getEntityType()) != null && e.getEntity().getKiller() != null) {
            PlayerData playerData = Main.getPlayerData(e.getEntity().getKiller().getUniqueId().toString());
            playerData.getButcherData().addExp(expKillableMobs.get(e.getEntityType()));
            playerData.updateButcher();
        }
    }
}
