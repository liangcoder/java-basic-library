package library.exception;

public class CheckInException extends RuntimeException
{
	private static final long serialVersionUID = 4529379941002622655L;
	
	public CheckInException(String message)
	{
		super(message);
	}
}
