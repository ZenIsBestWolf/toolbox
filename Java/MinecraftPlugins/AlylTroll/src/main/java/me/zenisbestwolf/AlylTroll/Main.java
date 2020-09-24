package me.zenisbestwolf.AlylTroll;

import org.bukkit.plugin.java.JavaPlugin;
import me.zenisbestwolf.AlylTroll.Listeners.*;

public class Main extends JavaPlugin{
	public void onEnable() {
		new Music(this);
	}
}