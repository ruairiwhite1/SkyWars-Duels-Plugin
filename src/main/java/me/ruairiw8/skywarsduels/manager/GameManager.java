package me.ruairiw8.skywarsduels.manager;


import me.ruairiw8.skywarsduels.SkyWarsDuels;
import me.ruairiw8.skywarsduels.tasks.GameStartCountdown;
import me.ruairiw8.skywarsduels.util.LocalGameMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class GameManager {

    private final SkyWarsDuels plugin;

    private GameState gameState = GameState.LOBBY;

    private final BlockManager blockManager;
    private final PlayerManager playerManager;
    private LocalGameMap localGameMap;

    private GameStartCountdown gameStartCountdown;


    public GameManager(SkyWarsDuels plugin) {
        this.plugin = plugin;

        this.gameStartCountdown = new GameStartCountdown(this);
        this.playerManager = new PlayerManager(this);
        this.blockManager = new BlockManager(this);

    }

    public void setGameState(GameState gameState) {
        if(this.gameState == GameState.ACTIVE && gameState == GameState.STARTING) return;
        if(this.gameState == gameState) return;
        this.gameState = gameState;
        switch(gameState) {
            case STARTING:
                Bukkit.broadcastMessage(ChatColor.GREEN + "The game will staring in:");
                //start the game
                getPlayerManager().clearInventories();
                this.gameStartCountdown = new GameStartCountdown(this);
                this.gameStartCountdown.runTaskTimer(plugin, 0, 20);
                break;
            case ACTIVE:
                if (this.gameStartCountdown != null) this.gameStartCountdown.cancel();
                Bukkit.broadcastMessage(ChatColor.GREEN + "FIGHT!");
                getPlayerManager().giveKits();
        }
    }

    public void cleanup() {
        localGameMap.restoreFromSource();
    }

    public BlockManager getBlockManager() {return blockManager;}

    public PlayerManager getPlayerManager() {return playerManager;}
}

