package me.jakegore.orebreakplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class OreBreakPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        // code here
      
    }

    /**
     * Gives the user a diamond pickaxe when they type "//pickaxe"
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("/pickaxe")) {
            Player player = (Player) sender;
            PlayerInventory inventory = player.getInventory();
            inventory.addItem(new ItemStack(Material.DIAMOND_PICKAXE));

            return true;
        }

        return false;

    }

}
