package com.gmail.justbru00.epic.randombuilders.utils;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


/**
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * @author Justin Brubaker
 *
 */
public class RandomItemGiver {
	// Give 54 stacks of 1-10 blocks of random stuff
	
	private static ArrayList<ItemStack> allTheBlocks = new ArrayList<ItemStack>();

	public static void giveRandomItemsToAll() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			Inventory i = p.getInventory();
			int x = 1;
			while (x <= 54) {
				ItemStack is = allTheBlocks.get(ThreadLocalRandom.current().nextInt(0, allTheBlocks.size() - 1)).clone();
				is.setAmount(ThreadLocalRandom.current().nextInt(1, 21));
				
				i.addItem(is);
				x++;
			}
		}
	}
	
	private static void addB(Material m, int dataValue) {
		allTheBlocks.add(new ItemBuilder(m).setDataValue(dataValue).build());
	}
	
	private static void addB(Material m) {
		allTheBlocks.add(new ItemBuilder(m).build());
	}
	
	 /**
	  * Biggest method ever
	  */
	public static void init() {
		addB(Material.ACACIA_DOOR_ITEM);
		addB(Material.ACACIA_FENCE);
		addB(Material.ACACIA_FENCE_GATE);
		addB(Material.ACACIA_STAIRS);
		addB(Material.ACTIVATOR_RAIL);
		addB(Material.ANVIL);
		addB(Material.BEACON);
		addB(Material.BED);
		addB(Material.BEDROCK);
		addB(Material.BIRCH_DOOR_ITEM);
		addB(Material.BIRCH_FENCE);
		addB(Material.BIRCH_FENCE_GATE);
		addB(Material.BIRCH_WOOD_STAIRS);
		addB(Material.BLACK_GLAZED_TERRACOTTA);
		addB(Material.BLACK_SHULKER_BOX);
		addB(Material.BLAZE_POWDER);
		addB(Material.BLAZE_ROD);
		addB(Material.BLUE_GLAZED_TERRACOTTA);
		addB(Material.BLUE_SHULKER_BOX);
		addB(Material.BONE_BLOCK);
		addB(Material.BOOKSHELF);
		addB(Material.BREWING_STAND_ITEM);
		addB(Material.BRICK);
		addB(Material.BRICK_STAIRS);
		addB(Material.BROWN_GLAZED_TERRACOTTA);
		addB(Material.BROWN_MUSHROOM);
		addB(Material.BROWN_SHULKER_BOX);
		addB(Material.CACTUS);
		addB(Material.CAKE);
		addB(Material.CARPET, 0);
		addB(Material.CARPET, 1);
		addB(Material.CARPET, 2);
		addB(Material.CARPET, 3);
		addB(Material.CARPET, 4);
		addB(Material.CARPET, 5);
		addB(Material.CARPET, 6);
		addB(Material.CARPET, 7);
		addB(Material.CARPET, 8);
		addB(Material.CARPET, 9);
		addB(Material.CARPET, 10);
		addB(Material.CARPET, 11);
		addB(Material.CARPET, 12);
		addB(Material.CARPET, 13);
		addB(Material.CARPET, 14);
		addB(Material.CARPET, 15);
		addB(Material.CAULDRON_ITEM);
		addB(Material.CHEST);
		addB(Material.CHORUS_FLOWER);
		addB(Material.CHORUS_PLANT);
		addB(Material.CLAY);
		addB(Material.CLAY_BRICK); // Might be hardened clay
		addB(Material.COAL_BLOCK);
		addB(Material.COAL_ORE);
		addB(Material.COBBLE_WALL);
		addB(Material.COBBLESTONE);
		addB(Material.COBBLESTONE_STAIRS);
		int i = 0;
		while (i <= 15) {
			addB(Material.CONCRETE, i);
			i++;
		}
		i = 0;
		while (i <= 15) {
			addB(Material.CONCRETE_POWDER, i);
			i++;
		}
		addB(Material.CYAN_GLAZED_TERRACOTTA);
		addB(Material.CYAN_SHULKER_BOX);
		addB(Material.DARK_OAK_DOOR_ITEM);
		addB(Material.DARK_OAK_FENCE);
		addB(Material.DARK_OAK_FENCE_GATE);
		addB(Material.DARK_OAK_STAIRS);
		addB(Material.DAYLIGHT_DETECTOR);
		addB(Material.DEAD_BUSH);
		addB(Material.DETECTOR_RAIL);
		addB(Material.DIAMOND_ORE);
		addB(Material.DIAMOND_BLOCK);
		addB(Material.DIODE);
		addB(Material.DIRT);
		addB(Material.DISPENSER);
		addB(Material.DROPPER);
		addB(Material.EMERALD_BLOCK);
		addB(Material.EMERALD_ORE);
		addB(Material.ENCHANTMENT_TABLE);
		addB(Material.END_BRICKS);		
		addB(Material.END_ROD);
		addB(Material.ENDER_CHEST);
		addB(Material.ENDER_PORTAL_FRAME);
		addB(Material.ENDER_STONE);
		addB(Material.FENCE);
		addB(Material.FENCE_GATE);
		addB(Material.FLOWER_POT_ITEM);
		addB(Material.FROSTED_ICE);
		addB(Material.FURNACE);
		addB(Material.GLASS);
		addB(Material.GLOWSTONE);
		addB(Material.GOLD_ORE);
		addB(Material.GOLD_BLOCK);
		addB(Material.GRASS);
		addB(Material.GRAVEL);
		addB(Material.GRAY_GLAZED_TERRACOTTA);
		addB(Material.GRAY_SHULKER_BOX);
		addB(Material.GREEN_GLAZED_TERRACOTTA);
		addB(Material.GREEN_SHULKER_BOX);
		addB(Material.HARD_CLAY);
		addB(Material.HAY_BLOCK);
		addB(Material.HOPPER);
		addB(Material.IRON_ORE);
		addB(Material.IRON_BLOCK);
		addB(Material.IRON_TRAPDOOR);
		addB(Material.JACK_O_LANTERN);
		addB(Material.JUKEBOX);
		addB(Material.JUNGLE_DOOR_ITEM);
		addB(Material.JUNGLE_FENCE);
		addB(Material.JUNGLE_FENCE_GATE);
		addB(Material.JUNGLE_WOOD_STAIRS);
		addB(Material.LADDER);
		addB(Material.LAPIS_BLOCK);
		addB(Material.LAPIS_ORE);
		addB(Material.LEAVES);
		addB(Material.LEAVES_2);
		addB(Material.LIGHT_BLUE_GLAZED_TERRACOTTA);
		addB(Material.LIGHT_BLUE_SHULKER_BOX);
		addB(Material.LIME_GLAZED_TERRACOTTA);
		addB(Material.LIME_SHULKER_BOX);
		addB(Material.LOG);
		addB(Material.LOG_2);
		addB(Material.MAGENTA_GLAZED_TERRACOTTA);
		addB(Material.MAGENTA_SHULKER_BOX);
		addB(Material.MELON);
		addB(Material.MOSSY_COBBLESTONE);
		addB(Material.MYCEL);
		addB(Material.NETHER_BRICK);
		addB(Material.NETHER_BRICK_STAIRS);
		addB(Material.NETHER_FENCE);
		addB(Material.NETHER_WART_BLOCK);
		addB(Material.NETHERRACK);
		addB(Material.NOTE_BLOCK);
		addB(Material.OBSERVER);
		addB(Material.OBSIDIAN);
		addB(Material.ORANGE_GLAZED_TERRACOTTA);
		addB(Material.ORANGE_SHULKER_BOX);
		addB(Material.PACKED_ICE);
		addB(Material.PINK_GLAZED_TERRACOTTA);
		addB(Material.PINK_SHULKER_BOX);
		addB(Material.PRISMARINE);
		addB(Material.PUMPKIN);
		addB(Material.PURPLE_GLAZED_TERRACOTTA);
		addB(Material.PURPLE_SHULKER_BOX);
		addB(Material.PURPUR_BLOCK);
		addB(Material.PURPUR_PILLAR);
		addB(Material.PURPUR_SLAB);
		addB(Material.PURPUR_STAIRS);
		addB(Material.QUARTZ_BLOCK);
		addB(Material.QUARTZ_ORE);
		addB(Material.QUARTZ_STAIRS);
		addB(Material.RAILS);
		addB(Material.RED_GLAZED_TERRACOTTA);
		addB(Material.RED_NETHER_BRICK);
		addB(Material.RED_SANDSTONE);
		addB(Material.RED_SANDSTONE_STAIRS);
		addB(Material.RED_SHULKER_BOX);
		addB(Material.REDSTONE);
		addB(Material.REDSTONE_LAMP_OFF);
		addB(Material.SAND);
		addB(Material.SANDSTONE);
		addB(Material.SANDSTONE_STAIRS);
		addB(Material.SEA_LANTERN);
		addB(Material.SIGN);
		addB(Material.SILVER_GLAZED_TERRACOTTA);
		addB(Material.SILVER_SHULKER_BOX);
		addB(Material.SLIME_BLOCK);
		addB(Material.SMOOTH_BRICK);
		addB(Material.SMOOTH_STAIRS);
		addB(Material.SNOW_BLOCK);
		addB(Material.SNOW);
		addB(Material.SPONGE);
		addB(Material.SPRUCE_DOOR_ITEM);
		addB(Material.SPRUCE_FENCE);
		addB(Material.SPRUCE_FENCE_GATE);
		addB(Material.SPRUCE_WOOD_STAIRS);
		i=0;
		while (i <= 15) {
			addB(Material.STAINED_CLAY, i);
			i++;
		}
		i=0;
		while (i <= 15) {
			addB(Material.STAINED_GLASS, i);
			i++;
		}
		i=0;
		while (i <= 15) {
			addB(Material.STAINED_GLASS_PANE, i);
			i++;
		}
		addB(Material.STONE);
		addB(Material.TRAP_DOOR);
		addB(Material.TRAPPED_CHEST);
		addB(Material.WEB);
		addB(Material.WHITE_GLAZED_TERRACOTTA);
		addB(Material.WHITE_SHULKER_BOX);
		addB(Material.WOOD);
		i=0;
		while (i <= 15) {
			addB(Material.WOOL, i);
			i++;
		}
		addB(Material.WORKBENCH);
		addB(Material.YELLOW_GLAZED_TERRACOTTA);
		addB(Material.YELLOW_SHULKER_BOX);
	}
	
}
