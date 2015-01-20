package me.dutch.Gun;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
	}
	
	@EventHandler
	public void gun(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() != Action.RIGHT_CLICK_AIR) {
			return;
		}
		if (e.getItem().getType() !=Material.WOOD_HOE) {
			return;
		}
		Arrow sb = (Arrow)p.launchProjectile(Arrow.class);
		sb.setVelocity(e.getPlayer().getLocation().getDirection().normalize().multiply(6));
		p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST2, 10.0F, 1.0F );
		sb.getWorld().playEffect(sb.getLocation(), Effect.SMOKE, 5);
		
	}
    }
