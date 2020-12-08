package me.bingorufus.consolelogeventtest;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConsoleLogEventTest extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ConsoleListener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
