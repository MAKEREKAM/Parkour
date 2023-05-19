package kr.vanilage.parkour;
;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractionBlock implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock().getType().equals(Material.TNT)) {
            e.getClickedBlock().setType(Material.AIR);
            e.getClickedBlock().getWorld().createExplosion(e.getClickedBlock().getLocation(), 3, false);
            e.getClickedBlock().setType(Material.TNT);
        }
    }
}
