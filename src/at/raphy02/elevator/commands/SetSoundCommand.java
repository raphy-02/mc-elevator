package at.raphy02.elevator.commands;

import at.raphy02.elevator.main.Main;
import at.raphy02.elevator.util.ConfigDebugMode;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SetSoundCommand {
    private Main plugin;
    private Player player;
    private Command command;
    private String label;
    private String[] args;
    private Inventory inv;

    public SetSoundCommand(Main plugin, Player player, Command command, String label, String[] args) {
        this.plugin = plugin;
        this.player = player;
        this.command = command;
        this.label = label;
        this.args = args;

        if (player.hasPermission("elevator.setsound")) {
            if( args.length == 1 ) {
                // Create Inv
                inv = Bukkit.createInventory(player, 9*1, "§6Simple Elevator Sounds");
                initializeItems();

                // Open Inv
                player.openInventory(inv);
            // Falsche Eingabe
            } else {
                player.sendMessage(Main.prefix + "§cPlease use §6/elevator setsound§c.");
            }

        // Keine Berechtigung
        } else {
            player.sendMessage(Main.noPermission);
        }
    }

    // Init Inv Function
    public void initializeItems() {
        inv.setItem(0, createGuiItem(Material.NOTE_BLOCK, "Sound 1"));
        inv.setItem(2, createGuiItem(Material.ENDER_PEARL, "Sound 2"));
        inv.setItem(4, createGuiItem(Material.IRON_BLOCK, "Sound 3"));
        inv.setItem(6, createGuiItem(Material.PISTON, "Sound 4"));
        inv.setItem(8, createGuiItem(Material.SNOW_BLOCK, "Sound 5"));
    }

    // Create Custom Items Function
    protected ItemStack createGuiItem(Material material, String name) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        assert meta != null;
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList("§6Simple Elevator Sounds", "§8LEFTCLICK - Select this sound", "§8RIGHTCLICK - Play this sound"));

        item.setItemMeta(meta);

        return item;
    }
}
