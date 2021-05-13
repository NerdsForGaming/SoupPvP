package me.elb1to.souppvp.user;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Elb1to
 * Project: SoupPvP
 * Date: 5/7/2021 @ 9:52 AM
 */
public class UserManager {

	@Getter private final Map<UUID, User> users = new HashMap<>();

	public User getOrCreate(UUID uuid) {
		return users.computeIfAbsent(uuid, User::new);
	}

	public User getByUuid(UUID uuid) {
		if (users.containsKey(uuid)) {
			return users.get(uuid);
		}

		return new User(uuid);
	}

	public User getByPlayer(Player player) {
		User user = users.get(player.getUniqueId());

		if (user == null) {
			user = new User(player.getUniqueId());
		}

		return user;
	}
}