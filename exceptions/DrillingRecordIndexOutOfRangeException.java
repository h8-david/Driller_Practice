package exceptions;

/**
 * Exception when trying to access an index that exceeds
 * the max length of a {@code DrillingRecord} array
 * @author David
 */
@SuppressWarnings("serial")
public class DrillingRecordIndexOutOfRangeException extends RuntimeException
{
	public DrillingRecordIndexOutOfRangeException() {}
	
	public DrillingRecordIndexOutOfRangeException(String message)
	{
		super(message);
	}
}
