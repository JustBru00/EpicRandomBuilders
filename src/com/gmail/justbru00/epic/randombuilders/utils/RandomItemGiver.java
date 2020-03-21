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
	// Give 54 stacks of 1-32 blocks of random stuff
	
	private static ArrayList<ItemStack> allTheBlocks = new ArrayList<ItemStack>();

	public static void giveRandomItemsToAll() {
		init();
		for (Player p : Bukkit.getOnlinePlayers()) {
			Inventory i = p.getInventory();
			int x = 1;
			while (x <= 54) {
				ItemStack is = allTheBlocks.get(ThreadLocalRandom.current().nextInt(0, allTheBlocks.size() - 1)).clone();
				is.setAmount(ThreadLocalRandom.current().nextInt(1, 32));
				
				i.addItem(is);
				x++;
			}
		}
	}
	
	
	private static void addB(Material m) {
		allTheBlocks.add(new ItemBuilder(m).build());
	}
	
	private static void addB(Material... materialsToChooseBetween) {
		int randomSelection = ThreadLocalRandom.current().nextInt(0, materialsToChooseBetween.length);
		
		addB(materialsToChooseBetween[randomSelection]);		
	}
	
	private static void addB(ArrayList<Material> materialsToChooseBetween) {
		int randomSelection = ThreadLocalRandom.current().nextInt(0, materialsToChooseBetween.size());
		
		addB(materialsToChooseBetween.get(randomSelection));		
	}
	
	private static void addB(String coloredBlockSuffix) {
		ArrayList<Material> materials = new ArrayList<Material>();
		String[] colors = {"BLACK", "BLUE", "BROWN", "WHITE", "ORANGE", "MAGENTA", "LIGHT_BLUE", "YELLOW", "LIME", "PINK",
				"GRAY", "LIGHT_GRAY", "CYAN", "PURPLE", "GREEN", "RED"};
		
		// Add stuff
		for (String s : colors) {
			materials.add(Material.getMaterial(s + "_" + coloredBlockSuffix));
		}
	
		addB(materials);
	}
	
	 /**
	  * Biggest method ever
	  */
	public static void init() {
		// Only give one of these:
		addB(Material.ACACIA_BUTTON, Material.BIRCH_BUTTON, Material.DARK_OAK_BUTTON, Material.JUNGLE_BUTTON, Material.OAK_BUTTON, Material.SPRUCE_BUTTON);
		addB(Material.ACACIA_DOOR, Material.BIRCH_DOOR, Material.DARK_OAK_DOOR, Material.JUNGLE_DOOR, Material.OAK_DOOR, Material.SPRUCE_DOOR);
		addB(Material.ACACIA_FENCE, Material.BIRCH_FENCE, Material.DARK_OAK_FENCE, Material.JUNGLE_FENCE, Material.OAK_FENCE, Material.SPRUCE_FENCE);
		addB(Material.ACACIA_FENCE_GATE, Material.BIRCH_FENCE_GATE, Material.DARK_OAK_FENCE_GATE, Material.JUNGLE_FENCE_GATE, Material.OAK_FENCE_GATE, Material.SPRUCE_FENCE_GATE);
		addB(Material.ACACIA_LEAVES, Material.BIRCH_LEAVES, Material.DARK_OAK_LEAVES, Material.JUNGLE_LEAVES, Material.OAK_LEAVES, Material.SPRUCE_LEAVES);
		addB(Material.ACACIA_PRESSURE_PLATE, Material.BIRCH_PRESSURE_PLATE, Material.DARK_OAK_PRESSURE_PLATE, Material.JUNGLE_PRESSURE_PLATE, Material.OAK_PRESSURE_PLATE, Material.SPRUCE_PRESSURE_PLATE);
		addB(Material.ACACIA_SIGN, Material.BIRCH_SIGN, Material.DARK_OAK_SIGN, Material.JUNGLE_SIGN, Material.OAK_SIGN, Material.SPRUCE_SIGN);
		addB(Material.ACACIA_SLAB, Material.BIRCH_SLAB, Material.DARK_OAK_SLAB, Material.JUNGLE_SLAB, Material.OAK_SLAB, Material.SPRUCE_SLAB);
		addB(Material.ACACIA_TRAPDOOR, Material.BIRCH_TRAPDOOR, Material.DARK_OAK_TRAPDOOR, Material.JUNGLE_TRAPDOOR, Material.OAK_TRAPDOOR, Material.SPRUCE_TRAPDOOR);		
		
		addB("BED");
		addB("CARPET");
		addB("CONCRETE");
		addB("CONCRETE_POWDER");
		addB("GLAZED_TERRACOTTA");
		addB("SHULKER_BOX");
		addB("STAINED_GLASS");
		addB("STAINED_GLASS_PANE");
		addB("TERRACOTTA");
		addB("WOOL");
		
		// Other items
		addB(Material.ACACIA_LOG);
		addB(Material.ACACIA_PLANKS);	
		addB(Material.ACACIA_STAIRS);
		addB(Material.ACACIA_WOOD);
		addB(Material.ANDESITE);
		addB(Material.ANDESITE_SLAB);
		addB(Material.ANDESITE_STAIRS);
		addB(Material.ANDESITE_WALL);
		addB(Material.ANVIL);
		addB(Material.BARREL);
		addB(Material.BEACON);
		addB(Material.BEDROCK);
		addB(Material.BEE_NEST);
		addB(Material.BEEHIVE);
		addB(Material.BELL);
		addB(Material.BIRCH_LOG);
		addB(Material.BIRCH_PLANKS);	
		addB(Material.BIRCH_STAIRS);
		addB(Material.BIRCH_WOOD);
		addB(Material.BLAST_FURNACE);
		addB(Material.BLUE_ICE);
		addB(Material.BONE_BLOCK);
		addB(Material.BOOKSHELF);
		addB(Material.BRAIN_CORAL_BLOCK);
		addB(Material.BRICKS);
		addB(Material.BRICK_SLAB);
		addB(Material.BRICK_STAIRS);
		addB(Material.BRICK_WALL);
		addB(Material.BROWN_MUSHROOM_BLOCK);
		addB(Material.BUBBLE_CORAL_BLOCK);
		addB(Material.CAMPFIRE);
		addB(Material.CARTOGRAPHY_TABLE);
		addB(Material.CARVED_PUMPKIN);
		addB(Material.CAULDRON);
		addB(Material.CHEST);
		addB(Material.CHISELED_QUARTZ_BLOCK);
		addB(Material.CHISELED_RED_SANDSTONE);
		addB(Material.CHISELED_SANDSTONE);
		addB(Material.CHISELED_STONE_BRICKS);
		addB(Material.CLAY);
		addB(Material.COAL_BLOCK);
		addB(Material.COAL_ORE);
		addB(Material.COARSE_DIRT);
		addB(Material.COBBLESTONE);
		addB(Material.COBBLESTONE_SLAB);
		addB(Material.COBBLESTONE_STAIRS);
		addB(Material.COBBLESTONE_WALL);
		addB(Material.COBWEB);
		addB(Material.COMPOSTER);
		addB(Material.CRACKED_STONE_BRICKS);
		addB(Material.CRAFTING_TABLE);
		addB(Material.CUT_RED_SANDSTONE);
		addB(Material.CUT_RED_SANDSTONE_SLAB);
		addB(Material.CUT_SANDSTONE);
		addB(Material.CUT_SANDSTONE_SLAB);
		addB(Material.DARK_OAK_LOG);
		addB(Material.DARK_OAK_PLANKS);	
		addB(Material.DARK_OAK_STAIRS);
		addB(Material.DARK_OAK_WOOD);
		addB(Material.DARK_PRISMARINE);
		addB(Material.DARK_PRISMARINE_SLAB);
		addB(Material.DARK_PRISMARINE_STAIRS);
		addB(Material.DAYLIGHT_DETECTOR);
		addB(Material.DEAD_BRAIN_CORAL_BLOCK);
		addB(Material.DEAD_BUBBLE_CORAL_BLOCK);
		addB(Material.DEAD_FIRE_CORAL_BLOCK);
		addB(Material.DEAD_HORN_CORAL_BLOCK);
		addB(Material.DEAD_TUBE_CORAL_BLOCK);
		addB(Material.DIAMOND_BLOCK);
		addB(Material.DIAMOND_ORE);
		addB(Material.DIORITE);
		addB(Material.DIORITE_SLAB);
		addB(Material.DIORITE_STAIRS);
		addB(Material.DIORITE_WALL);
		addB(Material.DIRT);
		addB(Material.DISPENSER);
		addB(Material.DRIED_KELP_BLOCK);
		addB(Material.DROPPER);
		addB(Material.EMERALD_BLOCK);
		addB(Material.EMERALD_ORE);
		addB(Material.ENCHANTING_TABLE);
		addB(Material.END_PORTAL_FRAME);
		addB(Material.END_ROD);
		addB(Material.END_STONE);
		addB(Material.END_STONE_BRICK_SLAB);
		addB(Material.END_STONE_BRICK_STAIRS);
		addB(Material.END_STONE_BRICK_WALL);
		addB(Material.END_STONE_BRICKS);
		addB(Material.FIRE_CORAL_BLOCK);
		addB(Material.FLETCHING_TABLE);
		addB(Material.FURNACE);
		addB(Material.GLASS);
		addB(Material.GLOWSTONE);
		addB(Material.GOLD_BLOCK);
		addB(Material.GOLD_ORE);
		addB(Material.GRANITE);
		addB(Material.GRANITE_SLAB);
		addB(Material.GRANITE_STAIRS);
		addB(Material.GRANITE_WALL);
		addB(Material.GRASS_BLOCK);
		addB(Material.GRAVEL);
		addB(Material.GRINDSTONE);
		addB(Material.HAY_BLOCK);
		addB(Material.HONEY_BLOCK);
		addB(Material.HONEYCOMB_BLOCK);
		addB(Material.HOPPER);
		addB(Material.HORN_CORAL_BLOCK);
		addB(Material.ICE);
		addB(Material.IRON_BLOCK);
		addB(Material.IRON_ORE);
		addB(Material.IRON_TRAPDOOR);
		addB(Material.JACK_O_LANTERN);
		addB(Material.JIGSAW);
		addB(Material.JUKEBOX);
		addB(Material.LANTERN);
		addB(Material.LAPIS_BLOCK);
		addB(Material.LAPIS_ORE);
		addB(Material.LECTERN);
		addB(Material.LOOM);
		addB(Material.MAGMA_BLOCK);
		addB(Material.MELON);
		addB(Material.MOSSY_COBBLESTONE);
		addB(Material.MOSSY_COBBLESTONE_SLAB);
		addB(Material.MOSSY_COBBLESTONE_STAIRS);
		addB(Material.MOSSY_COBBLESTONE_WALL);
		addB(Material.MOSSY_STONE_BRICK_SLAB);
		addB(Material.MOSSY_STONE_BRICK_STAIRS);
		addB(Material.MOSSY_STONE_BRICK_WALL);
		addB(Material.MOSSY_STONE_BRICKS);
		addB(Material.MUSHROOM_STEM);
		addB(Material.MYCELIUM);
		addB(Material.NETHER_BRICK);
		addB(Material.NETHER_BRICK_FENCE);
		addB(Material.NETHER_BRICK_SLAB);
		addB(Material.NETHER_BRICK_STAIRS);
		addB(Material.NETHER_BRICK_WALL);
		addB(Material.NETHER_QUARTZ_ORE);
		addB(Material.NETHER_WART_BLOCK);
		addB(Material.NETHERRACK);
		addB(Material.NOTE_BLOCK);
		addB(Material.OAK_LOG);
		addB(Material.OAK_PLANKS);	
		addB(Material.OAK_STAIRS);
		addB(Material.OAK_WOOD);
		addB(Material.OBSERVER);
		addB(Material.OBSIDIAN);
		addB(Material.PACKED_ICE);
		addB(Material.PETRIFIED_OAK_SLAB);
		addB(Material.PODZOL);
		addB(Material.POLISHED_ANDESITE);
		addB(Material.POLISHED_ANDESITE_SLAB);
		addB(Material.POLISHED_ANDESITE_STAIRS);
		addB(Material.POLISHED_DIORITE);
		addB(Material.POLISHED_DIORITE_SLAB);
		addB(Material.POLISHED_DIORITE_STAIRS);
		addB(Material.POLISHED_GRANITE);
		addB(Material.POLISHED_GRANITE_SLAB);
		addB(Material.POLISHED_GRANITE_STAIRS);
		addB(Material.PRISMARINE);
		addB(Material.PRISMARINE_BRICK_SLAB);
		addB(Material.PRISMARINE_BRICK_STAIRS);
		addB(Material.PRISMARINE_BRICKS);
		addB(Material.PRISMARINE_SLAB);
		addB(Material.PRISMARINE_STAIRS);
		addB(Material.PRISMARINE_WALL);
		addB(Material.PUMPKIN);
		addB(Material.PURPUR_BLOCK);
		addB(Material.PURPUR_PILLAR);
		addB(Material.PURPUR_SLAB);
		addB(Material.PURPUR_STAIRS);
		addB(Material.QUARTZ_BLOCK);
		addB(Material.QUARTZ_PILLAR);
		addB(Material.QUARTZ_SLAB);
		addB(Material.QUARTZ_STAIRS);
		addB(Material.RED_MUSHROOM_BLOCK);
		addB(Material.RED_NETHER_BRICK_SLAB);
		addB(Material.RED_NETHER_BRICK_STAIRS);
		addB(Material.RED_NETHER_BRICK_WALL);
		addB(Material.RED_NETHER_BRICKS);
		addB(Material.RED_SAND);
		addB(Material.RED_SANDSTONE);
		addB(Material.RED_SANDSTONE_SLAB);
		addB(Material.RED_SANDSTONE_STAIRS);
		addB(Material.RED_SANDSTONE_WALL);
		addB(Material.REDSTONE_BLOCK);
		addB(Material.REDSTONE_LAMP);
		addB(Material.REDSTONE_ORE);
		addB(Material.SAND);
		addB(Material.SANDSTONE);
		addB(Material.SANDSTONE_SLAB);
		addB(Material.SANDSTONE_STAIRS);
		addB(Material.SANDSTONE_WALL);
		addB(Material.SEA_LANTERN);
		addB(Material.SLIME_BLOCK);
		addB(Material.SMITHING_TABLE);
		addB(Material.SMOKER);
		addB(Material.SMOOTH_QUARTZ);
		addB(Material.SMOOTH_QUARTZ_SLAB);
		addB(Material.SMOOTH_QUARTZ_STAIRS);
		addB(Material.SMOOTH_RED_SANDSTONE);
		addB(Material.SMOOTH_RED_SANDSTONE_SLAB);
		addB(Material.SMOOTH_RED_SANDSTONE_STAIRS);
		addB(Material.SMOOTH_SANDSTONE);
		addB(Material.SMOOTH_SANDSTONE_SLAB);
		addB(Material.SMOOTH_SANDSTONE_STAIRS);
		addB(Material.SMOOTH_STONE);
		addB(Material.SMOOTH_STONE_SLAB);
		addB(Material.SNOW_BLOCK);
		addB(Material.SOUL_SAND);
		addB(Material.SPONGE);
		addB(Material.STONE);
		addB(Material.STONE_SLAB);
		addB(Material.STONE_STAIRS);
		addB(Material.STONECUTTER);
		addB(Material.STRIPPED_ACACIA_LOG);
		addB(Material.STRIPPED_BIRCH_LOG);
		addB(Material.STRIPPED_DARK_OAK_LOG);
		addB(Material.STRIPPED_JUNGLE_LOG);
		addB(Material.STRIPPED_OAK_LOG);
		addB(Material.STRIPPED_SPRUCE_LOG);
		addB(Material.STRIPPED_ACACIA_WOOD);
		addB(Material.STRIPPED_BIRCH_WOOD);
		addB(Material.STRIPPED_DARK_OAK_WOOD);
		addB(Material.STRIPPED_JUNGLE_WOOD);
		addB(Material.STRIPPED_OAK_WOOD);
		addB(Material.STRIPPED_SPRUCE_WOOD);
		addB(Material.TERRACOTTA);
		addB(Material.TUBE_CORAL_BLOCK);
		addB(Material.WET_SPONGE);
		
		
	}
	
}
