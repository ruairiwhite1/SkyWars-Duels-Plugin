package me.ruairiw8.skywarsduels;

import me.ruairiw8.skywarsduels.commands.ResetCommand;
import me.ruairiw8.skywarsduels.commands.StartCommand;
import me.ruairiw8.skywarsduels.commands.loadCommand;
import me.ruairiw8.skywarsduels.commands.resetChestsCommand;
import me.ruairiw8.skywarsduels.listener.BlockBreakListener;
import me.ruairiw8.skywarsduels.manager.ChestManager;
import me.ruairiw8.skywarsduels.manager.GameManager;
import me.ruairiw8.skywarsduels.util.LocalGameMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class SkyWarsDuels extends JavaPlugin {

    private GameManager gameManager;
    private GameMap map;
    private ChestManager chestManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        chestManager = new ChestManager(getConfig());

        getServer().getPluginManager().registerEvents(chestManager, this);

        getDataFolder().mkdirs();

        File gameMapsFolder = new File(getDataFolder(), "gameMaps");
        if(!gameMapsFolder.exists()) {
            gameMapsFolder.mkdirs();
        }

        map = new LocalGameMap(gameMapsFolder, "Hinode", true);

        System.out.println("[Duels] Skywars duels now enabled");

        this.gameManager = new GameManager(this);

        getServer().getPluginManager().registerEvents(new BlockBreakListener(gameManager), this);

        getCommand("start").setExecutor(new StartCommand(gameManager));
        getCommand("reset").setExecutor(new ResetCommand());
        getCommand("load").setExecutor(new loadCommand());
        getCommand("resetchests").setExecutor(new resetChestsCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();
        System.out.println("[Duels] Skywars duels now disabled");

    }
}
