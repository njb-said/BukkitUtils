package me.imnjb.bukkitutils;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

/**
 * A list of player related utils
 *
 * @author njb_said
 * @author CoderCake
 */
public class PlayerUtils {

    /**
     * Clear a players inventory + removes all their potion effects
     *
     * @param player player to clear
     */
    public static void clearInventory(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        for(PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }

        update(player);
    }

    public static void resetXP(Player player) {
        player.setExp(0.0f);
        player.setLevel(0);
    }

    /**
     * Heal/feed the player
     *
     * @param player player to heal/feed
     */
    public static void heal(Player player) {
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
    }

    /**
     * Uses {@link #clearInventory(Player)}, {@link #resetXP(Player)} and {@link #heal(Player)}
     */
    public static void reset(Player player) {
        clearInventory(player);
        heal(player);
        resetXP(player);

        player.setFallDistance(0.0f);
        player.setFireTicks(0);
    }

    /**
     * Call the update method
     * <p>
     * This used to be deprecated in bukkit which gave this method a purpose
     */
    public static void update(Player player) {
        player.updateInventory();
    }

    public static void update(CustomPlayer player) {
        update(player.getPlayer());
    }

    public static void reset(CustomPlayer player) {
        reset(player.getPlayer());
    }

    public static void resetXP(CustomPlayer player) {
        resetXP(player.getPlayer());
    }

    public static void heal(CustomPlayer player) {
        heal(player.getPlayer());
    }

    public static void clearInventory(CustomPlayer player) {
        clearInventory(player.getPlayer());
    }

}
