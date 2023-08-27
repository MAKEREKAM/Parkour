package kr.vanilage.parkour;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;

public class ToggleFallingBlock implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getHand().equals(EquipmentSlot.OFF_HAND)) return;
        if (e.getPlayer().isSneaking()) return;
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock().getType().equals(Material.CHISELED_STONE_BRICKS)) {
            e.getPlayer().playSound(e.getPlayer(), Sound.UI_BUTTON_CLICK, 100, 0.7F);
            ArrayList<Location> blockList = new ArrayList<>();

            for (int i = -400; i <= 400; i++) {
                for (int j = -64; j <= 64; j++) {
                    for (int k = -400; k <= 400; k++) {
                        if (e.getPlayer().getWorld().getBlockAt(i, j, k).getType().equals(Material.PURPUR_BLOCK)) {
                            blockList.add(new Location(e.getPlayer().getWorld(), i, j, k).add(0.5, 0, 0.5));
                        }
                    }
                }
            }

            for (Entity i : e.getPlayer().getWorld().getEntities()) {
                if (i.getType().equals(EntityType.FALLING_BLOCK)) {
                    i.getLocation().getBlock().setType(Material.PURPUR_BLOCK);
                    i.remove();
                }
            }

            for (Location i : blockList) {
                e.getPlayer().getWorld().getBlockAt(i).setType(Material.AIR);
                FallingBlock block = e.getPlayer().getWorld().spawnFallingBlock(i, Material.MAGENTA_STAINED_GLASS.createBlockData());
                block.setGravity(false);
                block.shouldAutoExpire(false);
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType().equals(Material.MAGENTA_STAINED_GLASS) && !e.getPlayer().isSneaking()) {
            e.setBuild(false);
            FallingBlock block = e.getBlock().getWorld().spawnFallingBlock(e.getBlock().getLocation().add(0.5, 0, 0.5), Material.MAGENTA_STAINED_GLASS.createBlockData());
            block.setGravity(false);
            block.shouldAutoExpire(false);
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getHitBlock() != null && e.getHitBlock().getType().equals(Material.CHISELED_STONE_BRICKS)) {
            e.getHitBlock().getWorld().playSound(e.getHitBlock().getLocation(), Sound.UI_BUTTON_CLICK, 100, 0.7F);
            ArrayList<Location> blockList = new ArrayList<>();

            for (int i = -200; i <= 200; i++) {
                for (int j = -64; j <= 0; j++) {
                    for (int k = -200; k <= 200; k++) {
                        if (e.getHitBlock().getWorld().getBlockAt(i, j, k).getType().equals(Material.PURPUR_BLOCK)) {
                            blockList.add(new Location(e.getHitBlock().getWorld(), i, j, k).add(0.5, 0, 0.5));
                        }
                    }
                }
            }

            for (Entity i : e.getHitBlock().getWorld().getEntities()) {
                if (i.getType().equals(EntityType.FALLING_BLOCK)) {
                    i.getLocation().getBlock().setType(Material.PURPUR_BLOCK);
                    i.remove();
                }
            }

            for (Location i : blockList) {
                e.getHitBlock().getWorld().getBlockAt(i).setType(Material.AIR);
                FallingBlock block = e.getHitBlock().getWorld().spawnFallingBlock(i, Material.MAGENTA_STAINED_GLASS.createBlockData());
                block.setGravity(false);
                block.shouldAutoExpire(false);
            }
        }
    }
}
