package fr.she3py.lalambic.handlers;

import fr.she3py.lalambic.BrewingRecipe;
import fr.she3py.lalambic.Lalambic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.BrewerInventory;

public class InventoryClickHandler implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getInventory() instanceof BrewerInventory brewer) {
            if(!e.isShiftClick()) {
                var cursor = e.getCursor();
                
                if(cursor != null) {
                    int slot = e.getRawSlot();
                    
                    if(slot == 3) {
                        var reagent = cursor.getType();
                        
                        for(int i = 0; i < 3; ++i) {
                            var base = brewer.getItem(i);
                            
                            if(base != null && !Lalambic.isBrewAuthorized(base, reagent, e.getWhoClicked().getUniqueId())) {
                                e.setCancelled(true);
                                return;
                            }
                        }
                    } else if(slot < 3) {
                        var base = cursor;
                        var reagent = brewer.getItem(3);
                        
                        if(reagent != null && !Lalambic.isBrewAuthorized(base, reagent.getType(), e.getWhoClicked().getUniqueId())) {
                            e.setCancelled(true);
                            return;
                        }
                    }
                }
            }
            else {
                var toShift = e.getCurrentItem();
                
                if(toShift != null) {
                    if(BrewingRecipe.isBase(toShift)) {
                        var reagent = brewer.getItem(3);
                        
                        if(reagent != null && !Lalambic.isBrewAuthorized(toShift, reagent.getType(), e.getWhoClicked().getUniqueId())) {
                            e.setCancelled(true);
                            return;
                        }
                    }
                    else {
                        for(int i = 0; i < 3; ++i) {
                            var base = brewer.getItem(i);
                            
                            if(base != null && !Lalambic.isBrewAuthorized(base, toShift.getType(), e.getWhoClicked().getUniqueId())) {
                                e.setCancelled(true);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
