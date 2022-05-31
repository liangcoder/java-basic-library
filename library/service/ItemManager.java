package library.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import library.entity.Category;
import library.entity.Item;
import library.exception.ItemManagementException;

/**
 * Class ItemManager provides management functionality for items of the library.
 * 
 * @see Item
 * @author Wenzheng Liang
 * @version 29 Nov 2009
 * @since 1.6
 * 
 */
public class ItemManager
{
	// the start number of library code
	private int nextCode = 9000;
	
	// list of items in the library
	private List<Item> items;
	
	public ItemManager()
	{
		this.items = new ArrayList<Item>();
	}
	
	public ItemManager(int startCode)
	{
		this();
		this.nextCode = startCode;
	}

	/**
	 * Validate whether the item with given code exists in the library or not. 
	 * @param code - the code of item
	 * @return true if the item with given code exists, or else, return false.
	 */
	public boolean validate(int code)
	{
		for(Item i : this.items)
		{
			if(i.getCode() == code)
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * Get all the items in the library.
	 * @return array of items in the library.
	 */
	public Item[] getItems()
	{
		return this.items.toArray(new Item[0]);
	}

	/**
	 * Query the specific item with code which is unique in the library code.
	 * If no item exists with given code, throw ItemManagementException.
	 * 
	 * @param id - code of item.
	 * @return the item with given code.
	 * @see ItemManagementException
	 */
	public Item getItemByCode(int code) throws ItemManagementException
	{
		for(Item i : this.items)
		{
			if(i.getCode() == code)
			{
				return i;
			}
		}
		throw new ItemManagementException("No item with code " + code);
	}

	/**
	 * Add a new item into library.
	 * 
	 * @param item - the new item contains detail information
	 */
	public void addItem(Item item)
	{
		// generate unique code for item
		item.setCode(generateNextCode());
		this.items.add(item);
	}

	/**
	 * Update detail information of existing item in the library.
	 * If exception occurs during the process of updating, 
	 * throw ItemManagementException.
	 * 
	 * 
	 * @param item - the item object contains detail information to update
	 *               the code of item is required.
	 * @see ItemManagementException
	 */
	public void updateItem(Item item) throws ItemManagementException
	{
		// the code of item must be set previously.
		if(item.getCode() == 0)
		{
			throw new ItemManagementException("The code of item is required when update.");
		}
		
		if(!validate(item.getCode()))
		{
			throw new ItemManagementException("No item with code " + item.getCode());
		}
		
		
		for(int i = 0; i < this.items.size(); i++)
		{
			Item currentItem = this.items.get(i);
			if(currentItem.getCode() == item.getCode())
			{
				this.items.set(i, item);
				return;
			}
		}
	}

	/** 
	 * Get all available items of the library.
	 * 
	 * @return array of available items
	 */
	public Item[] getAvailableItems()
	{
		List<Item> result = new LinkedList<Item>();
		
		for(Item i : this.items)
		{
			if(i.isAvailable())
			{
				result.add(i);
			}
		}
		
		return result.toArray(new Item[0]);
	}

	/** 
	 * Get items with specific category of the library.
	 * 
	 * @param category -The category of item
	 * 
	 */
	public Item[] getItemsByCategory(Category category)
	{
		List<Item> result = new LinkedList<Item>();
		
		for(Item i : this.items)
		{
			if(i.getCategory().equals(category))
			{
				result.add(i);
			}
		}
		
		return result.toArray(new Item[0]);
	}
	
	/**
	 * Get the number of items in the library.
	 * @return the number of items
	 */
	public int getNumberOfItems()
	{
		return this.items.size();
	}
	
	private int generateNextCode()
	{
		return this.nextCode++;
	}
}