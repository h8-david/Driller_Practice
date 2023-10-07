package exceptions;

/**
 * Exception when trying to insert null into some data structure
 * @author David
 */

@SuppressWarnings("serial")
public class NullInsertionException extends NullPointerException
{
	public NullInsertionException() {}
	
	public NullInsertionException(String message)
	{
		super(message);
	}
}