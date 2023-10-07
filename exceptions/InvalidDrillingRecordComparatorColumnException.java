package exceptions;

/**
 * Exception when creating a drilling record comparator with an invalid column
 * @author David
 */
@SuppressWarnings("serial")
public class InvalidDrillingRecordComparatorColumnException extends RuntimeException
{
	public InvalidDrillingRecordComparatorColumnException() {}
	
	public InvalidDrillingRecordComparatorColumnException(String message)
	{
		super(message);
	}
}
