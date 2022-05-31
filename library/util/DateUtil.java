package library.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is used to format the data type.
 * 
 * @author Wenzheng Liang
 * @version 29 Nov 2009
 * @since 1.6
 * 
 */
public class DateUtil
{
	private static final String pattern = "dd/MM/yyyy";

	private static SimpleDateFormat formatter = new SimpleDateFormat(pattern);

	/**
	 * Return string of given data type with "dd/MM/yyyy" pattern.
	 * 
	 * @param d
	 *            - the given data to be formatted
	 * @return string of given data type with "dd/MM/yyyy" pattern
	 */
	public static String getDateString(Date d)
	{
		return formatter.format(d);
	}

}
