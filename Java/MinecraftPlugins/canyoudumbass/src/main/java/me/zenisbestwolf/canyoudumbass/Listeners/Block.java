package me.zenisbestwolf.canyoudumbass.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.zenisbestwolf.canyoudumbass.Main;

public class Block implements Listener {
    private static Main plugin;
    public Block(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        e.getPlayer().sendMessage("GOOD JOB FUCKER YOU BROKE: " + e.getBlock().getType().toString());
    }
}