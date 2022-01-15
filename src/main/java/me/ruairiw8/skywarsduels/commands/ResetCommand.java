package me.ruairiw8.skywarsduels.commands;

import me.ruairiw8.skywarsduels.SkyWarsDuels;
import me.ruairiw8.skywarsduels.manager.GameManager;
import me.ruairiw8.skywarsduels.util.LocalGameMap;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetCommand implements CommandExecutor {

    private GameManager gameManager;
    private LocalGameMap localGameMap;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("duels.reset")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command");
        } else {
            localGameMap.restoreFromSource();
        }
        return false;
    }
}
