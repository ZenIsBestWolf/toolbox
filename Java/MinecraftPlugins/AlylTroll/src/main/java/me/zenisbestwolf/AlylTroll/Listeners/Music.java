package me.zenisbestwolf.AlylTroll.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;

import me.zenisbestwolf.AlylTroll.Main;

public class Music implements Listener {
    private static Main plugin;
    public Music(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onPlay(PlayerInteractEvent e) {
        String alyl = "Alyl";
        if (e.getPlayer().getName().equals(alyl) && e.getClickedBlock().getType().toString().equals("JUKEBOX") && e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getMaterial().isRecord()) {
            for(Player p : plugin.getServer().getOnlinePlayers()) {
                if (p.hasPermission("fuck.off")) {
                    p.sendMessage("Alyl has begun playing " + e.getMaterial().toString());
                }
            }
        }
    }
}