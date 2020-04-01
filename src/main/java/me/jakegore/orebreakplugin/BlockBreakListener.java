package me.jakegore.orebreakplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

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
        String itemName = item.getItemMeta().getDisplayName();
        
        if (itemName.equals(CustomPickaxe.ITEM_NAME)) {
            Block block = event.getBlock();
            Material type = block.getType();

            for (Material validBlock : validBlocks) {

                if (type.equals(validBlock)) {
                    player.giveExpLevels(100);  // left for testing purposes
                    mineSurroundingBlocks(block);

                    break;
                }

            }
            
        }
        
    }
    
    public void mineSurroundingBlocks(Block block) {
        // TODO implement this method...
    }
    
    public Block[] getSurroundingBlocks(Block block) {
        
        Block[] surrounding = new Block[6];
        
        Location loc = block.getLocation();
        World world = loc.getWorld();
        
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();
        
        surrounding[0] = world.getBlockAt(x - 1, y, z);
        surrounding[1] = world.getBlockAt(x + 1, y, z);
        surrounding[2] = world.getBlockAt(x, y - 1, z);
        surrounding[3] = world.getBlockAt(x, y + 1, z);
        surrounding[4] = world.getBlockAt(x, y, z - 1);
        surrounding[6] = world.getBlockAt(x, y, z + 1);
        
        return surrounding;
        
    }
    
}
