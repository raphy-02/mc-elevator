package at.raphy02.elevator.listener;

import at.raphy02.elevator.main.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class JumpOnDiamondBlockListener implements Listener {

    @EventHandler
    public void onJump(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        Block block = loc.add(0, -0.1,0).getBlock();

        // Permission
        if(player.hasPermission("test02.elevator")) {
            if (block.getBlockData().getMaterial() != Material.AIR) {
                if (player.getVelocity().getY() > 0.3 && block.getBlockData().getMaterial() == Material.DIAMOND_BLOCK) {
                    double i = loc.getY()+1;
                    while(i < 255) {
                        Location loc_new = player.getLocation();
                        loc_new.setY(i);
                        Block block_new = loc_new.getBlock();
                        if(block_new.getBlockData().getMaterial() == Material.DIAMOND_BLOCK ) {
                            loc.setY(i+1);
                            player.teleport(loc);
                            break;
                        }
                        i++;
                    }
                }
            }
        }
    }
}
