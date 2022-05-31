package library.util;

/**
 * The util class Outputter is responsible for outputting message and array info.
 * 
 * @see ArrayOutputter
 * @author Wenzheng Liang
 * @version 29 Nov 2009
 * @since 1.6
 *
 */
public class Outputter
{
	/**
	 * The following three methods wrap the System.out.print() and println().
	 * @param o
	 */
	public static void print(Object o)
	{
		System.out.print(o);
	}
	
	public static void println(Object o)
	{
		System.out.println(o);
	}
	
	public static void println()
	{
		System.out.println();
	}
	
	/**
	 * Output fixed number of specific string.
	 * @param s - string to be output
	 * @param number - fixed number of times to be output
	 */
	public static void printNString(String s, int number)
	{
		for(int i = 0; i < number; i++)
		{
			print(s);
		}
	}
	
	/**
	 * Output fixed number of specific char.
	 * @param s - char to be output
	 * @param number - fixed number of times to be output
	 */
	public static void printNChar(char c, int number)
	{
		for(int i = 0; i < number; i++)
		{
			print(c);
		}
	}
	
	/**
	 * Output elements of specific array with given header and content
	 * @see ArrayOutputter
	 * @param array - array to be output
	 */
	public static void outputArray(ArrayOutputter[] array)
	{
		final int NUMBER_OF_SEPARATOR = 80;
		if(array == null || array.length == 0)
		{
			return;
		}
		Outputter.println();
		println(array[0].getHeader());
		printNChar('-', NUMBER_OF_SEPARATOR);
		for(ArrayOutputter ao : array)
		{
			println(ao.getString());
		}
		printNChar('-', NUMBER_OF_SEPARATOR);
	}
}
