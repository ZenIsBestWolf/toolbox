package me.zenisbestwolf.canyoudumbass;

import org.bukkit.plugin.java.JavaPlugin;

import me.zenisbestwolf.canyoudumbass.Listeners.*;

public class Main extends JavaPlugin{
	public void onEnable() {
		new Block(this);
	}
}