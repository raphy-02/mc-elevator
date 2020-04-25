package at.raphy02.elevator.main;

import at.raphy02.elevator.listener.JumpOnDiamondBlockListener;
import at.raphy02.elevator.listener.SneakOnDiamondBlockListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        // Listeners
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JumpOnDiamondBlockListener(), this);
        pluginManager.registerEvents(new SneakOnDiamondBlockListener(), this);
    }
}