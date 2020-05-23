package at.raphy02.elevator.commands;

import at.raphy02.elevator.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SubCommandHandler implements CommandExecutor {
    private Main plugin;

    public SubCommandHandler(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if( sender instanceof Player || args[0].equalsIgnoreCase("setDebugMode" )) {
            Player player = (Player) sender;
            switch( args[0].toLowerCase() ) {
                case "setdebugmode":
                    new DebugModeCommand(plugin, sender, command, label, args);
                    break;

                case "setupmessage":
                case "setdownmessage": {
                    new SetMessageCommand(plugin, player, command, label, args);
                    break;
                }

                case "setsound":
                    new SetSoundCommand(plugin, player, command, label, args);
                    break;

                default:
                    player.sendMessage(Main.prefix + "§cPlease use a real command.");
                    break;
            }
        } else {
            sender.sendMessage(Main.prefix + "§cJust Players can use this command.");
        }
        return false;
    }
}