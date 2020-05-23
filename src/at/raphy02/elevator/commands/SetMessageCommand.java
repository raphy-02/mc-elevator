package at.raphy02.elevator.commands;

import at.raphy02.elevator.main.Main;
import at.raphy02.elevator.util.ConfigMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetMessageCommand {

    private Main plugin;
    private Player player;
    private Command command;
    private String label;
    private String[] args;

    public SetMessageCommand(Main plugin, Player player, Command command, String label, String[] args) {
        this.plugin = plugin;
        this.player = player;
        this.command = command;
        this.label = label;
        this.args = args;

        if (player.hasPermission("elevator.setmessage")) {
            if(args.length == 2) {
                if(args[0].equalsIgnoreCase("setUpMessage")) {
                    new ConfigMessage(plugin, args[1]).saveUpMessage();
                    player.sendMessage(Main.prefix + "§aThe Up-Message is set to: §6" + args[1]);
                } else if(args[0].equalsIgnoreCase("setDownMessage")) {
                    new ConfigMessage(plugin, args[1]).saveDownMessage();
                    player.sendMessage(Main.prefix + "§aThe Down-Message is set to: §6" + args[1]);
                    // Falsche Usereingabe
                } else {
                    player.sendMessage(Main.prefix + "§cPlease use: §6/elevator setUpMessage <MESSAGE>");
                }
                // Zu wenig / viele Argumente
            } else {
                player.sendMessage(Main.prefix + "§cPlease use: §6/elevator setUpMessage <MESSAGE>");
            }
            // Keine Rechte
        } else {
            player.sendMessage(Main.noPermission);
        }
    }
}
