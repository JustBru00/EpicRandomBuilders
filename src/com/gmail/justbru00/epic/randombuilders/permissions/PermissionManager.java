package com.gmail.justbru00.epic.randombuilders.permissions;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermissionManager {

	/**
	 * A permissions check so that it can be changed easier later to the EpicNetworkCore methods.
	 * @param p The player to check for
	 * @param perm The permissions level to check for.
	 * @return True if the player has permission. Returns false if the player doesn't have that permission.
	 */
	public static boolean checkPerms(Player p, Permission perm) {
		if (perm.equals(Permission.ADMIN)) { // What permission are we checking?
			if (p.hasPermission("projectrho.admin")) {
				return true;
			} else {
				return false;
			}
		} else if (perm.equals(Permission.STAFF)) { // What permission are we checking?
			if (p.hasPermission("projectrho.staff")) {
				return true;
			} else {
				return false;
			}
		} else if (perm.equals(Permission.DEFAULT)) { // What permission are we checking?
			return true;
		}
		return false;
	}
	
	/**
	 * A permissions check so that it can be changed easier later to the EpicNetworkCore methods.
	 * @param p The player to check for
	 * @param perm The permissions level to check for.
	 * @return True if the player has permission. Returns false if the player doesn't have that permission.
	 */
	public static boolean checkPerms(CommandSender s, Permission perm) {
		if (perm.equals(Permission.ADMIN)) { // What permission are we checking?
			if (s.hasPermission("projectrho.admin")) {
				return true;
			} else {
				return false;
			}
		} else if (perm.equals(Permission.STAFF)) { // What permission are we checking?
			if (s.hasPermission("projectrho.staff")) {
				return true;
			} else {
				return false;
			}
		} else if (perm.equals(Permission.DEFAULT)) { // What permission are we checking?
			return true;
		}
		return false;
	}
	
}
