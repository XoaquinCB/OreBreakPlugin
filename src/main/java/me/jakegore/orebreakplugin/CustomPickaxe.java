package me.jakegore.orebreakplugin;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class CustomPickaxe {
    
    public static final Material ITEM_MATERIAL = Material.GOLDEN_PICKAXE;
    public static final String ITEM_NAME = ChatColor.BOLD +  "" + ChatColor.GREEN + "Ore Breaker Pickaxe";
    public static final String ITEM_LORE = "Mines surrounding ores when a single ore is mined";
    
    /**
     * Returns the custom pickaxe used in this plugin
     */
    public static ItemStack getCustomPickaxe() {
        
        ItemStack pickaxe = new ItemStack(ITEM_MATERIAL);
        ItemMeta im = pickaxe.getItemMeta();
        
        im.setDisplayName(ITEM_NAME);
        im.setLore(Arrays.asList(ITEM_LORE));
        
        pickaxe.setItemMeta(im);
        
        return pickaxe;
        
    }
    
    /**
     * Returns the recipe used to make the custom pickaxe
     */
    public static final ShapelessRecipe getRecipe(Plugin plugin) {
        
        NamespacedKey key = new NamespacedKey(plugin, "ore_breaker");
        ShapelessRecipe recipe = new ShapelessRecipe(key, getCustomPickaxe());
        
        recipe.addIngredient(Material.GOLDEN_PICKAXE);
        recipe.addIngredient(Material.COAL_ORE);
        recipe.addIngredient(Material.DIAMOND_ORE);
        recipe.addIngredient(Material.EMERALD_ORE);
        recipe.addIngredient(Material.GOLD_ORE);
        recipe.addIngredient(Material.IRON_ORE);
        recipe.addIngredient(Material.LAPIS_ORE);
        recipe.addIngredient(Material.NETHER_QUARTZ_ORE);
        recipe.addIngredient(Material.REDSTONE_ORE);
        
        return recipe;
        
    }
    
}
