package kr.vanilage.parkour;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Parkour extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ToggleFallingBlock(), this);
        Bukkit.getPluginManager().registerEvents(new StandBlock(), this);
        Bukkit.getPluginManager().registerEvents(new InteractionBlock(), this);
    }
}
