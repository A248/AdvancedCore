/* Obtained from https://www.spigotmc.org/threads/libish-inventory-api-kinda.49339/
 */

package com.Ben12345rocks.AdvancedCore.Util.Inventory;

import org.bukkit.inventory.ItemStack;

import com.Ben12345rocks.AdvancedCore.Utils;
import com.Ben12345rocks.AdvancedCore.Util.Inventory.BInventory.ClickEvent;
import com.Ben12345rocks.AdvancedCore.Util.Item.ItemBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class BInventoryButton.
 */
public abstract class BInventoryButton {

	/** The name. */
	private String name;

	/** The lore. */
	private String[] lore;

	/** The item. */
	private ItemStack item;

	/** The slot. */
	private int slot;

	/**
	 * Instantiates a new b inventory button.
	 *
	 * @param name
	 *            the name
	 * @param lore
	 *            the lore
	 * @param item
	 *            the item
	 */
	public BInventoryButton(String name, String[] lore, ItemStack item) {
		setName(name);
		setLore(lore);
		setItem(item);
	}

	/**
	 * Gets the item.
	 *
	 * @return the item
	 */
	public ItemStack getItem() {
		return item;
	}

	/**
	 * Gets the lore.
	 *
	 * @return the lore
	 */
	public String[] getLore() {
		return lore;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the slot.
	 *
	 * @return the slot
	 */
	public int getSlot() {
		return slot;
	}

	/**
	 * On click.
	 *
	 * @param clickEvent
	 *            the click event
	 */
	public abstract void onClick(ClickEvent clickEvent);

	/**
	 * Sets the item.
	 *
	 * @param item
	 *            the new item
	 */
	public void setItem(ItemStack item) {
		this.item = item;
	}
	
	public void setItem(ItemBuilder builder) {
		this.item = builder.toItemStack();
	}

	/**
	 * Sets the lore.
	 *
	 * @param lore
	 *            the new lore
	 */
	@Deprecated
	public void setLore(String[] lore) {
		this.lore = Utils.getInstance().colorize(lore);
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	@Deprecated
	public void setName(String name) {
		this.name = Utils.getInstance().colorize(name);
	}

	/**
	 * Sets the slot.
	 *
	 * @param slot
	 *            the new slot
	 */
	public void setSlot(int slot) {
		this.slot = slot;
	}

}