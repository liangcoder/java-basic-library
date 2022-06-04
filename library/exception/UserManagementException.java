package library.exception;

/**
 * This exception is thrown by UserManagement to indicate that some 
 * management functionality cannot be accomplished normally. 
 * Such as the id of user doesn't exist.
 * 
 * @author communicated@yeah.net
 * @version 29 Nov 2009
 * @since 1.6
 *
 */
public class UserManagementException extends Exception
{
	private static final long serialVersionUID = 6750594330825907637L;

	public UserManagementException(String message)
	{
		super(message);
	}

}
