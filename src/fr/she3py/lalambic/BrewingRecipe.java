package fr.she3py.lalambic;

import com.google.common.collect.ImmutableList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

public class BrewingRecipe {
    @Unmodifiable
    private static final List<BrewingRecipe> REGISTRY = ImmutableList.<BrewingRecipe>builder()
        //                                base          +        reagent             =>             result
        .add(new BrewingRecipe(PotionType.WATER,        Material.GLOWSTONE_DUST,         PotionType.THICK))
        .add(new BrewingRecipe(PotionType.WATER,        Material.NETHER_WART,            PotionType.AWKWARD))
        .add(new BrewingRecipe(PotionType.AWKWARD,      Material.GOLDEN_CARROT,          PotionType.NIGHT_VISION))
        .add(new BrewingRecipe(PotionType.NIGHT_VISION, Material.FERMENTED_SPIDER_EYE,   PotionType.INVISIBILITY))
        .add(new BrewingRecipe(PotionType.AWKWARD,      Material.RABBIT_FOOT,            PotionType.JUMP))
        .add(new BrewingRecipe(PotionType.JUMP,         Material.FERMENTED_SPIDER_EYE,   PotionType.SLOWNESS))
        .add(new BrewingRecipe(PotionType.AWKWARD,      Material.MAGMA_CREAM,            PotionType.FIRE_RESISTANCE))
        .add(new BrewingRecipe(PotionType.AWKWARD,      Material.SUGAR,                  PotionType.SPEED))
        .add(new BrewingRecipe(PotionType.SPEED,        Material.FERMENTED_SPIDER_EYE,   PotionType.SLOWNESS))
        .add(new BrewingRecipe(PotionType.AWKWARD,      Material.PUFFERFISH,             PotionType.WATER_BREATHING))
        .add(new BrewingRecipe(PotionType.AWKWARD,      Material.GLISTERING_MELON_SLICE, PotionType.INSTANT_HEAL))
        .add(new BrewingRecipe(PotionType.INSTANT_HEAL, Material.FERMENTED_SPIDER_EYE,   PotionType.INSTANT_DAMAGE))
        .add(new BrewingRecipe(PotionType.AWKWARD,      Material.SPIDER_EYE,             PotionType.POISON))
        .add(new BrewingRecipe(PotionType.POISON,       Material.FERMENTED_SPIDER_EYE,   PotionType.INSTANT_DAMAGE))
        .add(new BrewingRecipe(PotionType.AWKWARD,      Material.GHAST_TEAR,             PotionType.REGEN))
        .add(new BrewingRecipe(PotionType.AWKWARD,      Material.BLAZE_POWDER,           PotionType.STRENGTH))
        .add(new BrewingRecipe(PotionType.WATER,        Material.FERMENTED_SPIDER_EYE,   PotionType.WEAKNESS))
        .add(new BrewingRecipe(PotionType.AWKWARD,      Material.TURTLE_HELMET,          PotionType.TURTLE_MASTER))
        .add(new BrewingRecipe(PotionType.AWKWARD,      Material.PHANTOM_MEMBRANE,       PotionType.SLOW_FALLING))
        .build();
    
    @Unmodifiable
    private static final List<Material> MUNDANE_REAGENTS = ImmutableList.of(
        Material.SPIDER_EYE,
        Material.GHAST_TEAR,
        Material.RABBIT_FOOT,
        Material.BLAZE_POWDER,
        Material.GLISTERING_MELON_SLICE,
        Material.SUGAR,
        Material.MAGMA_CREAM,
        Material.REDSTONE
    );
    
    private final PotionType base;
    private final Material reagent;
    private final PotionType result;
    
    private BrewingRecipe(PotionType base, Material reagent, PotionType result) {
        this.base = base;
        this.reagent = reagent;
        this.result = result;
    }
    
    @Nullable
    private static PotionType makePotion(PotionType base, Material reagent) {
        for(var recipe : REGISTRY) {
            if(recipe.base == base && recipe.reagent == reagent) {
                return recipe.result;
            }
        }
        
        if(base == PotionType.WATER && MUNDANE_REAGENTS.contains(reagent)) {
            return PotionType.MUNDANE;
        }
        
        return null;
    }

    public static ItemStack getResult(ItemStack base, Material reagent) {
        if(base.getItemMeta() instanceof PotionMeta meta) {
            if(base.getType() == Material.POTION && reagent == Material.GUNPOWDER) {
                var result = new ItemStack(Material.SPLASH_POTION);
                result.setItemMeta(meta);
                
                return result;
            }
            
            if(base.getType() == Material.SPLASH_POTION && reagent == Material.DRAGON_BREATH) {
                var result = new ItemStack(Material.LINGERING_POTION);
                result.setItemMeta(meta);
                
                return result;
            }
            
            var potion = meta.getBasePotionData();
            
            if(potion.getType().isExtendable() && reagent == Material.REDSTONE) {
                if(potion.isUpgraded()) {
                    return null;
                }
                else {
                    var result = new ItemStack(base.getType());
                    var rmeta = (PotionMeta) result.getItemMeta();
                    
                    rmeta.setBasePotionData(new PotionData(potion.getType(), true, false));
                    result.setItemMeta(rmeta);
                    
                    return result;
                }
            }
            
            if(potion.getType().isUpgradeable() && reagent == Material.GLOWSTONE_DUST) {
                if(potion.isExtended()) {
                    return null;
                }
                else {
                    var result = new ItemStack(base.getType());
                    var rmeta = (PotionMeta) result.getItemMeta();
                    
                    rmeta.setBasePotionData(new PotionData(potion.getType(), false, true));
                    result.setItemMeta(rmeta);
                    
                    return result;
                }
            }
            
            var ptype = makePotion(potion.getType(), reagent);
            if(ptype != null) {
                var result = new ItemStack(base.getType());
                var rmeta = (PotionMeta) result.getItemMeta();
                
                rmeta.setBasePotionData(new PotionData(ptype, potion.isExtended(), potion.isUpgraded()));
                result.setItemMeta(rmeta);
                
                return result;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
    
    public static boolean isBase(ItemStack stack) {
        return switch(stack.getType()) {
            case POTION, SPLASH_POTION, LINGERING_POTION -> true;
            default -> false;
        };
    }
}
