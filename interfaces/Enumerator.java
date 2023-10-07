package interfaces;

import exceptions.EnumerationBeyondEndException;

/**
 * Interface that defines a generic enumerator
 * @author David
 *
 * @param <T> Data Structure type to enumerator over
 */
public interface Enumerator<T>
{
	/**
	 * Determines if there is a next element in the Data Structure 
	 * being enumerated over
	 * @return true if there is a next element, false if there is no next element
	 */
	boolean hasNext();
	
	/**
	 * Moves to next element in the Data Structure while giving the current element back
	 * @return the current element the enumerator is looking at
	 * @throws EnumerationBeyondEndException
	 */
	T next()
		throws EnumerationBeyondEndException;
	
	/**
	 * Peeks at the next element in the Data Structure while giving the current element back
	 * @return the current element the enumerator is looking at
	 * @throws EnumerationBeyondEndException
	 */
	T peek()
		throws EnumerationBeyondEndException;
}
