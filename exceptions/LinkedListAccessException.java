package exceptions;

/**
 * Exception when trying to access data that doesn't exist in a linked list
 * @author David
 */
@SuppressWarnings("serial")
public class LinkedListAccessException extends NullPointerException
{
	public LinkedListAccessException() {}
	
	public LinkedListAccessException(String message)
	{
		super(message);
	}
}