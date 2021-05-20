package me.Sebbben.skillPlugin;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;


public class menuHandler {
    public menu
            mining,
            deforestation,
            farming,
            excavation,
            fishing;

    public menuHandler() {
        initMining();
        initDeforestation();
        initFarming();
        initExcavation();
        initFishing();
    }

    private void initMining() {
        mining = new menu("Mining", 36);

        mining.addItem(Material.DIAMOND_BLOCK,"Info",null,0);
        mining.addItem(Material.COAL,"Skill", null,10);
        mining.addItem(Material.COAL,"Skill",null,11);
        mining.addItem(Material.COAL,"Skill",null,12);
        mining.addItem(Material.COAL,"Skill",null,13);
        mining.addItem(Material.COAL,"Skill",null,14);
        mining.addItem(Material.COAL_BLOCK,"Ability",null,15);
        mining.addItem(Material.COAL_BLOCK,"Ability",null,16);
        mining.addItem(Material.COAL,"Skill",null,19);
        mining.addItem(Material.COAL,"Skill",null,20);
        mining.addItem(Material.COAL,"Skill",null,21);
        mining.addItem(Material.COAL,"Skill",null,22);
        mining.addItem(Material.COAL,"Skill",null,23);
        mining.addItem(Material.COAL_BLOCK,"Ability",null,24);
        mining.addItem(Material.COAL_BLOCK,"Ability",null,25);


        mining.fill(Material.BLACK_STAINED_GLASS_PANE);

    }
    private void initDeforestation() {
        deforestation = new menu("Deforestation", 36);

        deforestation.addItem(Material.DIAMOND_BLOCK,"Info",null,0);
        deforestation.addItem(Material.COAL,"Skill", null,10);
        deforestation.addItem(Material.COAL,"Skill",null,11);
        deforestation.addItem(Material.COAL,"Skill",null,12);
        deforestation.addItem(Material.COAL,"Skill",null,13);
        deforestation.addItem(Material.COAL,"Skill",null,14);
        deforestation.addItem(Material.COAL_BLOCK,"Ability",null,15);
        deforestation.addItem(Material.COAL_BLOCK,"Ability",null,16);
        deforestation.addItem(Material.COAL,"Skill",null,19);
        deforestation.addItem(Material.COAL,"Skill",null,20);
        deforestation.addItem(Material.COAL,"Skill",null,21);
        deforestation.addItem(Material.COAL,"Skill",null,22);
        deforestation.addItem(Material.COAL,"Skill",null,23);
        deforestation.addItem(Material.COAL_BLOCK,"Ability",null,24);
        deforestation.addItem(Material.COAL_BLOCK,"Ability",null,25);


        deforestation.fill(Material.BLACK_STAINED_GLASS_PANE);

    }
    private void initFarming() {
        farming = new menu("Farming", 36);

        farming.addItem(Material.DIAMOND_BLOCK,"Info",null,0);
        farming.addItem(Material.COAL,"Skill", null,10);
        farming.addItem(Material.COAL,"Skill",null,11);
        farming.addItem(Material.COAL,"Skill",null,12);
        farming.addItem(Material.COAL,"Skill",null,13);
        farming.addItem(Material.COAL,"Skill",null,14);
        farming.addItem(Material.COAL_BLOCK,"Ability",null,15);
        farming.addItem(Material.COAL_BLOCK,"Ability",null,16);
        farming.addItem(Material.COAL,"Skill",null,19);
        farming.addItem(Material.COAL,"Skill",null,20);
        farming.addItem(Material.COAL,"Skill",null,21);
        farming.addItem(Material.COAL,"Skill",null,22);
        farming.addItem(Material.COAL,"Skill",null,23);
        farming.addItem(Material.COAL_BLOCK,"Ability",null,24);
        farming.addItem(Material.COAL_BLOCK,"Ability",null,25);


        farming.fill(Material.BLACK_STAINED_GLASS_PANE);

    }
    private void initExcavation() {
        excavation = new menu("Excavation", 36);

        excavation.addItem(Material.DIAMOND_BLOCK,"Info",null,0);
        excavation.addItem(Material.COAL,"Skill", null,10);
        excavation.addItem(Material.COAL,"Skill",null,11);
        excavation.addItem(Material.COAL,"Skill",null,12);
        excavation.addItem(Material.COAL,"Skill",null,13);
        excavation.addItem(Material.COAL,"Skill",null,14);
        excavation.addItem(Material.COAL_BLOCK,"Ability",null,15);
        excavation.addItem(Material.COAL_BLOCK,"Ability",null,16);
        excavation.addItem(Material.COAL,"Skill",null,19);
        excavation.addItem(Material.COAL,"Skill",null,20);
        excavation.addItem(Material.COAL,"Skill",null,21);
        excavation.addItem(Material.COAL,"Skill",null,22);
        excavation.addItem(Material.COAL,"Skill",null,23);
        excavation.addItem(Material.COAL_BLOCK,"Ability",null,24);
        excavation.addItem(Material.COAL_BLOCK,"Ability",null,25);


        excavation.fill(Material.BLACK_STAINED_GLASS_PANE);

    }
    private void initFishing() {
        fishing = new menu("Fishing", 36);

        fishing.addItem(Material.DIAMOND_BLOCK,"Info",null,0);
        fishing.addItem(Material.COAL,"Skill", null,10);
        fishing.addItem(Material.COAL,"Skill",null,11);
        fishing.addItem(Material.COAL,"Skill",null,12);
        fishing.addItem(Material.COAL,"Skill",null,13);
        fishing.addItem(Material.COAL,"Skill",null,14);
        fishing.addItem(Material.COAL_BLOCK,"Ability",null,15);
        fishing.addItem(Material.COAL_BLOCK,"Ability",null,16);
        fishing.addItem(Material.COAL,"Skill",null,19);
        fishing.addItem(Material.COAL,"Skill",null,20);
        fishing.addItem(Material.COAL,"Skill",null,21);
        fishing.addItem(Material.COAL,"Skill",null,22);
        fishing.addItem(Material.COAL,"Skill",null,23);
        fishing.addItem(Material.COAL_BLOCK,"Ability",null,24);
        fishing.addItem(Material.COAL_BLOCK,"Ability",null,25);


        fishing.fill(Material.BLACK_STAINED_GLASS_PANE);

    }


    public void openMining(HumanEntity player) {
        mining.open((Player) player);
    }
    public void openDeforestation(HumanEntity player) {
        deforestation.open((Player) player);
    }
    public void openFarming(HumanEntity player) {
        farming.open((Player) player);
    }
    public void openExcavation(HumanEntity player) {
        excavation.open((Player) player);
    }
    public void openFishing(HumanEntity player) {
        fishing.open((Player) player);
    }
}
