package at.raphy02.elevator.commands;

import at.raphy02.elevator.main.Main;
import at.raphy02.elevator.util.ConfigDebugMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class DebugModeCommand {
    private Main plugin;
    private CommandSender sender;
    private Command command;
    private String label;
    private String[] args;

    public DebugModeCommand(Main plugin, CommandSender sender, Command command, String label, String[] args) {
        this.plugin = plugin;
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;

        if (sender.hasPermission("elevator.setdebugmode")) {
            if(args.length == 2) {
                if( args[1].equalsIgnoreCase("enabled") || args[1].equalsIgnoreCase("true") || args[1].equalsIgnoreCase("1") ) {
                    new ConfigDebugMode(plugin, "enabled").saveDebugMode();
                    sender.sendMessage(Main.prefix + "§aThe Debug Mode is set to §6enabled§a.");
                } else if( args[1].equalsIgnoreCase("disabled") || args[1].equalsIgnoreCase("false") || args[1].equalsIgnoreCase("2") ) {
                    new ConfigDebugMode(plugin, "disabled").saveDebugMode();
                    sender.sendMessage(Main.prefix + "§aThe Debug Mode is set to§6 disabled§a.");
                } else {
                    sender.sendMessage(Main.prefix + "§cPlease use: §6/elevator setDebugMode [enabled/disabled]");
                }
            } else {
                sender.sendMessage(Main.prefix + "§cPlease use: §6/elevator setDebugMode [enabled/disabled]");
            }
        } else {
            sender.sendMessage(Main.noPermission);
        }
    }
}
