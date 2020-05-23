package at.raphy02.elevator.main;

import at.raphy02.elevator.commands.DebugModeCommand;
import at.raphy02.elevator.commands.SubCommandHandler;
import at.raphy02.elevator.listener.JumpOnDiamondBlockListener;
import at.raphy02.elevator.listener.SneakOnDiamondBlockListener;
import at.raphy02.elevator.listener.SoundInvListener;
import at.raphy02.elevator.util.ConfigDefault;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // Globale Variablen
    public static final String
            prefix = ChatColor.GOLD + "[Simple Elevator] " + ChatColor.RESET,
            noPermission = "§cYou don't have permissions for this!";

    public ConsoleCommandSender console = getServer().getConsoleSender();

    public void onEnable() {
        console.sendMessage(prefix + "The plugin was started.");
        ConfigDefault configDefault = new ConfigDefault(this);
        if( !configDefault.isConfigSet() ) {
            console.sendMessage(prefix + "Default config loaded.");
        }
        // Commands
        getCommand("elevator").setExecutor(new SubCommandHandler(this));

        // Listeners
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JumpOnDiamondBlockListener(this), this);
        pluginManager.registerEvents(new SneakOnDiamondBlockListener(this), this);
        pluginManager.registerEvents(new SoundInvListener(this), this);
    }
}