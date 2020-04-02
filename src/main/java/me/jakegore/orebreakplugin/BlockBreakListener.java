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
            
            if (isBlockValid(block)) {
                player.giveExpLevels(100);  // left for testing purposes
                
                event.setCancelled(true);
                item.setType(Material.DIAMOND_PICKAXE);  // so that it mines the blocks as though it was a diamond pickaxe (in case it's not)
                block.breakNaturally(item);
                mineSurroundingBlocks(block, item);
            }
            
        }
        
    }
    
    /**
     * Checks if the item is a valid Ore Breaker
     */
    private boolean isItemValid(ItemStack item) {
        
        ItemMeta meta = item.getItemMeta();
        
        if (meta != null) {
            ItemMeta customMeta = CustomPickaxe.getCustomPickaxe().getItemMeta();
            
            if (meta.equals(customMeta)) {
                return true;
            }
            
        }
        
        return false;
        
    }
    
    /**
     * Checks if the block is a valid ore block
     */
    private boolean isBlockValid(Block block) {
        
        Material type = block.getType();
        
        for (Material validBlock : validBlocks) {
            
            if (type.equals(validBlock)) {
                return true;
            }
            
        }
        
        return false;
        
    }
    
    /**
     * Mines all the blocks surrounding startBlock that are of the same type, using the tool
     */
    private void mineSurroundingBlocks(Block startBlock, ItemStack tool) {
        
        ArrayList<Block> surroundingBlocks = getSurroundingBlocks(startBlock);
        
        for (Block block : surroundingBlocks) {
            
            if (block.getType().equals(startBlock.getType())) {
                block.breakNaturally(tool);
                mineSurroundingBlocks(block, tool);
            }
            
        }
        
    }
    
    /**
     * Returns a list containing all the blocks surrounding the input block
     */
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
