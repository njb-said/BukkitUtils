package me.imnjb.bukkitutils;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * @author njb_said
 */
public class SizeCalculator {

    public static @Getter @AllArgsConstructor enum Sizes {

        ONE(4, 0),
        TWO(3, 2),
        THREE(2, 2),
        FOUR(1, 2),
        FIVE(0, 2),
        MORE(0, 1);

        private final int start, split;

        /**
         * Gets the size value associated with an integer.
         *
         * @param size size as integer
         * @return size as enum
         */
        public static Sizes getFromInt(int size) {
            switch(size) {
                case 1:
                    return ONE;
                case 2:
                    return TWO;
                case 3:
                    return THREE;
                case 4:
                    return FOUR;
                case 5:
                    return FIVE;

                default:
                    return MORE;
            }
        }
    }

    /**
     * Fill an inventory with a list of items,
     * spaced out in a pretty way
     *
     * <p> If list is bigger than 5 nothing special
     * will happen
     *
     * @param inv
     * @param items
     */
    public static void fillInventory(Inventory inv, List<ItemStack> items) {
        Sizes size = Sizes.getFromInt(items.size());
        if(size == Sizes.MORE) {
            for(ItemStack item : items) {
                inv.addItem(item);
            }
        } else {
            int index = size.getStart();
            for(ItemStack item : items) {
                inv.setItem(index, item);
                index += size.getSplit();
            }
        }
    }
}