package exceptions;

/**
 * Exception for negative array indexes
 * I'm pretty sure one already exists
 * @author David
 */
@SuppressWarnings("serial")
public class IllegalIndexException extends RuntimeException
{
	public IllegalIndexException() {}
	
	public IllegalIndexException(String message)
	{
		super(message);
	}
}
