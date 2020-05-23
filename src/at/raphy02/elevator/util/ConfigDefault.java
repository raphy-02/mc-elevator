package at.raphy02.elevator.util;

import at.raphy02.elevator.main.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigDefault {
    private Main plugin;

    public ConfigDefault(Main plugin) {
        this.plugin = plugin;
    }

    public void saveDefaultConfig() {
        FileConfiguration config = plugin.getConfig();
        config.set("DebugMode", "false");
        config.set("Messages.upMessage", "Up");
        config.set("Messages.downMessage", "Down");
        config.set("Sounds.upSound", "BLOCK_NOTE_BLOCK_HARP");
        config.set("Sounds.downSound", "BLOCK_NOTE_BLOCK_BASS");
        plugin.saveConfig();
    }

    public boolean isConfigSet() {
        FileConfiguration config = plugin.getConfig();
        if(config.contains("DebugMode")) {
            return true;
        } else {
            this.saveDefaultConfig();
            return false;
        }
    }
}
