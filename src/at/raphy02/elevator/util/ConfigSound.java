package at.raphy02.elevator.util;

import at.raphy02.elevator.main.Main;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigSound {
    private Main plugin;
    private String upSound;
    private String downSound;
    private String root = "Sounds";

    public ConfigSound(Main plugin, String upSound, String downSound) {
        this.plugin = plugin;
        this.upSound = upSound;
        this.downSound = downSound;
    }

    public ConfigSound(Main plugin) {
        this.plugin = plugin;
        this.upSound = null;
        this.downSound = null;
    }

    public void saveSound() {
        FileConfiguration config = plugin.getConfig();
        config.set(root + ".upSound", upSound);
        config.set(root + ".downSound", downSound);
        plugin.saveConfig();
    }

    public String[] loadSound() {
        FileConfiguration config = plugin.getConfig();
        if(config.contains(root)) {
            String upSound = config.getString(root + ".upSound");
            String downSound = config.getString(root + ".downSound");
            String[] sounds = {
                    upSound,
                    downSound,
            };
            return sounds;
        } else {
            return null;
        }
    }
}
