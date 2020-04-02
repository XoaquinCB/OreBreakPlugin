package me.jakegore.orebreakplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class OreBreakPlugin extends JavaPlugin {
    
    @Override
    public void onEnable() {
        
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().addRecipe(CustomPickaxe.getRecipe(this));
        
    }
    
    /**
     * Gives the user the custom pickaxe when they type "/orebreak"
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (cmd.getName().equalsIgnoreCase("orebreak") && args.length == 0) {
            
            if (sender instanceof Player) {
                Player player = (Player) sender;
                PlayerInventory inventory = player.getInventory();
                
                inventory.addItem(CustomPickaxe.getCustomPickaxe());
                
                return true;
            }
            
        }
        
        return false;
        
    }
    
}
