package me.Sebbben.skillPlugin;

import java.util.HashMap;
import java.util.Map;

public class globals {
    public static Map<String, me.Sebbben.skillPlugin.classes.playerData> playerData = new HashMap<>();
    public static DataManager data;
    public static double levelUpMultiplier = 1.25;
    public static expHandeling expHandeler = new expHandeling();
}