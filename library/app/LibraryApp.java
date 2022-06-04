package library.app;

import library.entity.Category;
import library.entity.Item;
import library.entity.ItemFactory;
import library.entity.User;
import library.exception.CheckInException;
import library.exception.CheckOutException;
import library.exception.ItemManagementException;
import library.exception.UserManagementException;
import library.service.ItemManager;
import library.service.UserManager;
import library.ui.Menu;
import library.util.InputUtil;
import library.util.Outputter;
import library.util.RecordGenerator;

/**
 * The main program of library application.
 * 
 * @author communicated@yeah.net
 * @version 29 Nov 2009
 * @since 1.6
 * 
 */
public class LibraryApp
{
	// the menu with options of library application
	private Menu menu;

	// Manager of items in the library
	private ItemManager itemManager;

	// Manager of user of the library
	private UserManager userManager;

	public LibraryApp()
	{
		menu = new Menu();
		itemManager = new ItemManager();
		userManager = new UserManager();
	}

	// initialize the data randomly for library
	private void initData()
	{
		Item[] items = RecordGenerator.generateItems();
		for (Item i : items)
		{
			itemManager.addItem(i);
		}
		Outputter.println("Initialize item data, done.");

		User[] users = RecordGenerator.generateUsers();

		for (User u : users)
		{
			userManager.addUser(u);
		}

		Outputter.println("Initialize user data, done.");
	}

	private int getOption()
	{
		Outputter.printNString("\n", 2);
		String prompt = "Please input the number of selected option";
		menu.showMenu();
		return InputUtil.getInt(prompt);
	}

	public void run()
	{
		this.menu.showWelcome();

		initData();

		int option;
		while ((option = getOption()) != 0)
		{
			switch (option)
			{
			case 1:
				checkIn();
				pressAnyKey();
				break;
			case 2:
				checkOut();
				pressAnyKey();
				break;
			case 3:
				listAll();
				pressAnyKey();
				break;
			case 4:
				listByCategory();
				pressAnyKey();
				break;
			case 5:
				listAvailable();
				pressAnyKey();
				break;
			case 6:
				addUser();
				pressAnyKey();
				break;
			case 7:
				updateUser();
				pressAnyKey();
				break;
			case 8:
				userDetail();
				pressAnyKey();
				break;
			case 9:
				listUser();
				pressAnyKey();
				break;
			case 10:
				addItem();
				pressAnyKey();
				break;
			case 11:
				updateItem();
				pressAnyKey();
				break;
			case 12:
				itemDetail();
				pressAnyKey();
				break;
			default:
				Outputter.println("Illegal option!");
			}
		}
		Outputter.println("Bye-bye!");
		pressAnyKey();
	}

	// the private methods for each options in the menu

	// 1. CHECK-IN, user check in a item into library
	private void checkIn()
	{
		// get code of item
		int code = InputUtil.getInt("Please input the code of check-in item");
		Item item;

		// get item from item manager
		try
		{
			item = this.itemManager.getItemByCode(code);
		} catch (ItemManagementException e)
		{
			// no item with given code
			warn(e.getMessage());
			return;
		}

		// check in item
		try
		{
			item.checkIn();
			Outputter.println("Check in successful.");
		} catch (CheckInException e)
		{
			// the item is not on loan
			warn(e.getMessage());
			return;
		}
	}

	// 2. CHECK-OUT,user check out a item from library
	private void checkOut()
	{
		// get code of item and id of user
		int code = InputUtil.getInt("Please input the code of check-out item");
		int id = InputUtil.getInt("Please input the id of user");

		// get item from item manager
		Item item;
		User user;
		try
		{
			item = this.itemManager.getItemByCode(code);
		} catch (ItemManagementException e)
		{
			// no item with given code
			warn(e.getMessage());
			return;
		}

		// get user from user manager
		try
		{
			user = this.userManager.getUserById(id);
		} catch (UserManagementException e)
		{
			// no user with given id
			warn(e.getMessage());
			return;
		}

		// check out item
		try
		{
			item.checkOut(user);
			Outputter.println("Check out successful.");
		} catch (CheckOutException e)
		{
			// item is unavailable
			warn(e.getMessage());
		}
	}

	// 3. LIST_ALL
	private void listAll()
	{
		Outputter.outputArray(this.itemManager.getItems());
	}

	// 4. LIST_BY_CATEGORY
	private void listByCategory()
	{
		Outputter.outputArray(this.itemManager
				.getItemsByCategory(getCategoryFromInput()));
	}

	// 5. LIST_AVAIABLE
	private void listAvailable()
	{
		Outputter.outputArray(this.itemManager.getAvailableItems());
	}

	// 6. ADD_USER
	private void addUser()
	{
		User user = User.createUser();
		this.userManager.addUser(user);
		Outputter.println("Add user successful.");
	}

	// 7. UPDATE_USER
	private void updateUser()
	{
		int id = InputUtil.getInt("Please input the id of user");
		if (!this.userManager.validate(id))
		{
			warn("No user with id " + id);
			return;
		}
		User updateUser = User.createUser();
		updateUser.setId(id);
		try
		{
			this.userManager.updateUser(updateUser);
			Outputter.println("Update user successful.");
		} catch (UserManagementException e)
		{
			warn(e.getMessage());
		}
	}

	// 8. USER_DETAIL
	private void userDetail()
	{
		int id = InputUtil.getInt("Please input the id of user");
		try
		{
			Outputter.printNChar('-', 50);
			Outputter.println();
			Outputter.print(this.userManager.getUserById(id));
			Outputter.printNChar('-', 50);
			Outputter.println();
		} catch (UserManagementException e)
		{
			warn(e.getMessage());
		}
	}

	// 9. LIST_USER
	private void listUser()
	{
		Outputter.outputArray(this.userManager.getUsers());
	}

	// 10. ADD_ITEM
	private void addItem()
	{
		Item item = ItemFactory.getInstance()
				.createItem(getCategoryFromInput());
		this.itemManager.addItem(item);
		Outputter.println("Add item successful.");
	}

	// 11. UPDATE_ITEM
	private void updateItem()
	{
		int code = InputUtil.getInt("Please input the code of item");

		// validate whether the item with given code exists or not
		if (!this.itemManager.validate(code))
		{
			warn("No item with code " + code);
			return;
		}

		try
		{
			Item originalItem = this.itemManager.getItemByCode(code);

			// The unavailable item cannot be updated.
			if (!originalItem.isAvailable())
			{
				warn("The item with code " + code
						+ " only can be updated when it is available.");
				return;
			}

			Item updateItem = ItemFactory.getInstance().createItem(
					originalItem.getCategory());
			updateItem.setCode(code);
			this.itemManager.updateItem(updateItem);
			Outputter.println("Add item successful.");
		} catch (ItemManagementException e)
		{
			warn(e.getMessage());
		}
	}

	// 12. ITEM_DETAIL
	private void itemDetail()
	{
		int code = InputUtil.getInt("Please input the code of item");
		try
		{
			Outputter.printNChar('-', 50);
			Outputter.println();
			Outputter.print(this.itemManager.getItemByCode(code));
			Outputter.printNChar('-', 50);
			Outputter.println();
		} catch (ItemManagementException e)
		{
			warn(e.getMessage());
		}
	}

	private void warn(String warningMessage)
	{
		Outputter.println("!!! WARNING !!! - " + warningMessage);
	}

	private void pressAnyKey()
	{
		InputUtil.getInput("Press any key to continue...");
	}

	private Category getCategoryFromInput()
	{
		String prompt = "Please input the category of item (1-Book, 2-Periodical, 3-DVD)";
		int input = InputUtil.getInt(prompt);
		while (input < 1 || input > 3)
		{
			input = InputUtil.getInt(prompt);
		}

		if (input == 1)
		{
			return Category.BOOK;
		} else if (input == 2)
		{
			return Category.PERIODICAL;
		} else
		{
			return Category.DVD;
		}
	}

	public static void main(String[] args)
	{
		LibraryApp library = new LibraryApp();
		library.run();
	}
}
