package com.gmail.justbru00.epic.randombuilders.utils;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.justbru00.epic.randombuilders.chat.Messager;

public class ItemBuilder {

	private ItemStack item;
	private ItemMeta itemMeta;
	
	/**
	 * Creates a new {@link ItemBuilder} object
	 * @param m The material the item should be.
	 */
	public ItemBuilder(Material m) {
		item = new ItemStack(m);
		itemMeta = item.getItemMeta();
	}
	
	public ItemBuilder setAmount(int i) {
		item.setAmount(i);
		return this;
	}
	
	public ItemBuilder setDataValue(int i) {
		item.setDurability((short) i);
		return this;
	}
	
	public ItemBuilder setName(String name) {
		itemMeta.setDisplayName(Messager.color(name));
		return this;
	}
	
	public ItemBuilder setFirstLoreLine(String lore) {
		itemMeta.setLore(Arrays.asList(Messager.color(lore)));
		return this;
	}
	
	public ItemStack build() {
		item.setItemMeta(itemMeta);
		return item;
	}
	
}
