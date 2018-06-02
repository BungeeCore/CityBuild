package me.bungeecore.citybuild.apis;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;

public class TabHandler {

    private Scoreboard sb;

    public TabHandler() {
        this.sb = Bukkit.getScoreboardManager().getNewScoreboard();
        registerTeams();
    }

    private void registerTeams() {
        if (sb.getTeam("00000Admin") == null) {
//            sb.registerNewTeam("00000Admin").
        }
    }
}