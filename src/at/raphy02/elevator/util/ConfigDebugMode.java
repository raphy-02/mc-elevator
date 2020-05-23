package at.raphy02.elevator.util;

import at.raphy02.elevator.main.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigDebugMode {

    private Main plugin;
    private String debugMode;
    private String root = "DebugMode";

    public ConfigDebugMode(Main plugin, String debugMode) {
        this.plugin = plugin;
        this.debugMode = debugMode;
    }
    public ConfigDebugMode(Main plugin) {
        this.plugin = plugin;
        this.debugMode = null;
    }

    public void saveDebugMode() {
        FileConfiguration config = plugin.getConfig();
        config.set(root, debugMode);
        plugin.saveConfig();
    }

    public String loadDebugMode() {
        FileConfiguration config = plugin.getConfig();
        if(config.contains(root)) {
            String debugMode = config.getString(root);
            return debugMode;
        } else {
            return null;
        }
    }
}
