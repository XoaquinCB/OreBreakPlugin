package me.jakegore.orebreakplugin;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

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
    
    public static final ShapedRecipe getRecipe() {
        
        ShapedRecipe recipe = new ShapedRecipe(null, getCustomPickaxe());
        
        recipe.shape("*%*","%P%","*%*");
        
        recipe.setIngredient('*', Material.ACACIA_BOAT);
        recipe.setIngredient('%', Material.SUGAR);
        recipe.setIngredient('P', Material.GOLDEN_PICKAXE);
        
        return recipe;
        
    }
    
}
