package me.ruairiw8.skywarsduels.manager;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerManager {

    public PlayerManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    private GameManager gameManager;

    public void giveKits() {
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.SURVIVAL).forEach(this::giveKit);
    }

    public void giveKit(Player player) {
        player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
        player.getInventory().addItem(new ItemStack(Material.BOW));
        player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
        player.getInventory().addItem(new ItemStack(Material.ARROW));
    }
    public void clearInventories() {
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.SURVIVAL).forEach(this::clearInventory);
    }
    public void clearInventory(Player player) {
        player.getInventory().clear();
    }

}
