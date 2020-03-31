package me.jakegore.orebreakplugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockBreakListener extends JavaPlugin implements Listener {
    
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        getLogger().info("Code 0");
        
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        String itemName = item.getItemMeta().getDisplayName();

        if (itemName.equals(OreBreakPlugin.ITEM_NAME)) {
            Block block = event.getBlock();
            
            if (block.getType().equals(Material.COAL_ORE)) {
                getLogger().info("Code 2");
                player.giveExpLevels(100);
            }

        }
        
    }
  
}
