package me.bungeecore.citybuild;

import me.bungeecore.citybuild.apis.SideboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CityBuild extends JavaPlugin {

    private static CityBuild instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    private void initSchedulers() {
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(instance, new Runnable() {
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    new SideboardManager().setSideboard(all);
                }
            }
        }, 20*120, 20*120);
    }
}
