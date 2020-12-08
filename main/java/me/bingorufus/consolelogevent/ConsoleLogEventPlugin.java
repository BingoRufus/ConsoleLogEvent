package me.bingorufus.consolelogevent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;


public final class ConsoleLogEventPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        loadFilter();
    }

    @Override
    public void onDisable() {
    }

    private void loadFilter() {
        Logger logger = (Logger) LogManager.getRootLogger();
        Iterator<Filter> filters = logger.getFilters();
        while (filters.hasNext()) { // Prevents duplicate loggers
            Filter f = filters.next();
            if(f == null) continue;
            if (f.getClass().getName().equals(ConsoleFilter.class.getName()) && !f.isStopped()) // Check if the filter is from this plugin
                f.stop();
        }
        Filter f  = new ConsoleFilter();
        Bukkit.getScheduler().runTaskLater(this, () -> logger.addFilter(f),3L);
    }
}
