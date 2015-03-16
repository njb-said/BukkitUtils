package me.imnjb.bukkitutils;

import java.util.UUID;

import org.bukkit.entity.Player;

/**
 * Classes that implement this interface will be accepted
 * by methods which require only a {@link Player} or {@link UUID}
 * <p> Such as those found in {@link PlayerUtils}
 *
 * @author njb_said
 */
public interface CustomPlayer {

    public Player getPlayer();
    public UUID getUUID();

}
