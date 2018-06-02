package me.bungeecore.citybuild;

import org.bukkit.plugin.java.JavaPlugin;

public class CityBuild extends JavaPlugin {

    private static CityBuild instance;

    @Override
    public void onEnable() {
        instance = this;
    }
}
