package library.exception;

/**
 * This exception is thrown by ItemManagement to indicate that some 
 * management functionality cannot be accomplished normally. 
 * Such as the code of item doesn't exist.
 * 
 * @author Wenzheng Liang
 * @version 29 Nov 2009
 * @since 1.6
 *
 */
public class ItemManagementException extends Exception
{
	private static final long serialVersionUID = -7662623761626590953L;
	
	public ItemManagementException(String message)
	{
		super(message);
	}
}
