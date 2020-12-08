package me.bingorufus.consolelogeventtest;

import me.bingorufus.consolelogevent.ConsoleLogEvent;
import org.apache.logging.log4j.message.SimpleMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ConsoleListener implements Listener {
    @EventHandler
    public void onLog(ConsoleLogEvent e){
        if(e.getFormattedMessage().contains("hello")) e.setMessage(new SimpleMessage(e.getFormattedMessage().replace("hello","hi")));
    }

}