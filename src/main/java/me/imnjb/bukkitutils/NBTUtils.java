package me.imnjb.bukkitutils;

import net.minecraft.server.v1_8_R1.NBTTagCompound;
import net.minecraft.server.v1_8_R1.NBTTagList;

import org.bukkit.craftbukkit.v1_8_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

/**
 * Quicker ways to add useful NBT tags
 *
 * @author CoderCake
 */
public class NBTUtils {

    /**
     * Make an item 'glow' without adding
     * any enchantments
     *
     * @param item item to make glow
     * @return the now glowing item
     */
    public static ItemStack addGlow(ItemStack item) {
        net.minecraft.server.v1_8_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound();

        if(!tag.hasKey("ench")) {
            tag.set("ench", new NBTTagList());
        }

        nmsItem.setTag(tag);
        return CraftItemStack.asCraftMirror(nmsItem);
    }

}
