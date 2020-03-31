package me.jakegore.orebreakplugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {
    
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (item.equals(new ItemStack(Material.GOLDEN_PICKAXE))) {
            Block block = event.getBlock();
            
            if (block.getType().equals(Material.COAL_ORE)) {
                player.giveExpLevels(100);
            }
            
        }
        
    }
  
}
