package at.raphy02.elevator.listener;

import at.raphy02.elevator.main.Main;
import at.raphy02.elevator.util.ConfigMessage;
import at.raphy02.elevator.util.ConfigSound;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SoundInvListener implements Listener {
    private Main plugin;
    public SoundInvListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void handleSoundInvClick(InventoryClickEvent event) {
        if( !(event.getWhoClicked() instanceof Player) ) return;
        Player player = (Player) event.getWhoClicked();
        if( event.getView().getTitle().equalsIgnoreCase("§6Simple Elevator Sounds") ) {
            event.setCancelled(true);

            if( event.getCurrentItem() == null ) {
                return;
            }

            switch( event.getCurrentItem().getType() ) {
                case NOTE_BLOCK:
                    if( event.isLeftClick() ) {
                        new ConfigSound(plugin, "BLOCK_NOTE_BLOCK_HARP", "BLOCK_NOTE_BLOCK_BASS").saveSound();
                        player.sendMessage(Main.prefix + "§aThe Sounds were set.");
                        player.closeInventory();
                    }
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 1f, 1f);
                    break;

                case ENDER_PEARL:
                    if( event.isLeftClick() ) {
                        new ConfigSound(plugin, "ENTITY_ENDERMAN_TELEPORT", "ENTITY_ENDERMAN_TELEPORT").saveSound();
                        player.sendMessage(Main.prefix + "§aThe Sounds were set.");
                        player.closeInventory();
                    }
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                    break;

                case IRON_BLOCK:
                    if( event.isLeftClick() ) {
                        new ConfigSound(plugin, "BLOCK_METAL_PLACE", "BLOCK_METAL_BREAK").saveSound();
                        player.sendMessage(Main.prefix + "§aThe Sounds were set.");
                        player.closeInventory();
                    }
                    player.playSound(player.getLocation(), Sound.BLOCK_METAL_PLACE, 1f, 1f);
                    break;

                case PISTON:
                    if( event.isLeftClick() ) {
                        new ConfigSound(plugin, "BLOCK_PISTON_EXTEND", "BLOCK_PISTON_CONTRACT").saveSound();
                        player.sendMessage(Main.prefix + "§aThe Sounds were set.");
                        player.closeInventory();
                    }
                    player.playSound(player.getLocation(), Sound.BLOCK_PISTON_EXTEND, 1f, 1f);
                    break;

                case SNOW_BLOCK:
                    if( event.isLeftClick() ) {
                        new ConfigSound(plugin, "BLOCK_SNOW_PLACE", "BLOCK_SNOW_BREAK").saveSound();
                        player.sendMessage(Main.prefix + "§aThe Sounds were set.");
                        player.closeInventory();
                    }
                    player.playSound(player.getLocation(), Sound.BLOCK_SNOW_PLACE, 1f, 1f);
                    break;

                default:
                    player.sendMessage( Sound.BLOCK_NOTE_BLOCK_HARP + "" );
                    player.sendMessage( event.getCurrentItem().getType().name() + "" );
                    break;
            }
        }
    }
}
