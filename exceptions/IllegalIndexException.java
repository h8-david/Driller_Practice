package exceptions;

/**
 * Exception for negative array indexes
 * I'm pretty sure one already exists
 * @author David
 */
@SuppressWarnings("serial")
public class IllegalIndexException extends IndexOutOfBoundsException
{
	public IllegalIndexException() {}
	
	public IllegalIndexException(String message)
	{
		super(message);
	}
}