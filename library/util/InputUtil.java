package library.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class InputUtil is a helper class for capturing input from user.
 * 
 * @author communicated@yeah.net
 * @version 29 Nov 2009
 * @since 1.6
 *
 */
public class InputUtil
{
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Print prompt and get user input with Sting type.
	 * 
	 * @param prompt - the prompt message shown
	 * @return the string input from standard input
	 */
	public static String getInput(String prompt)
	{
		showMessage(prompt);
		try
		{
			return reader.readLine();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Print prompt and get user input with Sting type.
	 * Any space char will be ignore.
	 * 
	 * @param prompt - the prompt message shown
	 * @return the string input from standard input
	 */
	public static String getString(String prompt)
	{
		String input = "";
		while(input.trim().length() == 0)
		{
			showPrompt(prompt);
			try
			{
				input = reader.readLine();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return input;
	}
	
	/**
	 * Print prompt and get user input with int type.
	 * 
	 * @param prompt - the prompt message shown
	 * @return the int input from standard input
	 */
	public static int getInt(String prompt)
	{
		String input = getString(prompt);
		
		try
		{
			return Integer.parseInt(input);
		}
		catch(NumberFormatException e)
		{
			return getInt(prompt);
		}
	}
	
	private static void showPrompt(String prompt)
	{
		Outputter.print(prompt + ": ");
	}
	
	private static void showMessage(String prompt)
	{
		Outputter.print(prompt);
	}
}
