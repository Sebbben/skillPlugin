package me.Sebbben.skillPlugin.BackpacksPlugin.MenuSystem;

import org.bukkit.entity.Player;

public class PlayerMenuUtility {

    private Player owner;
    private Player playerToKill;


    public PlayerMenuUtility(Player owner) {
        this.owner = owner;
    }

    public Player getPlayerToKill() {
        return playerToKill;
    }
    public void setPlayerToKill(Player playerToKill) {
        this.playerToKill = playerToKill;
    }

    public Player getOwner() {
        return owner;
    }
    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
