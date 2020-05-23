package at.raphy02.elevator.util;

import at.raphy02.elevator.main.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigMessage {

    private Main plugin;
    private String message;
    private String root = "Messages";

    public ConfigMessage(Main plugin, String message) {
        this.plugin = plugin;
        this.message = message;
    }

    public ConfigMessage(Main plugin) {
        this.plugin = plugin;
        this.message = null;
    }

    public void saveUpMessage() {
        FileConfiguration config = plugin.getConfig();
        config.set(root + ".upMessage", message);
        plugin.saveConfig();
    }

    public void saveDownMessage() {
        FileConfiguration config = plugin.getConfig();
        config.set(root + ".downMessage", message);
        plugin.saveConfig();
    }

    public String[] loadMessages() {
        FileConfiguration config = plugin.getConfig();
        if(config.contains(root)) {
            String upMessage = config.getString(root + ".upMessage");
            String downMessage = config.getString(root + ".downMessage");
            String[] messages = {
                    upMessage,
                    downMessage,
            };
            return messages;
        } else {
            return null;
        }
    }
}
