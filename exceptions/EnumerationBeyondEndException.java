package exceptions;

import java.util.NoSuchElementException;

/**
 * Exception when accessing null data from an
 * {@code Enumerator}
 * @author David
 */
@SuppressWarnings("serial")
public class EnumerationBeyondEndException extends NoSuchElementException
{
	public EnumerationBeyondEndException() {}
	
	public EnumerationBeyondEndException(String message)
	{
		super(message);
	}
}
