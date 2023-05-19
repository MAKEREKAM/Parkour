package kr.vanilage.parkour;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StandBlock implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.SOUL_SOIL)) {
            PotionEffect effect = new PotionEffect(PotionEffectType.SLOW, 1, 2, false);
            e.getPlayer().addPotionEffect(effect);
        }

        if (e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.MAGENTA_GLAZED_TERRACOTTA)) {
            PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 1, 9, false);
            e.getPlayer().addPotionEffect(effect);
        }

        if (e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.SCULK)) {
            e.getPlayer().setHealth(0);
        }

        if (e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.VERDANT_FROGLIGHT)) {
            PotionEffect effect = new PotionEffect(PotionEffectType.JUMP, 20, 4,  false);
            e.getPlayer().addPotionEffect(effect);
        }

        if (e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.REINFORCED_DEEPSLATE)) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawnpoint " + e.getPlayer().getName() +  " " + e.getPlayer().getLocation().getBlockX() + " " +  e.getPlayer().getLocation().getBlockY() + " " + e.getPlayer().getLocation().getBlockZ());
        }
    }
}
