package me.jakegore.orebreakplugin;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockBreakListener implements Listener {
    
    public static final Material[] validBlocks = new Material[] {
        Material.COAL_ORE,
        Material.DIAMOND_ORE,
        Material.EMERALD_ORE,
        Material.GOLD_ORE,
        Material.IRON_ORE,
        Material.LAPIS_ORE,
        Material.NETHER_QUARTZ_ORE,
        Material.REDSTONE_ORE,
    };
    
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (isItemValid(item)) {
            Block block = event.getBlock();
            Material type = block.getType();
            
            for (int i = 0; i < validBlocks.length; i++) {
                
                if (type.equals(validBlocks[i])) {
                    player.giveExpLevels(100);  // left for testing purposes
                    
                    mineSurroundingBlocks(block);
                    break;
                }
                
            }
            
        }
        
    }
    
    private boolean isItemValid(ItemStack item) {
        
        ItemMeta meta = item.getItemMeta();
        
        if (meta == null)
            return false;
        else if (meta.equals(CustomPickaxe.getCustomPickaxe().getItemMeta()))
            return true;
        else
            return false;
        
    }
    
    private void mineSurroundingBlocks(Block startBlock) {
        
        for (Block block : getSurroundingBlocks(startBlock)) {
            
            if (block.getType().equals(startBlock.getType())) {
                mineBlock(block);
                mineSurroundingBlocks(block);
            }
            
        }
        
    }
    
    private void mineBlock(Block block) {
        block.setType(Material.AIR);
    }
    
    private ArrayList<Block> getSurroundingBlocks(Block block) {
        
        ArrayList<Block> surrounding = new ArrayList<Block>();
        
        Location loc = block.getLocation();
        World world = loc.getWorld();
        
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();
        
        surrounding.add(world.getBlockAt(x - 1, y, z));
        surrounding.add(world.getBlockAt(x + 1, y, z));
        surrounding.add(world.getBlockAt(x, y - 1, z));
        surrounding.add(world.getBlockAt(x, y + 1, z));
        surrounding.add(world.getBlockAt(x, y, z - 1));
        surrounding.add(world.getBlockAt(x, y, z + 1));
        
        return surrounding;
        
    }
    
}
