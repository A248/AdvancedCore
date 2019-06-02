package com.Ben12345rocks.AdvancedCore.Rewards.Injected;

import java.util.HashMap;

import org.bukkit.configuration.ConfigurationSection;

import com.Ben12345rocks.AdvancedCore.AdvancedCoreHook;
import com.Ben12345rocks.AdvancedCore.Rewards.Reward;
import com.Ben12345rocks.AdvancedCore.UserManager.User;

import lombok.Getter;
import lombok.Setter;

public abstract class RewardInjectBoolean extends RewardInject {

	@Getter
	@Setter
	private boolean defaultValue = false;

	public RewardInjectBoolean(String path) {
		super(path);
	}

	public RewardInjectBoolean(String path, boolean defaultValue) {
		super(path);
		this.defaultValue = defaultValue;
	}

	public abstract Boolean onRewardRequest(Reward reward, User user, boolean num,
			HashMap<String, String> placeholders);

	@Override
	public Boolean onRewardRequest(Reward reward, User user, ConfigurationSection data,
			HashMap<String, String> placeholders) {
		if (data.isBoolean(getPath()) || isAlwaysForce()) {
			boolean value = data.getBoolean(getPath(), isDefaultValue());
			AdvancedCoreHook.getInstance()
					.extraDebug(reward.getRewardName() + ": Giving " + getPath() + ", value: " + value);
			Boolean re = onRewardRequest(reward, user, value, placeholders);
			if (re == null) {
				return value;
			} else {
				return re;
			}
		}
		return null;
	}

}
