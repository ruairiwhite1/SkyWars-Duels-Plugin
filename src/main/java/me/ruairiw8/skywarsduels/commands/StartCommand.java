package me.ruairiw8.skywarsduels.commands;

import me.ruairiw8.skywarsduels.manager.GameManager;
import me.ruairiw8.skywarsduels.manager.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {

    private GameManager gameManager;

    public StartCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        gameManager.setGameState(GameState.STARTING);
        return false;
    }
}
