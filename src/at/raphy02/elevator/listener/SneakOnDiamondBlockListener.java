package at.raphy02.elevator.listener;

import at.raphy02.elevator.main.Main;
import at.raphy02.elevator.util.ConfigDebugMode;
import at.raphy02.elevator.util.ConfigMessage;
import at.raphy02.elevator.util.ConfigSound;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class SneakOnDiamondBlockListener implements Listener {

    private Main plugin;
    public SneakOnDiamondBlockListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJump(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        Block block = loc.add(0, -0.1,0).getBlock();

        // Permission
        //if(player.hasPermission("elevator.sneak")) {
            if (block.getBlockData().getMaterial() != Material.AIR) {
                if (block.getBlockData().getMaterial() == Material.DIAMOND_BLOCK || block.getBlockData().getMaterial() == Material.IRON_BLOCK || block.getBlockData().getMaterial() == Material.EMERALD_BLOCK) {
                    double i = loc.getY()-1;
                    while(i > 0) {
                        Location loc_new = player.getLocation();
                        loc_new.setY(i);
                        Block block_new = loc_new.getBlock();
                        if(block_new.getBlockData().getMaterial() == Material.DIAMOND_BLOCK || block_new.getBlockData().getMaterial() == Material.IRON_BLOCK || block_new.getBlockData().getMaterial() == Material.EMERALD_BLOCK) {
                            loc.setY(i+1);
                            player.teleport(loc);
                            ConfigMessage configMessage = new ConfigMessage(plugin);
                            String[] messages = configMessage.loadMessages();

                            ConfigSound configSound = new ConfigSound(plugin);
                            String[] sounds = configSound.loadSound();
                            Sound sound = Sound.valueOf(sounds[1]);

                            ConfigDebugMode configDebugMode = new ConfigDebugMode(plugin);
                            String debugMode = configDebugMode.loadDebugMode();

                            if(messages[1] != null) {
                                player.sendTitle("§c" + messages[1], null, 10, 10, 10);
                            } else if(debugMode.equals("true") || debugMode.equals("enabled")) {
                                player.sendMessage(Main.prefix + "§cPlease use: §6/elevator setDownMessage <MESSAGE> §cto setup the messages. §8If you think this is a bug please contact an administrator.");
                            }
                            player.playSound(player.getLocation(), sound, 1f, 1f);
                            break;
                        }
                        i--;
                    }
                }
            }
        //}
    }
}
