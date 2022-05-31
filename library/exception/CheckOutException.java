package library.exception;

public class CheckOutException extends RuntimeException
{
	private static final long serialVersionUID = -3763463895283936931L;

	public CheckOutException(String message)
	{
		super(message);
	}

}
