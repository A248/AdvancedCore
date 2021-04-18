package com.bencodez.advancedcore.api.rewards;

import org.bukkit.configuration.ConfigurationSection;

public class RewardEditData {
	private Reward reward;
	private DirectlyDefinedReward directlyDefinedReward;

	public RewardEditData(Reward reward) {
		this.reward = reward;
	}

	public RewardEditData(DirectlyDefinedReward directlyDefinedReward) {
		this.directlyDefinedReward = directlyDefinedReward;
	}

	public String getName() {
		if (reward != null) {
			return reward.getName();
		} else {
			return directlyDefinedReward.getPath();
		}
	}

	public boolean hasPath(String path) {
		if (reward != null) {
			return reward.getConfig().getConfigData().contains(path, false);
		} else {
			return directlyDefinedReward.getFileData().contains(directlyDefinedReward.getPath() + "." + path, false);
		}
	}

	public void setValue(String path, Object value) {
		if (reward != null) {
			reward.getConfig().set(path, value);
		} else if (directlyDefinedReward != null) {
			directlyDefinedReward.setValue(path, value);
		}
	}

	public ConfigurationSection getData() {
		if (reward != null) {
			return reward.getConfig().getConfigData();
		} else if (directlyDefinedReward != null) {
			return directlyDefinedReward.getFileData().getConfigurationSection(directlyDefinedReward.getPath());
		}
		return null;
	}

	public Object getValue(String key) {
		if (reward != null) {
			return reward.getConfig().getConfigData().get(key);
		} else if (directlyDefinedReward != null) {
			return directlyDefinedReward.getValue(key);
		}
		return null;
	}

	public void save() {
		if (reward != null) {
			reward.getConfig().save(reward.getConfig().getFileData());
		} else if (directlyDefinedReward != null) {
			directlyDefinedReward.save();
		}
	}

	public void createSection(String path) {
		if (reward != null) {
			reward.getConfig().createSection(path);
		} else if (directlyDefinedReward != null) {
			directlyDefinedReward.createSectionLocal(path);
		}
	}
}
