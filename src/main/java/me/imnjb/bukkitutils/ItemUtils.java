package me.imnjb.bukkitutils;

import java.util.Arrays;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.material.MaterialData;

/**
 * Quicker ways to to create and edit item stacks
 *
 * @author njb_said
 */
public class ItemUtils {

    public static ItemStack create(Material material) {
        return create(material, (short)0);
    }

    public static ItemStack create(Material material, short data) {
        return create(material, 1, data);
    }

    public static ItemStack create(Material material, int amount) {
        return create(material, amount, (short)0);
    }

    public static ItemStack create(Material material, int amount, short data) {
        ItemStack item = new ItemStack(material, amount, data);
        return item;
    }

    @SuppressWarnings("deprecation")
    public static ItemStack create(MaterialData materialData) {
        return create(materialData.getItemType(), materialData.getData());
    }

    public static ItemStack addEnchant(ItemStack item, Enchantment enchant, int level) {
        item.addUnsafeEnchantment(enchant, level < 0 ? 1 : level);
        return item;
    }

    public static ItemStack addEnchant(ItemStack item, Enchantment enchant) {
        return addEnchant(item, enchant, 1);
    }

    public static ItemStack addUnbreaking(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack[] addUnbreaking(ItemStack[] items) {
        for(int i = 0; i < items.length; i++) {
            ItemStack item = items[i];

            if(item != null && item.getType() != Material.AIR) {
                ItemMeta meta = item.getItemMeta();
                meta.spigot().setUnbreakable(true);
                item.setItemMeta(meta);
                items[i] = item;
            }
        }

        return items;
    }

    public static ItemStack[] addEnchant(ItemStack[] items, Enchantment enchant, int level) {
        for(ItemStack item : items) {
            if(item != null) {
                addEnchant(item, enchant, level);
            }
        }

        return items;
    }

    public static ItemStack[] addEnchant(ItemStack[] items, Enchantment enchant) {
        for(ItemStack item : items) {
            if(item != null) {
                addEnchant(item, enchant);
            }
        }

        return items;
    }

    public static ItemStack setColor(ItemStack item, Color color, boolean unbreaking) {
        if(item.getItemMeta() instanceof LeatherArmorMeta) {
            LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
            meta.setColor(color);
            item.setItemMeta(meta);
            return addUnbreaking(item);
        }

        return item;
    }

    public static ItemStack setName(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Sender.color("&r" + name));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack setLore(ItemStack item, String...lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Sender.color(Arrays.asList(lore)));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack setOwner(ItemStack item, String owner) {
        if(owner != null && owner.length() > 0 && item.getType() == Material.SKULL_ITEM && item.getDurability() == 3) {
            SkullMeta meta = (SkullMeta)item.getItemMeta();
            meta.setOwner(owner);
            item.setItemMeta(meta);
        }

        return item;
    }

}