package library.util;

/**
 * This interface is used to define operations of class which need to be
 * output as a list.
 * 
 * @author communicated@yeah.net
 * @version 29 Nov 2009
 * @since 1.6
 * @see Outputter
 *
 */
public interface ArrayOutputter
{
	/**
	 * The header of output list.
	 * @return the string of header
	 */
	abstract String getHeader();

	/**
	 * The content of each row.
	 * @return the string of each row
	 */
	abstract String getString();
}
