package me.imnjb.bukkitutils;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * A class to make sending messages easier
 *
 * @author njb_said
 */
public class Sender {

    public static final String CHAR = String.valueOf(ChatColor.COLOR_CHAR);

    /**
     * Quickly color a string
     *
     * @param str string to colorize
     * @return the string that is now colored
     */
    public static String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    /**
     * Quickly color a list of strings
     *
     * @param str string to colorize
     * @return the list that is now colored
     * @see Sender#color(String)
     */
    public static List<String> color(List<String> list) {
        for(int i = 0; i < list.size(); i++) {
            list.set(i, color("&7" + list.get(i)));
        }

        return list;
    }

    /**
     * Send a message to a player
     *
     * @param obj who to send to
     * @param message the message
     */
    public static void tell(CommandSender obj, String message) {
        if(obj == null || message == null) {
            return;
        }
        obj.sendMessage(color("&7" + message));
    }

    /**
     * Output a message to the console
     *
     * @param str the message to log
     */
    public static void log(String str) {
        if(str.isEmpty()) {
            System.out.println("");
            return;
        }

        if(Bukkit.getConsoleSender() == null) {
            System.out.println(ChatColor.stripColor(color(str)));
        } else {
            Bukkit.getConsoleSender().sendMessage(color(str));
        }
    }

}
