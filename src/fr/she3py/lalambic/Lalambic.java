package fr.she3py.lalambic;

import fr.she3py.lalambic.handlers.InventoryClickHandler;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NonNls;

import java.util.Locale;
import java.util.UUID;

public class Lalambic extends JavaPlugin {
    private static Lalambic plugin;
    
    @Override
    public void onEnable() {
        Lalambic.plugin = this;
        
        this.getServer().getPluginManager().registerEvents(new InventoryClickHandler(), this);
    }
    
    public static boolean isBrewAuthorized(ItemStack base, Material reagent, UUID playerId) {
        var result = BrewingRecipe.getResult(base, reagent);
        
        if(result == null) {
            return true;
        }
        else {
            var player = Lalambic.plugin.getServer().getPlayer(playerId);
            
            return player != null && player.hasPermission(makePermission(reagent, ((PotionMeta) result.getItemMeta()).getBasePotionData().getType()));
        }
    }
    
    @NonNls
    private static String makePermission(Material reagent, PotionType result) {
        String action;
        
        if(reagent == Material.GUNPOWDER) {
            action = "splash";
        }
        else if(reagent == Material.DRAGON_BREATH) {
            action = "linger";
        }
        else if(reagent == Material.REDSTONE && result != PotionType.MUNDANE) {
            action = "lengthen";
        }
        else if(reagent == Material.GLOWSTONE_DUST && result != PotionType.THICK) {
            action = "strengthen";
        }
        else {
            action = "brew";
        }
        
        return "lalambic." + action + '.' + result.name().toLowerCase(Locale.ROOT);
    }
}
