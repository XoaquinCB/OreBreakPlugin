package me.jakegore.orebreakplugin;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomPickaxe {
    
    /**
     * Returns the custom pickaxe used in this plugin
     */
    public static ItemStack getCustomPickaxe() {
        
        ItemStack pickaxe = new ItemStack(Material.GOLDEN_PICKAXE);
        ItemMeta im = pickaxe.getItemMeta();
        
        im.setDisplayName(ChatColor.BOLD + "Ore Breaker");
        im.setLore(Arrays.asList("Mines surrounding ores when a single ore is mined"));
        
        pickaxe.setItemMeta(im);
        
        return pickaxe;
        
    }
    
}
