package library.ui;

import library.util.Outputter;

/**
 * The Class Menu represents the menu of the system.
 * 
 * @author Wenzheng Liang
 * @version 29 Nov 2009
 * @since 1.6
 *
 */
public class Menu
{
	private final String MENU_HEADER = "**************  M E N U  **************";
	private final String WELCOME_STRING = "WELCOME TO LIBRARY SYSTEM (communicated@yeah.net)";
	private enum Option
	{
		EXIT, // 0
		CHECK_IN, // 1
		CHECK_OUT, // 2

		LIST_ALL_ITEMS, // 3
		LIST_ITEMS_BY_CATEGORY, // 4
		LIST_AVAILABLE_ITEMS, // 5

		ADD_USER, // 6
		UPDATE_USER, // 7
		USER_DETAIL, // 8
		LIST_USER, // 9

		ADD_ITEM, // 10
		UPDATE_ITEM, // 11
		ITEM_DETAIL
		// 12
	}

	/**
	 * Print out the menu with options.
	 */
	public void showMenu()
	{
		Outputter.println(MENU_HEADER);
		Option[] options = Option.values();
		for (int i = 1; i < options.length; i++)
		{
			if(i < 10)
			{
				Outputter.println(" " + i + "." + options[i] + "  ");
			}
			else
			{
				Outputter.println(i + "." + options[i] + "  ");
			}
		}
		Outputter.println(" 0." + options[0]);
		Outputter.printNChar('*', MENU_HEADER.length());
		Outputter.println();
	}

	/**
	 * Show welcome message of the system.
	 */
	public void showWelcome()
	{
		final int NUMBER_OF_CHAR = 50;

		Outputter.printNChar('*', NUMBER_OF_CHAR);
		Outputter.println();
		Outputter.printNChar(' ',
				(NUMBER_OF_CHAR - WELCOME_STRING.length()) / 2);
		Outputter.println(WELCOME_STRING);
		Outputter.printNChar('*', NUMBER_OF_CHAR);
		Outputter.println();
	}
}
