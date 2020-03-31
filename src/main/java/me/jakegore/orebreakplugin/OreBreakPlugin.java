package me.jakegore.orebreakplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class OreBreakPlugin extends JavaPlugin {

    public static final String ITEM_NAME = ChatColor.GREEN + "Ore Breaker Pickaxe";

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);

    }

    /**
     * Gives the user a diamond pickaxe when they type "/orebreak"
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("orebreak")) {
            Player player = (Player) sender;
            PlayerInventory inventory = player.getInventory();

            ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ITEM_NAME);
            item.setItemMeta(meta);

            inventory.addItem(item);

            return true;
        }

        return false;

    }

}
