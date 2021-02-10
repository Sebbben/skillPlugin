package me.Sebbben.skillPlugin.classes;

import java.util.Arrays;
import java.util.List;

public class playerData {
    private int
            exp,
            lvl,
            miningLvl,
            excavationLvl,
            farmingLvl,
            deforestationLvl,
            fishingLvl;

    public playerData(
            String exp,
            String lvl,
            String miningLvl,
            String excavationLvl,
            String farmingLvl,
            String deforestationLvl,
            String fishingLvl
            ) {
        this.exp = Integer.valueOf(exp);
        this.lvl = Integer.valueOf(lvl);
        this.miningLvl = Integer.valueOf(miningLvl);
        this.excavationLvl = Integer.valueOf(excavationLvl);
        this.farmingLvl = Integer.valueOf(farmingLvl);
        this.deforestationLvl = Integer.valueOf(deforestationLvl);
        this.fishingLvl = Integer.valueOf(fishingLvl);


    }

    public void addExp(int amount) {
        this.exp += amount;
    }

    public int getExp() {
        return this.exp;
    }
    public void restExp() {
        this.exp = 0;
    }

    public List<String> getAllVars() {
        return Arrays.asList(
                String.valueOf(exp),
                String.valueOf(lvl),
                String.valueOf(miningLvl),
                String.valueOf(excavationLvl),
                String.valueOf(farmingLvl),
                String.valueOf(deforestationLvl),
                String.valueOf(fishingLvl)
        );
    }

}
