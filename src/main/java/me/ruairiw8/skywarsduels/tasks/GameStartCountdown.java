package me.ruairiw8.skywarsduels.tasks;

import me.ruairiw8.skywarsduels.manager.GameManager;
import me.ruairiw8.skywarsduels.manager.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class GameStartCountdown extends BukkitRunnable {

    public GameStartCountdown(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    private int timeLeft = 10;

    private GameManager gameManager;

    @Override
    public void run() {
        timeLeft--;
        if (timeLeft <= 0) {
            cancel();
            gameManager.setGameState(GameState.ACTIVE);
            return;
        }

        Bukkit.broadcastMessage(ChatColor.YELLOW + "Game starts in " + timeLeft);
    }
}
