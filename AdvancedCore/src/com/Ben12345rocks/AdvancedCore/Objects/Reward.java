package com.Ben12345rocks.AdvancedCore.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.Ben12345rocks.AdvancedCore.Main;
import com.Ben12345rocks.AdvancedCore.Utils;
import com.Ben12345rocks.AdvancedCore.Configs.Config;
import com.Ben12345rocks.AdvancedCore.Configs.ConfigRewards;
import com.Ben12345rocks.AdvancedCore.Listeners.PlayerRewardEvent;
import com.Ben12345rocks.AdvancedCore.Util.Javascript.JavascriptHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class Reward.
 */
public class Reward {

	/** The plugin. */
	static Main plugin = Main.plugin;

	/** The name. */
	public String name;

	/** The reward type. */
	private String rewardType;

	/** The delay enabled. */
	private boolean delayEnabled;

	/** The delay hours. */
	private int delayHours;

	/** The delay minutes. */
	private int delayMinutes;

	/** The timed enabled. */
	private boolean timedEnabled;

	/** The timed hour. */
	private int timedHour;

	/** The timed minute. */
	private int timedMinute;

	/** The chance. */
	private double chance;

	/** The random chance. */
	private double randomChance;

	/** The random rewards. */
	private ArrayList<String> randomRewards;

	/** The random fall back. */
	private ArrayList<String> randomFallBack;

	/** The require permission. */
	private boolean requirePermission;

	/** The worlds. */
	private ArrayList<String> worlds;

	/** The give in each world. */
	private boolean giveInEachWorld;

	/** The items. */
	private Set<String> items;

	/** The item material. */
	private HashMap<String, String> itemMaterial;

	/** The item skull. */
	private HashMap<String, String> itemSkull;

	/** The item data. */
	private HashMap<String, Integer> itemData;

	/** The item durabilty. */
	private HashMap<String, Integer> itemDurabilty;

	/** The item amount. */
	private HashMap<String, Integer> itemAmount;

	/** The item min amount. */
	private HashMap<String, Integer> itemMinAmount;

	/** The item max amount. */
	private HashMap<String, Integer> itemMaxAmount;

	/** The item name. */
	private HashMap<String, String> itemName;

	/** The item lore. */
	private HashMap<String, ArrayList<String>> itemLore;

	/** The item enchants. */
	private HashMap<String, HashMap<String, Integer>> itemEnchants;

	/** The money. */
	private int money;

	/** The Min money. */
	private int MinMoney;

	/** The Max money. */
	private int MaxMoney;

	/** The exp. */
	private int exp;

	/** The min exp. */
	private int minExp;

	/** The max exp. */
	private int maxExp;

	/** The console commands. */
	private ArrayList<String> consoleCommands;

	/** The player commands. */
	private ArrayList<String> playerCommands;

	/** The potions. */
	private Set<String> potions;

	/** The potions duration. */
	private HashMap<String, Integer> potionsDuration;

	/** The potions amplifier. */
	private HashMap<String, Integer> potionsAmplifier;

	/** The reward msg. */
	private String rewardMsg;

	/** The action bar msg. */
	private String actionBarMsg;

	/** The action bar delay. */
	private int actionBarDelay;

	/** The boss bar enabled. */
	private boolean bossBarEnabled;

	/** The boss bar message. */
	private String bossBarMessage;

	/** The boss bar color. */
	private String bossBarColor;

	/** The boss bar style. */
	private String bossBarStyle;

	/** The boss bar delay. */
	private int bossBarDelay;

	/** The boss bar progress. */
	private double bossBarProgress;

	private String broadcastMsg;

	private String permission;

	private boolean javascriptEnabled;

	private String javascriptExpression;

	private ArrayList<String> javascriptTrueRewards;

	private ArrayList<String> javascriptFalseRewards;

	private ArrayList<String> choiceRewardsRewards;

	public boolean isFireworkEnabled() {
		return fireworkEnabled;
	}

	public void setFireworkEnabled(boolean fireworkEnabled) {
		this.fireworkEnabled = fireworkEnabled;
	}

	public boolean isFireworkFlicker() {
		return fireworkFlicker;
	}

	public void setFireworkFlicker(boolean fireworkFlicker) {
		this.fireworkFlicker = fireworkFlicker;
	}

	public boolean isFireworkTrail() {
		return fireworkTrail;
	}

	public void setFireworkTrail(boolean fireworkTrail) {
		this.fireworkTrail = fireworkTrail;
	}

	public int getFireworkPower() {
		return fireworkPower;
	}

	public void setFireworkPower(int fireworkPower) {
		this.fireworkPower = fireworkPower;
	}

	public ArrayList<String> getFireworkColors() {
		return fireworkColors;
	}

	public void setFireworkColors(ArrayList<String> fireworkColors) {
		this.fireworkColors = fireworkColors;
	}

	public ArrayList<String> getFireworkFadeOutColors() {
		return fireworkFadeOutColors;
	}

	public void setFireworkFadeOutColors(ArrayList<String> fireworkFadeOutColors) {
		this.fireworkFadeOutColors = fireworkFadeOutColors;
	}

	public ArrayList<String> getFireworkTypes() {
		return fireworkTypes;
	}

	public void setFireworkTypes(ArrayList<String> fireworkTypes) {
		this.fireworkTypes = fireworkTypes;
	}

	private boolean choiceRewardsEnabled;

	private boolean fireworkEnabled;
	private boolean fireworkFlicker;
	private boolean fireworkTrail;
	private int fireworkPower;
	private ArrayList<String> fireworkColors;
	private ArrayList<String> fireworkFadeOutColors;
	private ArrayList<String> fireworkTypes;

	/**
	 * Instantiates a new reward.
	 *
	 * @param plugin
	 *            the plugin
	 */
	public Reward(Main plugin) {
		Reward.plugin = plugin;
	}

	/**
	 * Instantiates a new reward.
	 *
	 * @param reward
	 *            the reward
	 */
	public Reward(String reward) {
		name = reward;

		setRewardType(ConfigRewards.getInstance().getRewardType(reward));

		setDelayEnabled(ConfigRewards.getInstance().getDelayedEnabled(reward));
		setDelayHours(ConfigRewards.getInstance().getDelayedHours(reward));
		setDelayMinutes(ConfigRewards.getInstance().getDelayedMinutes(reward));

		setTimedEnabled(ConfigRewards.getInstance().getTimedEnabled(reward));
		setTimedHour(ConfigRewards.getInstance().getTimedHour(reward));
		setTimedMinute(ConfigRewards.getInstance().getTimedMinute(reward));

		setChance(ConfigRewards.getInstance().getChance(reward));
		setRandomChance(ConfigRewards.getInstance().getRandomChance(reward));
		setRandomRewards(ConfigRewards.getInstance().getRandomRewards(reward));
		setRandomFallBack(ConfigRewards.getInstance().getRandomFallBack(reward));

		setRequirePermission(ConfigRewards.getInstance().getRequirePermission(
				reward));
		setWorlds(ConfigRewards.getInstance().getWorlds(reward));
		setGiveInEachWorld(ConfigRewards.getInstance().getGiveInEachWorld(
				reward));

		setItems(ConfigRewards.getInstance().getItems(reward));
		itemMaterial = new HashMap<String, String>();
		itemData = new HashMap<String, Integer>();
		itemSkull = new HashMap<String, String>();
		itemDurabilty = new HashMap<String, Integer>();
		itemAmount = new HashMap<String, Integer>();
		itemMinAmount = new HashMap<String, Integer>();
		itemMaxAmount = new HashMap<String, Integer>();
		itemName = new HashMap<String, String>();
		itemLore = new HashMap<String, ArrayList<String>>();
		itemName = new HashMap<String, String>();
		itemEnchants = new HashMap<String, HashMap<String, Integer>>();
		for (String item : ConfigRewards.getInstance().getItems(reward)) {
			itemMaterial.put(item,
					ConfigRewards.getInstance().getItemMaterial(reward, item));
			itemData.put(item,
					ConfigRewards.getInstance().getItemData(reward, item));
			itemAmount.put(item,
					ConfigRewards.getInstance().getItemAmount(reward, item));
			itemMinAmount.put(item, ConfigRewards.getInstance()
					.getItemMinAmount(reward, item));
			itemMaxAmount.put(item, ConfigRewards.getInstance()
					.getItemMaxAmount(reward, item));
			itemName.put(item,
					ConfigRewards.getInstance().getItemName(reward, item));
			itemLore.put(item,
					ConfigRewards.getInstance().getItemLore(reward, item));
			itemDurabilty.put(item, ConfigRewards.getInstance()
					.getItemDurability(reward, item));
			itemSkull.put(item,
					ConfigRewards.getInstance().getItemSkull(reward, item));
			HashMap<String, Integer> enchants = new HashMap<String, Integer>();
			for (String enchant : ConfigRewards.getInstance().getItemEnchants(
					reward, item)) {
				enchants.put(enchant, ConfigRewards.getInstance()
						.getItemEnchantsLevel(reward, item, enchant));

			}
			itemEnchants.put(item, enchants);
		}

		setMoney(ConfigRewards.getInstance().getMoney(reward));
		setMinMoney(ConfigRewards.getInstance().getMinMoney(reward));
		setMaxMoney(ConfigRewards.getInstance().getMaxMoney(reward));

		setExp(ConfigRewards.getInstance().getEXP(reward));
		setMinExp(ConfigRewards.getInstance().getMinExp(reward));
		setMaxExp(ConfigRewards.getInstance().getMaxExp(reward));

		setConsoleCommands(ConfigRewards.getInstance().getCommandsConsole(
				reward));
		setPlayerCommands(ConfigRewards.getInstance().getCommandsPlayer(reward));

		potions = ConfigRewards.getInstance().getPotions(reward);
		potionsDuration = new HashMap<String, Integer>();
		potionsAmplifier = new HashMap<String, Integer>();
		for (String potion : potions) {
			potionsDuration.put(potion, ConfigRewards.getInstance()
					.getPotionsDuration(reward, potion));
			potionsAmplifier.put(potion, ConfigRewards.getInstance()
					.getPotionsAmplifier(reward, potion));
		}

		setRewardMsg(ConfigRewards.getInstance().getMessagesReward(reward));
		setActionBarMsg(ConfigRewards.getInstance().getActionBarMessage(reward));
		setActionBarDelay(ConfigRewards.getInstance().getActionBarDelay(reward));

		setBossBarEnabled(ConfigRewards.getInstance().getBossBarEnabled(reward));
		setBossBarMessage(ConfigRewards.getInstance().getBossBarMessage(reward));
		setBossBarColor(ConfigRewards.getInstance().getBossBarColor(reward));
		setBossBarStyle(ConfigRewards.getInstance().getBossBarStyle(reward));
		setBossBarProgress(ConfigRewards.getInstance().getBossBarProgress(
				reward));
		setBossBarDelay(ConfigRewards.getInstance().getBossBarDelay(reward));

		broadcastMsg = ConfigRewards.getInstance().getMessagesBroadcast(reward);

		permission = ConfigRewards.getInstance().getPermission(reward);

		setJavascriptEnabled(ConfigRewards.getInstance().getJavascriptEnabled(
				reward));
		setJavascriptExpression(ConfigRewards.getInstance()
				.getJavascriptExpression(reward));
		setJavascriptTrueRewards(ConfigRewards.getInstance()
				.getJavascriptTrueRewards(reward));
		setJavascriptFalseRewards(ConfigRewards.getInstance()
				.getJavascriptFalseRewards(reward));
		this.setChoiceRewardsEnabled(ConfigRewards.getInstance()
				.getChoiceRewardsEnabled(reward));
		this.setChoiceRewardsRewards(ConfigRewards.getInstance()
				.getChoiceRewardsRewards(reward));

		this.fireworkEnabled = ConfigRewards.getInstance().getFireworkEnabled(
				reward);
		this.fireworkColors = ConfigRewards.getInstance().getFireworkColors(
				reward);
		this.fireworkFadeOutColors = ConfigRewards.getInstance()
				.getFireworkColorsFadeOut(reward);
		this.fireworkPower = ConfigRewards.getInstance().getFireworkPower(
				reward);
		this.fireworkTypes = ConfigRewards.getInstance().getFireworkTypes(
				reward);
		this.fireworkTrail = ConfigRewards.getInstance().getFireworkTrail(
				reward);
		this.fireworkFlicker = ConfigRewards.getInstance().getFireworkFlicker(
				reward);

	}

	public String getBroadcastMsg() {
		return broadcastMsg;
	}

	public void setBroadcastMsg(String broadcastMsg) {
		this.broadcastMsg = broadcastMsg;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * Check chance.
	 *
	 * @return true, if successful
	 */
	public boolean checkChance() {
		double chance = getChance();

		if ((chance == 0) || (chance == 100)) {
			return true;
		}

		double randomNum = (Math.random() * 100) + 1;

		plugin.debug("Random: " + randomNum + ", Chance: " + chance);

		if (randomNum <= chance) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check delayed.
	 *
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	public boolean checkDelayed(User user) {
		if (!isDelayEnabled()) {
			return false;
		}

		Date time = new Date();
		time = DateUtils.addHours(time, getDelayHours());
		time = DateUtils.addMinutes(time, getDelayMinutes());
		user.setTimedReward(this, time.getTime());

		plugin.debug("Giving reward " + name + " in " + getDelayHours()
				+ " hours " + getDelayMinutes() + " minutes ("
				+ time.toString() + ")");
		return true;

	}

	/**
	 * Check random chance.
	 *
	 * @return true, if successful
	 */
	public boolean checkRandomChance() {
		double chance = getRandomChance();

		if ((chance == 0) || (chance == 100)) {
			return true;
		}

		double randomNum = (Math.random() * 100) + 1;

		plugin.debug("Random: Random: " + randomNum + ", Chance: " + chance);

		if (randomNum <= chance) {
			return true;
		} else {
			return false;
		}
	}

	public void runJavascript(User user, boolean online) {
		new JavascriptHandler(user, online, getJavascriptExpression(),
				getJavascriptTrueRewards(), getJavascriptFalseRewards());
	}

	/**
	 * Check timed.
	 *
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	@SuppressWarnings("deprecation")
	public boolean checkTimed(User user) {
		if (!isTimedEnabled()) {
			return false;
		}

		Date time = new Date();
		time.setHours(getTimedHour());
		time.setMinutes(getTimedMinute());
		if (new Date().after(time)) {
			time = DateUtils.addDays(time, 1);
		}
		user.setTimedReward(this, time.getTime());

		plugin.debug("Giving reward " + name + " at " + time.toString());
		return true;
	}

	/**
	 * Gets the action bar delay.
	 *
	 * @return the action bar delay
	 */
	public int getActionBarDelay() {
		return actionBarDelay;
	}

	/**
	 * Gets the action bar msg.
	 *
	 * @return the action bar msg
	 */
	public String getActionBarMsg() {
		return actionBarMsg;
	}

	/**
	 * Gets the boss bar color.
	 *
	 * @return the boss bar color
	 */
	public String getBossBarColor() {
		return bossBarColor;
	}

	/**
	 * Gets the boss bar delay.
	 *
	 * @return the boss bar delay
	 */
	public int getBossBarDelay() {
		return bossBarDelay;
	}

	/**
	 * Gets the boss bar message.
	 *
	 * @return the boss bar message
	 */
	public String getBossBarMessage() {
		return bossBarMessage;
	}

	/**
	 * Gets the boss bar progress.
	 *
	 * @return the boss bar progress
	 */
	public double getBossBarProgress() {
		return bossBarProgress;
	}

	/**
	 * Gets the boss bar style.
	 *
	 * @return the boss bar style
	 */
	public String getBossBarStyle() {
		return bossBarStyle;
	}

	/**
	 * Gets the chance.
	 *
	 * @return the chance
	 */
	public double getChance() {
		return chance;
	}

	/**
	 * Gets the console commands.
	 *
	 * @return the console commands
	 */
	public ArrayList<String> getConsoleCommands() {
		return consoleCommands;
	}

	/**
	 * Gets the delay hours.
	 *
	 * @return the delay hours
	 */
	public int getDelayHours() {
		return delayHours;
	}

	/**
	 * Gets the delay minutes.
	 *
	 * @return the delay minutes
	 */
	public int getDelayMinutes() {
		return delayMinutes;
	}

	/**
	 * Gets the exp.
	 *
	 * @return the exp
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * Gets the exp to give.
	 *
	 * @return the exp to give
	 */
	public int getExpToGive() {
		int amount = getExp();
		int maxAmount = getMaxExp();
		int minAmount = getMinExp();
		if ((maxAmount == 0) && (minAmount == 0)) {
			return amount;
		} else {
			int num = (int) (Math.random() * maxAmount);
			num++;
			if (num < minAmount) {
				num = minAmount;
			}
			return num;
		}
	}

	/**
	 * Gets the item amount.
	 *
	 * @return the item amount
	 */
	public HashMap<String, Integer> getItemAmount() {
		return itemAmount;
	}

	/**
	 * Gets the item amount.
	 *
	 * @param item
	 *            the item
	 * @return the item amount
	 */
	public int getItemAmount(String item) {
		int amount = getItemAmount().get(item);
		int maxAmount = getItemMaxAmount().get(item);
		int minAmount = getItemMinAmount().get(item);
		if ((maxAmount == 0) && (minAmount == 0)) {
			return amount;
		} else {
			int num = (int) (Math.random() * maxAmount);
			num++;
			if (num < minAmount) {
				num = minAmount;
			}
			return num;
		}
	}

	/**
	 * Gets the item data.
	 *
	 * @return the item data
	 */
	public HashMap<String, Integer> getItemData() {
		return itemData;
	}

	/**
	 * Gets the item durabilty.
	 *
	 * @return the item durabilty
	 */
	public HashMap<String, Integer> getItemDurabilty() {
		return itemDurabilty;
	}

	/**
	 * Gets the item enchants.
	 *
	 * @return the item enchants
	 */
	public HashMap<String, HashMap<String, Integer>> getItemEnchants() {
		return itemEnchants;
	}

	/**
	 * Gets the item lore.
	 *
	 * @return the item lore
	 */
	public HashMap<String, ArrayList<String>> getItemLore() {
		return itemLore;
	}

	/**
	 * Gets the item material.
	 *
	 * @return the item material
	 */
	public HashMap<String, String> getItemMaterial() {
		return itemMaterial;
	}

	/**
	 * Gets the item max amount.
	 *
	 * @return the item max amount
	 */
	public HashMap<String, Integer> getItemMaxAmount() {
		return itemMaxAmount;
	}

	/**
	 * Gets the item min amount.
	 *
	 * @return the item min amount
	 */
	public HashMap<String, Integer> getItemMinAmount() {
		return itemMinAmount;
	}

	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public HashMap<String, String> getItemName() {
		return itemName;
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public Set<String> getItems() {
		return items;
	}

	/**
	 * Gets the item skull.
	 *
	 * @return the item skull
	 */
	public HashMap<String, String> getItemSkull() {
		return itemSkull;
	}

	/**
	 * Gets the max exp.
	 *
	 * @return the max exp
	 */
	public int getMaxExp() {
		return maxExp;
	}

	/**
	 * Gets the max money.
	 *
	 * @return the max money
	 */
	public int getMaxMoney() {
		return MaxMoney;
	}

	/**
	 * Gets the min exp.
	 *
	 * @return the min exp
	 */
	public int getMinExp() {
		return minExp;
	}

	/**
	 * Gets the min money.
	 *
	 * @return the min money
	 */
	public int getMinMoney() {
		return MinMoney;
	}

	/**
	 * Gets the money.
	 *
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * Gets the money to give.
	 *
	 * @return the money to give
	 */
	public int getMoneyToGive() {
		int amount = getMoney();
		int maxAmount = getMaxMoney();
		int minAmount = getMinMoney();
		if ((maxAmount == 0) && (minAmount == 0)) {
			return amount;
		} else {
			int num = (int) (Math.random() * maxAmount);
			num++;
			if (num < minAmount) {
				num = minAmount;
			}
			return num;
		}
	}

	/**
	 * Gets the player commands.
	 *
	 * @return the player commands
	 */
	public ArrayList<String> getPlayerCommands() {
		return playerCommands;
	}

	/**
	 * Gets the potions.
	 *
	 * @return the potions
	 */
	public Set<String> getPotions() {
		return potions;
	}

	/**
	 * Gets the potions amplifier.
	 *
	 * @return the potions amplifier
	 */
	public HashMap<String, Integer> getPotionsAmplifier() {
		return potionsAmplifier;
	}

	/**
	 * Gets the potions duration.
	 *
	 * @return the potions duration
	 */
	public HashMap<String, Integer> getPotionsDuration() {
		return potionsDuration;
	}

	/**
	 * Gets the random chance.
	 *
	 * @return the random chance
	 */
	public double getRandomChance() {
		return randomChance;
	}

	/**
	 * Gets the random fall back.
	 *
	 * @return the random fall back
	 */
	public ArrayList<String> getRandomFallBack() {
		return randomFallBack;
	}

	/**
	 * Gets the random rewards.
	 *
	 * @return the random rewards
	 */
	public ArrayList<String> getRandomRewards() {
		return randomRewards;
	}

	/**
	 * Gets the reward msg.
	 *
	 * @return the reward msg
	 */
	public String getRewardMsg() {
		return rewardMsg;
	}

	/**
	 * Gets the reward name.
	 *
	 * @return the reward name
	 */
	public String getRewardName() {
		return name;
	}

	/**
	 * Gets the reward type.
	 *
	 * @return the reward type
	 */
	public String getRewardType() {
		return rewardType;
	}

	/**
	 * Gets the timed hour.
	 *
	 * @return the timed hour
	 */
	public int getTimedHour() {
		return timedHour;
	}

	/**
	 * Gets the timed minute.
	 *
	 * @return the timed minute
	 */
	public int getTimedMinute() {
		return timedMinute;
	}

	/**
	 * Gets the worlds.
	 *
	 * @return the worlds
	 */
	public ArrayList<String> getWorlds() {
		return worlds;
	}

	/**
	 * Give exp.
	 *
	 * @param user
	 *            the user
	 */
	public void giveExp(User user) {
		user.giveExp(getExpToGive());
	}

	/**
	 * Give items.
	 *
	 * @param user
	 *            the user
	 */
	public void giveItems(User user) {
		for (String item : getItems()) {
			ItemStack itemStack = new ItemStack(
					Material.valueOf(getItemMaterial().get(item)),
					getItemAmount(item), Short.valueOf(Integer
							.toString(getItemData().get(item))));
			String name = getItemName().get(item);
			if (name != null) {
				itemStack = Utils.getInstance().nameItem(itemStack,
						name.replace("%Player%", user.getPlayerName()));
			}
			itemStack = Utils.getInstance().addLore(
					itemStack,
					Utils.getInstance().replace(getItemLore().get(item),
							"%Player%", user.getPlayerName()));
			itemStack = Utils.getInstance().addEnchants(itemStack,
					getItemEnchants().get(item));
			itemStack = Utils.getInstance().setDurabilty(itemStack,
					getItemDurabilty().get(item));
			String skull = getItemSkull().get(item);
			if (skull != null) {
				itemStack = Utils.getInstance().setSkullOwner(itemStack,
						skull.replace("%Player%", user.getPlayerName()));
			}
			user.giveItem(itemStack);
		}
	}

	/**
	 * Give money.
	 *
	 * @param user
	 *            the user
	 */
	public void giveMoney(User user) {
		user.giveMoney(getMoneyToGive());
	}

	/**
	 * Give potions.
	 *
	 * @param user
	 *            the user
	 */
	public void givePotions(User user) {
		for (String potionName : getPotions()) {
			user.givePotionEffect(potionName,
					getPotionsDuration().get(potionName), getPotionsAmplifier()
							.get(potionName));
		}
	}

	/**
	 * Give random.
	 *
	 * @param user
	 *            the user
	 * @param online
	 *            the online
	 */
	public void giveRandom(User user, boolean online) {
		if (checkRandomChance()) {
			ArrayList<String> rewards = getRandomRewards();
			if (rewards != null) {
				if (rewards.size() > 0) {
					String reward = rewards.get((int) Math.random()
							* rewards.size());
					if (reward.equalsIgnoreCase("")) {
						ConfigRewards.getInstance().getReward(reward)
								.giveReward(user, online);
					}
				}
			}
		} else {
			for (String reward : getRandomFallBack()) {
				if (reward.equalsIgnoreCase("")) {
					user.giveReward(
							ConfigRewards.getInstance().getReward(reward),
							online);
				}
			}
		}
	}

	/**
	 * Give reward.
	 *
	 * @param user
	 *            the user
	 * @param online
	 *            the online
	 */
	public void giveReward(User user, boolean online) {

		PlayerRewardEvent event = new PlayerRewardEvent(this, user);
		Bukkit.getPluginManager().callEvent(event);

		if (event.isCancelled()) {
			plugin.debug("Reward " + name + " was cancelled");
			return;
		}

		if (!online
				&& !Utils.getInstance().isPlayerOnline(user.getPlayerName())) {
			user.setOfflineRewards(this, user.getOfflineRewards(this) + 1);
			return;
		}

		if (checkDelayed(user)) {
			return;
		}

		if (checkTimed(user)) {
			return;
		}

		giveRewardReward(user, online);
	}

	/**
	 * Give reward reward.
	 *
	 * @param user
	 *            the user
	 * @param online
	 *            the online
	 */
	public void giveRewardReward(User user, boolean online) {
		plugin.debug("Attempting to give " + user.getPlayerName() + " reward "
				+ name);

		String type = getRewardType();
		if (online) {
			if (type.equalsIgnoreCase("offline")) {
				plugin.debug("Reward Type Don't match");
				return;
			}
		} else {
			if (type.equalsIgnoreCase("online")) {
				plugin.debug("Reward Type Don't match");
				return;
			}
		}

		if (checkChance()) {
			ArrayList<String> worlds = getWorlds();
			Player player = Bukkit.getPlayer(user.getPlayerName());
			if ((player != null) && (worlds != null) && !worlds.isEmpty()) {
				if (isGiveInEachWorld()) {
					for (String world : worlds) {
						if (player.getWorld().getName().equals(world)) {
							giveRewardUser(user);
						} else {
							user.setOfflineRewardWorld(getRewardName(), world,
									user.getOfflineRewardWorld(getRewardName(),
											world) + 1);
						}
					}
				} else {
					if (worlds.contains(player.getWorld().getName())) {
						giveRewardUser(user);
						
					} else {
						user.setOfflineRewardWorld(getRewardName(), null,
								user.getOfflineRewardWorld(getRewardName(),
										null) + 1);

					}
				}
			} else {
				giveRewardUser(user);
				
				
			}
		}
	}

	/**
	 * Give reward user.
	 *
	 * @param user
	 *            the user
	 */
	public void giveRewardUser(User user) {
		Player player = Bukkit.getPlayer(user.getPlayerName());
		if (player != null) {
			if (hasPermission(user)) {
				giveRandom(user, true);
				runJavascript(user, true);
				giveMoney(user);
				giveItems(user);
				giveExp(user);
				runCommands(user);
				givePotions(user);
				sendTitle(user);
				sendActionBar(user);
				playSound(user);
				playEffect(user);
				sendBossBar(user);
				sendMessage(user);
				checkChoiceRewards(user);
				sendFirework(user);

				plugin.debug("Gave " + user.getPlayerName() + " reward " + name);

			}
		}
	}

	public void sendFirework(User user) {
		if (isFireworkEnabled()) {
			Utils.getInstance().launchFirework(user.getPlayer().getLocation(),
					getFireworkPower(), getFireworkColors(),
					getFireworkFadeOutColors(), isFireworkTrail(),
					isFireworkFlicker(), getFireworkTypes());
		}
	}

	public void checkChoiceRewards(User user) {
		if (isChoiceRewardsEnabled()) {
			Player player = user.getPlayer();
			if (player != null) {
				user.addChoiceReward(this);
			}
		}
	}

	public boolean hasPermission(User user) {
		if (!isRequirePermission()) {
			return true;
		}
		return Utils.getInstance().hasPermission(user.getPlayerName(),
				permission);
	}

	/**
	 * Checks if is boss bar enabled.
	 *
	 * @return true, if is boss bar enabled
	 */
	public boolean isBossBarEnabled() {
		return bossBarEnabled;
	}

	/**
	 * Checks if is delay enabled.
	 *
	 * @return true, if is delay enabled
	 */
	public boolean isDelayEnabled() {
		return delayEnabled;
	}

	/**
	 * Checks if is give in each world.
	 *
	 * @return true, if is give in each world
	 */
	public boolean isGiveInEachWorld() {
		return giveInEachWorld;
	}

	/**
	 * Checks if is require permission.
	 *
	 * @return true, if is require permission
	 */
	public boolean isRequirePermission() {
		return requirePermission;
	}

	/**
	 * Checks if is timed enabled.
	 *
	 * @return true, if is timed enabled
	 */
	public boolean isTimedEnabled() {
		return timedEnabled;
	}

	/**
	 * Play effect.
	 *
	 * @param user
	 *            the user
	 */
	public void playEffect(User user) {
		if (ConfigRewards.getInstance().getEffectEnabled(name)) {
			user.playParticleEffect(ConfigRewards.getInstance()
					.getEffectEffect(name), ConfigRewards.getInstance()
					.getEffectData(name), ConfigRewards.getInstance()
					.getEffectParticles(name), ConfigRewards.getInstance()
					.getEffectRadius(name));
		}
	}

	/**
	 * Play sound.
	 *
	 * @param user
	 *            the user
	 */
	public void playSound(User user) {
		if (ConfigRewards.getInstance().getSoundEnabled(name)) {
			try {
				user.playSound(ConfigRewards.getInstance().getSoundSound(name),
						ConfigRewards.getInstance().getSoundVolume(name),
						ConfigRewards.getInstance().getSoundPitch(name));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Run commands.
	 *
	 * @param user
	 *            the user
	 */
	public void runCommands(User user) {
		String playerName = user.getPlayerName();

		// Console commands
		ArrayList<String> consolecmds = getConsoleCommands();

		if (consolecmds != null) {
			for (String consolecmd : consolecmds) {
				if (consolecmd.length() > 0) {
					consolecmd = consolecmd.replace("%player%", playerName);
					Bukkit.getServer().dispatchCommand(
							Bukkit.getConsoleSender(), consolecmd);
				}
			}
		}

		// Player commands
		ArrayList<String> playercmds = getPlayerCommands();

		Player player = Bukkit.getPlayer(playerName);
		if (playercmds != null) {
			for (String playercmd : playercmds) {
				if ((player != null) && (playercmd.length() > 0)) {
					playercmd = playercmd.replace("%player%", playerName);
					player.performCommand(playercmd);
				}
			}
		}
	}

	/**
	 * Send action bar.
	 *
	 * @param user
	 *            the user
	 */
	public void sendActionBar(User user) {
		user.sendActionBar(getActionBarMsg(), getActionBarDelay());
	}

	/**
	 * Send boss bar.
	 *
	 * @param user
	 *            the user
	 */
	public void sendBossBar(User user) {
		if (isBossBarEnabled()) {
			user.sendBossBar(getBossBarMessage(), getBossBarColor(),
					getBossBarStyle(), getBossBarProgress(), getBossBarDelay());
		}
	}

	/**
	 * Send message.
	 *
	 * @param user
	 *            the user
	 */
	public void sendMessage(User user) {
		Utils.getInstance().broadcast(broadcastMsg);
		if (rewardMsg != null) {
			user.sendMessage(rewardMsg);
		} else {
			user.sendMessage(Config.getInstance().getFormatDefaultRewardMsg());
		}

	}

	/**
	 * Send title.
	 *
	 * @param user
	 *            the user
	 */
	public void sendTitle(User user) {
		if (ConfigRewards.getInstance().getTitleEnabled(name)) {
			user.sendTitle(ConfigRewards.getInstance().getTitleTitle(name),

			ConfigRewards.getInstance().getTitleSubTitle(name),

			ConfigRewards.getInstance().getTitleFadeIn(name), ConfigRewards
					.getInstance().getTitleShowTime(name), ConfigRewards
					.getInstance().getTitleFadeOut(name));
		}
	}

	/**
	 * Sets the action bar delay.
	 *
	 * @param actionBarDelay
	 *            the new action bar delay
	 */
	public void setActionBarDelay(int actionBarDelay) {
		this.actionBarDelay = actionBarDelay;
	}

	/**
	 * Sets the action bar msg.
	 *
	 * @param actionBarMsg
	 *            the new action bar msg
	 */
	public void setActionBarMsg(String actionBarMsg) {
		this.actionBarMsg = actionBarMsg;
	}

	/**
	 * Sets the boss bar color.
	 *
	 * @param bossBarColor
	 *            the new boss bar color
	 */
	public void setBossBarColor(String bossBarColor) {
		this.bossBarColor = bossBarColor;
	}

	/**
	 * Sets the boss bar delay.
	 *
	 * @param bossBarDelay
	 *            the new boss bar delay
	 */
	public void setBossBarDelay(int bossBarDelay) {
		this.bossBarDelay = bossBarDelay;
	}

	/**
	 * Sets the boss bar enabled.
	 *
	 * @param bossBarEnabled
	 *            the new boss bar enabled
	 */
	public void setBossBarEnabled(boolean bossBarEnabled) {
		this.bossBarEnabled = bossBarEnabled;
	}

	/**
	 * Sets the boss bar message.
	 *
	 * @param bossBarMessage
	 *            the new boss bar message
	 */
	public void setBossBarMessage(String bossBarMessage) {
		this.bossBarMessage = bossBarMessage;
	}

	/**
	 * Sets the boss bar progress.
	 *
	 * @param bossBarProgress
	 *            the new boss bar progress
	 */
	public void setBossBarProgress(double bossBarProgress) {
		this.bossBarProgress = bossBarProgress;
	}

	/**
	 * Sets the boss bar style.
	 *
	 * @param bossBarStyle
	 *            the new boss bar style
	 */
	public void setBossBarStyle(String bossBarStyle) {
		this.bossBarStyle = bossBarStyle;
	}

	/**
	 * Sets the chance.
	 *
	 * @param chance
	 *            the new chance
	 */
	public void setChance(double chance) {
		this.chance = chance;
	}

	/**
	 * Sets the console commands.
	 *
	 * @param consoleCommands
	 *            the new console commands
	 */
	public void setConsoleCommands(ArrayList<String> consoleCommands) {
		this.consoleCommands = consoleCommands;
	}

	/**
	 * Sets the delay enabled.
	 *
	 * @param delayEnabled
	 *            the new delay enabled
	 */
	public void setDelayEnabled(boolean delayEnabled) {
		this.delayEnabled = delayEnabled;
	}

	/**
	 * Sets the delay hours.
	 *
	 * @param delayHours
	 *            the new delay hours
	 */
	public void setDelayHours(int delayHours) {
		this.delayHours = delayHours;
	}

	/**
	 * Sets the delay minutes.
	 *
	 * @param delayMinutes
	 *            the new delay minutes
	 */
	public void setDelayMinutes(int delayMinutes) {
		this.delayMinutes = delayMinutes;
	}

	/**
	 * Sets the exp.
	 *
	 * @param exp
	 *            the new exp
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}

	/**
	 * Sets the give in each world.
	 *
	 * @param giveInEachWorld
	 *            the new give in each world
	 */
	public void setGiveInEachWorld(boolean giveInEachWorld) {
		this.giveInEachWorld = giveInEachWorld;
	}

	/**
	 * Sets the item amount.
	 *
	 * @param itemAmount
	 *            the item amount
	 */
	public void setItemAmount(HashMap<String, Integer> itemAmount) {
		this.itemAmount = itemAmount;
	}

	/**
	 * Sets the item data.
	 *
	 * @param itemData
	 *            the item data
	 */
	public void setItemData(HashMap<String, Integer> itemData) {
		this.itemData = itemData;
	}

	/**
	 * Sets the item durabilty.
	 *
	 * @param itemDurabilty
	 *            the item durabilty
	 */
	public void setItemDurabilty(HashMap<String, Integer> itemDurabilty) {
		this.itemDurabilty = itemDurabilty;
	}

	/**
	 * Sets the item enchants.
	 *
	 * @param itemEnchants
	 *            the item enchants
	 */
	public void setItemEnchants(
			HashMap<String, HashMap<String, Integer>> itemEnchants) {
		this.itemEnchants = itemEnchants;
	}

	/**
	 * Sets the item lore.
	 *
	 * @param itemLore
	 *            the item lore
	 */
	public void setItemLore(HashMap<String, ArrayList<String>> itemLore) {
		this.itemLore = itemLore;
	}

	/**
	 * Sets the item material.
	 *
	 * @param itemMaterial
	 *            the item material
	 */
	public void setItemMaterial(HashMap<String, String> itemMaterial) {
		this.itemMaterial = itemMaterial;
	}

	/**
	 * Sets the item max amount.
	 *
	 * @param itemMaxAmount
	 *            the item max amount
	 */
	public void setItemMaxAmount(HashMap<String, Integer> itemMaxAmount) {
		this.itemMaxAmount = itemMaxAmount;
	}

	/**
	 * Sets the item min amount.
	 *
	 * @param itemMinAmount
	 *            the item min amount
	 */
	public void setItemMinAmount(HashMap<String, Integer> itemMinAmount) {
		this.itemMinAmount = itemMinAmount;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName
	 *            the item name
	 */
	public void setItemName(HashMap<String, String> itemName) {
		this.itemName = itemName;
	}

	/**
	 * Sets the items.
	 *
	 * @param items
	 *            the new items
	 */
	public void setItems(Set<String> items) {
		this.items = items;
	}

	/**
	 * Sets the item skull.
	 *
	 * @param itemSkull
	 *            the item skull
	 */
	public void setItemSkull(HashMap<String, String> itemSkull) {
		this.itemSkull = itemSkull;
	}

	/**
	 * Sets the max exp.
	 *
	 * @param maxExp
	 *            the new max exp
	 */
	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}

	/**
	 * Sets the max money.
	 *
	 * @param maxMoney
	 *            the new max money
	 */
	public void setMaxMoney(int maxMoney) {
		MaxMoney = maxMoney;
	}

	/**
	 * Sets the min exp.
	 *
	 * @param minExp
	 *            the new min exp
	 */
	public void setMinExp(int minExp) {
		this.minExp = minExp;
	}

	/**
	 * Sets the min money.
	 *
	 * @param minMoney
	 *            the new min money
	 */
	public void setMinMoney(int minMoney) {
		MinMoney = minMoney;
	}

	/**
	 * Sets the money.
	 *
	 * @param money
	 *            the new money
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * Sets the player commands.
	 *
	 * @param playerCommands
	 *            the new player commands
	 */
	public void setPlayerCommands(ArrayList<String> playerCommands) {
		this.playerCommands = playerCommands;
	}

	/**
	 * Sets the potions.
	 *
	 * @param potions
	 *            the new potions
	 */
	public void setPotions(Set<String> potions) {
		this.potions = potions;
	}

	/**
	 * Sets the potions amplifier.
	 *
	 * @param potionsAmplifier
	 *            the potions amplifier
	 */
	public void setPotionsAmplifier(HashMap<String, Integer> potionsAmplifier) {
		this.potionsAmplifier = potionsAmplifier;
	}

	/**
	 * Sets the potions duration.
	 *
	 * @param potionsDuration
	 *            the potions duration
	 */
	public void setPotionsDuration(HashMap<String, Integer> potionsDuration) {
		this.potionsDuration = potionsDuration;
	}

	/**
	 * Sets the random chance.
	 *
	 * @param randomChance
	 *            the new random chance
	 */
	public void setRandomChance(double randomChance) {
		this.randomChance = randomChance;
	}

	/**
	 * Sets the random fall back.
	 *
	 * @param randomFallBack
	 *            the new random fall back
	 */
	public void setRandomFallBack(ArrayList<String> randomFallBack) {
		this.randomFallBack = randomFallBack;
	}

	/**
	 * Sets the random rewards.
	 *
	 * @param randomRewards
	 *            the new random rewards
	 */
	public void setRandomRewards(ArrayList<String> randomRewards) {
		this.randomRewards = randomRewards;
	}

	/**
	 * Sets the require permission.
	 *
	 * @param requirePermission
	 *            the new require permission
	 */
	public void setRequirePermission(boolean requirePermission) {
		this.requirePermission = requirePermission;
	}

	/**
	 * Sets the reward msg.
	 *
	 * @param rewardMsg
	 *            the new reward msg
	 */
	public void setRewardMsg(String rewardMsg) {
		this.rewardMsg = rewardMsg;
	}

	/**
	 * Sets the reward type.
	 *
	 * @param rewardType
	 *            the new reward type
	 */
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	/**
	 * Sets the timed enabled.
	 *
	 * @param timedEnabled
	 *            the new timed enabled
	 */
	public void setTimedEnabled(boolean timedEnabled) {
		this.timedEnabled = timedEnabled;
	}

	/**
	 * Sets the timed hour.
	 *
	 * @param timedHour
	 *            the new timed hour
	 */
	public void setTimedHour(int timedHour) {
		this.timedHour = timedHour;
	}

	/**
	 * Sets the timed minute.
	 *
	 * @param timedMinute
	 *            the new timed minute
	 */
	public void setTimedMinute(int timedMinute) {
		this.timedMinute = timedMinute;
	}

	/**
	 * Sets the worlds.
	 *
	 * @param worlds
	 *            the new worlds
	 */
	public void setWorlds(ArrayList<String> worlds) {
		this.worlds = worlds;
	}

	public boolean isJavascriptEnabled() {
		return javascriptEnabled;
	}

	public void setJavascriptEnabled(boolean javascriptEnabled) {
		this.javascriptEnabled = javascriptEnabled;
	}

	public String getJavascriptExpression() {
		return javascriptExpression;
	}

	public void setJavascriptExpression(String javascriptExpression) {
		this.javascriptExpression = javascriptExpression;
	}

	public ArrayList<String> getJavascriptTrueRewards() {
		return javascriptTrueRewards;
	}

	public void setJavascriptTrueRewards(ArrayList<String> javascriptTrueRewards) {
		this.javascriptTrueRewards = javascriptTrueRewards;
	}

	public ArrayList<String> getJavascriptFalseRewards() {
		return javascriptFalseRewards;
	}

	public void setJavascriptFalseRewards(
			ArrayList<String> javascriptFalseRewards) {
		this.javascriptFalseRewards = javascriptFalseRewards;
	}

	public ArrayList<String> getChoiceRewardsRewards() {
		return choiceRewardsRewards;
	}

	public void setChoiceRewardsRewards(ArrayList<String> choiceRewardsRewards) {
		this.choiceRewardsRewards = choiceRewardsRewards;
	}

	public boolean isChoiceRewardsEnabled() {
		return choiceRewardsEnabled;
	}

	public void setChoiceRewardsEnabled(boolean choiceRewardsEnabled) {
		this.choiceRewardsEnabled = choiceRewardsEnabled;
	}

}
